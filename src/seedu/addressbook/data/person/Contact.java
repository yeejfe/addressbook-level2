package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represent contact details in person
 * 
 * @author Yee
 *
 */
public class Contact {
    public String value;
    protected boolean isPrivate;

    public Contact(String value, boolean isPrivate, String validationRegex, String constraints)
            throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedValue = value.trim();
        if (!isValid(trimmedValue, validationRegex)) {
            throw new IllegalValueException(constraints);
        }
        this.value = trimmedValue;
    }

    /**
     * Returns true if a given string match the valid regular expression.
     */
    public static boolean isValid(String test, String validationRegex) {
        return test.matches(validationRegex);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                        && this.value.equals(((Contact) other).value)); // state
                                                                        // check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
