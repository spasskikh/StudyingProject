package oop.innerclasses;

public class CellPhone {

    private String make;
    private String model;
    private Display display;

    public CellPhone(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Display getDisplay() {
        return display;
    }

    private void initDisplay() {
        Display d = new Display();
        this.display = d;
    }

    public void turnOn () {
        initDisplay();
    }
}
