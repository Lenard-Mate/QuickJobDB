package com.edu.QucikJob.dal;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("User")
public class Userdao {
	@Id
	private int idnumber;
	
	private String userName;
	
	private String email;
	
    private String password;
   
    private String phonenumber;
    
    private String description;
	
	public int getId_number() {
		return idnumber;
	}

	public void setId_number(int idnumber) {
		this.idnumber = idnumber;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @param id_number
	 * @param userName
	 * @param email
	 * @param password
	 */
	public Userdao(int idnumber, String userName, String email, String password) {
		super();
		this.idnumber = idnumber;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	/**
	 * @param id_number
	 * @param userName
	 * @param email
	 * @param password
	 * @param phonenumber
	 * @param description
	 */
	public Userdao(int idnumber, String userName, String email, String password, String phonenumber,
			String description) {
		super();
		this.idnumber = idnumber;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.description = description;
	}

	/**
	 * 
	 */
	public Userdao() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void sendemails() {
		System.out.println("Function Work");
		
		
	}
	
}
