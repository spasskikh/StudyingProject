package collections.set;

public class Car implements Comparable<Car> {

    private final String carBrend;
    private final String model;
    private final Integer pricePerDay;

    public Car(String carBrend, String model, int pricePerDay) {
        this.carBrend = carBrend;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getCarBrend() {
        return carBrend;
    }

    public String getModel() {
        return model;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    //    x.equals(x) = true - reflexivity
//    x.equals(y) = true THEN y.equals(c) = true - symmetry
//    x.equals(y) = true && y.equals(z) = true THEN x.equals(z) = true - transitivity
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        } else {
            Car car = (Car) obj;
            if (!this.carBrend.equals(car.getCarBrend())) {
                return false;
            } else if (!this.model.equals(car.getModel())) {
                return false;
            } else return this.pricePerDay.equals(car.pricePerDay);
        }
    }

//    if fields are the same (was not changed), method hashCode should generate the same value, otherwise object cannot be found
//    method hashCode for equal objects should generate equal values too
//    if X equals Y then their hash codes equals, but equal hash codes do not mean, that objects will be equal (due to possible collisions)

    /*31 simple number, can be divided by 1 or by itself*/
    @Override
    public int hashCode() {
        int result = carBrend.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + pricePerDay.hashCode();
        return result;
    }

    @Override
    public int compareTo(Car car) {
        if (pricePerDay < car.getPricePerDay()) {
            return -1;
        } else if (pricePerDay > car.getPricePerDay()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return carBrend + " " + model + " " + pricePerDay;
    }
}

