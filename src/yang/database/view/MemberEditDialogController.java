/*
 * Yang, Michelle
 * APCS-A
 * Period 5
 * FBLA Members
 */

package yang.database.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yang.database.model.Member;

public class MemberEditDialogController {

	@FXML
	private TextField lastNameField;
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField genderAndGradeField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField phoneNumberField;
	@FXML
	private TextField shirtSizeField;

	private Stage dialogStage;
	private Member member;
	private boolean okClicked = false;

	//Called right after the FXML file is loaded
    public void initialize() {

    }

	/**
	 * Sets the new dialog stage for the FMXL file to appear in
	 *
	 * @param dialogStage	provides the setting for the dialog to appear on
	 */
    public void setDialogStage(Stage dialogStage) {
    	this.dialogStage = dialogStage;
    }

    /**
     * Sets the selected member's information into their respective categories
     *
     * @param member	retrieves the information of the selected member
     */
    public void setMember(Member member) {
    	this.member = member;

    	lastNameField.setText(member.getmemberLastName());
    	firstNameField.setText(member.getmemberFirstName());
    	genderAndGradeField.setText(member.getmemberGenderAndGrade());
    	emailField.setText(member.getmemberEmail());
    	phoneNumberField.setText(member.getmemberPhoneNumber());
    	shirtSizeField.setText(member.getmemberShirtSize());
    }

    //Takes in the any new information that was entered and sets it to the respective field before closing the dialog
    @FXML
    private void handleOk() {
    	if (isInputValid()) {
    		member.setmemberLastName(lastNameField.getText());
    		member.setmemberFirstName(firstNameField.getText());
            member.setmemberGenderAndGrade(genderAndGradeField.getText());
            member.setmemberEmail(emailField.getText());
            member.setmemberPhoneNumber(phoneNumberField.getText());
            member.setmemberShirtSize(shirtSizeField.getText());


            okClicked = true;
            dialogStage.close();
    	}
    }

    //Lets the mainApp know that the OK button was clicked
    public boolean isOkClicked() {
    	return okClicked;
    }

    //Called when the user clicks Cancel
    @FXML
    private void handleCancel() {
    	dialogStage.close();
    }

    //If any of the fields are empty, the respective error messages appear
    private boolean isInputValid(){
    	String errorMessage = "";

    	if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "Invalid last name!\n";
        }
    	if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "Invalid first name!\n";
        }
        if (genderAndGradeField.getText() == null || genderAndGradeField.getText().length() == 0) {
            errorMessage += "Invalid gender or grade!\n";
        }
    	if (emailField.getText() == null || emailField.getText().length() == 0) {
            errorMessage += "Invalid email!\n";
        }
    	if (phoneNumberField.getText() == null || phoneNumberField.getText().length() == 0) {
            errorMessage += "Invalid phone number!\n";
        }
    	if (shirtSizeField.getText() == null || shirtSizeField.getText().length() == 0) {
            errorMessage += "Invalid shirt size!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {

            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
