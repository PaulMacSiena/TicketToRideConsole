import java.util.ArrayList;
import java.awt.Color;
/**
 * Pathway object for ticket to ride
 *
 * @author Team 5
 * @version 1.0
 */
//////////////////////////////////////////////////////////////////////////////////////////
public class Pathway
{
    public NamedColor color;
    public Node end;
    public Node start;
    public int length;
    boolean isClaimed;
    //public ArrayList<Pathway> takenPaths = new ArrayList<Pathway>();
    /**
     * Constructor for the Pathway class
     * Initializes a color, start node, end node, and lenth of the path
     * @param c Color of path
     * @param start The starting node for the path
     * @param end The end node for the path
     * @param lenth The lenght of the path
     */
    public Pathway(NamedColor c,Node start,Node end, int length){
        this.color = c;
        this.end = end;
        this.start = start;
        this.length = length;
        isClaimed = false;
    }
    
    public boolean equals(Pathway other){
        if (this.end.name.equals(other.end) && this.start.name.equals(other.start)){
            return true;
        }
        else if (this.end.name.equals(other.start) && this.start.name.equals(other.end)){
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Standard tostring method
     * @return a String with the name of the path's start, end, length, and color 
     * 
     */
    public String toString(){
        String temp ="Route from "+start.name+" to "+end.name+" of color ";
        temp = temp +color+" and length "+length + ": " + "(start ID) "; 
        temp = temp + start.nodeNumber + " to " + "(end ID) " + end.nodeNumber;
        int numTouristDests =0;
        if (start.isTourDest){
            numTouristDests++;
        }
        if (end.isTourDest){
            numTouristDests++;
        }
        if (numTouristDests>0){
            temp = temp + ": has "+ numTouristDests + " tourist destinations.";
        }
        return temp;
    }
}
