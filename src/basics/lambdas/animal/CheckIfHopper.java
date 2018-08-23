package basics.lambdas.animal;

public class CheckIfHopper implements Checker {

    @Override
    public boolean test(Animal a) {
        return a.canHop();
    }
}
