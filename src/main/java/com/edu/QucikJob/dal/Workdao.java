package com.edu.QucikJob.dal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("workDescription")
public class Workdao {
	@Id
	private int idnumber;
	
	private int UserIdnumber;
	
	private String workTitle;
	
	private String paymant;
	
	private String date;
	
	private String phoneNumber;
	
	private String workDescriptionText;
	
	
	/**
	 * 
	 */
	public Workdao() {
		super();
	}

	



	/**
	 * @param idnumber
	 * @param userIdnumber
	 * @param workTitle
	 * @param paymant
	 * @param date
	 * @param phoneNumber
	 * @param workDescriptionText
	 */
	public Workdao(int idnumber, int userIdnumber, String workTitle, String paymant, String date, String phoneNumber,
			String workDescriptionText) {
		super();
		this.idnumber = idnumber;
		this.UserIdnumber = userIdnumber;
		this.workTitle = workTitle;
		this.paymant = paymant;
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.workDescriptionText = workDescriptionText;
	}





	public int getUserIdnumber() {
		return UserIdnumber;
	}


	public void setUserIdnumber(int userIdnumber) {
		UserIdnumber = userIdnumber;
	}


	public int getId_number() {
		return idnumber;
	}
	public void setId_number(int idnumber) {
		this.idnumber = idnumber;
	}
	public String getWorkTitle() {
		return workTitle;
	}
	public void setWorkTitle(String workTitle) {
		this.workTitle = workTitle;
	}
	public String getPaymant() {
		return paymant;
	}
	public void setPaymant(String paymant) {
		this.paymant = paymant;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getWorkDescriptionText() {
		return workDescriptionText;
	}
	public void setWorkDescriptionText(String workDescriptionText) {
		this.workDescriptionText = workDescriptionText;
	}
	
	
}
