package Task5;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Binder_Skeleton {
	Binder myServer;
	public Binder_Skeleton(Binder s) {
		myServer = s;
	}

	public void serve() {
		try {
			ServerSocket s = new ServerSocket(9000);
			while(true) {
				Socket socket = s.accept();
				ObjectInputStream i = new ObjectInputStream(socket.getInputStream());
				RequestReplyMessage rrm = (RequestReplyMessage)i.readObject();
				if(rrm.getOperationId()==1) 
				{
					myServer.bind(String.valueOf(rrm.getRequestId()),rrm.remoteReference);
					int a = myServer.lookup(String.valueOf(rrm.getRequestId())).getObjectNumber();
					ObjectOutputStream o = new
							ObjectOutputStream(socket.getOutputStream());
					o.writeInt(a);
					o.flush();
				} else if(rrm.getOperationId()==0) {
					RemoteObjectRefrence n = myServer.lookup(String.valueOf(rrm.getRemoteReference().getInterfaceOfRemoteObject()));
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
