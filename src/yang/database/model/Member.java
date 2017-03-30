/*
 * Yang, Michelle
 * APCS-A
 * Period 5
 * FBLA Members
 */

package yang.database.model;

import javafx.beans.property.StringProperty;

import javafx.beans.property.SimpleStringProperty;

public class Member {

	private final StringProperty memberLastName;
	private final StringProperty memberFirstName;
	private final StringProperty memberGenderAndGrade;
	private final StringProperty memberEmail;
	private final StringProperty memberPhoneNumber;
	private final StringProperty memberShirtSize;

	public Member() {
		this(null, null, null, null, null, null);
	}

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
