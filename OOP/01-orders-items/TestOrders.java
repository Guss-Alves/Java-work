import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        item1.name = "Mocha";
        item1.value = 2.50;

        Item item2 = new Item();
        item2.name = "latte";
        item2.value = 2.75;

        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.value = 2.75;

        Item item4 = new Item();
        item4.name = "capuccino";
        item4.value = 3.25;

        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";
        order1.ready = true;

        Order order2 = new Order();
        order2.name = "Jimmy";
        order2.items.add( item1 );
        order2.items.add( item2 );
        order2.items.add( item2 );
        order2.total += item1.value + (2* item2.value);
        System.out.println(order2.items);

        Order order3 = new Order();
        order3.name = "Noah";
        order3.items.add( item4 );
        order3.total += item4.value;

        Order order4 = new Order();
        order4.name = "Sam";
        order4.items.add( item2 );
        order4.total += item2.value;
    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order1.ready);
    }
}
