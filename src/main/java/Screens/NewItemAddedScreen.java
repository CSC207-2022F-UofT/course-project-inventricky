package Screens;

import new_item_use_case.NewItemPresenter;
import new_item_use_case.NewItemResponseModel;

//TODO implement methods
public class NewItemAddedScreen implements NewItemPresenter {
    @Override
    public NewItemResponseModel prepareSuccessView(NewItemResponseModel item) {
        return null;
    }

    @Override
    public NewItemResponseModel prepareFailView(String error) {
        return null;
    }
}
