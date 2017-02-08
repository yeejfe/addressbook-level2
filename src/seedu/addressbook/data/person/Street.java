package seedu.addressbook.data.person;

/**
 * Represents a Person's street name in the address details
 * Guarantees: immutable
 */
public class Street {
    private String name;

    public Street(String streetName){
        this.setName(streetName);
    }
    
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
