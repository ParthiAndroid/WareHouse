package com.inventry.warehouse.orders.neworder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.inventry.warehouse.App;
import com.inventry.warehouse.R;
import com.inventry.warehouse.base.BaseActivity;
import com.inventry.warehouse.businesslayer.ApiInterface;
import com.inventry.warehouse.businesslayer.db.DBHelper;
import com.inventry.warehouse.businesslayer.model.Category;
import com.inventry.warehouse.businesslayer.model.SearchResponse;
import com.inventry.warehouse.businesslayer.model.SearchSidemarkResponse;
import com.inventry.warehouse.search.SearchActivity;
import com.inventry.warehouse.search.sidemark.SidemarkSearchInteracter;
import com.inventry.warehouse.util.PrefStorage;
import com.inventry.warehouse.util.ViewUtil;

import java.util.ArrayList;
import java.util.UUID;

public class NewOrderActivity extends BaseActivity implements NewOrderInteracter.ViewInteractor,View.OnClickListener {


    private static final String TAG = NewOrderActivity.class.getSimpleName();

    LinearLayout orgininsertvalue;

    TextView txt_item_no; EditText tagNoTxt;
    EditText heightEdt, itemNameEdt, widthEdt, depthEdt, perValueEdt, ed_lbs, ed_cubicft, ed_squareft;
    TextView orderIdTxt, tv_add_more;
    RelativeLayout btn_save_exception;
    EditText edt_comments_desc;

    LinearLayout customerBtn, sidemarkBtn, orginBtn, carrierBtn, itemBtn;

    Spinner spinner_exception, spinner_location;

    DBHelper dbHelper;

    ArrayList<Category> exceptionList, locationList;
    RecyclerView rv_exception_list, itemCardViewRv;

    private static final int NEW_ORDER_CUSTOMER = 1000;
    private static final int NEW_ORDER_SIDEMARK = 1001;
    private static final int NEW_ORDER_CARRIER = 1002;

    ArrayList<ConditionalNote> mExceptionsList = new ArrayList<>();
    ArrayList<Item> addedItemsList = new ArrayList<>();

    EditText edt_lbs;
    TextView tv_customer_name, tv_company_name, tv_city_name, tv_state_name;
    TextView tv_customer_name1, tv_company_name1, tv_city_name1, tv_state_name1;

    TextView tv_side_name;
    CardView card_customercard, sidemark_card, orgin_card;

    SearchResponse.Company customerData;
    SearchSidemarkResponse.Smark sidemarkData;
    boolean isCubicFtEdited;
    boolean isSqFtEdited;
    boolean isQuickAdd;
    ItemAddAdapter itemAddAdapter;

    ExceptionListAdapter exceptionsAdapter;
    TextView btnSubmit;

    int totCubicFt = 0;
    ProgressDialog mDialog;

    NewOrderPresenter newOrderPresenter;
    NewOrder masterData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        orderIdTxt = (TextView) findViewById(R.id.toolbar_title);

        tv_add_more = (TextView) findViewById(R.id.tv_add_more);
        edt_lbs = (EditText) findViewById(R.id.edt_lbs);

        tv_customer_name = (TextView) findViewById(R.id.tv_customer_name);
        tv_company_name = (TextView) findViewById(R.id.tv_company_name);
        tv_city_name = (TextView) findViewById(R.id.tv_city_name);
        tv_state_name = (TextView) findViewById(R.id.tv_state_name);

        tv_customer_name1 = (TextView) findViewById(R.id.tv_customer_name1);
        tv_company_name1 = (TextView) findViewById(R.id.tv_company_name1);
        tv_city_name1 = (TextView) findViewById(R.id.tv_city_name1);
        tv_state_name1 = (TextView) findViewById(R.id.tv_state_name1);

        tv_side_name = (TextView) findViewById(R.id.tv_side_name);

        card_customercard = (CardView) findViewById(R.id.card_customercard);
        sidemark_card = (CardView) findViewById(R.id.sidemark_card);
        orgin_card = (CardView) findViewById(R.id.orgin_card);

        customerBtn = (LinearLayout) findViewById(R.id.lyt_customer);
        sidemarkBtn = (LinearLayout) findViewById(R.id.lyt_sidemark);
        orginBtn = (LinearLayout) findViewById(R.id.lyt_orgin);
        carrierBtn = (LinearLayout) findViewById(R.id.lyt_carrier);
        itemBtn = (LinearLayout) findViewById(R.id.lyt_item);
        btn_save_exception = (RelativeLayout) findViewById(R.id.btn_save_exception);
        spinner_exception = (Spinner) findViewById(R.id.spinner_exception);
        spinner_location = (Spinner) findViewById(R.id.spinner_location);
        edt_comments_desc = (EditText) findViewById(R.id.edt_comments_desc);

        btnSubmit = (TextView)findViewById(R.id.btn_submit);

        /* item */
        txt_item_no = (TextView) findViewById(R.id.txt_item_no);
        tagNoTxt = (EditText) findViewById(R.id.ed_tag_no);
        heightEdt = (EditText) findViewById(R.id.ed_height);
        widthEdt = (EditText) findViewById(R.id.ed_width);
        depthEdt = (EditText) findViewById(R.id.ed_depth);
        itemNameEdt = (EditText) findViewById(R.id.ed_itemname);
        perValueEdt = (EditText) findViewById(R.id.ed_pervalue);
        ed_lbs = (EditText) findViewById(R.id.ed_lbs);
        ed_cubicft = (EditText) findViewById(R.id.ed_cubicft);
        ed_squareft = (EditText) findViewById(R.id.ed_squareft);

        customerBtn.setOnClickListener(this);
        sidemarkBtn.setOnClickListener(this);
        orginBtn.setOnClickListener(this);
        carrierBtn.setOnClickListener(this);
        itemBtn.setOnClickListener(this);
        btn_save_exception.setOnClickListener(this);
        tv_add_more.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        dbHelper = new DBHelper(this);
        mDialog = new ProgressDialog(this);
        newOrderPresenter = new NewOrderPresenter(apiService, this, this);
        orderIdTxt.setText(dbHelper.getOrderId());

        exceptionList = dbHelper.getDictionaryPair("ExceptionType");
        locationList = dbHelper.getDictionaryPair("LocationType");

        String[] exceptionItems = new String[exceptionList.size()];
        for (int z = 0; z < exceptionList.size(); z++) {
            exceptionItems[z] = exceptionList.get(z).getCategoryKey();
        }

        String[] locationItems = new String[locationList.size()];
        for (int z = 0; z < locationList.size(); z++) {
            locationItems[z] = locationList.get(z).getCategoryKey();
        }

        ArrayAdapter<String> exceptionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, exceptionItems);
        spinner_exception.setAdapter(exceptionAdapter);
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locationItems);
        spinner_location.setAdapter(locationAdapter);

        rv_exception_list = (RecyclerView) findViewById(R.id.rv_exception_list);
        itemCardViewRv = (RecyclerView) findViewById(R.id.Rv_itemcardview);
        rv_exception_list.setLayoutManager(new LinearLayoutManager(this));

        itemCardViewRv.setLayoutManager(new LinearLayoutManager(this));

        ed_cubicft.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0)
                    isCubicFtEdited = true;
            }
        });

        ed_squareft.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0)
                    isSqFtEdited = true;
            }
        });

        itemAddAdapter = new ItemAddAdapter(this);
        itemCardViewRv.setAdapter(itemAddAdapter);

        exceptionsAdapter = new ExceptionListAdapter(this);
        rv_exception_list.setAdapter(exceptionsAdapter);

        /***
         * Creating new Order Instance*
         */
        masterData = new NewOrder();

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.lyt_customer:
                Intent intent = new Intent(NewOrderActivity.this, ViewCustomerDetailsActivity.class);
                intent.putExtra("order_id", orderIdTxt.getText().toString());
                startActivityForResult(intent, NEW_ORDER_CUSTOMER);
                break;

            case R.id.lyt_sidemark:
                if (customerData != null) {
                    intent = new Intent(NewOrderActivity.this, SearchActivity.class);
                    intent.putExtra("wherefrom", "SidemarkSearch");
                    intent.putExtra("CompanyId", customerData.getCompanyId());
                    startActivityForResult(intent, NEW_ORDER_SIDEMARK);
                } else {
                    showToast("Enter the Customer Data");
                }

                break;

            case R.id.lyt_orgin:
                ViewUtil.showCustomToast(NewOrderActivity.this, "Development is in progress");
                break;

            case R.id.lyt_carrier:
                ViewUtil.showCustomToast(NewOrderActivity.this, "Development is in progress");
                break;

            case R.id.lyt_item:
                break;


            case R.id.Rl_orgin_arrow:
                orgininsertvalue.setVisibility(View.VISIBLE);
                break;

            case R.id.btn_save_exception:
                addException();
                break;


            case R.id.tv_add_more:
                addItem();
                break;
            case R.id.btn_submit:
                createNewOderData();
                break;

            default:
                break;

        }

    }

    private String calculateCubicFt(String height, String width, String depth) {
        String cubicFt = EMPTY;
        try {

            if (!height.equals(EMPTY) && !width.equals(EMPTY) && !depth.equals(EMPTY)) {

                int h = getIntegerFromString(height);
                int w = getIntegerFromString(width);
                int d = getIntegerFromString(depth);

                cubicFt = Integer.toString((h / 12) * (w / 12) * (d / 12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cubicFt;
    }

    private String calculateSqFt(String width, String depth) {

        String sqFt = EMPTY;
        try {

            if (!width.equals(EMPTY) && !depth.equals(EMPTY)) {

                int w = getIntegerFromString(width);
                int d = getIntegerFromString(depth);

                sqFt = Integer.toString((w / 12) * (d / 12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqFt;
    }

    private String getUUId() {
        return UUID.randomUUID().toString();
    }

    private String getGUId() {
        StringBuilder myName = new StringBuilder(getUUId());
        myName.setCharAt(4, '7');

        App.PrintLog.w(TAG, "Altered GUID String " + myName);
        return myName.toString();
    }

    private int getIntegerFromString(String value) {
        return (value == null || value.equals("")) ? 0 : Integer.parseInt(value);
    }

    private void addItem() {


        String itemName = itemNameEdt.getText().toString();
        String height = heightEdt.getText().toString();
        String width = widthEdt.getText().toString();
        String depth = depthEdt.getText().toString();
        String tagName = tagNoTxt.getText().toString();
        String userId = PrefStorage.getValue(this,PrefStorage.USER_ID);
        int itemValue = getIntegerFromString(perValueEdt.getText().toString());

        String lbs = edt_lbs.getText().toString();
        String sidemark = tv_side_name.getText().toString();

        String cubicFt = calculateCubicFt(height, width, depth);
        String sqFt = calculateSqFt(width, depth);

        if (isCubicFtEdited)
            cubicFt = ed_cubicft.getText().toString();
        if (isSqFtEdited)
            sqFt = ed_squareft.getText().toString();

        Item item = new Item();
        item.setJobItemId(getGUId());//to change
        item.setItemQuantity("1");
        item.setItemName(itemName);
        item.setItemH(height);
        item.setItemD(depth);
        item.setItemW(width);
        item.setItemValue(itemValue);//to Know
        item.setItemCuFt(cubicFt);
        item.setItemSqFt(sqFt);
        item.setItemLbs(lbs);
        item.setIsConditionNotes(mExceptionsList.size() > 0);//if item has exceptions added then send true else false
        item.setBarCode(null);
        item.setIsNew(true);//newly added item then true else false
        item.setIsCubicOverride(isCubicFtEdited);//false if its calculated from above formula. True if manually given
        item.setIsSqFtOverride(isSqFtEdited);//false if its calculated from above formula. True if manually given
        item.setSeqNo(null);//For new item send as null, for edit mode send the data received from the API
        item.setSmarkId(sidemark);//For new item(isnew=true) assign the sidemarkId of the job. For edit mode send the received data.
        item.setIsQuickAdd(isQuickAdd);//Send true if the item is added from the QuickAdd(item search) else false
        item.setIsImportantNotes(false);//Send true if the item is added from the QuickAdd(item search) else false
        item.setConditionalNotes(mExceptionsList);
        item.setValuationTypeId("ec51e804-75c1-475a-a57f-3d613b4f7c82");//Static to be change

        TagDetail tagDetail = new TagDetail();
        tagDetail.setIsNew(isQuickAdd);
        tagDetail.setSeqNo(1);
        tagDetail.setTagId(0);
        tagDetail.setTagName(tagName);
        tagDetail.setCreatedBy(userId);
        tagDetail.setCreatedDate("08/03/2016");
        tagDetail.setModifiedBy(null);
        tagDetail.setModifiedDate(null);
        ArrayList<TagDetail> tagDetails = new ArrayList<>();
        tagDetails.add(tagDetail);

        item.setTagDetails(tagDetails);

        addedItemsList.add(item);

        itemAddAdapter.add(item);

        itemAddAdapter.notifyDataSetChanged();

        isCubicFtEdited = false;
        isSqFtEdited = false;

        totCubicFt = totCubicFt + getIntegerFromString(cubicFt);

    }

    public void addException() {
        App.PrintLog.i(TAG, "Exception Clicked");
        String exception = spinner_exception.getSelectedItem().toString();
        String location = spinner_location.getSelectedItem().toString();

        String exceptionId = exceptionList.get(spinner_exception.getSelectedItemPosition()).getCategoryValue();
        String locationId = locationList.get(spinner_location.getSelectedItemPosition()).getCategoryValue();

        App.PrintLog.d(TAG, exceptionId);
        App.PrintLog.d(TAG, locationId);

        String comments = edt_comments_desc.getText().toString();

        ConditionalNote cNote = new ConditionalNote();
        cNote.setExceptionId(exceptionId);
        cNote.setExceptionName(exception);
        cNote.setConditionalNoteId(0);
        cNote.setComments(comments);
        cNote.setLocationName(location);
        cNote.setLocationId(locationId);

        mExceptionsList.add(cNote);
        exceptionsAdapter.add(cNote);

        spinner_exception.setSelection(0);
        spinner_location.setSelection(0);
        edt_comments_desc.setText("");
        //exceptionsAdapter.notifyDataSetChanged();
    }


    public void createNewOderData(){

        showProgress();

        boolean isPuResidence = customerData.getCompanyId().equals(customerData.getContactId());
        String payTermId = customerData.getPayTermId();
        String companyId = customerData.getCompanyId();
        String billingContactId = customerData.getBillingContactId();
        String payerContId = customerData.getCompanyId();

        String createdBy = PrefStorage.getValue(this, PrefStorage.USER_ID);
        Job job = new Job();
        job.setJobId("00000000-0000-0000-0000-000000000000");//For new order set Null
        job.setJobDisplayId("00000000");//For new order set Null
        job.setIsPuResidence(isPuResidence);//If pickup is selected, check if the companyId & contactid. If both are same then send it as true else false
        job.setPayTermId(payTermId);//Fill the data from the PayTermId from the customer search for new. For edit mode send the data received from the API if the customer is not changed. If changed then Fill the data from the PayTermId from the customer search for new.
        job.setCompanyId(companyId);//Send the companyId from the login API
        job.setCubicFeet(Integer.toString(totCubicFt));//tot cubic area of all added items
        job.setPayerId(billingContactId);//Fill the data from the BillingContactId from the customer search for new. For edit mode send the data received from the API if the customer is not changed. If changed then Fill the data from the BillingContactId from the customer search for new.
        job.setPayerType("C");//Always C - Customer
        job.setItems(addedItemsList);//total items list
        job.setTotalItems(Integer.toString(addedItemsList.size()));//size of items
        job.setCreatedBy(createdBy);
        job.setPayerContId(payerContId);
        job.setOrginName("TEST COMPANY");

        Customer customer = new Customer();
        customer.setCompanyId(customerData.getCompanyId());
        customer.setContactId(customerData.getContactId());
        customer.setAddressId(customerData.getAddressId());

        Pickup pickup = new Pickup();
        pickup.setCompanyId(customerData.getCompanyId());
        pickup.setContactId(customerData.getContactId());
        pickup.setAddressId(customerData.getAddressId());

        Payer payer = new Payer();
        payer.setCompanyId(customerData.getCompanyId());
        payer.setContactId(customerData.getContactId());
        payer.setAddressId(customerData.getAddressId());

        job.setCustomer(customer);
        job.setPickup(pickup);
        job.setPayer(payer);

        Freight freight = new Freight();
        freight.setFreightId(0);
        freight.setJobId("00000000-0000-0000-0000-000000000000");
        freight.setCarrierId("bb58e42f-0554-e611-82ef-c0d9621c1f9d");
        freight.setCarrierName(null);
        freight.setFreightBillNo("322323");
        freight.setIsFreightBill(false);
        freight.setIsCollect(false);
        freight.setIsPrepaid(false);
        freight.setFreightAmt("565.00");
        freight.setWeight("34");

        job.setFreight(freight);

        masterData.setJob(job);
        masterData.setUserId(createdBy);
        masterData.setTrfJobId("00000000-0000-0000-0000-000000000000");

        newOrderPresenter.onJobPost(masterData);
    }

    public void removeException(int position) {
        exceptionList.remove(position);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        App.PrintLog.w(TAG, "requestCode ==> " + requestCode);
        App.PrintLog.w(TAG, "resultCode ==> " + resultCode);

        if (requestCode == NEW_ORDER_CUSTOMER) {
            if (resultCode == RESULT_OK) {

                Bundle bundle = data.getExtras();
                customerData = (SearchResponse.Company) bundle.getSerializable("CompanyData");
                boolean copyToOrgin = bundle.getBoolean("copyToOrgin");
                fillCustomerData(customerData, copyToOrgin);

            }
        } else if (requestCode == NEW_ORDER_SIDEMARK) {
            if (resultCode == RESULT_OK) {

                Bundle bundle = data.getExtras();
                sidemarkData = (SearchSidemarkResponse.Smark) bundle.getSerializable("SideMark");
                fillSidemarkData(sidemarkData);
                sidemark_card.setVisibility(View.VISIBLE);
                findViewById(R.id.view2).setVisibility(View.GONE);
            }
        }
    }

    private void fillCustomerData(SearchResponse.Company data, boolean copyToOrgin) {
        card_customercard.setVisibility(View.VISIBLE);
        findViewById(R.id.view1).setVisibility(View.GONE);
        App.PrintLog.i(TAG, "Customer Data filled");
        tv_customer_name.setText(data.getFirstName());
        tv_company_name.setText(data.getBusinessName());
        tv_city_name.setText(data.getCity());
        tv_state_name.setText(data.getState());
        if (copyToOrgin) {
            orgin_card.setVisibility(View.VISIBLE);
            findViewById(R.id.view3).setVisibility(View.GONE);
            tv_customer_name1.setText(data.getFirstName());
            tv_company_name1.setText(data.getBusinessName());
            tv_city_name1.setText(data.getCity());
            tv_state_name1.setText(data.getState());
        }

        /*Customer customer = new Customer();
        customer.setCompanyId(data.getCompanyId());
        customer.setContactId(data.getContactId());
        customer.setAddressId(data.getAddressId());

        masterData.getJob().setCustomer(customer);*/
    }

    private void fillSidemarkData(SearchSidemarkResponse.Smark sidemark) {
        App.PrintLog.i(TAG, "Sidemark Data filled");
        tv_side_name.setText(sidemark.getSmarkName());
        /*masterData.getJob().setSmarkId(sidemark.getSmarkId());
        masterData.getJob().setSmarkName(sidemark.getSmarkName());
        masterData.getJob().setStorageType(sidemark.getStorageType());
        masterData.getJob().setStorageTypeId(sidemark.getStorageTypeId());*/

    }

    @Override
    public void showProgress() {
        if (mDialog != null)
            if (!mDialog.isShowing())
                mDialog.show();
    }

    @Override
    public void hideProgress() {
        if (mDialog != null)
            mDialog.dismiss();
    }

    @Override
    public void showError() {

    }

    @Override
    public void onJobPostSuccess(String message) {
        hideProgress();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onJobPostFailure(String errorMessage) {
        hideProgress();
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}