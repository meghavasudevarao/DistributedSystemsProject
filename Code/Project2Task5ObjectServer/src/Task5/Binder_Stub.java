package Task5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import Task5.Binder_Skeleton;
public class Binder_Stub implements Binder {
	Socket socket;
	ObjectOutputStream o;
	ObjectInputStream i;
	RemoteObjectRefrence robjref;
	
	public Binder_Stub() {
		super();
		
	}
	
	public Binder_Stub(RemoteObjectRefrence robjref) {
		super();
		this.robjref = robjref;
	}
	
	
	@Override
	public RemoteObjectRefrence lookup(String lookupval) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(9000);
		socket=server.accept();
//		i = new ObjectInputStream(socket.getInputStream());
//		RequestReplyMessage ret =(RequestReplyMessage) i.readObject();
		
		o = new ObjectOutputStream(socket.getOutputStream());
		RequestReplyMessage rrm= new RequestReplyMessage();
		rrm.setOperationId(0);
		
		rrm.setRequestId(robjref.objectNumber);
		o.writeObject(rrm);
		
		o.flush();
		
		socket.close();
		return robjref;
	}

	@Override
	public void bind(String lookupval, RemoteObjectRefrence remoteObjectRefrence) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(9000);
		socket=server.accept();
		o = new ObjectOutputStream(socket.getOutputStream());
		
		RequestReplyMessage rrm= new RequestReplyMessage();
		rrm.setOperationId(1);
		int randomNum = 1 + (int)(Math.random() * 5000); 
		rrm.setRequestId(randomNum);
		
		rrm.setRemoteReference(remoteObjectRefrence);
		o.writeObject(rrm);
		o.flush();
		i = new ObjectInputStream(socket.getInputStream());
		RequestReplyMessage ret =(RequestReplyMessage) i.readObject();
		socket.close();
	//	return ret.getRemoteReference().getInterfaceOfRemoteObject();
	}
}
