package Screens;

import export_use_case.ExportInputBoundary;
import export_use_case.ExportRequestModel;

import java.io.IOException;

public class ExportController {
    //userInput is an interactor that implements the methods described by the interface
    final ExportInputBoundary userInput;

    /**
     * Constructor for the Export Controller
     * @param ExportGateway to connect to the outer layer
     */
    //userInput is an interactor that implements the methods described by the interface
    public ExportController(ExportInputBoundary ExportGateway) {
        this.userInput = ExportGateway;
    }

    //take in input from the user
    ExportViewModel create(String invName, String[][] inventorytable) throws IOException {

        //take user input and pass into the use case interactor
        ExportRequestModel ExportRequestModel = new ExportRequestModel(invName,inventorytable);

        return userInput.create(ExportRequestModel);

    }
}