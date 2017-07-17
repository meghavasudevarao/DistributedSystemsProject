package Task4;

public class Person_Servant implements Person {
	int id;
	String name;
	public Person_Servant(String n, int i) {
		name = n;
		id = i;
	}
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
}
