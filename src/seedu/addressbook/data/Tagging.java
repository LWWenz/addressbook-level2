package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {

	private Person person;
	private Tag tag;
	private boolean isAdd;
	
	public Tagging(Person personAdded, Tag personTag, boolean isAdd) {
		person = personAdded;
		tag = personTag;
		this.isAdd = isAdd;
	}
	
	public String getString() {
		StringBuilder sb = new StringBuilder();
		if(isAdd) {
			sb.append("+ ");
		}
		else {
			sb.append("- ");
		}
		sb.append(person.getName() + " " + tag.toString());
		
		return sb.toString();
	}
	
	
	
}
