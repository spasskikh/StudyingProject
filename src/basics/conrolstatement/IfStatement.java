package basics.conrolstatement;

public class IfStatement {

    public static void main(String[] args) {
        int mark = (int)(Math.random()*100);

        System.out.print("You've got ");

        if (mark>=90){
            System.out.print("EXCELLENT");
        }else if (mark>=80) {
            System.out.print("GOOD");
        }else if (mark >=60) {
            System.out.print("SATISFACTORY");
        } else {
            System.out.print("BAD");
        }

        System.out.print(" mark.");


    }
}
