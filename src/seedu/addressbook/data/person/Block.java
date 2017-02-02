package seedu.addressbook.data.person;

public class Block {
    private int num;

    public Block(int blockNum){
        this.setBlockNum(blockNum);
    }
    
    public int getBlockNum() {
        return num;
    }

    private void setBlockNum(int blockNum) {
        this.num = blockNum;
    }
}
