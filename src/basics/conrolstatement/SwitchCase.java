package basics.conrolstatement;

public class SwitchCase {

    public static void main(String[] args) {
        int choice = /*Integer.valueOf(args[0]);*/ (int) (Math.random() * 10);

        switch (choice) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Your choice is " + choice + ".");
                break;
            default:
                System.out.println("Your choice is out of range.");
        }

        System.out.println();
        String weekDay = getDay();

        System.out.println("Your day is " + weekDay + ".");

        switch (weekDay) {
            case "Monday":
                System.out.println("This is first working day.");
                break;
            case "Tuesday":
                System.out.println("This is second working day.");
                break;
            case "Wednesday":
                System.out.println("This is third working day.");
                break;
            case "Thursday":
                System.out.println("This is forth working day.");
                break;
            case "Friday":
                System.out.println("This is fifth working day.");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println("Finally weekend.");
                break;
        }


    }

    public static String getDay() {
        int day = (int) (Math.random() * 10);

        if (day > 7 || day == 0) {
            return getDay();
        } else {
            String weekDay = null;

            switch (day) {
                case 1:
                    weekDay = "Monday";
                    break;
                case 2:
                    weekDay = "Tuesday";
                    break;
                case 3:
                    weekDay = "Wednesday";
                    break;
                case 4:
                    weekDay = "Thursday";
                    break;
                case 5:
                    weekDay = "Friday";
                    break;
                case 6:
                    weekDay = "Saturday";
                    break;
                case 7:
                    weekDay = "Sunday";
                    break;
            }
            return weekDay;
        }

    }


}
