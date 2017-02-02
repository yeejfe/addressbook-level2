package seedu.addressbook.data.person;

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
