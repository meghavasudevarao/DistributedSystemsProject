package Task5;

import java.io.IOException;
import java.net.UnknownHostException;

public interface Binder {
	public RemoteObjectRefrence lookup(String lookupval) throws Exception;
	public void bind(String lookupval,RemoteObjectRefrence remoteObjectRefrence) throws Exception;

}
