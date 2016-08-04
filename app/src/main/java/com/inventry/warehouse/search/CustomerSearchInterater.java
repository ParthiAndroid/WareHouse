package com.inventry.warehouse.search;

import com.inventry.warehouse.businesslayer.model.CustomerSearchModel;
import com.inventry.warehouse.businesslayer.model.SearchResponse;

import java.util.List;

public class CustomerSearchInterater {

    interface ViewInteractor {

        void showProgress();

        void hideProgress();

        void showError();

        void onSearchFinished(List<SearchResponse.Company> searchedContents);

        void onSearchFailure(String errorMessage);

    }

    interface ActionListener {
        void onSearchClicked(String itemType, String itemName);
    }
}
