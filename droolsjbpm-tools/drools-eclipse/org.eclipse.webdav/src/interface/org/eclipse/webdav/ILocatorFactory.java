/**
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclipse.webdav;

/**
 * Factory for constructing resource locators.
 * <p>
 * <b>Note:</b> This class/interface is part of an interim API that is still under 
 * development and expected to change significantly before reaching stability. 
 * It is being made available at this early stage to solicit feedback from pioneering 
 * adopters on the understanding that any code that uses this API will almost 
 * certainly be broken (repeatedly) as the API evolves.
 * </p>
 *
 * @see ILocator
 */
public interface ILocatorFactory {

	/**
	 * Returns a locator with the given resource URL that
	 * (implicitly) uses the standard way of resolving resource
	 * URLs.
	 * <p>
	 * Version-unaware clients use this kind of locator exclusively.
	 *
	 * @param resourceURL the URL identifier of the resource as a
	 * <code>String</code>.
	 */
	public ILocator newLocator(String resourceURL);

	/**
	 * Returns a locator with the given resource URL and
	 * label.
	 * <p>
	 * This kind of locator is used only by version-aware clients.
	 * It allows a versioning client to specify a version-controlled
	 * resource URL and the label of a version in the corresponding
	 * history.  The resulting locator identifies the
	 * <em>version</em>.</p>
	 * <p>
	 * The resource URL MUST NOT be a stable URL.</p>
	 *
	 * @param requestURL the <code>String</code> representation of
	 * the version-controlled resource URL.
	 * @param label the label of the version to select from the
	 * corresponding history.
	 */
	public ILocator newLocator(String requestURL, String label);

	/**
	 * Returns a locator given a stable resource URL.
	 * <p>
	 * This kind of locator is used only by version-aware clients.
	 * The stable URL is generated by the server.  Clients may
	 * reliably store the URL and use it to identify the same
	 * resource in subsequent operations.  Resources identified by
	 * a stable URL cannot be moved but they may be deleted.
	 * The stable URL cannot be bound to a different resource
	 * by the client or server).</p>
	 * <p>
	 * Note that locators with stable URLs cannot have also have a
	 * label.</p>
	 *
	 * @param resourceURL the stable URL to a versioning resource
	 * as a <code>String</code>.
	 */
	public ILocator newStableLocator(String resourceURL);
}