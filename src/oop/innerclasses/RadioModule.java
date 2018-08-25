package oop.innerclasses;

public class RadioModule {

    public RadioModule() {
        System.out.println("RadioModule initialized.");
    }

    public void call(String number) {

        int length = 10;

        class GSMModule{

            private String phoneNumber;
            private int validNumber;

            public GSMModule(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public boolean isValid() {
                if (number.length()!=length) {
                    return false;
                } else {
                    try {
                        validNumber = Integer.parseInt(phoneNumber);
                        return true;
                    } catch (NumberFormatException exc) {
                        return false;
                    }
                }
            }

            public void dialIn () {
                if (isValid()) {
                    System.out.println("Calling for number "+phoneNumber);
                } else {
                    System.out.println("Phone number is invalid");
                }
            }
        }

        GSMModule module = new GSMModule(number);
        module.dialIn();
    }
}
