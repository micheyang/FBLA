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

	//Private modifiers are used for encapsulation.
		//In order for the loader to put what we've made in the FXML files into the controller, @FXML modifiers are needed
		//The following are generics because they can take in multiple data types which are specified in the <>
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

		//As a field, the main application passes a reference of itself to the controller
		private mainApp mainApp;

		//The loader needs this empty constructor because it locates this first
		//Afterwards, it will call initialize() if it has @FXML before it
		public MemberOverviewController() {

		}

		@FXML
		private void initialize() {

			//Once the loader gets to the constructor, this method is always called right after
			//We use it to create the columns of the salesRecord information

			lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().memberLastNameProperty());
			firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().memberFirstNameProperty());
			genderAndGradeColumn.setCellValueFactory(cellData -> cellData.getValue().memberGenderAndGradeProperty());
			emailColumn.setCellValueFactory(cellData -> cellData.getValue().memberEmailProperty());
			phoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().memberPhoneNumberProperty());
			shirtSizeColumn.setCellValueFactory(cellData -> cellData.getValue().memberShirtSizeProperty());

		}

		//@param mainApp
		public void setMainApp(mainApp mainApp) {

			//Once the main application is passed in, this method sets the field for the controller to it
			//Therefore, it can have a pointer to itself because the main application's pointer is set in the controller's field
			this.mainApp = mainApp;

			//The following receives the SalesRecord items and sets those passes of the main application's pointer into the itemTable
			memberTable.setItems(mainApp.getMemberList());
		}


		/*
		 * This was to test if I could add in this button.
		@FXML
	    private void handleExportMember() {
	        //Item tempItem = new Item();
	        boolean okClicked = mainApp.showExportDialog();
	        if (okClicked) {
	            //mainApp.getSalesRecord().add(tempItem);
	        }
	    }
	    */
		@FXML
	    private void handleExportMember() {
	        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
	        if (selectedMember != null) {
	            boolean okClicked = mainApp.showExportDialog(selectedMember);
	            if (okClicked) {
	            	//showItemDetails(selectedItem);
	            }

	        } else {
	            //When nothing is selected, the following alert is displayed
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.initOwner(mainApp.getPrimaryStage());
	            alert.setTitle("No Selection");
	            alert.setHeaderText("No Member Selected");
	            alert.setContentText("Please select a member in the table to export their information.");

	            alert.showAndWait();

	        }
	    }

		//The following is the Item Editing Dialog Control section for buttons

		//This method is called whenever a user asks to add a new person--clicks the new button
		    @FXML
		    private void handleNewMember() {
		        Member tempMember = new Member();
		        boolean okClicked = mainApp.showMemberEditDialog(tempMember);
		        if (okClicked) {
		            mainApp.getMemberList().add(tempMember);
		        }
		    }

			//This method handles the editing of an Item
		    @FXML
		    private void handleEditMember() {
		        Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
		        if (selectedMember != null) {
		            boolean okClicked = mainApp.showMemberEditDialog(selectedMember);
		            if (okClicked) {
		            	//showMemberDetails(selectedMember);
		            }

		        } else {
		            //When nothing is selected, the following alert is displayed
		            Alert alert = new Alert(AlertType.WARNING);
		            alert.initOwner(mainApp.getPrimaryStage());
		            alert.setTitle("No Selection");
		            alert.setHeaderText("No Member Selected");
		            alert.setContentText("Please select a member in the table to edit their information.");

		            alert.showAndWait();

		        }
		    }

		    //This method handles the delete button
		    @FXML
		    private void handleDeleteMember(){
		    	int selectedIndex = memberTable.getSelectionModel().getSelectedIndex();

		    	//tutorial note: added error handling code after initial build of this method
		    	if (selectedIndex >=0) {
		    	memberTable.getItems().remove(selectedIndex);

		    	} else {
		    		//When nothing is selected, the following alert is displayed
		    		Alert alert = new Alert(AlertType.WARNING);
		    		alert.initOwner(mainApp.getPrimaryStage());
		    		alert.setTitle("No Selection Made");
		    		alert.setHeaderText("No Member Selected");
		    		alert.setContentText("Please select a member in the table to delete their information.");

		    		alert.showAndWait();

		    	}

		    }

}
