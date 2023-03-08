/**
 * 
 */
package com.emai.model;

/**
 * @author hp
 *
 */
public class EmailResponse {

	String token;

	public EmailResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
