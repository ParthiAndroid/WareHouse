package com.inventry.warehouse.businesslayer.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.inventry.warehouse.App;
import com.inventry.warehouse.BuildConfig;
import com.inventry.warehouse.businesslayer.model.Category;
import com.inventry.warehouse.businesslayer.model.MasterDataResponse;
import com.inventry.warehouse.businesslayer.model.UnSyncedOrder;

import java.sql.SQLException;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    /**
     * @author : -
     * @updated : -
     * @LastUpdated : -
     * @details : -
     */

    private static final String TAG = DBHelper.class.getSimpleName();

    //***************************************DATABASE********************************************//
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "IPCWareHouse.db";
    //*******************************************************************************************//

    //***************************************TABLE***********************************************//
    // table name
    private static final String TABLE_Master = "WarehouseTableMaster";
    private static final String TABLE_CategoryMaster = "WarehouseCategoryMaster";


    //Columns names for TableMaster
    public static final String KEY_ID = "Id";
    public static final String USER_NAME = "UserName";
    public static final String CUSTOMER_NAME = "CustomerName";
    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String COMPANY_NAME = "CompanyName";
    public static final String CONTACT_NO = "ContactNo";
    public static final String CUSTOMER_ADDRESS = "CustomerAddress";
    public static final String ZIPCODE = "ZipCode";
    public static final String CITY = "City";
    public static final String STATE = "STATE";
    public static final String DATE_ADDED = "DateAdded";
    public static final String CSR_NAME = "CSRName";
    public static final String SIDEMARK = "Sidemark";

    public static final String IS_ALREADY_SYNCED = "IsAlreadySynced";


    ///Columns names for Category Table////
    private static final String CATEGORY_NAME = "CategoryName";
    private static final String CATEGORY_KEY = "CategoryKey";
    private static final String CATEGORY_VALUE = "CategoryValue";


    /**********************************************************************************************/
    ////////////////////////////////////////////TABLES//////////////////////////////////////////////
    /**********************************************************************************************/
    //create tables
    private static final String CREATE_TABLE_MASTER = "CREATE TABLE "
            + TABLE_Master + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + USER_NAME + " TEXT, " + CUSTOMER_NAME + " TEXT, " + CSR_NAME + " TEXT, "
            + SIDEMARK + " TEXT, " + DATE_ADDED + " TEXT);";

    private static final String CREATE_CATEGORY_MASTER = "CREATE TABLE "
            + TABLE_CategoryMaster + "(" + CATEGORY_NAME + " TEXT, " + CATEGORY_KEY + " TEXT, " + CATEGORY_VALUE + " TEXT);";

    /**********************************************************************************************/

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MASTER);
        db.execSQL(CREATE_CATEGORY_MASTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /****************************************
     * TABLE**UPDATES
     ****************************************/

    public void insertUnSyncedDataToMaster(String custName, String sideMark,
                                           String csrName, String dateAdded,
                                           boolean isAlreadySynced) {

        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ContentValues value = new ContentValues();
            value.put(USER_NAME, App.getInstance().getUserName());
            value.put(CUSTOMER_NAME, custName);
            value.put(SIDEMARK, sideMark);
            value.put(CSR_NAME, csrName);
            value.put(DATE_ADDED, dateAdded);
            value.put(IS_ALREADY_SYNCED, BuildConfig.FLAVOR + isAlreadySynced);

            long rowInserted = db.insert(TABLE_Master, null, value);
            if (rowInserted != -1)
                Log.e(TAG, "Row Values added");
            else
                Log.e(TAG, "Row Something went wrong");
        } catch (Exception e) {
            e.printStackTrace();
        }

        db.close();
    }

    /*public void updateMaster(String imgId, String clientName, String sideMark, String itemId, String isSuccess) {
        SQLiteDatabase db = this.getWritableDatabase();

        String updateQuery = "UPDATE " + TABLE_Master + " SET "
                + SIDE_MARK + "= '" + sideMark + "',"
                + CLIENT_NAME + "='" + clientName + "',"
                + ITEM_ID + "='" + itemId + "',"
                + IS_ALREADY_SYNCED + "='" + isSuccess
                + "' WHERE " + IMAGE_ID + "='" + imgId + "'";
        Log.d(TAG, "updateQuery==>" + updateQuery);
        try {
            db.execSQL(updateQuery);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "Row Updated");
        db.close();
    }*/

    public synchronized boolean isAlreadySyncedItem(String rowId) {
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor cur = db.rawQuery("SELECT * FROM " + TABLE_Master + " WHERE " + KEY_ID + " = '"
                    + rowId + "' AND " + IS_ALREADY_SYNCED + " = 'true'", null);
            if (cur.getCount() > 0) { // This will get the number of rows
                return true;
            }
            cur.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return false;
    }

    /*public void setJunkDataByRowId(String imageId, String isJunkData) {
        SQLiteDatabase db = this.getWritableDatabase();

        String updateQuery = "UPDATE " + TABLE_Master + " SET "
                + IS_JUNK_DATA + "='" + isJunkData
                + "' WHERE " + IMAGE_ID + "='" + imageId + "'";
        Log.i(TAG, "updateQuery ==>" + updateQuery);
        try {
            db.execSQL(updateQuery);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "Row Updated");
        db.close();
    }*/

    /*public synchronized boolean isJunkItem(String imageId) {
        SQLiteDatabase db = this.getReadableDatabase();
        try {

            String query = "SELECT * FROM " + TABLE_Master + " WHERE " + IMAGE_ID + " = '"
                    + imageId + "' AND " + IS_JUNK_DATA + " ='true'";
            Log.i(TAG, "IsJunkItem  Query  ==>" + query);

            Cursor cur = db.rawQuery(query, null);
            Log.e(TAG, "Cursor count " + cur.getCount());
            if (cur.getCount() > 0) { // This will get the number of rows
                cur.close();
                db.close();
                return true;
            }
            cur.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return false;
    }*/

    public synchronized int getTableRowCount() {
        String userName = App.getInstance().getUserName();
        SQLiteDatabase db = this.getReadableDatabase();
        int rowCount = 0;
        try {
            Cursor cur = db.rawQuery("SELECT * FROM " + TABLE_Master + " WHERE " + USER_NAME + " = '" + userName + "'", null);
            rowCount = cur.getCount();
            cur.close();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        db.close();
        return rowCount;
    }

    public synchronized String getOrderId() {
        StringBuilder orderID = new StringBuilder();
        int orderId = getTableRowCount() + 1;
        if (orderId < 10000) {

            for (int i = Integer.toString(orderId).length(); i <= 4; i++) {
                orderID.append("0");
            }
            orderID.append(orderId);
            return "New Order " + orderID.toString();
        }

        return "New Order " + Integer.toString(orderId);
    }

    public ArrayList<UnSyncedOrder> getUnSyncedData() {
        String userName = App.getInstance().getUserName();
        SQLiteDatabase db = this.getReadableDatabase();
        String sqrQuery = "SELECT * from " + TABLE_Master + " WHERE " + IS_ALREADY_SYNCED
                + " = 'false' AND " + USER_NAME + " = '" + userName;
        //Log.i(tag, "getAllSavedData==>" + sqrQuery);
        ArrayList<UnSyncedOrder> unSyncedOrders = new ArrayList<>();
        try {
            Cursor cursor = db.rawQuery(sqrQuery, null);
            UnSyncedOrder unSyncedItem;
            if (cursor.moveToFirst()) {
                do {
                    unSyncedItem = new UnSyncedOrder();
                    unSyncedItem.setCustomerName(cursor.getString(cursor.getColumnIndex(CUSTOMER_NAME)));
                    unSyncedItem.setCsrName(cursor.getString(cursor.getColumnIndex(CSR_NAME)));
                    unSyncedItem.setDateAdded(cursor.getString(cursor.getColumnIndex(DATE_ADDED)));
                    unSyncedItem.setSideMark(cursor.getString(cursor.getColumnIndex(SIDEMARK)));
                    unSyncedItem.setOrderId(cursor.getString(cursor.getColumnIndex(KEY_ID)));

                    unSyncedOrders.add(unSyncedItem);

                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();

        return unSyncedOrders;
    }

    /*public ArrayList<InventoryItemModel> getSavedItems() {
        String userName = App.getInstance().getUserName();
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlQuery = "SELECT * FROM " + TABLE_Master + " WHERE " + USERNAME + " = '"
                + userName + "' ORDER BY " + KEY_ID + " DESC";
        //Log.i(tag, "getAllSavedData==>" + sqrQuery);
        ArrayList<InventoryItemModel> inventoryList = new ArrayList<>();
        try {
            Cursor cursor = db.rawQuery(sqlQuery, null);
            InventoryItemModel cModel;
            if (cursor.moveToFirst() && cursor.getCount() > 0) {
                do {
                    cModel = new InventoryItemModel();
                    cModel.setItemId(cursor.getString(cursor.getColumnIndex(KEY_ID)));
                    cModel.setClientName(cursor.getString(cursor.getColumnIndex(CLIENT_NAME)));
                    cModel.setBarcodeId(cursor.getString(cursor.getColumnIndex(BARCODE_ID)));
                    cModel.setDateAdded(cursor.getString(cursor.getColumnIndex(DATE_ADDED)));
                    cModel.setSideMark(cursor.getString(cursor.getColumnIndex(SIDE_MARK)));
                    cModel.setLocalImagePath(cursor.getString(cursor.getColumnIndex(IMAGE_PATH)));
                    cModel.setImageId(cursor.getString(cursor.getColumnIndex(IMAGE_ID)));
                    cModel.setIsAlreadySynced(cursor.getString(cursor.getColumnIndex(IS_ALREADY_SYNCED)).equals("true"));
                    cModel.setOrientation(cursor.getString(cursor.getColumnIndex(IMG_ORIENTATION)));

                    inventoryList.add(cModel);

                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        */

    /***
     * To get the recent item first
     **//*
        //Collections.reverse(inventryList);

        return inventoryList;
    }*/
    public void deleteItems(String orderId) {

        SQLiteDatabase db = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM " + TABLE_Master + " WHERE " + KEY_ID + "='" + orderId + "'";
        try {
            //Log.e(TAG, "imageId  " + imageId);
            db.execSQL(deleteQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }

        db.close();
    }

    public ArrayList<Category> getDictionaryPair(String categoryName) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CategoryMaster + " WHERE " + CATEGORY_NAME + " = '" + categoryName + "'";
        ArrayList<Category> cModelList = new ArrayList<>();
        try {
            Cursor cursor = db.rawQuery(query, null);
            Category category;
            if (cursor.moveToFirst() && cursor.getCount() > 0) {
                do {
                    category = new Category();
                    category.setCategoryName(cursor.getString(cursor.getColumnIndex(CATEGORY_NAME)));
                    category.setCategoryKey(cursor.getString(cursor.getColumnIndex(CATEGORY_KEY)));
                    category.setCategoryValue(cursor.getString(cursor.getColumnIndex(CATEGORY_VALUE)));
                    cModelList.add(category);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        db.close();
        return cModelList;
    }

    public boolean insertMasterData(MasterDataResponse masterData) {
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            ///db.beginTransaction();

            for (int i = 0; i < masterData.getCategory().size(); i++) {
                try {
                    MasterDataResponse.Category category = masterData.getCategory().get(i);
                    String categoryName = category.getCategoryName();
                    for (int j = 0; j < category.getDictionaryPair().size(); j++) {
                        MasterDataResponse.Category.DictionaryPair keyPair = category.getDictionaryPair().get(j);

                        ContentValues value = new ContentValues();
                        value.put(CATEGORY_NAME, categoryName);
                        value.put(CATEGORY_KEY, keyPair.getKey());
                        value.put(CATEGORY_VALUE, keyPair.getValue());

                        long rowInserted = db.insert(TABLE_CategoryMaster, null, value);
                        if (rowInserted != -1)
                            Log.e(TAG, "Row Values added");
                        else
                            Log.e(TAG, "Row Something went wrong");
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //db.endTransaction();
        }


        /*try {
            ContentValues value = new ContentValues();
            value.put(USER_NAME, App.getInstance().getUserName());
            value.put(CUSTOMER_NAME, custName);
            value.put(SIDEMARK, sideMark);
            value.put(CSR_NAME, csrName);
            value.put(DATE_ADDED, dateAdded);

            long rowInserted = db.insert(CREATE_CATEGORY_MASTER, null, value);
            if (rowInserted != -1)
                Log.e(TAG, "Row Values added");
            else
                Log.e(TAG, "Row Something went wrong");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        db.close();
        return true;
    }

    /*public ArrayList<InventoryItemModel> getItemsByPage(int itemCount, int limit) {

        ArrayList<InventoryItemModel> inventryList = new ArrayList<>();
        String query;
        if (limit > 10) {
            query = "select * from " + TABLE_Master + " order by " + KEY_ID + " DESC limit " + limit + " OFFSET " + itemCount;
        } else {
            query = "select * from " + TABLE_Master + " order by " + KEY_ID + " DESC limit " + limit;
        }
        Log.i(TAG, "getAllSavedData==>" + query);
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            Cursor cursor = db.rawQuery(query, null);
            InventoryItemModel cModel;
            if (cursor.moveToFirst() && cursor.getCount() > 0) {
                do {
                    cModel = new InventoryItemModel();
                    cModel.setItemId(cursor.getString(cursor.getColumnIndex(KEY_ID)));
                    cModel.setClientName(cursor.getString(cursor.getColumnIndex(CLIENT_NAME)));
                    cModel.setBarcodeId(cursor.getString(cursor.getColumnIndex(BARCODE_ID)));
                    cModel.setDateAdded(cursor.getString(cursor.getColumnIndex(DATE_ADDED)));
                    cModel.setSideMark(cursor.getString(cursor.getColumnIndex(SIDE_MARK)));
                    cModel.setLocalImagePath(cursor.getString(cursor.getColumnIndex(IMAGE_PATH)));
                    cModel.setImageId(cursor.getString(cursor.getColumnIndex(IMAGE_ID)));
                    cModel.setIsAlreadySynced(cursor.getString(cursor.getColumnIndex(IS_ALREADY_SYNCED)).equals("true"));

                    inventryList.add(cModel);

                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();

        return inventryList;
    }*/
}