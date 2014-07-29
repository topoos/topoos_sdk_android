/**
 * Copyright 2014-present topoos
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package topoos.APIAccess.Operations;

import java.util.Date;

/**
 * Class that put membership.
 * 
 * Updates user profile. It can be used to change user password.
 * 
 * @see APIOperation
 * @author topoos
 */
public class UsersPutMembership extends APIOperation {

	/** The oauth_token. */
	private String oauth_token; // Required) access_token. User token or
								// administrator token.
								// Administrator token can update other user
								// profiles. User token can update its own
								// profile only.

	/** Usr */
	private String usr; // (Optional) number of elements in the page. Default is
						// 100 users.

	/** Pass */
	private String pwd; // (Optional) new password for the user.
						// Must be between 6 and 40 characters length and it
						// will be stored encrypted.

	/** Oldpwd */
	private String old_pwd; // (Required if pwd param is provided) current
							// password for the user.
							// Must be provided if pwd parameter is provided.

	/** Gender */
	private String gender; // (Optional) gender for your new user. Allowed
							// values are �male� or �female�.
							// Default value is �Undefined�.

	/** Birthdate */
	private Date birthdate; // (Optional) birthday date for your new user.
								// according to the ISO 8601 standard.
								// datetime (AAAA-MM-DDThh:mm:sszzzzzz) UTC
								// example: 1997-07-16T10:30:15.342+03:00

	
	/***
	 * Instantiates a new Reset password.
	 * 
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param oauth_token
	 * @param usr
	 * @param pwd
	 * @param old_pwd
	 * @param gender
	 * @param birthdate
	 */
	public UsersPutMembership(String operationName, String method,
			String format, Integer version, String oauth_token, String usr,
			String pwd, String old_pwd, String gender, Date birthdate) {
		super(operationName, method, format, version);
		this.oauth_token = oauth_token;
		this.usr = usr;
		this.pwd = pwd;
		this.old_pwd = old_pwd;
		this.gender = gender;
		this.birthdate = birthdate;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(oauth_token);
		validate = validate && isValid(usr);
		if (isValid (pwd)){
			validate = validate && isValid(old_pwd);
		}
		validate = validate && isValidorNull(gender);
		validate = validate && isValidorNull(APIUtils.toStringDate(birthdate));
		
		return validate;
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ConcatParams()
	 */
	@Override
	public String ConcatParams() {
		// TODO Auto-generated method stub

		String params = null;
		if (this.ValidateParams()) {
			params = "/" + this.Version + "/users/"+usr+"."+this.Format+"?" + "access_token="+oauth_token
					+ addPwds ()
					+ (gender == null ? "" : "&gender="+gender)
					+ (birthdate == null ? "" : "&birthdate="+APIUtils.toStringDate(birthdate));

		}
		return params;
	}
	
	private String addPwds (){
		String result = "";
		if (pwd != null && !pwd.equals("")){
			result = "&pwd="+pwd+"&oldpwd="+old_pwd;
		}
		return result;
	}
}