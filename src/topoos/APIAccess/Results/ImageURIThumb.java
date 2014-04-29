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

package topoos.APIAccess.Results;

import topoos.APIAccess.APICaller;

/**
 * The Class ImageURIThumb.
 * 
 * @author DMC
 */
public class ImageURIThumb extends APICallResult{
	
	

	/** The uri of thumb. */
	private String uriThumb;
	
	/**filename_unique  image filename_unique*/
	private String filename_unique;
	/**token */
	private String token;
	/**size desired maximum image size*/
	private String size;
	/**width desired output width for the thumbnail*/
	private String width;
	/**height desired output height for the thumbnail*/
	private String height;
	/**dpi desired output image density*/
	private String dpi;
	/**mode resize mode*/
	private String mode;
	
	
	/**
	 * Instantiates a new ImageURIThumb result.
	 */
	public ImageURIThumb(String token,String filename_unique,
			String size, String dpi, String mode) {
		this.token = token;
		this.filename_unique = filename_unique;
		this.size = size;
		this.dpi = dpi;
		this.mode = mode;
	}


	/**
	 * Instantiates a new ImageURIThumb result.
	 */
	public ImageURIThumb(String token,String filename_unique,
			String width, String height, String dpi, String mode) {
		this.token = token;
		this.filename_unique = filename_unique;
		this.width = width;
		this.height = height;
		this.dpi = dpi;
		this.mode = mode;
	}



	@Override
	public void setParameters()  {
		this.uriThumb = APICaller.GetURLPICAPItopoos() + "/thumb/"
				+filename_unique+"?"+getParameter("token", token)+
				getParameter ("size", size)+ getParameter ("width",width)+
				getParameter ("height", height)+ getParameter ("dpi", dpi)+
				getParameter ("mode", mode);
		
	}
	
	/**
	 * Get parameter
	 * 
	 * if parameter is valid, it will be built
	 * @param nameParameter
	 * @param parameter
	 * @return parameter for the URI*/
	private String getParameter (String nameParameter, String parameter){
		String param = "";
		if (parameter != null){
			if (parameter!= ""){
				param += "&"+nameParameter+"="+parameter;
			}
		}
		return param; 
	}
	
	/**
	 * GetUriThumb 
	 * 
	 * @return uriThumb*/
	public String getUriThumb() {
		return uriThumb;
	}


	/**
	 * SetUriThumb 
	 * 
	 * @param uriThumb*/
	public void setUriThumb(String uriThumb) {
		this.uriThumb = uriThumb;
	}

}
