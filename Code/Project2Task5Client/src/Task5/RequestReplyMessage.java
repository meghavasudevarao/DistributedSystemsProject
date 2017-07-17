package Task5;

import java.io.Serializable;

public class RequestReplyMessage implements Serializable  {
	int messageType;
	int requestId;
	RemoteObjectRefrence remoteReference ;
	int operationId; 
	byte[] arguments;
	
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public RemoteObjectRefrence getRemoteReference() {
		return remoteReference;
	}
	public void setRemoteReference(RemoteObjectRefrence remoteReference) {
		this.remoteReference = remoteReference;
	}
	public int getOperationId() {
		return operationId;
	}
	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}
	public byte[] getArguments() {
		return arguments;
	}
	public void setArguments(byte[] arguments) {
		this.arguments = arguments;
	}

}
