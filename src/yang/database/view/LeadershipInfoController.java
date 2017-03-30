/*
 * Yang, Michelle
 * APCS-A
 * Period 5
 * FBLA Members
 */

package yang.database.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LeadershipInfoController {

	@FXML
	private ImageView portrait;
	@FXML
	private ChoiceBox<String> chooseAPosition;

	private Stage dialogStage;
	private boolean okClicked = false;

	public void initialize() {

	}

	//Sets the new dialog stage for the FMXL file to appear in

	public void setDialogStage(Stage dialogStage) {
	    this.dialogStage = dialogStage;
	}

	//Displays a picture of each member of the FBLA leadership team after selecting their position from the drop-down menu
	public void showPortraits() {

		//Puts the selectable items into the ChoiceBox through an ObservableList
		chooseAPosition.setItems(FXCollections.observableArrayList(
			    "Sponsor", "President", "Vice President", "Secretary", "Treasurer")
			);

		//Gets the selected index and puts it into a Listener to determine which was chosen
		chooseAPosition.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			//Takes in the number of the chosen position and sets the respective image to the ImageView
			@Override
		    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {

				switch (chooseAPosition.getItems().get((Integer) number2)) {

		    	case "Sponsor" :  {
		    		Image image = new Image("file:resources/Mrs.Cowart.png");
		    		portrait.setImage(image);
		    	  	break;
		    	}

		    	//The following pictures are just placeholders for next year's officers
		    	case "President" :  {
		    		Image image = new Image("file:resources/Photo.png");
    	  			portrait.setImage(image);
    	  			break;
		    	}
		    	case "Vice President" :  {
    	  			Image image = new Image("file:resources/Photo2.png");
    	  			portrait.setImage(image);
    	  			break;
    	  		}
		    	case "Secretary" :  {
    	  			Image image = new Image("file:resources/Photo3.png");
    	  			portrait.setImage(image);
    	  			break;
    	  		}
		    	case "Treasurer" :  {
  	  				Image image = new Image("file:resources/Photo4.png");
  	  				portrait.setImage(image);
  	  				break;
		    	}

				}
			}
			});

	}

	//Called by the mainApp at the end of the method that runs this class and its FXML file
	public boolean isOkClicked() {
	   	return okClicked;
	}


	//Called when the user clicks OK
	@FXML
	private void handleOk() {
		okClicked = true;
		dialogStage.close();

	}

}
