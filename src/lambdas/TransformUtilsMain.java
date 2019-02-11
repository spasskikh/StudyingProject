package lambdas;

public class TransformUtilsMain {

    public static void main(String[] args) {

//         * CustomClass::staticMethod
        TransformUtil<Double> doubleUtils = new TransformUtil<>();
        Double resD = doubleUtils.transform(9.02, Math::sin);
        System.out.println(resD);

        TransformUtil<String> stringUtils = new TransformUtil<>();
        String resS = stringUtils.transform("Hello", TransformUtil::exclaim);
        System.out.println(resS);

//         * customClassInstance::nonStaticMethod
        String resS2 = stringUtils.transform("Anton", "Hello "::concat);
        System.out.println(resS2);

//         * CustomClass::nonStaticMethod
        String resS3 = stringUtils.transform("Hello", String::toUpperCase);
        System.out.println(resS3);

//         * CustomClass::new
        String resS4 = stringUtils.transform("Hello", String::new);
        System.out.println(resS4);
    }

}
