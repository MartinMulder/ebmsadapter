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

import java.util.List;

import javax.activation.DataSource;

import nl.clockwork.mule.ebms.model.ebxml.AckRequested;
import nl.clockwork.mule.ebms.model.ebxml.Manifest;
import nl.clockwork.mule.ebms.model.ebxml.MessageHeader;
import nl.clockwork.mule.ebms.model.ebxml.MessageOrder;
import nl.clockwork.mule.ebms.model.ebxml.SyncReply;
import nl.clockwork.mule.ebms.model.xml.xmldsig.SignatureType;

public class EbMSMessage implements EbMSBaseMessage
{
	private byte[] original;
	private SignatureType signature;
	private MessageHeader messageHeader;
	private SyncReply syncReply;
	private MessageOrder messageOrder;
	private AckRequested ackRequested;
	private Manifest manifest;
	private List<DataSource> attachments;

	public EbMSMessage(MessageHeader messageHeader, AckRequested ackRequested, Manifest manifest, List<DataSource> attachments)
	{
		this(null,null,messageHeader,ackRequested,manifest,attachments);
	}
	
	public EbMSMessage(byte[] message, SignatureType signature, MessageHeader messageHeader, AckRequested ackRequested, Manifest manifest, List<DataSource> attachments)
	{
		this(message,signature,messageHeader,null,null,ackRequested,manifest,attachments);
	}
	
	public EbMSMessage(MessageHeader messageHeader, SyncReply syncReply, MessageOrder messageOrder, AckRequested ackRequested, Manifest manifest, List<DataSource> attachments)
	{
		this(null,null,messageHeader,syncReply,messageOrder,ackRequested,manifest,attachments);
	}
	
	public EbMSMessage(byte[] original, SignatureType signature, MessageHeader messageHeader, SyncReply syncReply, MessageOrder messageOrder, AckRequested ackRequested, Manifest manifest, List<DataSource> attachments)
	{
		this.original = original;
		this.signature = signature;
		this.messageHeader = messageHeader;
		this.syncReply = syncReply;
		this.messageOrder = messageOrder;
		this.ackRequested = ackRequested;
		this.manifest = manifest;
		this.attachments = attachments;
	}
	
	public byte[] getOriginal()
	{
		return original;
	}
	
	public SignatureType getSignature()
	{
		return signature;
	}
	
	@Override
	public MessageHeader getMessageHeader()
	{
		return messageHeader;
	}
	
	public SyncReply getSyncReply()
	{
		return syncReply;
	}
	
	public MessageOrder getMessageOrder()
	{
		return messageOrder;
	}
	
	public AckRequested getAckRequested()
	{
		return ackRequested;
	}

	public Manifest getManifest()
	{
		return manifest;
	}
	
	public List<DataSource> getAttachments()
	{
		return attachments;
	}
}
