package oop.inheritance;

import java.util.List;

public class InheritanceType {

    public static void main(String[] args) {

        Engine truckEngine = new Engine(6.0, EngineType.DIESEL, 900);
        Truck truck = new Truck("Volvo", "VNL300", truckEngine, 300, 500, 10_000);
        truck.start();
        truck.accelerate(40);
        truck.stop();
        truck.fuelUp(100);
        truck.load();
        truck.unload();

        System.out.println();

        ElectricCar car = new ElectricCar("Tesla", "S", 100, 4);
        car.start();
        car.stop();
        car.charge();

        System.out.println();


        Engine busEngine = new Engine(3.5,EngineType.PETROL, 500);
        Bus bus = new Bus("Mercedes","Sprinter", busEngine, 70,150,15 );
        bus.fuelUp();
        bus.pickUpPassengers(10);
        bus.start();
        bus.releasePassengers();

        Engine engine = bus.getEngine();
        System.out.println(engine.getEngineType());
        List<Piston> pistons = engine.getPistons();
        System.out.println(pistons);
    }
}
