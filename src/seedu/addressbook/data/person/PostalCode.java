package seedu.addressbook.data.person;

/**
 * Represents a Person's postal code in the address details
 * Guarantees: immutable
 */
public class PostalCode {   
    private int code;

    public PostalCode(int code) {
        this.setCode(code);
    }

    /**
     * Convert postal code to String object and return
     * 
     * @return String object of Postal code
     */
    public String getCode() {
        return Integer.toString(code);
    }

    private void setCode(int code) {
        this.code = code;
    }

}
