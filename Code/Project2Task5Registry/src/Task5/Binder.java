package Task5;

public interface Binder {
	public RemoteObjectRefrence lookup(String lookupval);
	public void bind(String lookupval,RemoteObjectRefrence remoteObjectRefrence);

}
