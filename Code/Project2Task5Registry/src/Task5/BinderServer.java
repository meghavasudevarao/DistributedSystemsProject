package Task5;

public class BinderServer {
	Binder b= new Binder_Servant();
	Binder_Skeleton bsk= new Binder_Skeleton(b); 
	public  void serve()
	{
		bsk.serve();
	}

}
