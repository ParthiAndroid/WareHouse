package com.inventry.warehouse.orders;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.inventry.warehouse.BuildConfig;
import com.inventry.warehouse.R;
import com.inventry.warehouse.base.BaseActivity;
import com.inventry.warehouse.businesslayer.model.UnSyncedOrder;
import com.inventry.warehouse.util.FontsUtil;
import com.inventry.warehouse.util.floatingbutton.FloatingActionButton;
import com.inventry.warehouse.util.floatingbutton.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{

    RecyclerView inventoryList;
    //private SwipeRefreshLayout swipeRefreshLayout;

    Context mContext;

    ArrayList<UnSyncedOrder> inventryListArr;

    UnSyncedOrderAdapter adapter;
    LinearLayoutManager mLayoutManager;

    private FloatingActionButton fab1, fab2, fab3;
    FloatingActionMenu floatingActionMenu;
    
    private static final String TAG = HomeActivity.class.getSimpleName();

    private List<FloatingActionMenu> menus = new ArrayList<>();
    private Handler mUiHandler = new Handler();
    private View.OnClickListener clickListener = new View.OnClickListener() {
        /**
         * Created by LovesonJ on 20/07/2016.
         */
        @Override
        public void onClick(View fab_View) {
            switch (fab_View.getId()) {

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(BuildConfig.FLAVOR);

        floatingActionMenu = (FloatingActionMenu) findViewById(R.id.fab);
        floatingActionMenu.setOnMenuButtonClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                /**
                 * Created by LovesonJ on 20/07/2016.
                 */
                if (floatingActionMenu.isOpened()) {
                } else {
                    fab1.setVisibility(View.VISIBLE);
                    fab2.setVisibility(View.VISIBLE);
                    fab3.setVisibility(View.VISIBLE);
                }
                floatingActionMenu.toggle(true);
            }
        });
        floatingActionMenu.setClosedOnTouchOutside();
        menus.add(floatingActionMenu);
        // floatingActionMenu.hideMenuButton(false);
        int delay = 400;
        for (final FloatingActionMenu menu : menus) {
            mUiHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    menu.showMenuButton(true);
                }
            }, delay);
            delay += 150;
        }
        floatingActionMenu.setClosedOnTouchOutside();
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab1.setColorNormal(ContextCompat.getColor(this, R.color.fab_normal));
        fab1.setColorPressed(ContextCompat.getColor(this, R.color.fab_pressed));
        fab1.setColorRipple(ContextCompat.getColor(this, R.color.fab_ripple));
        fab2.setColorNormal(ContextCompat.getColor(this, R.color.fab_normal));
        fab2.setColorPressed(ContextCompat.getColor(this, R.color.fab_pressed));
        fab2.setColorRipple(ContextCompat.getColor(this, R.color.fab_ripple));
        fab3.setColorNormal(ContextCompat.getColor(this, R.color.fab_normal));
        fab3.setColorPressed(ContextCompat.getColor(this, R.color.fab_pressed));
        fab3.setColorRipple(ContextCompat.getColor(this, R.color.fab_ripple));
        createCustomAnimation();
        mContext =this;

        inventoryList = (RecyclerView) findViewById(R.id.orders_list);
        TextView toolbar_title = (TextView)findViewById(R.id.toolbar_title);
        TextView nodata_txt = (TextView)findViewById(R.id.nodata_txt);
        /*swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

        swipeRefreshLayout.setOnRefreshListener(this);*/

        mLayoutManager = new LinearLayoutManager(mContext);
        inventoryList.setLayoutManager(mLayoutManager);

        //custom fonts
        toolbar_title.setTypeface(FontsUtil.getRobotoMediumFont(this));
        nodata_txt.setTypeface(FontsUtil.getLatoRegularFont(this));
        inventryListArr = new ArrayList<>();

        ///Need to update static contents

        for(int i=0;i<10;i++) {
            UnSyncedOrder model = new UnSyncedOrder();
            model.setCustomerName("Arjun");
            model.setCsrName("123456789");

            inventryListArr.add(model);
        }
        /**
         * Showing Swipe Refresh animation on activity create
         * As animation won't start on onCreate, post runnable is used
         */
        /*swipeRefreshLayout.post(
                new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(true);

                        if (inventryListArr.size() > 0) {
                            adapter = new UnSyncedOrderAdapter(mContext, inventryListArr);
                            inventoryList.setAdapter(adapter);
                        }
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }
        );*/

        if (inventryListArr.size() > 0) {
            adapter = new UnSyncedOrderAdapter(mContext, inventryListArr);
            inventoryList.setAdapter(adapter);
        }else {
            inventoryList.setVisibility(View.GONE);
            nodata_txt.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        Log.d(TAG, "onRefresh");
        //swipeRefreshLayout.setRefreshing(true);
        //ArrayList<InventoryItemModel> inventryListArr = helper.getSavedItems();

        if (inventryListArr.size() > 0) {
            /*adapter = new InventoryItemAdapter(mContext, inventryListArr, this);
            inventoryList.setAdapter(adapter);*/
        }
        //swipeRefreshLayout.setRefreshing(false);
        adapter.notifyDataSetChanged();
    }

    private void createCustomAnimation() {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator scaleOutX = ObjectAnimator.ofFloat(floatingActionMenu.getMenuIconView(), "scaleX", 1.0f, 0.2f);
        ObjectAnimator scaleOutY = ObjectAnimator.ofFloat(floatingActionMenu.getMenuIconView(), "scaleY", 1.0f, 0.2f);
        ObjectAnimator scaleInX = ObjectAnimator.ofFloat(floatingActionMenu.getMenuIconView(), "scaleX", 0.2f, 1.0f);
        ObjectAnimator scaleInY = ObjectAnimator.ofFloat(floatingActionMenu.getMenuIconView(), "scaleY", 0.2f, 1.0f);
        scaleOutX.setDuration(50);
        scaleOutY.setDuration(50);
        scaleInX.setDuration(150);
        scaleInY.setDuration(150);
        scaleInX.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                if(floatingActionMenu.isOpened())
                    floatingActionMenu.setMenuButtonColorNormal(getResources().getColor(R.color.colorPrimaryDark));
                else floatingActionMenu.setMenuButtonColorNormal(getResources().getColor(R.color.colorAccent));
                floatingActionMenu.getMenuIconView().setImageResource(floatingActionMenu.isOpened()
                        ? R.drawable.ic_close_white : R.drawable.ic_sort_white_24dp);


            }
        });
        set.play(scaleOutX).with(scaleOutY);
        set.play(scaleInX).with(scaleInY).after(scaleOutX);
        set.setInterpolator(new OvershootInterpolator(2));
        floatingActionMenu.setIconToggleAnimatorSet(set);
    }
}
