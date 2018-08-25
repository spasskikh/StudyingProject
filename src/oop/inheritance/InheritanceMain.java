abstraction.inheritance;

import java.util.List;

public class InheritanceMain {

    public static void main(String[] args) {

        Engine truckEngine = new Engine(6.0, EngineType.DIESEL, 900);
        Truck truck = new Truck("Volvo", "VNL300", truckEngine, 300, 500, 10_000);
        run(truck);

        Engine busEngine = new Engine(3.5,EngineType.PETROL, 500);
        Bus bus = new Bus("Mercedes","Sprinter", busEngine, 70,150,15 );
        run(bus);

        ElectricCar car = new ElectricCar("Tesla", "S", 100, 4);
        run(car);


    }

    public static void run(Auto auto) {
        auto.energize();
        auto.start();
        auto.stop();
    }
}
