package com.inventry.warehouse.orders.neworder;


public class NewOrderInteracter {


    interface ViewInteractor {

        void showProgress();

        void hideProgress();

        void showError();

        void onJobPostSuccess(String msg);

        void onJobPostFailure(String errorMessage);

    }

    interface ActionListener {
        void onJobPost(NewOrder order);
    }
}
