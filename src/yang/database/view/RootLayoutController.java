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

	//Reference to the mainApp
	private mainApp mainApp;

	/**
	 * Sets the field for the controller to the mainApp so it can have a pointer to itself
	 *
	 * @param mainApp	passes in the main application
	 */
	public void setMainApp(mainApp mainApp) {
		this.mainApp = mainApp;
	}

	//Creates an new empty list
	@FXML
	private void handleNew() {

		//Clears the member list that was there initially
		mainApp.getMemberList().clear();
		mainApp.setMemberListFilePath(null);
	}

	//Opens the FileChooser for the user to choose the member list to use
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

	//Saves the file to the currently open file
	//If there is no open file, it jumps to the save as method below
	@FXML
	private void handleSave() {
		File personFile = mainApp.getMemberListFilePath();
			if (personFile != null) {
				mainApp.saveMemberListToFile(personFile);
			} else {
				handleSaveAs();
			}
	}

	//Opens the FileChooser for the user to locate and select a file to save the list to
	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		//Sets extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		//Shows dialog to save the file
		File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

		if (file != null) {
			//Checks that the file has the right extension
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			mainApp.saveMemberListToFile(file);
		}
	}

	//Shows short blurb about Future Business Leaders of America
	@FXML
	private void handleAboutFBLA() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("FBLA");
		alert.setHeaderText("About");
		alert.setContentText("As of the 2016-2017 school year, Johns Creek High School has nearly 200 Future Business Leaders of America. FBLA strives to continually grow its membership and to pursue technological advances to keep up with the numbers.");

		alert.showAndWait();
	}

	//Calls the controller class of LeadershipInfo through a method in the mainApp to display a comprehensive dialog of the FBLA Leadership Team
	@FXML
	private void handleLeadership() {
		boolean okClicked = mainApp.showLeadershipInfo();
        if (okClicked) {

        }
	}

	//Mentions the guide that helped me with developing this code
	@FXML
	private void handleCredits() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Credits");
		alert.setHeaderText("About");
		alert.setContentText("Modified code by Michelle Yang:\nhttp://code.makery.ch");

		alert.showAndWait();
	}


	//Closes application when the user selects Exit
	@FXML
	private void handleExit() {
		System.exit(0);
	}

}
