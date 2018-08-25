package oop.interfaces;

public interface Pricable extends Deliverable, Orderable{

    default int calcTotalAmount() {
        return calcrOrderPrice()+calcDeliveryPrice();
    }

}
