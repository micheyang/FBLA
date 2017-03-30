/*
 * Yang, Michelle
 * APCS-A
 * Period 5
 * FBLA Members
 */

package yang.database;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import yang.database.model.MemberListWrapper;
import yang.database.view.RootLayoutController;
import yang.database.mainApp;
import yang.database.model.Member;
import yang.database.view.ExportDialogController;
import yang.database.view.LeadershipInfoController;
import yang.database.view.MemberEditDialogController;
import yang.database.view.MemberOverviewController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class mainApp extends Application {

	//Putting the memberList Members into an ObservableList
	private ObservableList<Member> memberList = FXCollections.observableArrayList();

	//Primary stage and the root layout of the main window that opens when the program is run
    private Stage primaryStage;
    private BorderPane rootLayout;

    //Defult constructor with initial data
    public mainApp() {
    	memberList.add(new Member("Duncan", "Don", "M9", "don@gmail.com", "123-123-1234", "Medium"));
    	memberList.add(new Member("Evans", "Elle", "F10", "ellee@gmail.com", "234-234-2345", "Small"));
    	memberList.add(new Member("Finley", "Faith", "F9", "faith2002@gmail.com", "345-345-3456", "Large"));
    	memberList.add(new Member("Graham", "Greg", "M9", "grahamcrackers@gmail.com", "456-456-4567", "Small"));
    	memberList.add(new Member("Hunt", "Hailey", "F11", "hailey@gmail.com", "567-567-5678", "Large"));
    	memberList.add(new Member("Ireland", "Isabella", "F9", "izzyireland@gmail.com", "678-678-6789", "Small"));
    	memberList.add(new Member("Knight", "Katie", "F10", "katieknight@gmail.com", "789-789-7890", "Medium"));
    	memberList.add(new Member("Lee", "Lydia", "F11", "lydial@gmail.com", "890-890-8901", "Small"));
    	memberList.add(new Member("Nicholson", "Nick", "M12", "nicknich@gmail.com", "901-901-9012", "Medium"));
    	memberList.add(new Member("Paddock", "Peter", "M12", "ppaddock@gmail.com", "010-010-0101", "Large"));
    	memberList.add(new Member("Robinson", "Richard", "M12", "richrob@gmail.com", "101-101-1011", "Small"));
    	memberList.add(new Member("Smith", "Scarlet", "F12", "scarlet98@gmail.com", "011-011-0111", "Small"));
    	memberList.add(new Member("Turner", "Tony", "M11", "tturner@gmail.com", "111-111-1112", "Large"));
    	memberList.add(new Member("White", "Wesley", "M12", "wesleywwhite@gmail.com", "112-112-1121", "Large"));
    	memberList.add(new Member("Young", "Yvonne", "F11", "yvonne1@gmail.com", "121-121-1213", "Medium"));


    }

    @Override
    public void start(Stage primaryStage) {
    	try {

    		//Set the primaryStage field to the parameter passed into this method
    		this.primaryStage = primaryStage;

    		//This sets the title of the Window
            this.primaryStage.setTitle("FBLA Members");

            //This finds the image file and sets it as the application icon
            this.primaryStage.getIcons().add(new Image("file:resources/Flag.png"));

            //Call to the method that sets up the rootLayout, outer window
            initRootLayout();

            //Call to the method that yields the content of the inner window class
            showMemberOverview();

    	} catch(Exception e) {
    		e.printStackTrace();
    	}

    }

    //Standard JavaFX main loop that calls Launch(args)
    public static void main(String[] args) {
        launch(args);
    }

    //Outer window class
    public void initRootLayout() {
        try {

        	//An FXML Loader object is created in the below initialization that is routine to start the application and layout
            FXMLLoader loader = new FXMLLoader();

            //Takes in the FXML file to use with the location
            loader.setLocation(mainApp.class.getResource("/yang/database/view/RootLayout.fxml"));

            //The rootLayout field is set to the BorderPane FXML file that was added through @FXML
            rootLayout = (BorderPane) loader.load();

            //The rootLayout is given a Scene object
            Scene scene = new Scene(rootLayout);

            //Gives the controller access to this class
	        RootLayoutController controller = loader.getController();
	        controller.setMainApp(this);

	        //Sets the primaryScene Scene object to scene
            primaryStage.setScene(scene);

            //Shows the primaryStage object
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Inner window class
    public void showMemberOverview() {
        try {

        	//Instantiation of this loader class
            FXMLLoader loader = new FXMLLoader();

            //Takes in the FXML file to use with the location
            loader.setLocation(mainApp.class.getResource("/yang/database/view/MemberOverview.fxml"));

            //Loads the AnchorPane into the memberOverview object
            AnchorPane memberOverview = (AnchorPane) loader.load();

            //Centers memberOverview in rootLayout
            rootLayout.setCenter(memberOverview);

            //Sets memberOverview with a controller
            MemberOverviewController controller = loader.getController();

            //Reference for the controller to this class
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Issues the hook or memory address of the primaryStage
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    //Gives the hook to the memberList object
    public ObservableList<Member> getMemberList(){
    	return memberList;
    }

    /*
     * The following code works on saving settings and data
     * It can also return file last opened or file preference, reading from the Operating System Registry
     */

    //Gets the current memberList file path
  	public File getMemberListFilePath(){
  			Preferences prefs = Preferences.userNodeForPackage(mainApp.class);
  			String filePath = prefs.get("filePath", null);
  			if (filePath != null) {
  				return new File(filePath);
  			} else {
  			return null;
  			}
  		}

  	//Sets the memberList file path
  	public void setMemberListFilePath(File file) {

  		Preferences prefs = Preferences.userNodeForPackage(mainApp.class);

  		if (file != null) {
  			prefs.put("filePath",  file.getPath());
  			primaryStage.setTitle("FBLA - " +  file.getName());
  		} else {
  			prefs.remove("filePath");
  			primaryStage.setTitle("FBLA");
  		}
  }

  	//Reads in the memberList
  	public void loadMemberListFromFile(File file) {
  		try{
  			JAXBContext context = JAXBContext.newInstance(yang.database.model.MemberListWrapper.class,Member.class);
  			System.out.println(context.toString());
  			Unmarshaller um = context.createUnmarshaller();

  			//Reads XML from the unmarshaller
  			MemberListWrapper wrapper = new MemberListWrapper();
  				wrapper =  (MemberListWrapper) um.unmarshal(file);

  			memberList.clear();
  			memberList.addAll(wrapper.getMembers());

  			//Saves the fire path to the Registry
  			setMemberListFilePath(file);

  		} catch (Exception e) {

  			Alert alert = new Alert(AlertType.ERROR);
  			alert.setTitle("Error");
  			alert.setHeaderText("Could not load data");
  			alert.setContentText("Could not load data from file:\n" + file.getPath()+ ": " + e.toString());
  			alert.showAndWait();

  		}

  	}

  	//Writes the memberList to disk
  	public void saveMemberListToFile(File file) {
  		try{
  			JAXBContext context = JAXBContext.newInstance(MemberListWrapper.class);
  		    Marshaller m = context.createMarshaller();
  		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

  		    //Wraps the member data
  		    MemberListWrapper wrapper = new MemberListWrapper();
  		    wrapper.setMembers(memberList);

  		    //Marshalling and saving XML to file
  		    m.marshal(wrapper, file);

  		    //Saves the file path to the registry
  		    setMemberListFilePath(file);


  		} catch (Exception e) {

  			Alert alert = new Alert(AlertType.ERROR);
  			alert.setTitle("Error");
  			alert.setHeaderText("Could not load data");
  			alert.setContentText("Could not load data from file:\n" + file.getPath());
  			alert.showAndWait();

  		}

  	}

  	//Dialog box for adding or editing a member's information
  	public boolean showMemberEditDialog(Member member) {
  		try {
  			//Loads an FXML document
  	        FXMLLoader loader = new FXMLLoader();
  	        loader.setLocation(mainApp.class.getResource("/yang/database/view/MemberEditDialog.fxml"));
  	        AnchorPane page = (AnchorPane) loader.load();

  	        //New stage for the pop-up dialog
  	        Stage dialogStage = new Stage();
  	        dialogStage.setTitle("Edit Member");
  	        dialogStage.getIcons().add(new Image("file:resources/Flag.png"));
  	        dialogStage.initModality(Modality.WINDOW_MODAL);
  	        dialogStage.initOwner(primaryStage);
  	        Scene scene = new Scene(page);
  	        dialogStage.setScene(scene);

  	        //Sets the controller to this method and calls methods within the controller class
  	        MemberEditDialogController controller = loader.getController();
  	        controller.setDialogStage(dialogStage);
  	        controller.setMember(member);

  	        //Dialog box waits until the user interacts with it
  	        dialogStage.showAndWait();

  	        return controller.isOkClicked();
  	    } catch (IOException e) {
  	        e.printStackTrace();
  	        return false;
  	    }
  	}

  	//Dialog box for exporting a member's email or t-shirt size for external use
  	public boolean showExportDialog(Member member) {
  		try {
  			//Loads an FXML document
  	        FXMLLoader loader = new FXMLLoader();
  	        loader.setLocation(mainApp.class.getResource("/yang/database/view/ExportDialog.fxml"));
  	        AnchorPane page = (AnchorPane) loader.load();

  	        //New stage for the pop-up dialog
  	        Stage dialogStage = new Stage();
  	        dialogStage.setTitle("Export Member Information");
  	        dialogStage.getIcons().add(new Image("file:resources/Flag.png"));
  	        dialogStage.initModality(Modality.WINDOW_MODAL);
  	        dialogStage.initOwner(primaryStage);
  	        Scene scene = new Scene(page);
  	        dialogStage.setScene(scene);

  	      //Sets the controller to this method and calls methods within the controller class
  	        ExportDialogController controller = loader.getController();
  	        controller.setDialogStage(dialogStage);
  	        controller.getInfo(member);

  	        //Dialog box waits until the user interacts with it
  	        dialogStage.showAndWait();

  	        return controller.isDoneClicked();
  	    } catch (IOException e) {
  	        e.printStackTrace();
  	        return false;
  	    }
  	}

  	public boolean showLeadershipInfo() {
  		try {
  			//Loads an FXML file
  	        FXMLLoader loader = new FXMLLoader();
  	        loader.setLocation(mainApp.class.getResource("/yang/database/view/LeadershipInfo.fxml"));
  	        AnchorPane page = (AnchorPane) loader.load();

  	        //New stage for the pop-up dialog
  	        Stage dialogStage = new Stage();
  	        dialogStage.setTitle("FBLA Leadership Team");
  	        dialogStage.getIcons().add(new Image("file:resources/Flag.png"));
  	        dialogStage.initModality(Modality.WINDOW_MODAL);
  	        dialogStage.initOwner(primaryStage);
  	        Scene scene = new Scene(page);
  	        dialogStage.setScene(scene);

  	      //Sets the controller to this method and calls methods within the controller class
  	        LeadershipInfoController controller = loader.getController();
  	        controller.setDialogStage(dialogStage);
  	        controller.showPortraits();

  	        //Dialog box waits until the user interacts with it
  	        dialogStage.showAndWait();

  	        return controller.isOkClicked();
  	    } catch (IOException e) {
  	        e.printStackTrace();
  	        return false;
  	    }
  	}

}
