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

/**
 * Class that login user.
 * 
 * @see APIOperation
 * @author topoos
 */
public class UsersRegisterLogin extends APIOperation {

	/** The api_key. */
	private String api_key = null; // (Required) client id.
		
	/** The user_name. */
	private String user_name = null; //  (Required) user username or email

	/** The pwd. */
	private String pwd = null; // (Required) password this user
	
	/** expiresIn. */
	private Integer expiresIn = null; //(Optional) seconds from now until the new accreditation will be accessible. Default value is a permanent accreditation.
	
	
	/***
	 * 
	 * @param operationName
	 * @param method
	 * @param format
	 * @param version
	 * @param api_key
	 * @param user_name
	 * @param pwd
	 * @param expiresIn
	 */
	public UsersRegisterLogin(String operationName, String method,
			String format, Integer version, String api_key, String user_name,
			String pwd, Integer expiresIn) {
		super(operationName, method, format, version);
		this.api_key = api_key;
		this.user_name = user_name;
		this.pwd = pwd;
		this.expiresIn = expiresIn;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see topoos.APIAccess.Operations.APIOperation#ValidateParams()
	 */
	@Override
	public boolean ValidateParams() {
		boolean validate = super.ValidateParams();
		validate = validate && isValid(api_key);
		validate = validate && isValid(user_name);
		validate = validate && isValid(pwd);
		validate = validate && isValidorNull(APIUtils.toStringInteger(expiresIn));
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
			params = "/" + this.Version + "/users/login."
					+ this.Format + "?api_key=" + this.api_key
					+"&username="+this.user_name
					+"&pwd="+this.pwd
					+(expiresIn == null ? "" : "&expiresIn="+APIUtils.toStringInteger(expiresIn));

		}
		return params;
	}

}
