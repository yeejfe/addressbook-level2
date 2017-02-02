package seedu.addressbook.data.person;

public class PostalCode {   
    private int code;

    public PostalCode(int code) {
        this.setCode(code);
    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

}
