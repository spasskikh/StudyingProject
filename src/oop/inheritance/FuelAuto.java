package oop.inheritance;

public class FuelAuto extends Auto {

    private int availablePetrol;
    private int tankVolume;

    public FuelAuto(String producer, String model, Engine engine, int availablePetrol, int tankVolume) {
        super(producer, model, engine);
        this.availablePetrol = availablePetrol;
        this.tankVolume = tankVolume;
        System.out.println("FuelAuto was initialized.");
    }

    public int getAvailablePetrol() {
        return availablePetrol;
    }

    public void setAvailablePetrol(int availablePetrol) {
        this.availablePetrol = availablePetrol;
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }

    public void fuelUp(int volume) {
        availablePetrol+=volume;
        System.out.println("Adding fuel.");
    }



}
