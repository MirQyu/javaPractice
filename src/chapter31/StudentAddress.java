package chapter31;

public class StudentAddress implements java.io.Serializable {
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public StudentAddress(String name, String street, String city, String state, String zip) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		
		builder.append(name + ", ");
		builder.append(street + ", ");
		builder.append(city + ", ");
		builder.append(state + ", ");
		builder.append(zip + "]");
		
		return builder.toString();
	}
}
