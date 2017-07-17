package Task5;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
				RequestReplyMessage rrm = (RequestReplyMessage)i.readObject();
				if(rrm.operationId==0) {
					int a = myServer.getID("Mike");
					ObjectOutputStream o = new
							ObjectOutputStream(socket.getOutputStream());
					o.writeInt(a);
					o.flush();
				} else if(rrm.operationId==1) {
					String n = myServer.getName("Mike");
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
