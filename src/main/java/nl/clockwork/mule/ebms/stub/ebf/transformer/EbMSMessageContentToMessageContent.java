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
package nl.clockwork.mule.ebms.stub.ebf.transformer;

import nl.clockwork.mule.ebms.model.EbMSMessageContent;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageAwareTransformer;

public class EbMSMessageContentToMessageContent extends AbstractMessageAwareTransformer
{
	public EbMSMessageContentToMessageContent()
	{
		registerSourceType(EbMSMessageContent.class);
	}
	
	@Override
	public Object transform(MuleMessage message, String outputEncoding) throws TransformerException
	{
		try
		{
			EbMSMessageContent content = (EbMSMessageContent)message.getPayload();
			return new String(content.getAttachments().get(0).getContent());
		}
		catch (Exception e)
		{
			throw new TransformerException(this,e);
		}
	}

}
