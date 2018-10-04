package basics.other.transform;

import basics.other.transform.controller.Transformer;
import basics.other.transform.model.ValueToTransfom;
import basics.other.transform.view.Viewer;

public class TransformMain {

    public static void main(String[] args) {

        int i = ValueToTransfom.generate();

        Transformer.binary(i);

        Viewer.print("Initial value: " + i);
        Viewer.print("Binary number: " + Transformer.binary(i));
        Viewer.print("Octal number: " + Transformer.octal(i));
        Viewer.print("Hexadecimal number: " + Transformer.hexadecimal(i));

        System.out.println(Integer.toHexString(i));


    }

}
