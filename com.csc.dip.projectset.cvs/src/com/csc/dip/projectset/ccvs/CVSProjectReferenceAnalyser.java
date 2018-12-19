/*******************************************************************************
 * Copyright (C) 2018 DXC Technology
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.csc.dip.projectset.ccvs;

/**
 * @author Dirk Baumann
 * 
 * 
 * This is the implementation of the interface IProjectReferenceAnalyser
 * for the CVS team provider
 */

import java.util.StringTokenizer;

import com.csc.dip.projectset.AbstractProjectReferenceAnalyser;


public class CVSProjectReferenceAnalyser extends AbstractProjectReferenceAnalyser
{
	/**
	 * Constructor for CVSProjectReferenceAnalyser.
	 */
	public CVSProjectReferenceAnalyser() {
		super();
	}

	/**
	 * @see com.csc.dip.projectset.IProjectReferenceAnalyser#isEqual(String, String)
	 */
	public boolean areEqual(String projectReference1, String projectReference2) {
		return projectReference1.equals(projectReference2);
	}

	/**
	 * @see com.csc.dip.projectset.IProjectReferenceAnalyser#getProjectName(String)
	 */
	public String getProjectName(String projectReference) {
		StringTokenizer tokenizer = new StringTokenizer(projectReference, ","); //$NON-NLS-1$
		tokenizer.nextToken();
		tokenizer.nextToken();
		tokenizer.nextToken();
		return tokenizer.nextToken();
	}

	/**
	 * @see com.csc.dip.projectset.IProjectReferenceAnalyser#getVersionName(String)
	 */
	public String getTag(String projectReference) {
		StringTokenizer tokenizer = new StringTokenizer(projectReference, ","); //$NON-NLS-1$
		tokenizer.nextToken();
		tokenizer.nextToken();
		tokenizer.nextToken();
		tokenizer.nextToken();		
		if (tokenizer.hasMoreTokens()) {
			return tokenizer.nextToken();
		} else {
			return "HEAD"; //$NON-NLS-1$
		}
		
	}

	/**
	 * @see com.csc.dip.projectset.IProjectReferenceAnalyser#getLocation(String)
	 */
	public String getLocation(String projectReference){
		StringTokenizer tokenizer = new StringTokenizer(projectReference, ","); //$NON-NLS-1$
		tokenizer.nextToken();
		return tokenizer.nextToken()+"/"+tokenizer.nextToken();		 //$NON-NLS-1$
	}

	/**
	 * @see com.csc.dip.projectset.IProjectReferenceAnalyser#getProviderName()
	 */
	public String getProviderName() {
		return "CVS"; //$NON-NLS-1$
	}
}
