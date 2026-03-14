package domain;

public class DragonHead {
    private int eyesCount;
    private Double toothCount; //Поле не может быть null

    public DragonHead(int eyesCount, Double toothCount) {
        this.eyesCount = eyesCount;
        this.toothCount = toothCount;
    }

    public int getEyesCount() { return eyesCount; }
    public void setEyesCount(int eyesCount) { this.eyesCount = eyesCount; }

    public Double getToothCount() { return toothCount; }
    public void setToothCount(Double toothCount) { this.toothCount = toothCount; }

    @Override
    public String toString() {
        return String.format("DragonHead{eyesCount=%d, toothCount=%.1f}", eyesCount, toothCount);
    }
}
