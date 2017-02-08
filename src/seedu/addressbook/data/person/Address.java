package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact {

    public static final String EXAMPLE = "a/123, some street, #12-34, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in the following format: a/BLOCK, STREET, UNIT, POSTALCODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+, .+, .+, .+";
    public static final String ADDRESS_SPLIT_POINT =", ";
    public static final int ADDRESS_BLOCK_INDEX = 0;
    public static final int ADDRESS_UNIT_INDEX = 1;
    public static final int ADDRESS_STREET_INDEX = 2;
    public static final int ADDRESS_POSTALCODE_INDEX = 3;
    public static final int ADDRESS_SUBSTRING_INDEX = 2;
    
    
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException{
        String trimmedAddress = address.trim();
        trimmedAddress = trimmedAddress.substring(ADDRESS_SUBSTRING_INDEX);
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        String[] segments = trimmedAddress.split(ADDRESS_SPLIT_POINT);
        block = new Block(segments[ADDRESS_BLOCK_INDEX]);
        street = new Street(segments[ADDRESS_STREET_INDEX]);
        unit = new Unit(segments[ADDRESS_UNIT_INDEX]);
        postalCode = new PostalCode(segments[ADDRESS_POSTALCODE_INDEX]);
        
    }
    public String getAddress(){
    	return new String(block.getBlock()+ADDRESS_SPLIT_POINT
        		+street.getStreet()+ADDRESS_SPLIT_POINT
        		+unit.getUnit()+ADDRESS_SPLIT_POINT
        		+postalCode.getPostalCode());
    }
    
    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return new String(block.getBlock()+ADDRESS_SPLIT_POINT
        		+street.getStreet()+ADDRESS_SPLIT_POINT
        		+unit.getUnit()+ADDRESS_SPLIT_POINT
        		+postalCode.getPostalCode());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && getAddress().equals(((Address) other).getAddress())); // state check
    }

    @Override
    public int hashCode() {
        return new String(block.getBlock()+ADDRESS_SPLIT_POINT
        		+street.getStreet()+ADDRESS_SPLIT_POINT
        		+unit.getUnit()+ADDRESS_SPLIT_POINT
        		+postalCode.getPostalCode())
        		.hashCode();
    }
}
