package Task4;

public class PersonServer {
	public static void main(String args[]) {
		Person p = new Person_Servant("Mike",24);
		Person_Skeleton ps = new Person_Skeleton(p);
		ps.serve();
	}
}
