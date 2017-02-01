package seedu.addressbook.data.person;

public class Street {

	private String _street;
	
	public Street(String street){
		_street = street;
	}
	
	public String getStreet() {
		return _street;
	}
	
	public void updatestreet(String street){
		_street = street;
	}
}
