package oop.innerclasses;

public class CellPhone {

    private String make;
    private String model;
    private Display display;
    private RadioModule module;
    private AbstractButton button;

    public interface AbstractButton {
        void click();
    }

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
        module = new RadioModule();
        initButton();
    }

    public void initButton() {
        button = new AbstractButton() {
            @Override
            public void click() {
                System.out.println("Button clicked.");
            }
        };
    }

    public void call(String number) {
        button.click();
        module.call(number);
    }
}

