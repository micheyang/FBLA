/*
 * Yang, Michelle
 * APCS-A
 * Period 5
 * FBLA Members
 */

package yang.database.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import yang.database.mainApp;
import yang.database.model.Member;

public class MemberOverviewController {

	//@FXML modifiers help the loader put the FXML files that we've created in SceneBuilder into this controller
	//Generics are used because they can take in the data types specified in the <>
	@FXML
	private TableView<Member> memberTable;
	@FXML
	private TableColumn<Member, String> lastNameColumn;
	@FXML
	private TableColumn<Member, String> firstNameColumn;
	@FXML
	private TableColumn<Member, String> genderAndGradeColumn;
	@FXML
	private TableColumn<Member, String> emailColumn;
	@FXML
	private TableColumn<Member, String> phoneNumberColumn;
	@FXML
	private TableColumn<Member, String> shirtSizeColumn;

	//Since it's a field, the main application can pass a reference of itself to the controller
	private mainApp mainApp;

	//First the loader locates this empty constructor, then it calls initialize() if it has @FXML before it
	public MemberOverviewController() {

	}

	//Called right after the FXML file is loaded
	@FXML
	private void initialize() {

		//Creation of the columns in the memberTable
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().memberLastNameProperty());
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().memberFirstNameProperty());
		genderAndGradeColumn.setCellValueFactory(cellData -> cellData.getValue().memberGenderAndGradeProperty());
		emailColumn.setCellValueFactory(cellData -> cellData.getValue().memberEmailProperty());
		phoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().memberPhoneNumberProperty());
		shirtSizeColumn.setCellValueFactory(cellData -> cellData.getValue().memberShirtSizeProperty());

	}

	/**
	 * Sets the field for the controller to the mainApp so it can have a pointer to itself
	 *
	 * @param mainApp	passes in the main application
	 */
	public void setMainApp(mainApp mainApp) {

		this.mainApp = mainApp;

		//Sets passes of the mainApp's pointer into the memberTable after receiving the members' information from the list
		memberTable.setItems(mainApp.getMemberList());

	}

	//The following are the methods for all of the buttons.

	/*
	Testing how to add in a basic button
	@FXML
    private void handleExportMember() {
        //Item tempItem = new Item();
        boolean okClicked = mainApp.showExportDialog();
        if (okClicked) {
            //mainApp.getSalesRecord().add(tempItem);
        }
    }
    */

	//Called when the Export button is pressed and a member is selected
	//Extracts the member's email and t-shirt size and puts them into a dialog box with two radio buttons and a text field
	@FXML
    private void handleExportMember() {
        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
        if (selectedMember != null) {
            boolean okClicked = mainApp.showExportDialog(selectedMember);
            if (okClicked) {
            }

        } else {
            //When a member isn't selected, the following alert is displayed
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Member Selected");
            alert.setContentText("Please select a member in the table to export their information.");

            alert.showAndWait();

        }
    }

	//Called when the New button is pressed
	//Opens the dialog box that asks for all of the member's information to be entered into text fields
    @FXML
    private void handleNewMember() {
        Member tempMember = new Member();
        boolean okClicked = mainApp.showMemberEditDialog(tempMember);
        if (okClicked) {
	            mainApp.getMemberList().add(tempMember);
        }
    }

	//Called when the Edit button is pressed and a member is selected
    //Opens the dialog box with all of the member's current information set into text fields to be changed
    @FXML
    private void handleEditMember() {
        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
        if (selectedMember != null) {
            boolean okClicked = mainApp.showMemberEditDialog(selectedMember);
            if (okClicked) {
            }

        } else {
        	//When a member isn't selected, the following alert is displayed
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Member Selected");
            alert.setContentText("Please select a member in the table to edit their information.");

            alert.showAndWait();

        }
    }

    //Called when the Delete button is pressed and a member is selected
    //Selected member is removed from the member list
    @FXML
    private void handleDeleteMember(){
    	int selectedIndex = memberTable.getSelectionModel().getSelectedIndex();
    	if (selectedIndex >=0) {
    	memberTable.getItems().remove(selectedIndex);

    	} else {
    		//When a member isn't selected, the following alert is displayed
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.initOwner(mainApp.getPrimaryStage());
    		alert.setTitle("No Selection Made");
    		alert.setHeaderText("No Member Selected");
    		alert.setContentText("Please select a member in the table to delete their information.");

    		alert.showAndWait();

		}

    }

}
