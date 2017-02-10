package seedu.addressbook.data;

/**
 * Allows classes that implement this interface to produce printable representation of object
 */
public interface Printable {
    public static final String PRINTABLE_SEPARATOR = ", ";

    public abstract String getPrintableString();

    /**
     * Returns a concatenated version of the printable strings of each object.
     */
    static String getPrintableString(Printable... printables) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Printable printable : printables) {
            stringBuilder.append(printable.getPrintableString() + PRINTABLE_SEPARATOR);
        }
        return stringBuilder.toString();
    }
}