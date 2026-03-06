package ru.tequila.lab.domain;

public final class DragonHead {
    private int eyesCount;
    private Double toothCount; // не null

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
        return String.format("DragonHead{eyes=%d, teeth=%.1f}", eyesCount, toothCount);
    }
}
