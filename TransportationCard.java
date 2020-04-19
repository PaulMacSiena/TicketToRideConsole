import java.awt.Color;
/**
 * Transportation card for ticket to ride. Called "trans"
 * card because frankly we need to minimize variable
 * name length as much as possible
 *
 * @author Team 5
 * @version 1.0
 */
//////////////////////////////////////////////////////////////////////////////////////////
public class TransportationCard extends Card
{
    //these are protected so they can accessed anywhere in package or subclass
    protected NamedColor color; //COLORS: BLUE, GREEN, BLACK, PINK, RED, ORANGE,(RAINBOW)
    protected boolean isFaceUp; 
    public String imagePath;

    /**
     * Constructor for objects of class TransCard
     * @param color of the card
     */
    public TransportationCard(NamedColor c,String imagePath){
        color = c;
        this.imagePath = imagePath;
    }   
    
    
    /**
     * ToString method that will print the output in the form
     * of a string.
     */
    @Override
    public String toString(){
        return  color + " card";
    }
    
}
