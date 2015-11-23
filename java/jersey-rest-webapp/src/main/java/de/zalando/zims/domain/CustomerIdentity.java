package de.zalando.zims.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerIdentity {
	public enum IDENTITY_TYPE {
		GUEST, SOFT_LOGIN, HARD_LOGIN
	}

	private IDENTITY_TYPE identityType;

	private String customerId;

	private String sessionId;

	private String name;

	private long lastActive;

	@XmlElement
	public IDENTITY_TYPE getIdentityType() {
		return identityType;
	}

	public void setIdentityType(IDENTITY_TYPE identityType) {
		this.identityType = identityType;
	}

	@XmlElement
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@XmlElement
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public long getLastActive() {
		return lastActive;
	}

	public void setLastActive(long lastActive) {
		this.lastActive = lastActive;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("customerId: " + customerId);
		builder.append(", sessionId: " + sessionId);
		builder.append(", name: " + name);
		builder.append(", lastActive: " + lastActive);
		builder.append(", identityType: " + identityType);
		return builder.toString();
	}

}
