package basics.other;

public class DrawTree {

    public static void main(String[] args) {

        DrawTree.oneSideTree (10);
        System.out.println();
        DrawTree.oneSideTreeReversed (10);
        System.out.println();
        DrawTree.twoSideTree (10);
        System.out.println();
        DrawTree.twoSideTreeReversed (10);

    }

    public static void oneSideTree (int hight) {

        char c = '*';

        int width = 1;

        while (hight > 0) {
            for (int j = 0 ; j < width ; j++){
                System.out.print(c);
            }
            System.out.println();
            width++;
            hight--;
        }
    }

    public static void oneSideTreeReversed (int hight) {

        char c = '*';

        int width = hight;

        while (hight > 0) {
            for (int j = width ; j > 0 ; j--){
                System.out.print(c);
            }
            System.out.println();
            width--;
            hight--;
        }
    }

    public static void twoSideTree (int hight) {

        char c = '*';
        char s = ' ';

        int maxWidth = hight*2-1;
        int spaces = maxWidth-1;
        int width = 1;

        while (hight > 0) {

            if (spaces!=0) {
                for (int k = 0 ; k < spaces/2 ; k++) {
                    System.out.print(s);
                }
            }
            for (int j = 0 ; j < width ; j++){
                System.out.print(c);
            }
            System.out.println();
            width += 2;
            spaces -= 2;
            hight--;
        }
    }

    public static void twoSideTreeReversed (int hight) {

        char c = '*';
        char s = ' ';

        int width = hight*2-1;
        int spaces = 0;

        while (hight > 0) {

            if (spaces!=0) {
                for (int k = 0 ; k < spaces/2 ; k++) {
                    System.out.print(s);
                }
            }
            for (int j = width ; j > 0 ; j--){
                System.out.print(c);
            }
            System.out.println();
            width -= 2;
            spaces += 2;
            hight--;
        }
    }



}
