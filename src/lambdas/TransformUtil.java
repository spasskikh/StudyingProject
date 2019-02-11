package lambdas;

@FunctionalInterface
interface Transformable<T> {
    T transform(T t);
}

public class TransformUtil<T> {

    T transform(T t, Transformable<T> function) {
        return function.transform(t);
    }

    static String exclaim(String str) {
        return str.toUpperCase();
    }

}
