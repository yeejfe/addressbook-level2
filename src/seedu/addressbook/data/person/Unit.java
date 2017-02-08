package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's unit address in the address details
 * Guarantees: immutable
 */
public class Unit {
    public static final String UNIT_VALIDATION_REGEX = "^(#\\d{2}-\\d{2})$";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Person addresses can be in any format";
    
    private String num;

    public Unit(String blockNum) throws IllegalValueException{
        this.setBlockNum(blockNum);
    }
    
    public String getBlockNum() {
        return num;
    }

    private void setBlockNum(String blockNum) throws IllegalValueException {
        if (!isValidUnit(blockNum)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.num = blockNum;
    }
    
    /**
     * Returns true if a given string is a valid unit.
     */
    private static boolean isValidUnit(String unit) {
        return unit.matches(UNIT_VALIDATION_REGEX);
    }
}
