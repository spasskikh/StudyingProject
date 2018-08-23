package basics.conrolstatement;

public class WhileDo {

    public static void main(String[] args) {
        int finalBalance = 100_000;
        int currentBalance = 0;
        int payment = 1_000;
        int years = 0;
        double interestRate = 0.1;

        while (currentBalance < finalBalance && years < 15) {
            currentBalance += payment;
            currentBalance = currentBalance + (int)(currentBalance * interestRate);
            years++;
            System.out.println("Years: " + years + '\t' + "Current balance: " + currentBalance);
        }

//        do {
//            currentBalance += payment;
//            currentBalance = currentBalance + (int)(currentBalance * interestRate);
//            years++;
//            System.out.println("Years: " + years + '\t' + "Current balance: " + currentBalance);
//        }
//        while (currentBalance < finalBalance && years < 15);

    }
}
