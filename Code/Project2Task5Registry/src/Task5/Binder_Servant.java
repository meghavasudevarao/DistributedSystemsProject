package Task5;

import java.util.HashMap;

public class Binder_Servant implements Binder {
	HashMap<String,RemoteObjectRefrence> m1 = new HashMap<String,RemoteObjectRefrence>();
	@Override
	public RemoteObjectRefrence lookup(String lookupval) {
		// TODO Auto-generated method stub
		return m1.get(lookupval);
	}

	@Override
	public void bind(String lookupval, RemoteObjectRefrence remoteObjectRefrence) {
		if(!m1.containsKey(lookupval))
			m1.put(lookupval, remoteObjectRefrence);
		
	}

	
	
}
