package Task5;

import java.io.Serializable;
import java.util.Date;

public class RemoteObjectRefrence implements Serializable {

	byte[] internetAddress;
	int portNumber;
	Date time;
	int objectNumber;
	String interfaceOfRemoteObject;
	
	
	public byte[] getInternetAddress() {
		return internetAddress;
	}
	public void setInternetAddress(byte[] internetAddress) {
		internetAddress = internetAddress;
	}
	public int getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(int portNumber) {
		portNumber = portNumber;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		time = time;
	}
	public int getObjectNumber() {
		return objectNumber;
	}
	public void setObjectNumber(int objectNumber) {
		objectNumber = objectNumber;
	}
	public String getInterfaceOfRemoteObject() {
		return interfaceOfRemoteObject;
	}
	public void setInterfaceOfRemoteObject(String interfaceOfRemoteObject) {
		interfaceOfRemoteObject = interfaceOfRemoteObject;
	}
	
	
	public static void main(String args[]) {
		
		//To do test driver code 
	}
	
	
	
	
}
