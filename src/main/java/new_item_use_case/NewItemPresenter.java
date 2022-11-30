package new_item_use_case;

//Presenter
public interface NewItemPresenter {

    //item added to database, display item details
    NewItemResponseModel prepareSuccessView(NewItemResponseModel item);

    NewItemResponseModel prepareFailView(String error); //TODO more speicific errors
}
