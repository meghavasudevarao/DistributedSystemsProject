package Task4;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.ServerSocket;
public class Person_Skeleton {
	Person myServer;
	public Person_Skeleton(Person s) {
		myServer = s;
	}
	
	public void serve() {
		try {
			ServerSocket s = new ServerSocket(9000);
			while(true) {
				Socket socket = s.accept();
				ObjectInputStream i = new ObjectInputStream(socket.getInputStream());
				String method = (String)i.readObject();
				if(method.equals("ID")) {
					int a = myServer.getID();
					ObjectOutputStream o = new
							ObjectOutputStream(socket.getOutputStream());
					o.writeInt(a);
					o.flush();
				} else if(method.equals("name")) {
					String n = myServer.getName();
					ObjectOutputStream o = new
							ObjectOutputStream(socket.getOutputStream());
					o.writeObject(n);
					o.flush();
				}
			}
		} catch(Exception t) {
			System.out.println("Error " + t);
			System.exit(0);
		}
	}
}