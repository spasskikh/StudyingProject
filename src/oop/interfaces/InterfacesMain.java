package oop.interfaces;

import com.sun.deploy.resources.Deployment_ko;

public class InterfacesMain {

    public static void main(String[] args) {

        Pricable pizza = new Pizza("BBQ", 1,20,Size.L);
        CellPhone phone = new CellPhone("Nokia", "1100",1,160);
        Fridge fridge = new Fridge("LG", "E9090", 1, 100);

        printDeliveryPrice(pizza);
        printDeliveryPrice(phone);
        printDeliveryPrice(fridge);

        System.out.println("Total amount for " +fridge.getClass().getSimpleName() +" is " +fridge.calcTotalAmount());




    }

    private static void printDeliveryPrice (Pricable pr) {
        System.out.println("Order price for " + pr.getClass().getSimpleName() +" is "+pr.calcrOrderPrice());
        System.out.println("Delivery price for " + pr.getClass().getSimpleName() +" is "+pr.calcDeliveryPrice());
    }
}
