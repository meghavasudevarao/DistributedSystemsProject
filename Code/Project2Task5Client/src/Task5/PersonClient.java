
package Task5;



public class PersonClient{
	public static void main(String args[]) {
	try {
		
		Binder_Stub b = new Binder_Stub();
		RemoteObjectRefrence remoteObjectRefrence = b.lookup("Mike");
		Person_Stub p = new Person_Stub(b);
		
		System.out.println("ID = " + p.getID("Mike"));
		String name = remoteObjectRefrence.getInterfaceOfRemoteObject();
		System.out.println(p.getName("Mike") + " has ID number " + p.getID("Mike"));
	}
	catch(Exception t) {
		t.printStackTrace();
		System.exit(0);
	}
}

}

