import java.util.ArrayList;

public class Array {
	public static void main(String[] args) {
        
        ArrayList<Integer> myList = new ArrayList<Integer>();
        myList.add(10);
        myList.add(30);
        myList.add(40);
        // System.out.println(myList.size());

        // System.out.println( myList );

        for(int i = 0; i < myList.size(); i++){
            System.out.println( "here is the : " + myList.get(i) );
        }
	}
}