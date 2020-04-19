import java.util.ArrayList;
/**
 * Holds a destination object
 *
 * @author team 5
 * @version 1.0
 */
//////////////////////////////////////////////////////////////////////////////////////////
public class Node
{
    protected String name; //name of location
    protected Boolean isTourDest; //whether or not it is a tourist dest
    public ArrayList<Pathway> destinations = new ArrayList<Pathway>(); //list of
    //PathWays
    int Xpos;
    int Ypos;
    boolean visited = false; // this is used for the checking dest card algorithm
    public int nodeNumber;
    /**
     * Constructor for objects of class Point
     * @param inName Name of location
     * @param isTD whether or not it is a tourist dest
     * @param paths List of Pathways from point
     * @param inC Coordinates of point
     * @param the number that the node represents on the map
     */
    public Node(String inName, boolean isTD, int Xpos,int Ypos, int nodeNumber){
        name = inName;
        isTourDest = isTD;

        this.Xpos = Xpos;
        this.Ypos = Ypos;
        visited = false;
        this.nodeNumber = nodeNumber;
    }

    /**
     * Standard toString method
     * @return a string indicatng the node's name and all of its 
     * connected destinations
     */
    @Override
    public String toString(){

        String output ="City: "+name;

        for(Pathway p: destinations){
            output+=p.toString()+"\n";
        }
        return output;

    }

    public void setVisited(){
        visited = true;
    }

    public void resetVisited(){
        visited = false;
    }

}
