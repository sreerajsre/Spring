import java.util.HashSet;

public class Employee{
	private String name;
	private int id;
	private int age;
	public Employee(String name,int id,int age) {
		this.age = age;
		this.name  = name;
		this.id = id;
	}


	public static void main (String[] args){
		//TreeSet<Employee> treeSet = new TreeSet<Employee>();
		HashSet<Employee> treeSet = new HashSet<Employee>();
		treeSet.add(new Employee("Ram",10,30));
		treeSet.add(new Employee("Shyam",30,12));
		treeSet.add(new Employee("Manu",20,26));
		treeSet.stream().forEach(e-> System.out.println(e.name + " " + e.age));
	}

//	@Override
//	public int compareTo(Employee e) {
//		if(e.age < this.age)
//			return 1 ;
//		else if(e.age == this.age)
//			return 0;
//		else
//			return -1;
//	}
}