/*******************************************************************************
 * Copyright 2011 Clockwork
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package nl.clockwork.mule.ebms.model;

import nl.clockwork.mule.ebms.model.ebxml.Service;

public class EbMSAction
{
	private Service service;
	private String action;
	
	public EbMSAction(Service service, String action)
	{
		this.service = service;
		this.action = action;
	}
	
	public Service getService()
	{
		return service;
	}
	
	public String getAction()
	{
		return action;
	}
}
