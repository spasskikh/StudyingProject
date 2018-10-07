package collections.implementations.stack;

public interface Stack {

    boolean push(int elem); //puts an element to an array
    boolean empty(); //is there any element
    Integer pop(); //take last element and delete it from array
    Integer peek(); //take last element and DO NOT delete it from array
    int size(); // shows number of elements

}

