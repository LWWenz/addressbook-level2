package seedu.addressbook.data.person;

public class Unit {

	private String _unit;
	
	public Unit(String unit){
		_unit = unit;
	}
	
	public String getUnit() {
		return _unit;
	}
	
	public void updateUnit(String unit){
		_unit = unit;
	}
}
