package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)} Assume the address is
 * entered in the following format BLOCK, STREET, UNIT, POSTAL_CODE e.g. 123,
 * Clementi Ave 3, #12-34, 231534
 */
public class Address {

    private static final int POSTAL_CODE = 3;
    private static final int UNIT_NUM = 2;
    private static final int STREET_NAME = 1;
    private static final int BLOCK_NUM = 0;
    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

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
        splitAddressDetails(trimmedAddress);
    }

    /**
     * Split the address details into block number, street name, unit number,
     * postal code respectively.
     * <p>
     * This method always execute immediately, unless there exist a Unit value
     * that is invalid.
     * @param trimmedAddress    the trimmedAddress String object of white spaces
     * @throws IllegalValueException
     */
    private void splitAddressDetails(String trimmedAddress) throws IllegalValueException {
        String[] addrArray = trimmedAddress.split(",");
        this.blockNum = new Block(Integer.parseInt(addrArray[BLOCK_NUM]));
        this.streetName = new Street(addrArray[STREET_NAME]);
        this.unitNum = new Unit(addrArray[UNIT_NUM]);
        this.postal = new PostalCode(Integer.parseInt(addrArray[POSTAL_CODE]));
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.blockNum.getBlockNum() + this.streetName.toString() + this.unitNum.toString() + this.postal.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                        && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
