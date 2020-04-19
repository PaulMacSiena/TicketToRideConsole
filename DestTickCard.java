
/**
 * Destination Ticket for Ticket to Ride,  
 *
 * @author team 5
 * @version 1.0
 */
//////////////////////////////////////////////////////////////////////////////////////////
public class DestTickCard extends Card
{
    protected Node a;
    protected Node b;
    int value;
    public String imagePath;
    boolean fullfilled;

    /**
     * Constructor for objects of class DestTickCard
     * @param A One point on card
     * @param B Other point on card
     * @param value Value of dest ticket card
     * @param String the image path
     */
    public DestTickCard(Node A, Node B, int val,String imagePath){
        a = A;
        b = B;
        value = val;
        this.imagePath = imagePath;
        fullfilled = false;
    }
    
    /**
     * Standard to string method for a destination ticket card
     * @return the Name of each node, the value of the card, and the name of the
     * path
     */
    public String toString(){
        return "DestTicketCard - Route from " + a.name +" to "+b.name+" worth "
        + value + " points";
    }
    
    /**
     * sets the card to be fulled
     */
    
    public void setFullFilled(){
        fullfilled = true;
    }
    
    
}
