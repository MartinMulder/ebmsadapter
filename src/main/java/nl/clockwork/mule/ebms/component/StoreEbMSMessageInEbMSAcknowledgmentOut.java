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
package nl.clockwork.mule.ebms.component;

import nl.clockwork.mule.common.component.Callable;
import nl.clockwork.mule.ebms.Constants;
import nl.clockwork.mule.ebms.Constants.EbMSMessageStatus;
import nl.clockwork.mule.ebms.dao.EbMSDAO;
import nl.clockwork.mule.ebms.model.EbMSAcknowledgment;
import nl.clockwork.mule.ebms.model.EbMSMessage;

import org.mule.api.MuleMessage;

public class StoreEbMSMessageInEbMSAcknowledgmentOut extends Callable
{
	private EbMSDAO ebMSDAO;

	@Override
	public Object onCall(MuleMessage message) throws Exception
	{
		if (message.getPayload() instanceof EbMSAcknowledgment)
		{
			EbMSMessage msg = (EbMSMessage)message.getProperty(Constants.EBMS_MESSAGE);
			EbMSMessageStatus status = EbMSMessageStatus.get((String)message.getProperty(Constants.EBMS_MESSAGE_STATUS));
			EbMSAcknowledgment ack = (EbMSAcknowledgment)message.getPayload();
			ebMSDAO.insertMessage(msg,status,ack);
		}
		return message;
	}

	public void setEbMSDAO(EbMSDAO ebMSDAO)
	{
		this.ebMSDAO = ebMSDAO;
	}
}
