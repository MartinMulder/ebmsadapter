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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.28 at 11:40:06 AM CEST 
//


package nl.clockwork.mule.ebms.model.cpp.cpa;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.oasis-open.org/committees/ebxml-cppa/schema/cpp-cpa-2_0.xsd}SignatureTransforms" minOccurs="0"/>
 *         &lt;element ref="{http://www.oasis-open.org/committees/ebxml-cppa/schema/cpp-cpa-2_0.xsd}EncryptionTransforms" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://www.oasis-open.org/committees/ebxml-cppa/schema/cpp-cpa-2_0.xsd}idref use="required""/>
 *       &lt;attribute name="excludedFromSignature" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="minOccurs" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="maxOccurs" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "signatureTransforms",
    "encryptionTransforms"
})
@XmlRootElement(name = "Constituent")
public class Constituent {

    @XmlElement(name = "SignatureTransforms")
    protected SignatureTransforms signatureTransforms;
    @XmlElement(name = "EncryptionTransforms")
    protected EncryptionTransforms encryptionTransforms;
    @XmlAttribute(namespace = "http://www.oasis-open.org/committees/ebxml-cppa/schema/cpp-cpa-2_0.xsd", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object idref;
    @XmlAttribute(namespace = "http://www.oasis-open.org/committees/ebxml-cppa/schema/cpp-cpa-2_0.xsd")
    protected Boolean excludedFromSignature;
    @XmlAttribute(namespace = "http://www.oasis-open.org/committees/ebxml-cppa/schema/cpp-cpa-2_0.xsd")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger minOccurs;
    @XmlAttribute(namespace = "http://www.oasis-open.org/committees/ebxml-cppa/schema/cpp-cpa-2_0.xsd")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger maxOccurs;

    /**
     * Gets the value of the signatureTransforms property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureTransforms }
     *     
     */
    public SignatureTransforms getSignatureTransforms() {
        return signatureTransforms;
    }

    /**
     * Sets the value of the signatureTransforms property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureTransforms }
     *     
     */
    public void setSignatureTransforms(SignatureTransforms value) {
        this.signatureTransforms = value;
    }

    /**
     * Gets the value of the encryptionTransforms property.
     * 
     * @return
     *     possible object is
     *     {@link EncryptionTransforms }
     *     
     */
    public EncryptionTransforms getEncryptionTransforms() {
        return encryptionTransforms;
    }

    /**
     * Sets the value of the encryptionTransforms property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncryptionTransforms }
     *     
     */
    public void setEncryptionTransforms(EncryptionTransforms value) {
        this.encryptionTransforms = value;
    }

    /**
     * Gets the value of the idref property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getIdref() {
        return idref;
    }

    /**
     * Sets the value of the idref property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setIdref(Object value) {
        this.idref = value;
    }

    /**
     * Gets the value of the excludedFromSignature property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isExcludedFromSignature() {
        if (excludedFromSignature == null) {
            return false;
        } else {
            return excludedFromSignature;
        }
    }

    /**
     * Sets the value of the excludedFromSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExcludedFromSignature(Boolean value) {
        this.excludedFromSignature = value;
    }

    /**
     * Gets the value of the minOccurs property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinOccurs() {
        return minOccurs;
    }

    /**
     * Sets the value of the minOccurs property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinOccurs(BigInteger value) {
        this.minOccurs = value;
    }

    /**
     * Gets the value of the maxOccurs property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxOccurs() {
        return maxOccurs;
    }

    /**
     * Sets the value of the maxOccurs property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxOccurs(BigInteger value) {
        this.maxOccurs = value;
    }

}
