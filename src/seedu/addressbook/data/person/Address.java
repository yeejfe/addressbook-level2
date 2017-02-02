package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)} Assume the address is
 * entered in the following format BLOCK, STREET, UNIT, POSTAL_CODE e.g.
 * 123, Clementi Ave 3, #12-34, 231534
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    private Block blockNum;
    private Street streetName;
    private Unit unitNum;
    private PostalCode postal;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException
     *             if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();       
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
        
        splitAddressDetails();
    }

    private void splitAddressDetails() throws IllegalValueException {
        String[] addrArray =  this.value.split(", ");
        this.setBlockNum(new Block(Integer.parseInt(addrArray[0])));
        this.setStreetName(new Street(addrArray[1]));
        this.setUnitNum(new Unit(addrArray[2]));
        this.setPostal(new PostalCode(Integer.parseInt(addrArray[3])));
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                        && this.value.equals(((Address) other).value)); // state
                                                                        // check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public Block getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(Block blockNum) {
        this.blockNum = blockNum;
    }

    public Street getStreetName() {
        return streetName;
    }

    public void setStreetName(Street streetName) {
        this.streetName = streetName;
    }

    public Unit getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(Unit unitNum) {
        this.unitNum = unitNum;
    }

    public PostalCode getPostal() {
        return postal;
    }

    public void setPostal(PostalCode postal) {
        this.postal = postal;
    }
}
