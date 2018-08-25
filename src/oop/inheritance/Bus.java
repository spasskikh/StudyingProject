package oop.inheritance;

public class Bus extends FuelAuto{

    private int passengersNumber;

    public Bus(String producer, String model, Engine engine, int availablePetrol, int tankVolume, int passengersNumber) {
        super(producer, model, engine, availablePetrol, tankVolume);
        this.passengersNumber = passengersNumber;
        System.out.println("Bus was initialized.");
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }
    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    public void pickUpPassengers(int passengersNumber) {
        this.passengersNumber+=passengersNumber;
        System.out.println("Picking up "+passengersNumber+" passengers.");
    }

    public void releasePassengers() {
        if(isRunning()) {
            stop();
        }
        passengersNumber=0;
        System.out.println("Passenger released.");
    }

}
