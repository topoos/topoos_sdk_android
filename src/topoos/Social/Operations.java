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

package topoos.Social;

import java.io.IOException;
import java.util.List;

import topoos.AccessTokenOAuth;
import topoos.Exception.TopoosException;
import topoos.Objects.POI;
import topoos.Objects.Relationship;
import android.content.Context;

/**
 * 
 * @author topoos
 * 
 * Operations related to Social management
 * 
 */
public class Operations {

	/**
	 * Add a following relationship between both users, the authenticated user and the specified one.
	 *
	 * The specified user will be followed by the current authorized user.
	 * 
	 * @param targetUserId
	 *            target user identifier to follow.
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return Relationship
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Relationship AddFollow(String targetUserId, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		return Translator.AddFollow(targetUserId, accessTokenPregenerated);
	}

	/**
	 * Remove a following relationship between both users, the authenticated user and the specified one.
	 *
	 * As result, the specified user will not be followed by the current authorized user.
	 * 
	 * @param targetUserId
	 *            target user identifier to follow.
	 * @param accessTokenPregenerated
	 *            (required) access_token to user resources
	 * @return Relationship
	 * @throws IOException
	 * @throws TopoosException
	 */
	public static Relationship DeleteFollow(String targetUserId, AccessTokenOAuth accessTokenPregenerated)
			throws IOException, TopoosException {
		return Translator.DeleteFollow(targetUserId, accessTokenPregenerated);
	}

}
