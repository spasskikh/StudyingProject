package oop.inheritance;

public class Truck extends FuelAuto {

    private int cargoWeigh;

    public Truck(String producer, String model, Engine engine, int availablePetrol, int tankVolume, int cargoWeigh) {
        super(producer, model, engine, availablePetrol, tankVolume);
        this.cargoWeigh = cargoWeigh;
        System.out.println("Truck was initialized.");
    }

    public int getCargoWeigh() {
        return cargoWeigh;
    }
    public void setCargoWeigh(int cargoWeigh) {
        this.cargoWeigh = cargoWeigh;
    }

    public void load() {
        System.out.println("Cargo loaded.");
    }

    public void unload() {
        System.out.println("Cargo unloaded.");
    }
}
