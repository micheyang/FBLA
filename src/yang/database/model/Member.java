/*
 * Yang, Michelle
 * APCS-A
 * Period 5
 * FBLA Members
 */

package yang.database.model;

//Adapter classes provide the default implementation of all methods in an event listener interface
//Mix between regular Java Bean properties (with binding capacity) and JavaFX properties
import javafx.beans.property.StringProperty;

import javafx.beans.property.SimpleStringProperty;

public class Member {

	//Adapter class memory allocation is applied through the initializations of these fields
	private final StringProperty memberLastName;
	private final StringProperty memberFirstName;
	private final StringProperty memberGenderAndGrade;
	private final StringProperty memberEmail;
	private final StringProperty memberPhoneNumber;
	private final StringProperty memberShirtSize;

	//Default constructor that initializes each field
	public Member() {
		this(null, null, null, null, null, null);
	}

	/**
	 * Overloaded constructor that takes in every field
	 * Constructors of the fields are called using SimpleXXXProperty of the JavaFX class types for Properties
	 * Using 'this' resolves the type match error
	 *
	 * @param memberLastName		last name of member
	 * @param memberFirstName		first name of member
	 * @param memberGenderAndGrade	the first letter of the gender followed by the grade
	 * @param memberEmail			email of member
	 * @param memberPhoneNumber		phone number of member
	 * @param memberShirtSize		shirt size of member
	 */
	public Member(String memberLastName, String memberFirstName, String memberGenderAndGrade, String memberEmail, String memberPhoneNumber, String memberShirtSize) {

		if (memberLastName==null){
			this.memberLastName = new SimpleStringProperty("---");
		} else {
			this.memberLastName = new SimpleStringProperty(memberLastName);
		}

		if (memberFirstName==null){
			this.memberFirstName = new SimpleStringProperty("---");
		} else {
			this.memberFirstName = new SimpleStringProperty(memberFirstName);
		}

		if (memberGenderAndGrade==null){
			this.memberGenderAndGrade = new SimpleStringProperty("---");
		} else {
			this.memberGenderAndGrade = new SimpleStringProperty(memberGenderAndGrade);
		}

		if (memberEmail==null){
			this.memberEmail = new SimpleStringProperty("---");
		} else {
			this.memberEmail = new SimpleStringProperty(memberEmail);
		}

		if (memberPhoneNumber==null){
			this.memberPhoneNumber = new SimpleStringProperty("---");
		} else {
			this.memberPhoneNumber = new SimpleStringProperty(memberPhoneNumber);
		}

		if (memberShirtSize==null){
			this.memberShirtSize = new SimpleStringProperty("---");
		} else {
			this.memberShirtSize = new SimpleStringProperty(memberShirtSize);
		}

	}

	//PROPERTY getters and setters
	public String getmemberLastName() {
		return memberLastName.get();
	}

	public void setmemberLastName(String memberLastName) {
		this.memberLastName.set(memberLastName);
	}

	public String getmemberFirstName() {
		return memberFirstName.get();
	}

	public void setmemberFirstName(String memberFirstName) {
		this.memberFirstName.set(memberFirstName);
	}

	public String getmemberGenderAndGrade() {
		return memberGenderAndGrade.get();
	}

	public void setmemberGenderAndGrade(String memberGenderAndGrade) {
		this.memberGenderAndGrade.set(memberGenderAndGrade);
	}

	public String getmemberEmail() {
		return memberEmail.get();
	}

	public void setmemberEmail(String memberEmail) {
		this.memberEmail.set(memberEmail);
	}

	public String getmemberPhoneNumber() {
		return memberPhoneNumber.get();
	}

	public void setmemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber.set(memberPhoneNumber);
	}

	public String getmemberShirtSize() {
		return memberShirtSize.get();
	}

	public void setmemberShirtSize(String memberShirtSize) {
		this.memberShirtSize.set(memberShirtSize);
	}

	//Property methods (functions) that return the memory address and base type (adapter class) of the specified property
	//Define the links for the binding and ask for the object the adapter classes bind
	public StringProperty memberLastNameProperty() {
		return memberLastName;
	}

	public StringProperty memberFirstNameProperty() {
		return memberFirstName;
	}

	public StringProperty memberGenderAndGradeProperty() {
		return memberGenderAndGrade;
	}

	public StringProperty memberEmailProperty() {
		return memberEmail;
	}

	public StringProperty memberPhoneNumberProperty() {
		return memberPhoneNumber;
	}

	public StringProperty memberShirtSizeProperty() {
		return memberShirtSize;
	}


}
