import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item("cappucino", 3.50);
        Item item2 = new Item("Mocha", 2.75);
        Item item3 = new Item("Latte", 3.25);
        Item item4 = new Item("Drip Coffee", 3.75);
    
       //Create 2 orders 
        Order order1 = new Order();
        Order order2 = new Order();

       //Create 3 orders with name
        Order order3 = new Order("Gustavo");
        Order order4 = new Order("Mia");

       //Add 2 items to each of the orders 
        order1.addItem(item1);
        order1.addItem(item4);
        order2.addItem(item3);
        order2.addItem(item2);

        // get messages
        System.out.println(order1.getStatusMessage());

        order1.setReady(false);
        System.out.println(order1.getStatusMessage());


        // get total
        System.out.println("Your total is :"+ " "+order1.getOrderTotal());
        System.out.println("Your total is :"+ " "+order2.getOrderTotal());

        order3.addItem(item1);
        order3.addItem(item4);
        order3.addItem(item2);
        order3.display();
        

    }
}