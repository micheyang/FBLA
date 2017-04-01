/*
 * Yang, Michelle
 * APCS-A
 * Period 5
 * FBLA Members
 */

package yang.database.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import yang.database.model.Member;

public class ExportDialogController {

	//Gives an fx:id to those controls in the FXML file
	@FXML
	private RadioButton email;
	@FXML
	private RadioButton shirtSize;
	@FXML
	private TextField selectedInformation;

	//Creates a new stage for the dialog to show up in
	private Stage dialogStage;
	//Returns to the method in mainApp whether or not Done was clicked
	private boolean doneClicked = false;

	//Called right after the FXML file is loaded
	public void initialize() {

	}

	/**
	 * Extracts the email and t-shirt information to be exported to an external program
	 *
	 * @param member	retrieves the information of the selected member
	 */
	public void getInfo(Member member) {

		//Puts the two RadioButtons into one ToggleGroup so that their actions relate to each other
	    ToggleGroup group = new ToggleGroup();
	    email.setToggleGroup(group);
	    shirtSize.setToggleGroup(group);

	    //Replaces the name of one RadioButton with the member's email and the other with the full name of the member, a colon, and the letter of their t-shirt size
	    email.setText(member.getmemberEmail());
	    shirtSize.setText(member.getmemberFirstName() + " " + member.getmemberLastName() + ": " + member.getmemberShirtSize().substring(0, 1));

	    //Makes the initially selected RadioButton, upon the dialog opening, the member's email
	    group.selectToggle(email);

	    //Sets the name of the selected RadioButton into the TextField
		selectedInformation.textProperty().setValue(((RadioButton) group.getSelectedToggle()).getText());

		//Determines if another RadioButton is clicked and deselects the previously selected one
	    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	    	public void changed(ObservableValue<? extends Toggle> ov,
	    			Toggle old_toggle, Toggle new_toggle) {

	    		//Retrieves the new RadioButton's name and sets it in the TextField
	    		if (group.getSelectedToggle() != null) {
	    	        	selectedInformation.textProperty().setValue(((RadioButton) group.getSelectedToggle()).getText());;
	    		}
	    			}
	    });

	}

	/**
	 * Sets the new dialog stage for the FMXL file to appear in
	 *
	 * @param dialogStage	provides the setting for the dialog to appear on
	 */
	public void setDialogStage(Stage dialogStage) {
	    this.dialogStage = dialogStage;
	}

	//Lets the mainApp know that the Done button was clicked
	public boolean isDoneClicked() {
	   	return doneClicked;
	}


	//Called when the user clicks Done
	@FXML
	private void handleDone() {
		doneClicked = true;
		dialogStage.close();

	}

}
