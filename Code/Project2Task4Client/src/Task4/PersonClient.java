package Task4;

public class PersonClient {
	public static void main(String args[]) {
		try {
			Person p = new Person_Stub();
			int id = p.getID();
			System.out.println("ID = " + id);
			String name = p.getName();
			System.out.println(name + " has ID number" + id);
		}
		catch(Exception t) {
			t.printStackTrace();
			System.exit(0);
		}
	}
}