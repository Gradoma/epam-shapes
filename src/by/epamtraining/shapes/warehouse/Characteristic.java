package by.epamtraining.shapes.warehouse;

public class Characteristic {
    private double square;
    private double volume;
    private boolean isTouchPlane;
    private double volumeRatio;

    public Characteristic(){}

    public double getSquare() {
        return square;
    }

    public double getVolume() {
        return volume;
    }

    public boolean isTouchPlane() {
        return isTouchPlane;
    }

    public double getVolumeRatio() {
        return volumeRatio;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setTouchPlane(boolean touchPlane) {
        isTouchPlane = touchPlane;
    }

    public void setVolumeRatio(double volumeRatio) {
        this.volumeRatio = volumeRatio;
    }

    @Override
    public String toString() {
        return getClass().getName() +"{" +
                "square=" + square +
                ", volume=" + volume +
                ", isTouchPlane=" + isTouchPlane +
                ", volumeRatio=" + volumeRatio +
                '}';
    }
}
