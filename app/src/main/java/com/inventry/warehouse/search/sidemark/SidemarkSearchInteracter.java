package com.inventry.warehouse.search.sidemark;

import com.inventry.warehouse.businesslayer.model.SearchSidemarkResponse;

import java.util.List;

public class SidemarkSearchInteracter {

    interface ViewInteractor {

        void showProgress();

        void hideProgress();

        void showError();

        void onSearchFinished(List<SearchSidemarkResponse.Smark> searchedContents);

        void onSearchFailure(String errorMessage);

    }

    interface ActionListener {
        void onSearchClicked(String searchContent, String companyId);
    }

}
