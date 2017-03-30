/*
 * Yang, Michelle
 * APCS-A
 * Period 5
 * FBLA Members
 */

package yang.database.view;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import yang.database.mainApp;

public class RootLayoutController {

	//A reference to the main application:
	private mainApp mainApp;

	//This is called by the main application, to give a reference back to itself
	//@param mainApp
	public void setMainApp(mainApp mainApp) {
		this.mainApp = mainApp;
	}

	//This creates an empty address book
	@FXML
	private void handleNew() {
		//Clears the sales record with the inherited 'clear method'
		mainApp.getMemberList().clear();     //Clears the sales record with the inherited clear method
		mainApp.setMemberListFilePath(null);
	}

	//This opens a fileChooser and lets the user select a garage sale record to use
	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();

		//Sets extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml, arg1)", "*.xml");

		//Shows the save file
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

		if (file != null) {
			mainApp.loadMemberListFromFile(file);
		}
		else {
			System.out.println("GOT HERE - Shouldn't Have");
		}
	}

	//This method saves the file to the person file currently open
	//If there is no open file, the 'save as' dialog fires
	@FXML
	private void handleSave() {
		File personFile = mainApp.getMemberListFilePath();
			if (personFile != null) {
				mainApp.saveMemberListToFile(personFile);
			} else {
				handleSaveAs();
			}
	}

	//The following opens the fileChooser to let the user select the file to save to
	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		//Sets extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		//Shows 'save file' dialog
		File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

		if (file != null) {
			//Makes sure the file has the correct extension
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			mainApp.saveMemberListToFile(file);
		}
	}

	//Shows the About dialog
	@FXML
	private void handleAboutFBLA() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("FBLA");
		alert.setHeaderText("About");
		alert.setContentText("As of the 2016-2017 school year, Johns Creek High School has nearly 200 Future Business Leaders of America. FBLA strives to continually grow its membership and to pursue technological advances to keep up with the numbers.");

		alert.showAndWait();
	}

	@FXML
	private void handleLeadership() {
		boolean okClicked = mainApp.showLeadershipInfo();
        if (okClicked) {

        }
	}

	@FXML
	private void handleCredits() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Credits");
		alert.setHeaderText("About");
		alert.setContentText("Modified code by Michelle Yang:\nCommander Schenk\nhttp://code.makery.ch");

		alert.showAndWait();
	}


	//The application is closed when the user chooses to exit
	@FXML
	private void handleExit() {
		System.exit(0);
	}

}
