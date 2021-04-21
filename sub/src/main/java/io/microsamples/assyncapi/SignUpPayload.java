
package io.microsamples.assyncapi;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignUpPayload {

	public SignUpPayload () {
	}
	public SignUpPayload (
		String displayName, 
		String email) {
		this.displayName = displayName;
		this.email = email;
	}


	private String displayName;
	private String email;

	public String getDisplayName() {
		return displayName;
	}

	public SignUpPayload setDisplayName(String displayName) {
		this.displayName = displayName;
		return this;
	}


	public String getEmail() {
		return email;
	}

	public SignUpPayload setEmail(String email) {
		this.email = email;
		return this;
	}


	public String toString() {
		return "SignUpPayload ["
		+ " displayName: " + displayName
		+ " email: " + email
		+ " ]";
	}
}

