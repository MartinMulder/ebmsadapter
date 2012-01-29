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
package nl.clockwork.mule.ebms.util;

import nl.clockwork.common.dao.DAOException;
import nl.clockwork.mule.ebms.dao.EbMSDAO;
import nl.clockwork.mule.ebms.model.EbMSMessageContext;
import nl.clockwork.mule.ebms.model.cpp.cpa.CollaborationProtocolAgreement;
import nl.clockwork.mule.ebms.model.cpp.cpa.PartyInfo;

import org.apache.axis.utils.StringUtils;

public class EbMSMessageContextValidator
{
	private EbMSDAO ebMSDAO;
	
	public EbMSMessageContextValidator(EbMSDAO ebMSDAO)
	{
		this.ebMSDAO = ebMSDAO;
	}
	
	public void validate(EbMSMessageContext context)
	{
		try
		{
			if (StringUtils.isEmpty(context.getCpaId()))
				throw new EbMSMessageContextValidationException("context.cpaId cannot be empty.");
			CollaborationProtocolAgreement cpa = ebMSDAO.getCPA(context.getCpaId());
			if (cpa == null)
				throw new EbMSMessageContextValidationException("No CPA found with cpaId: " + context.getCpaId());

			if (StringUtils.isEmpty(context.getService()))
				throw new EbMSMessageContextValidationException("context.service cannot be empty.");
			if (StringUtils.isEmpty(context.getAction()))
				throw new EbMSMessageContextValidationException("context.action cannot be empty.");

			PartyInfo partyInfo = CPAUtils.getSendingPartyInfo(cpa,context.getFromRole(),context.getServiceType(),context.getService(),context.getAction());
			if (partyInfo == null)
			{
				StringBuffer msg = new StringBuffer();

				msg.append("No action found for:");
				msg.append("\n\tcontext.cpaId: ").append(context.getCpaId());
				if (context.getFromRole() != null)
					msg.append("\n\tcontext.fromRole: ").append(context.getFromRole());
				if (context.getServiceType() != null)
					msg.append("\n\tcontext.serviceType: ").append(context.getServiceType());
				msg.append("\n\tcontext.service: ").append(context.getService());
				msg.append("\n\tcontext.action: ").append(context.getAction());

				throw new EbMSMessageContextValidationException(msg.toString());
			}
			PartyInfo otherPartyInfo = CPAUtils.getReceivingPartyInfo(cpa,context.getToRole(),context.getServiceType(),context.getService(),context.getAction());
			if (otherPartyInfo == null)
			{
				StringBuffer msg = new StringBuffer();

				msg.append("No action found for:");
				msg.append("\n\tcontext.cpaId: ").append(context.getCpaId());
				if (context.getFromRole() != null)
					msg.append("\n\tcontext.toRole: ").append(context.getToRole());
				if (context.getServiceType() != null)
					msg.append("\n\tcontext.serviceType: ").append(context.getServiceType());
				msg.append("\n\tcontext.service: ").append(context.getService());
				msg.append("\n\tcontext.action: ").append(context.getAction());
				
				throw new EbMSMessageContextValidationException(msg.toString());
			}
		}
		catch (DAOException e)
		{
			throw new EbMSMessageContextValidatorException(e);
		}
	}
	
}