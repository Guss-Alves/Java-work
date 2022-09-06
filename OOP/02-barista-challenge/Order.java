import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items = new ArrayList<Item>(); // defaults to null
    
    public Order(){
        this.name = "";
        this.ready = true;
    }
    public Order( String name) {
        this.name = name;
        this.ready = false;
    }
    public String getName(){
        return this.name;
    }
    public boolean getReady(){
        return this.ready;
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setReady(boolean ready){
        this.ready = ready;
    }
    public void setItems(ArrayList<Item> items){
        this.items = items;
    }

    //methods are being created here !!

    public void addItem(Item item) {
        this.items.add(item);
        // System.out.println(item);
    }

    public String getStatusMessage(){
        if(this.ready == true) {
            return "Your order is ready.";
        } else {
            return "Thanks you for waiting, your order will be ready pretty soon.";
        }
    }
    public double getOrderTotal(){
        double total = 0;
        for(Item i: this.items) {
            // System.out.println(this.items);
            total += i.getPrice();
        }
        return total;
    }
    public void display(){
        System.out.println("Customer Name: "+ this.name);
        for(Item i: this.items) {
            System.out.println(i.getName() + " - $" + i.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }
    
}

