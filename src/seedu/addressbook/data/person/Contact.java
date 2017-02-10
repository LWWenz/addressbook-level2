package seedu.addressbook.data.person;

public class Contact {
	protected boolean isPrivate;
	protected String value;
	
	public boolean isPrivate() {
        return isPrivate;
    }
	
	@Override
    public String toString() {
        return value;
    }
	
	@Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}