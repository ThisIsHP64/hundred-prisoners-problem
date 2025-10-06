public class Box {
    private int lidNum;
    private int slipNum = 0;

    public Box(int lidNum) {
        this.lidNum = lidNum;
    }

    public void setSlipNum(int slipNum) {
        this.slipNum = slipNum;
    }

    public int getLidNum() {
        return lidNum;
    }

    public int getSlipNum() {
        return slipNum;
    }
}
