package lambdas;

import java.util.function.Consumer;

public class LambdaScopeTest {

    double d = 1.23;

    class LambdaScopeInner {
        double d = 4.56;

        void testScope(double d) {
            Consumer<Double> res = e -> {
                System.out.println("e = " + e);
                System.out.println("d = " + d);
                System.out.println("this.d = " + this.d);
                System.out.println("LambdaScopeTest.this.d = " + LambdaScopeTest.this.d);
            };
            res.accept(1.234);
        }
    }

    public static void main(String[] args) {
        LambdaScopeTest test = new LambdaScopeTest();
        LambdaScopeInner inner = test.new LambdaScopeInner();

        inner.testScope(999.0);
    }
}
