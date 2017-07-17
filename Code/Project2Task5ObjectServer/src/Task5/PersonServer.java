package Task5;



public class PersonServer {
	public static void main(String args[]) throws Exception {
		RemoteObjectRefrence remoteObjectRefrence= new RemoteObjectRefrence();
		remoteObjectRefrence.objectNumber=34;
		Person p = new Person_Servant(remoteObjectRefrence);
		Person_Skeleton ps = new Person_Skeleton(p);
		Binder b= new  Binder_Stub(remoteObjectRefrence);
		b.bind("Mike", remoteObjectRefrence);
		ps.serve();
	}

}
