class TripleInOne {

    private int[] list;
    private int[] indexs;
    private int stackSize;
    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        this.list = new int[stackSize * 3];
        this.indexs = new int[3];
        this.indexs[0] = -1;
        this.indexs[1] = -1 + stackSize;
        this.indexs[2] = -1 + stackSize * 2;
    }
    
    public void push(int stackNum, int value) {
        if (indexs[stackNum] == (stackNum + 1) * stackSize - 1) {
            return;
        }
        list[++indexs[stackNum]] = value;
    }
    
    public int pop(int stackNum) {
        if (indexs[stackNum] < stackNum * stackSize) {
            return -1;
        }
        return list[indexs[stackNum]--];
    }
    
    public int peek(int stackNum) {
        if (indexs[stackNum] < stackNum * stackSize) {
            return -1;
        }
        return list[indexs[stackNum]];
    }
    
    public boolean isEmpty(int stackNum) {
        return indexs[stackNum] < stackNum * stackSize;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
