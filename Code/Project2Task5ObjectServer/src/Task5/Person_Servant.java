package Task5;

public class Person_Servant implements Person {
	RemoteObjectRefrence remoteObjectRefrence;
	String ret= "Mike";
	int ID= 34;
	public Person_Servant (RemoteObjectRefrence remoteObjectRefrence)
	{
		this.remoteObjectRefrence=remoteObjectRefrence;
	}
	Binder b= new  Binder_Stub(remoteObjectRefrence);

	@Override
	public int getID(String lookup) throws Exception {
		return ID;
		// TODO Auto-generated method stub

	}

	@Override
	public String getName(String lookup) throws Exception {
		// TODO Auto-generated method stub
		 return ret;
	}
	
	
	

}
