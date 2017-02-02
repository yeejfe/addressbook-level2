package seedu.addressbook.ui;

import java.io.PrintStream;

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
    
    private final PrintStream out;

    
    public Formatter(PrintStream out) {
        this.out = out;
    }

    /** Shows message(s) to the user */
    public void showToUserNoNewLine(String message) {
        out.println(LINE_PREFIX + message);
    }
    
    /** Shows message(s) to the user */
    public void showToUser(String... message) {
        for (String m : message) {
            out.println(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
        }
    }
}
