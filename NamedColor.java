import java.util.ArrayList;
import java.awt.Color;
import java.util.*;

/**
 * Constructs a board object for the game
 * Holds a transportation Card deck,
 * a destination card deck,
 * A list of players,
 * a list if colors (for transportation cards),
 * and a list of nodes (for the map)
 * 
 *
 * @author Team 5 
 * @version 1.0
 */
////////////////////////////////////////////////////////////////////////////////
public enum NamedColor {
    BLUE(Color.BLUE, "Blue"),
    RED(Color.RED, "Red"),
    ORANGE(Color.ORANGE, "Orange"),
    GREEN(Color.GREEN, "Green"),
    PINK(Color.BLUE, "Pink"),
    BLACK(Color.RED, "Black"),
    RAINBOW(Color.CYAN, "Rainbow"),
    ;

    private final Color awtColor;
    private final String colorName;
    
    /**
     * Sets the color and color name when the constructor is called.
     */
    private NamedColor(Color awtColor, String name) {
        this.awtColor = awtColor;
        this.colorName = name;
    }
    
    /**
     * Boolean method that will check to see if the colors are equal.
     */
    public boolean equals(NamedColor other){
        if (this.colorName.equals(other.colorName)) return true;
        else return false;
    }

    /**
     * Returns the color.
     */
    public Color getAwtColor() {
        return awtColor;
    }

    
    /**
     * Returns the name of the color.
     */
    public String getColorName() {
        return colorName;
    }
    
    
    /**
     * Main Method. Used for printing.
     */
    public static void main(String[] args){
        System.out.println(BLUE.getColorName());
    }
}
