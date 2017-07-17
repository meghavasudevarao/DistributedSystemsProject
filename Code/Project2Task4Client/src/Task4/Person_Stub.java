package Task4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Person_Stub implements Person {
	Socket socket;
	ObjectOutputStream o;
	ObjectInputStream i;
	public Person_Stub() throws Exception {
	}
	public int getID() throws Exception {
		socket = new Socket("localhost",9000);
		o = new ObjectOutputStream(socket.getOutputStream());
		o.writeObject("ID");
		o.flush();
		i = new ObjectInputStream(socket.getInputStream());
		int ret = i.readInt();
		socket.close();
		return ret;
	}

	public String getName() throws Exception {
		socket = new Socket("localhost",9000);
		o = new ObjectOutputStream(socket.getOutputStream());
		o.writeObject("name");
		o.flush();
		i = new ObjectInputStream(socket.getInputStream());
		String ret = (String)(i.readObject());
		socket.close();
		return (String)ret;
	}
}