package Task5;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Person_Stub implements Person {
	Binder b;
	String ret= "Mike";
	int ID= 34;
	
	public Person_Stub(Binder b) {
		super();
		this.b = b;
	}

	@Override
	public int getID(String lookup) throws Exception {
		// TODO Auto-generated method stub
		return ID;
		
	}

	@Override
	public String getName(String lookup) throws Exception {
		// TODO Auto-generated method stub
		return ret;
		
	}

}
