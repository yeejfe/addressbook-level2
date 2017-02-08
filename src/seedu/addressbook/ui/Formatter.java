package seedu.addressbook.ui;

/**
 * Represents the formatter used for text displayed to user
 *
 * Guarantees:
 *  - String is formatted and returned according to methods called
 * 
 * @author Yee Eric
 */
public class Formatter {
    /** Format of indexed list item */
    protected static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    protected static final String COMMENT_LINE_FORMAT_REGEX = "#.*";
    
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    protected static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    protected static final String LS = System.lineSeparator();

    protected static final String DIVIDER = "===================================================";
    
    /** format string */
    public static String format(String toBeFormatString){
        return Formatter.LINE_PREFIX + toBeFormatString;
    }
    
    /** format string(s) */
    public static String format(String... toBeFormatString){
        String formattedString = null;
        for (String fString : toBeFormatString){
            formattedString = LINE_PREFIX + fString.replace("\n", LS + LINE_PREFIX);
        }
        if(formattedString.equals(null))
            throw new NullPointerException("Formating String cannot be null");
        else
            return formattedString;
    }
}
