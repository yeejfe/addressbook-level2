package seedu.addressbook.data.person;

/**
 * Represents a Person's block number in the address details
 * Guarantees: immutable
 */
public class Block {
    private int num;

    public Block(int blockNum){
        this.setBlockNum(blockNum);
    }
    
    /**
     * Convert block number to String object and return
     * 
     * @return String object of block number
     */
    public String getBlockNum() {
        return Integer.toString(num);
    }

    private void setBlockNum(int blockNum) {
        this.num = blockNum;
    }
}
