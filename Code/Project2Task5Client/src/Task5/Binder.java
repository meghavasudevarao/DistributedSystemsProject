package Task5;

public interface Binder {
	public RemoteObjectRefrence lookup(String lookupval) throws Exception;
	public void bind(String lookupval,RemoteObjectRefrence remoteObjectRefrence) throws Exception;

}
