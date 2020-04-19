import java.util.ArrayList;
import java.awt.Color;
import java.util.*;
import java.io.File;
import java.io.IOException;

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
public class Board 
{
    public Deck transDeck = new Deck();
    public Deck destDeck = new Deck();
    public ArrayList<TransportationCard> faceUps = 
        new ArrayList<TransportationCard>();

    public ArrayList<Player> players = new ArrayList<Player>();
    public ArrayList<NamedColor> colorsInGame = new ArrayList<NamedColor>();
    public ArrayList<Node> map = new ArrayList<Node>();
    public int numP;
    public Player currentPlayer; 
    public static NamedColor[] THE_COLORS = new NamedColor[]{NamedColor.BLUE,
            NamedColor.RED,  
            NamedColor.ORANGE, NamedColor.GREEN, NamedColor.PINK, 
            NamedColor.BLACK,NamedColor.RAINBOW};

    {        
        for (int i =0; i<THE_COLORS.length-1;i++){ //IGNORE THE RAINBOW
            colorsInGame.add(THE_COLORS[i]);
        }
    }

    /**
     * Constructor for board object
     * Takes as input the number of players for the game
     */
    public Board(int numPlayers){
        numP = numPlayers;
        map.add(new Node("Lincoln Center",false,0,0,0));//0
        map.add(new Node("Central Park",true,0,0,1));//1
        map.add(new Node("Midtown West",false,0,0,2));//2
        map.add(new Node("Times Square",true,0,0,3));//3
        map.add(new Node("United Nations",true,0,0,4));//4
        map.add(new Node("Empire State Building",true,0,0,5));//5
        map.add(new Node("Chelsea",true,0,0,6));//6
        map.add(new Node("Gramercy Park",false,0,0,7));//7
        map.add(new Node("Greenwich Village",true,0,0,8));//8
        map.add(new Node("East Village",false,0,0,9));//9
        map.add(new Node("Soho",false,0,0,10));//10
        map.add(new Node("Lower East Side",false,0,0,11));//11
        map.add(new Node("Chinatown",true,0,0,12));//12
        map.add(new Node("Wall Street",true,0,0,13));//13
        map.add(new Node("Brooklyn",true,0,0,14));//14

        //connections from Lincoln Center
        map.get(0).destinations.
        add(new Pathway(NamedColor.ORANGE,map.get(0),map.get(1),2));
        map.get(0).destinations
        .add(new Pathway(NamedColor.RED,map.get(0),map.get(2),2));

        map.get(0).destinations.
        add(new Pathway(NamedColor.BLUE,map.get(0),map.get(3),2));

        if (numPlayers>2){ // if there are less than 3 players, don't add the double route
            map.get(0).destinations.
            add(new Pathway(NamedColor.GREEN,map.get(0),map.get(3),2));
        }

        //connections from Central Park
        map.get(1).destinations.
        add(new Pathway(NamedColor.ORANGE,map.get(1),map.get(0),2));

        map.get(1).destinations.
        add(new Pathway(NamedColor.PINK,map.get(1),map.get(4),3));

        // map.get(1).destinations.
        // add(new Pathway(NamedColor.PINK,map.get(1),map.get(4),3)); duplicate

        map.get(1).destinations.
        add(new Pathway(NamedColor.RED,map.get(1),map.get(3),2));

        if (numPlayers>2){ // if there are less than 3 players, don't add the double route
            map.get(1).destinations.
            add(new Pathway(NamedColor.BLACK,map.get(1),map.get(3),2));
        }

        //connections from Midtown West
        map.get(2).destinations.
        add(new Pathway(NamedColor.RED,map.get(2),map.get(0),2));
        map.get(2).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(2),map.get(3),1));
        map.get(2).destinations.
        add(new Pathway(NamedColor.GREEN,map.get(2),map.get(5),2));
        map.get(2).destinations.
        add(new Pathway(NamedColor.BLUE,map.get(2),map.get(6),2));

        //connections from Times Square
        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(3).destinations.
            add(new Pathway(NamedColor.GREEN,map.get(3),map.get(0),2));
        }

        map.get(3).destinations.
        add(new Pathway(NamedColor.BLUE,map.get(3),map.get(0),2));
        map.get(3).destinations.        
        add(new Pathway(NamedColor.BLACK,map.get(3),map.get(1),2));
        map.get(3).destinations.
        add(new Pathway(NamedColor.RED,map.get(3),map.get(1),2));
        map.get(3).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(3),map.get(2),1));
        map.get(3).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(3),map.get(4),2));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(3).destinations.
            add(new Pathway(NamedColor.ORANGE,map.get(3),map.get(5),1));
        }
        map.get(3).destinations.
        add(new Pathway(NamedColor.PINK,map.get(3),map.get(5),1));

        //connections from United Nations
        map.get(4).destinations.
        add(new Pathway(NamedColor.PINK,map.get(4),map.get(1),3));
        map.get(4).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(4),map.get(3),2));
        map.get(4).destinations.
        add(new Pathway(NamedColor.GREEN,map.get(4),map.get(7),3));
        map.get(4).destinations.
        add(new Pathway(NamedColor.BLACK,map.get(4),map.get(5),2));

        //connections from Empire State Building
        map.get(5).destinations.
        add(new Pathway(NamedColor.GREEN,map.get(5),map.get(2),2));
        map.get(5).destinations.
        add(new Pathway(NamedColor.BLACK,map.get(5),map.get(4),2));

        map.get(5).destinations.
        add(new Pathway(NamedColor.PINK,map.get(5),map.get(3),1));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(5).destinations.
            add(new Pathway(NamedColor.ORANGE,map.get(5),map.get(3),1));
        }

        map.get(5).destinations.
        add(new Pathway(NamedColor.RED,map.get(5),map.get(7),1));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(5).destinations.
            add(new Pathway(NamedColor.BLUE,map.get(5),map.get(7),1));
        }

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(5).destinations.
            add(new Pathway(NamedColor.RAINBOW,map.get(5),map.get(6),2));
        }

        map.get(5).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(5),map.get(6),2));

        //connections from Chelsea
        map.get(6).destinations.
        add(new Pathway(NamedColor.BLUE,map.get(6),map.get(2),2));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(6).destinations.
            add(new Pathway(NamedColor.RAINBOW,map.get(6),map.get(5),2));
        }

        map.get(6).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(6),map.get(5),2));

        map.get(6).destinations.
        add(new Pathway(NamedColor.ORANGE,map.get(6),map.get(7),2));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(6).destinations.        
            add(new Pathway(NamedColor.RED,map.get(6),map.get(8),3));
        }

        map.get(6).destinations.
        add(new Pathway(NamedColor.GREEN,map.get(6),map.get(8),3));

        map.get(6).destinations.
        add(new Pathway(NamedColor.PINK,map.get(6),map.get(10),4));

        //connections from Gramercy Park
        map.get(7).destinations.
        add(new Pathway(NamedColor.GREEN,map.get(7),map.get(4),3));

        if (numPlayers>2){ // if there are less than 3 players,
            //don't add the double route
            map.get(7).destinations.
            add(new Pathway(NamedColor.BLUE,map.get(7),map.get(5),1));
        }

        map.get(7).destinations.
        add(new Pathway(NamedColor.RED,map.get(7),map.get(5),1));

        map.get(7).destinations.
        add(new Pathway(NamedColor.ORANGE,map.get(7),map.get(6),2));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(7).destinations.
            add(new Pathway(NamedColor.BLACK,map.get(7),map.get(8),2));
        }

        map.get(7).destinations.
        add(new Pathway(NamedColor.PINK,map.get(7),map.get(8),2));
        map.get(7).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(7),map.get(9),2));

        //connections from Greenwich Village

        map.get(8).destinations.
        add(new Pathway(NamedColor.GREEN,map.get(8),map.get(6),3));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(8).destinations.
            add(new Pathway(NamedColor.RED,map.get(8),map.get(6),3));
        }

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(8).destinations.
            add(new Pathway(NamedColor.BLACK,map.get(8),map.get(7),2));
        }

        map.get(8).destinations.
        add(new Pathway(NamedColor.PINK,map.get(8),map.get(7),2));

        map.get(8).destinations.
        add(new Pathway(NamedColor.BLUE,map.get(8),map.get(9),2));
        map.get(8).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(8),map.get(11),2));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(8).destinations.
            add(new Pathway(NamedColor.RAINBOW,map.get(8),map.get(12),2));
        }

        map.get(8).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(8),map.get(12),2));

        map.get(8).destinations.
        add(new Pathway(NamedColor.ORANGE,map.get(8),map.get(10),2));

        //connections from East Village
        map.get(9).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(9),map.get(7),2));
        map.get(9).destinations.
        add(new Pathway(NamedColor.BLACK,map.get(9),map.get(11),1));
        map.get(9).destinations.
        add(new Pathway(NamedColor.BLUE,map.get(9),map.get(8),2));

        //connections from Soho
        map.get(10).destinations.
        add(new Pathway(NamedColor.PINK,map.get(10),map.get(6),4));
        map.get(10).destinations.
        add(new Pathway(NamedColor.ORANGE,map.get(10),map.get(8),2));
        map.get(10).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(10),map.get(13),2));

        //connections from Lower East Side
        map.get(11).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(11),map.get(9),2));
        map.get(11).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(11),map.get(14),3));
        map.get(11).destinations.
        add(new Pathway(NamedColor.BLUE,map.get(11),map.get(12),1));
        map.get(11).destinations.
        add(new Pathway(NamedColor.BLACK,map.get(11),map.get(9),1));

        //connections from Chinatown
        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(12).destinations.
            add(new Pathway(NamedColor.RAINBOW,map.get(12),map.get(8),2));
        }

        map.get(12).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(12),map.get(8),2));

        map.get(12).destinations.
        add(new Pathway(NamedColor.BLUE,map.get(12),map.get(11),1));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(12).destinations.
            add(new Pathway(NamedColor.GREEN,map.get(12),map.get(13),1));
        }

        map.get(12).destinations.
        add(new Pathway(NamedColor.PINK,map.get(12),map.get(13),1));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(12).destinations.
            add(new Pathway(NamedColor.RED,map.get(12),map.get(14),3));
        }

        map.get(12).destinations.
        add(new Pathway(NamedColor.ORANGE,map.get(12),map.get(14),3));

        //connections from Wall Street
        map.get(13).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(13),map.get(10),2));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(13).destinations.
            add(new Pathway(NamedColor.GREEN,map.get(13),map.get(12),1));
        }

        map.get(13).destinations.
        add(new Pathway(NamedColor.PINK,map.get(13),map.get(12),1));

        map.get(13).destinations.
        add(new Pathway(NamedColor.BLUE,map.get(13),map.get(14),3));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(13).destinations.
            add(new Pathway(NamedColor.BLACK,map.get(13),map.get(14),3));
        }

        //connections from Brooklyn
        map.get(14).destinations.
        add(new Pathway(NamedColor.BLUE,map.get(14),map.get(13),3));

        if (numPlayers>2){ // if there are less than 3 players, 
            //don't add the double route
            map.get(14).destinations.
            add(new Pathway(NamedColor.BLACK,map.get(14),map.get(13),3));
        }

        if (numPlayers>2){ // if there are less than 3 players,
            // don't add the double route
            map.get(14).destinations.
            add(new Pathway(NamedColor.RED,map.get(14),map.get(12),3));
        }

        map.get(14).destinations.
        add(new Pathway(NamedColor.ORANGE,map.get(14),map.get(12),3));

        map.get(14).destinations.
        add(new Pathway(NamedColor.RAINBOW,map.get(14),map.get(11),3));

        initializeAllCards();
        ////////////////////////////////////////////////////////////////////////////////
    }

    /**
     * Gets the total of Destination tickets for the players score.
     */
    public int scoreDestTickets(Player p){
        int total = 0;
        for(DestTickCard d: p.myDestCards){
            if(checkDestCard(d,p)){
                total+=d.value;
            }
            else{
                total-=d.value;
            }
        }
        return total;
    }

    /**
     * Gets the pathway so the player can see the routes.
     */
    public String getPathway(int startL, int endL){
        ArrayList<Pathway> availablePaths = new ArrayList<Pathway>();
        for (Node node: map){
            for (Pathway path: node.destinations){
                if (path.start.equals(startL)&&path.end.equals(endL)){
                    return path.toString();
                }
            }

        }
        return "";
    }

    /**
     * Shows the players what routes are available during their turn.
     */
    public void displayPathsAvailable(){
        ArrayList<Pathway> availablePaths = new ArrayList<Pathway>();
        for (Node node: map){
            for (Pathway path: node.destinations){
                if (!contains(availablePaths, path)){
                    availablePaths.add(path);
                }
            }

        }

        System.out.println();
        System.out.print("Pathways available (Duplicates will show: Chelsea "); 
        System.out.println(" to Soho is the same as Soho to Chelsea)");
        for (Pathway p: availablePaths){
            System.out.println(p);
        }
    }

    /**
     * Tells the player if a route is taken or not.
     */
    public boolean contains(ArrayList<Pathway> paths, Pathway p){
        for (Pathway ps: paths){
            if (ps.equals(p)){
                return true;
            }
        }
        return false;
    }

    /**
     * Takes a destination card and a player and checks to see if
     * the two nodes on the card can be a claimed path. 
     */
    public boolean checkDestCard(DestTickCard d,Player p){
        Pathway start= null;
        Node end = null;
        for(Pathway k:p.takenPaths){
            if(d.a.equals(k.start)){
                start = k;
                break;
            }
        }
        if (start == null){return false;}

        for(Pathway k:p.takenPaths){
            if(d.a.equals(k.end)){
                end = k.end;
                break;
            }
        }
        if (end == null){return false;}

        boolean connection = checkConnection(p,start,end,
                new ArrayList<Pathway>());

        return connection;
    }

    /**
     * Method that will make sure that a path and node can 
     * connect.
     */
    public boolean checkConnection(Player p,Pathway start,Node end,
    ArrayList<Pathway> arr){
        ArrayList<Pathway> copy = new ArrayList<Pathway>(arr);
        if(start.end.equals(end)){return true;}
        ArrayList<Pathway> temp = new ArrayList<Pathway>();

        for(Pathway m:p.takenPaths){
            if(m.start.equals(start.end)){
                //finds all the paths that come from current path
                boolean b = true;
                for(Pathway g:copy){
                    if(m.end.equals(g.start)){
                        b = false;
                    }
                }
                if(b){
                    temp.add(m);
                }

            }
        }

        boolean result = false;

        for(Pathway j:temp){
            result = result || checkConnection(p,j,end,copy);
        }
        return result;
    }

    /**
     * Method used to claim a route for a given player
     * //NEEDS MORE TESTING
     * @param p Player who is claiming route
     * @param locationStart Number of the starting location
     * @param locationEnd Number of the end location
     * @return false if the user tried to do something they could not
     */
    public boolean claimRoute(Player p, int locationStart,int locationEnd){

        Scanner scan = new Scanner(System.in);
        ArrayList<TransportationCard> inputCards = new ArrayList<TransportationCard>();
        boolean validInt = false;
        int length =-1;
        while (!validInt){

            validInt = true; //assume true because of logic of try catch
            try {
                System.out.print("How many cards are you using to claim a route?");
                length = scan.nextInt();
                //valid
            } catch (java.util.InputMismatchException e){
                scan.next();
                System.out.println("Please enter an integer.");
                validInt=false;
            }
        } 
        validInt = false;

        int numColor = 0;
        int count =0;
        int count1 =0;
        int numRainbow =0;
        NamedColor c = NamedColor.RAINBOW; 
        //just set to rainbow to instantiate
        //if (length
        if (p.tokens<length) {

            System.out.print("Sorry, you don't have enough taxis"); 
            System.out.println(" to claim the route");
            return false;
        }

        //see if user is using any rainbow cards
        do {
            do {
                while (!validInt){
                    try{
                        System.out.print("How many rainbow cards are you");
                        System.out.println(" using to claim a route?");
                        numRainbow = scan.nextInt();
                        validInt =true;
                    }catch (java.util.InputMismatchException e){
                        scan.next();
                        System.out.println("Please enter an integer.");
                        validInt=false;
                    }
                }
                validInt = false;
                count = 0;

                for (int i =0; i < p.hand.size();i++){
                    if (count == numRainbow) 
                        break; //exit loop once proper amount of taxi cards
                    //were selected
                    //check here to see if the current card is 
                    //the color we are looking for,
                    //if it is, remove it from the player 
                    //and add it to the cards to check
                    if (p.hand.get(i).color.equals(NamedColor.RAINBOW)){
                        count++;
                        TransportationCard temp = p.hand.get(i);
                        inputCards.add(temp);
                    }           
                }
                if (count!=numRainbow){
                    System.out.println("You do not have " + numRainbow
                        + " rainbow cards.");

                }
            } while (count!=numRainbow);

            boolean isValidColor=false;

            String color; 
            //ask user what color they are using if they are using any
            if (count!=length){
                do {
                    System.out.print("What color cards are you using?");
                    color = scan.next();
                    //blue, green, black, pink, red, orange
                    if (color.equalsIgnoreCase("red")){
                        c = NamedColor.RED;
                        isValidColor=true;
                    }
                    else if (color.equalsIgnoreCase("blue")){
                        c = NamedColor.BLUE;
                        isValidColor=true;
                    }
                    else if (color.equalsIgnoreCase("green")){
                        c = NamedColor.GREEN;
                        isValidColor=true;
                    }
                    else if (color.equalsIgnoreCase("orange")){
                        c = NamedColor.ORANGE;
                        isValidColor=true;
                    }
                    else if (color.equalsIgnoreCase("black")){
                        c = NamedColor.BLACK;
                        isValidColor=true;
                    }
                    else if (color.equalsIgnoreCase("pink")){
                        c = NamedColor.PINK;
                        isValidColor=true;
                    }
                    else{
                        System.out.println("Invalid color");
                    }
                }
                while (!isValidColor);

                //prompt user for how many colored cards they will be using
                do{
                    validInt = false;

                    count1 = 0;
                    while (!validInt){
                        try{
                            System.out.print("How many " + color 
                                + " cards are you using to claim a route?");
                            numColor = scan.nextInt();
                            validInt =true;
                        }catch (java.util.InputMismatchException e){
                            scan.next();
                            System.out.println("Please enter an integer.");
                            validInt=false;
                        }
                    }

                    for (int i =0; i < p.hand.size();i++){
                        if (count1 == numColor)
                            break; //exit loop once proper amount of colored cards
                        //were selected
                        //check here to see if the current card 
                        //is the color we are looking for,
                        //if it is, remove it from the player and 
                        //add it to the cards to check
                        if (p.hand.get(i).color.equals(c)){ 
                            count1++;
                            TransportationCard temp = p.hand.get(i);
                            inputCards.add(temp);
                        }           
                    }
                    if (count1!=numColor){ 
                        //if they don't have the proper number of color cards
                        System.out.println("You do not have " + numColor + " " 
                            + color + " cards.");
                    }
                } while(count1!=numColor);
            }

            //if the player did not select the proper amount of taxis 
            //and colored cards
            //or they don't have the amount that they asked to select
            //tell them they did not select the correct 
            //amount of cards and move to the next turn
            if (count + count1 != length){
                System.out.println("You did not choose " + length 
                    + " valid cards.");
                System.out.print("Type 'other' to do something else this turn, ");
                System.out.print("or literally anything else ");
                System.out.print("to try a different set of cards.");
                if (scan.next().equalsIgnoreCase("other")){
                    return false;                    
                }
            }
        } while (count + count1 != length);

        if(!checkPathwayAvailability(p,inputCards, locationStart, locationEnd)){
            //give the player their cards back
            p.hand.addAll(inputCards);
            System.out.println("Something went wrong with your selection.");
            System.out.print("Please try again. Make sure you enter the ");
            System.out.println("correct info! ");
            return false;
        }

        //otherwise you can claim the path, discard the transcards, 
        //and we are done

        //remove all the rainbow cards from the deck
        for (int i =0; i < numRainbow;i++){
            for (TransportationCard card: p.hand){
                if (card.color.equals(NamedColor.RAINBOW)){
                    TransportationCard temp = p.hand.remove(p.hand.indexOf(card));
                    transDeck.discards.add(temp);
                    break;
                }
            }
        }

        return true;
    }

    /**
     * Checks to see if a list of cards is all rainbow
     * @return true if the list is indeed all cyan. Else false
     */
    public boolean allRainbow(ArrayList<TransportationCard> list){
        for (TransportationCard c: list){
            if (!c.color.equals(NamedColor.RAINBOW)){
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the first color that is not a cyan, 
     * if all rainbow, then returns rainbow
     */
    public NamedColor findFirstColor(ArrayList<TransportationCard> list){
        for (TransportationCard c: list){
            if (!c.color.equals(NamedColor.RAINBOW)){
                return c.color;
            }            
        }
        return NamedColor.RAINBOW;
    }

    /**
     * Check to see if a pathway is available to claim
     * @param turn The player who's turn it is
     * @param inputCards The cards used to attempt a claim
     * @param locationStart the identity number for the start location
     * @param locationEnd the identity number the for the end location
     * 
     */
    public boolean checkPathwayAvailability(Player turn,
    ArrayList<TransportationCard> inputCards,
    int locationStart,int locationEnd){

        //inputCards is the cards picked
        //locationStart and Locationend correspond to the int 
        //value of city nodes
        NamedColor c = inputCards.get(0).color;
        if (c.equals(NamedColor.RAINBOW)){
            c = findFirstColor(inputCards);
        }

        //need checks for rainbow cards (should be done in loop below)
        boolean allTaxi = false;
        //if not a taxi and not the color
        if(!allRainbow(inputCards)){
            for(TransportationCard t:inputCards){
                if(!t.color.equals(NamedColor.RAINBOW) && !c.
                equals(t.color)){ 
                    System.out.println("Cards picked have the wrong color.");
                    return false;
                }
                if (!t.color.equals(NamedColor.RAINBOW)){
                    c = t.color;
                }
            }
        }

        else {
            allTaxi=true;
        }
        //loop before checks to see if all the colors of the 
        //inputted cards are the same
        Node endNode = map.get(locationEnd);
        int length = inputCards.size();
        Node start = map.get(locationStart);
        for(Pathway p:start.destinations){
            //these if statements are complicated because they need to
            //account
            //for there being two pathways with NamedColor.RAINBOW color
            //and same length with different end nodes

            if((p.color.equals(c) || p.color.equals(NamedColor.RAINBOW)
                ||allTaxi) 
                //same color as cards, or grey route, or all taxi card so
                //who cares about the color of the route
            && (p.length == length)){
                if(p.end.name.equals(endNode.name)){
                    if (turn.ownsPath(p)){
                        System.out.print("You already own the other ");
                        System.out.print("side of this path ");
                        System.out.println("so you cannot claim this side.");
                    }

                    System.out.println
                    ("Path claimed from "+start.name+" to "+endNode.name 
                        + " of color " + p.color);
                    turn.takenPaths.add(p);
                    turn.tokens = turn.tokens - p.length;
                    //two paths are added to the players list one from
                    //(a to b) and one from (b to a)
                    //this will make traversal easier later
                    start.destinations.remove(p);
                    for (Iterator<Pathway> it = endNode.destinations.
                        iterator();
                    it.hasNext();){
                        Pathway path = it.next();
                        if((path.color.equals(c) || path.color.equals
                            (NamedColor.RAINBOW)) 
                        && (path.length == length)){
                            if(path.end.name.equals(start.name)){
                                //turn.takenPaths.add(p);
                                it.remove();
                            }
                        }
                    }
                    return true;
                }
            }
        }
        System.out.println("Path does not exist or has been taken.");
        return false;
        //method must remove not only the pathway from the start node list
        //but also the reverse pathway coming from the end node
    }

    /**
     * This lets a player choose cards from the deck  
     * should reveal two cards from top of deck
     * user can add both, and must add 1
     * returned cards are placed at bottom of deck
     * This is a text version for now, gui update later
     * //TESTED AND WORKS
     * @param p Player that will be drawing cards
     */
    public void drawDestCards(Player p){
        //draw the two cards from the top 
        DestTickCard card1 = (DestTickCard)destDeck.draw();
        if (destDeck.cards.size()==1 && destDeck.discards.isEmpty()){
            System.out.print("There is only one card left, ");
            System.out.println(" you must draw it.");
            // player has to draw a card if only one left
            p.myDestCards.add(card1); 
            System.out.println("You added a " + card1);
            return;
        }
        boolean validAnswer = true;
        DestTickCard card2 = (DestTickCard)destDeck.draw();

        //reveal the two cards 
        do {
            System.out.print(p.name +" you drew a " + card1 + "\n");
            System.out.println( " and a " + card2);
            System.out.print("Would you like to keep both? ");
            System.out.print(" (Enter 'yes' or 'no') ");
            Scanner scan = new Scanner(System.in);
            String answer ="";
            answer = scan.next();
            if(answer.equalsIgnoreCase("yes")){ //user keeps both cards
                p.myDestCards.add(card1);
                p.myDestCards.add(card2);
                System.out.print("You added a " + card1 + "\nand ");
                System.out.println(" a " + card2);
                return;
            }

            else if (answer.equalsIgnoreCase("no")){
                System.out.print("You must keep at least 1, which ");
                System.out.print("one would you like to keep?");

                do { //
                    System.out.print("(Enter '1' to take the first card, ");
                    System.out.println(" '2' to take the second)");
                    answer ="";                
                    answer = scan.next();
                    //user keeps the first card
                    if (answer.equalsIgnoreCase("1")){ 
                        p.myDestCards.add(card1);
                        System.out.println("You added a " + card1);
                        //add other card back to bottom of deck
                        destDeck.cards.add(0,card2);
                        return;
                    }
                    //user keeps the second card
                    else if (answer.equalsIgnoreCase("2")){ 
                        p.myDestCards.add(card2);
                        System.out.println("You added a " + card2);
                        //add other card back to bottom of deck
                        destDeck.cards.add(0,card1); 
                        return;
                    }
                    else {
                        System.out.println("invalid input");
                        validAnswer = false;
                    }
                }
                while (!validAnswer);
            } 
            else{
                System.out.println("invalid input");
                validAnswer = false;
            }
        } while (!validAnswer);
    } 

    /**
     * Checks the end condition for the game, a player has two or
     * fewer taxis
     * @return true if the game should end, else false
     */
    public boolean checkEndCondition(Player p){
        if (p.tokens<=2) return true;
        return false;
    }

    /**
     * Once the end game condition is triggered each player will get
     * one last turn
     * param player number, the number of the player who's turn it is 
     * By the way, if you are actually reading this, Endgame was awesome!
     * Favorite part Thor ("I aimed for the head this time")
     */
    public void endGame(int playerNumber){
        Player p = players.get(playerNumber);
        int i = playerNumber;
        int numPlayers = players.size();
        Scanner scan = new Scanner(System.in);
        boolean validInt =false;
        int start =0;
        int end = 0;
        int turns =0;
        while (turns <numPlayers){
            System.out.println();
            System.out.print("It is " + p.name + "'s turn. " + p.name);
            System.out.println(" has " + p.tokens + " taxi's left.");
            System.out.println(p.name + " has " + p.score + " points.");
            p.displayCardsAndRoutes();
            boolean validChoice = false;
            while(!validChoice){
                System.out.println();
                System.out.println("It is " + p.name + "'s turn. " + p.name);
                System.out.println(" has " + p.tokens + " taxi's left.");
                System.out.println(p.name + " has " + p.score + " points.");
                p.displayCardsAndRoutes();
                validChoice = false;

                while(!validChoice){
                    System.out.println("Would you like to draw transcards, ");
                    System.out.println(" dest ticket cards, or ");
                    System.out.println(" claim a route?");
                    System.out.print("Enter claim, drawDest, or drawTrans");
                    String decision = scan.next();
                    if (decision.equalsIgnoreCase("claim")){
                        System.out.print("Would you like to see routes ");
                        System.out.print(" available? (Enter 'yes' for yes ");
                        System.out.println(" or literally any else for no)");
                        decision = scan.next();
                        if (decision.equalsIgnoreCase("yes")){
                            displayPathsAvailable();
                        }
                        System.out.print("Would you like to see cards ");
                        System.out.print(" again? (Enter 'yes' for yes ");
                        System.out.println(" or literally any else for no)");
                        decision = scan.next();
                        if (decision.equalsIgnoreCase("yes")){
                            p.displayCardsAndRoutes();
                        }                         
                        System.out.print("What is the number of the start ");
                        System.out.println(" of the route you want to claim?"); 
                        boolean inRange = false;
                        while  (!validInt || !inRange){
                            validInt = false;
                            inRange = false;
                            try{
                                System.out.print("Enter the number/ID for ");
                                System.out.print(" the start of the ");
                                System.out.print(" route (0-14)");
                                start = scan.nextInt();
                                validInt=true;
                            } catch (java.util.InputMismatchException e){
                                scan.next();
                                System.out.print("Please enter ");
                                System.out.println(" an integer.");
                                validInt=false;
                            }

                            if (start<0 || start>14){
                                System.out.print("Number "+ start);
                                System.out.println(" is not in range.");
                            }
                            else {
                                inRange = true;
                            }
                        }
                        validInt=false;
                        inRange = false;
                        System.out.print("What is the number/ID ");
                        System.out.print("of the end of the");
                        System.out.println(" route you want to claim?");                        
                        while (!validInt || !inRange){
                            validInt = false;
                            inRange = false;
                            try{
                                System.out.print("Enter the ID for the");
                                System.out.println(" end of the route");
                                end = scan.nextInt();
                                validInt=true;

                            } catch (java.util.InputMismatchException e){
                                scan.next();
                                System.out.print("Please enter");
                                System.out.println(" an integer.");
                                validInt=false;
                            }

                            if (end<0 || end>14){
                                System.out.println("Number "+ end);
                                System.out.println(" is not in range.");
                            }
                            else {
                                inRange = true;
                            }
                        }

                        if(claimRoute(p,start,end)){
                            validChoice = true;
                        }

                    }
                    else if (decision.equalsIgnoreCase("drawDest")){
                        drawDestCards(p);
                        validChoice = true;
                    }
                    //draw trans cards
                    else if (decision.equalsIgnoreCase("drawTrans")){ 
                        drawTransCard(p);
                        validChoice = true;
                    }
                    else {
                        System.out.println("That is not a valid decision");
                    }
                }
                p.updateScore();
                if (i == players.size()-1){
                    i = 0;
                    // if this is the last player, go back to the first player
                    p = this.players.get(i); 
                }
                else {
                    i++;
                    p = this.players.get(i);
                }   

                turns++;
            }
            System.out.println("The game is over!");
            printFinalScores();
            winner();

        }
    }

    /**
     * prints players final scores
     * 
     */
    public void printFinalScores(){
        for (Player p: players){
            p.updateScore();
            int destTickScore = scoreDestTickets(p);
            System.out.print("Final score for " + p.name + ": " );
            System.out.println((p.score + destTickScore));
            p.score = p.score + destTickScore;
        }
    }

    /**
     * Calculates the winner of the game (whoever has the highest amount
     * of points)
     * If there is a tie, check to see who completed most dest ticketcards
     * 
     */
    public void winner(){
        ArrayList<Player> winners = new ArrayList<Player>();
        int max = -111111;
        for (Player p: players){
            if (p.finalScore>max){
                max = p.finalScore;
                winners.add(p);
            }
        }

        for (Player p: winners){
            if (p.finalScore<max){
                winners.remove(p);
            }
        }
        int count =0;
        for (Player p: winners){
            if (count>0){
                System.out.println(p.name + " also won with ");
                System.out.println( p.finalScore + " points.");
            }
            System.out.println(p.name +"won with ");
            System.out.println(p.finalScore + " points.");
        }
    }

    /**
     * This is if the player chooses to draw transcards during their turn
     * Tested and works!
     * @param p Player that is drawing the transportation card
     * 
     */
    public void drawTransCard(Player p){
        Scanner scan = new Scanner(System.in);
        System.out.println("This is your first draw."); 

        boolean validChoice = false;
        String choice = "";

        while (!validChoice){
            System.out.print("Would you like to draw from the deck");
            System.out.print(" or the face up cards? ");
            System.out.print(" (Enter 'deck' or 'face ups')");
            choice = scan.nextLine();
            //draw a card from the top of the deck
            if (choice.equalsIgnoreCase("deck")){ 
                TransportationCard card1 = drawFromDeck(p);
                p.hand.add(card1);
                System.out.println("You added a " + card1);
                validChoice = true;
            }
            //draw a card from the face up cards
            else if (choice.equalsIgnoreCase("face ups")){ 
                TransportationCard card1 = drawFromFaceUp(p,false);

                p.hand.add(card1);
                System.out.println("You added a " + card1);
                validChoice = true;
                if (card1.color.equals(NamedColor.RAINBOW)){
                    //if player draws a taxi, they can't draw another card
                    System.out.println("You added a taxi, so you cannot ");
                    System.out.println(" draw anymore cards this turn");
                    return;
                }
            }
            else {
                System.out.print("Invalid input. ");
            }

        }
        validChoice = false;
        System.out.println("This is your second draw."); 

        while(!validChoice){
            System.out.print("Would you like to draw from the deck ");
            System.out.print(" or the face up cards? ");
            System.out.print("(Enter 'deck' or 'face Ups')");
            choice = scan.nextLine();
            if (choice.equalsIgnoreCase("deck")){
                TransportationCard card2 = drawFromDeck(p);
                p.hand.add(card2);
                System.out.println("You added a " + card2);
                validChoice = true;
                return;
            }
            else if(choice.equalsIgnoreCase("face ups")) {
                TransportationCard card2 = drawFromFaceUp(p,true);
                p.hand.add(card2);
                System.out.println("You added a " + card2);
                validChoice = true;
                return;
            }
            else {
                System.out.print("Invalid input. ");
            }

        }

    }

    /**
     * Provides new faceUp cards for the faceUp deck
     * Will only ever be called if stupidTaxiCondition returns true
     */
    public void newFaceUps(){

        transDeck.discards.addAll(faceUps); //add all transcard 
        //that were face up 
        // to the dicscard pile
        faceUps.clear(); //clear out the faceup cards
        boolean isValidDeck = true;

        for (int i = 0; i <5;i++){
            faceUps.add((TransportationCard)transDeck.draw()); 
            //draw 5 new cards from deck
        }
    }

    /**
     * Checks to see if there is three or more taxi cards in the faceUp Deck
     * If there is, then the cards need to be discarded 
     * into the the discard pile
     * I named it stupidTaxiCondition because it is an antiquated rule
     * @return true if condition is fullfilled, else false
     */    
    public boolean stupidTaxiCondition(){
        int count = 0;
        for (TransportationCard card: faceUps){
            if (card.color.equals(NamedColor.RAINBOW)){
                count++;
            }            
        }
        if (count>=3) return true;
        return false;
    }

    /**
     * This lets a player draw cards from the deck, 
     * just draws from the top of the deck
     * Tested and works!
     * @param p Player that is drawing the card
     */
    public TransportationCard drawFromDeck(Player p){
        return (TransportationCard)transDeck.draw();
    }

    /**
     * This lets a player choose cards from the face up cards 
     * tested and works
     * @param p Player that is drawing the card
     */
    public TransportationCard drawFromFaceUp(Player p, boolean secondDraw){
        boolean isTaxi = false;
        int i =0;
        boolean isValidInt = false;
        TransportationCard card = null; //just instantiating outside loop
        do {
            Scanner scan = new Scanner(System.in);

            printFaceUps();
            while (!isValidInt){
                try {
                    System.out.print("Choose which card you would ");
                    System.out.print("like to draw (range 0 - 4)");
                    i = scan.nextInt();
                    isValidInt = true;
                }catch (java.util.InputMismatchException e){
                    scan.next();
                    isValidInt = false;
                    System.out.println("Invalid input. Not an integer");
                }

                if (i>4||i<0){

                    System.out.print("Invalid input. " + i 
                        + " is not in range");
                    isValidInt = false;
                }
            }

            //if (stupidTaxiCondition()) newFaceUps(); 
            // this take care of the instance
            //where there is an invalid FaceUps deck
            card = faceUps.get(i);
            isTaxi = false;

            if (!card.color.equals(NamedColor.RAINBOW)&&!secondDraw){ 
                //first turn, not a taxi
                isTaxi = false;
                card = faceUps.remove(i);   
                faceUps.add((TransportationCard)transDeck.draw());
            }
            else if (!secondDraw || !card.color.equals(NamedColor.RAINBOW)){
                card = faceUps.remove(i);   
                faceUps.add((TransportationCard)transDeck.draw());
            }
            else {
                isTaxi=true;
                System.out.print("You can't pick a taxi as ");
                System.out.println("your second card");

            }
        } while(isTaxi && secondDraw);       
        return card;
    }

    public void printFaceUps(){
        System.out.println("The face Up cards are: ");
        int count =0;
        for (TransportationCard c: faceUps){
            if (count==4){
                System.out.println(c + "(" +count + ") "); 
            }
            else {System.out.print(c + "(" +count + "), "); 
            }
            count++;
        }

    }
    ////////////////////////////////////////////////////////////////////////////////
    /**
     * Simply a method to initialize all the cards for the game
     * Makes the appropriate amount of each card
     */
    public void initializeAllCards(){
        //Rainbow Cards, color is NamedColor.RAINBOW
        String color = "RAINBOW";
        for(int i =0;i<=7;i++){
            TransportationCard c =
                new TransportationCard(NamedColor.RAINBOW,"./TRANSCARDS/"+color
                    +".jpg");
            transDeck.discard(c);
        }
        color = "BLACK";
        for(int i =0;i<=5;i++){
            TransportationCard c = 
                new TransportationCard(NamedColor.BLACK,"./TRANSCARDS/"
                    +color+".jpg");
            transDeck.discard(c);
        }
        color = "BLUE";
        for(int i =0;i<=5;i++){
            TransportationCard c = 
                new TransportationCard(NamedColor.BLUE,"./TRANSCARDS/"
                    +color+".jpg");
            transDeck.discard(c);
        }
        color = "GREEN";
        for(int i =0;i<=5;i++){
            TransportationCard c = new 
                TransportationCard(NamedColor.GREEN,"./TRANSCARDS/"
                    +color+".jpg");
            transDeck.discard(c);
        }
        color = "ORANGE";
        for(int i =0;i<=5;i++){
            TransportationCard c = new 
                TransportationCard(NamedColor.ORANGE,"./TRANSCARDS/"
                    +color+".jpg");
            transDeck.discard(c);
        }
        color = "PINK";
        for(int i =0;i<=5;i++){
            TransportationCard c = new 
                TransportationCard(NamedColor.PINK,"./TRANSCARDS/"
                    +color+".jpg");
            transDeck.discard(c);
        }
        color = "RED";
        for(int i =0;i<=5;i++){
            TransportationCard c = new 
                TransportationCard(NamedColor.RED,"./TRANSCARDS/"
                    +color+".jpg");
            transDeck.discard(c);
        }
        transDeck.shuffleWithDiscards();

        DestTickCard c = new DestTickCard(map.get(2),
                map.get(4),3,"./DESTCARDS/0.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(13),map.get(11),2,"./DESTCARDS/1.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(0),map.get(5),3,"./DESTCARDS/2.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(5),map.get(8),3,"./DESTCARDS/3.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(2),map.get(1),3,"./DESTCARDS/4.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(7),map.get(12),4,"./DESTCARDS/5.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(1),map.get(7),4,"./DESTCARDS/6.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(10),map.get(9),4,"./DESTCARDS/7.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(9),map.get(3),4,"./DESTCARDS/8.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(6),map.get(1),5,"./DESTCARDS/9.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(6),map.get(13),6,"./DESTCARDS/10.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(10),map.get(3),6,"./DESTCARDS/11.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(8),map.get(0),6,"./DESTCARDS/12.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(5),map.get(14),7,"./DESTCARDS/13.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(1),map.get(12),8,"./DESTCARDS/14.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(14),map.get(6),8,"./DESTCARDS/15.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(14),map.get(3),8,"./DESTCARDS/16.jpg");
        destDeck.discard(c);
        c = new DestTickCard(map.get(13),map.get(4),8,"./DESTCARDS/17.jpg");
        destDeck.discard(c);

        destDeck.shuffleWithDiscards(); //all cards are in the discard pile

        for (int i =0; i <5; i++){ // make 5 cards faceUp
            faceUps.add((TransportationCard)transDeck.draw());

        }
        if (stupidTaxiCondition()) newFaceUps(); // this take care 
        //of the instance

    }
    ////////////////////////////////////////////////////////////////////////////////
    /**
     * Method that will deal the starting hand for each player. 
     */
    public void dealingStartingHand(){
        //deals 5 trans cards to each player
        for(int i=0; i<players.size(); i++){
            //deals 5 trans cards to each player
            for(int j=0; j<2;j++){
                Player p = players.get(i);
                p.hand.add((TransportationCard)transDeck.draw());
            }
            //deals 2 dest cards to each player
            drawDestCards(players.get(i));
            System.out.println();
        }
    }

    /**
     * Checks to see if the arrayList of Named Color in colorInGame contains 
     * a particular named color
     * @return true if condition is true, else false
     */
    public boolean contains(NamedColor col){
        for (NamedColor colors: colorsInGame){
            if (colors.equals(col)){
                return true;

            }            
        }
        return false;
    }

    public  boolean containsName(String thisname){
        for (Player p: this.players){
            if (p.name.equalsIgnoreCase(thisname)) return true;
        }
        return false;
    }

    /**
     * Method that starts the game
     * So far is implemented so users can enter their name, color, 
     * and they get their cards
     */
    public static void startgame(){

        boolean validInt = false;
        System.out.print("Open daMap.jpg to see the IDs ");
        System.out.println("for each destination");
        System.out.println("The game has started");
        System.out.print("Make sure you enter the ");
        System.out.println("correct info as you play! ");
        int numPlayers =0;
        Scanner scan = new Scanner(System.in);
        while (numPlayers<2 || numPlayers > 5 || !validInt){
            System.out.print("How many players are playing? (2-5)");
            try{
                numPlayers = scan.nextInt();
                validInt=true;
                if ((numPlayers<2 || numPlayers > 5)){
                    System.out.println("invalid number of players");
                }
            } catch (java.util.InputMismatchException e){
                scan.next();
                System.out.println("Please enter an integer.");
                validInt=false;
            }

        }
        ////////////////////////////////////////////////////////////////////////////////
        String userName = "";
        Board theGame = new Board(numPlayers);
        boolean containsN = false;
        for (int i =0; i< numPlayers;i++){
            do{
                System.out.print("Player " + (i+1) + " enter your username: ");
                userName  = scan.next();
                containsN = theGame.containsName(userName);

                if (containsN){
                    System.out.println("Username " + userName + 
                        " has already been taken.");
                }
            }
            while (containsN);
            boolean isValidColor = false;
            NamedColor c = NamedColor.RAINBOW;
            do {
                System.out.println("Colors available: " + 
                    theGame.printColors()); 
                System.out.print("Player " + (i+1) + 
                    " what color would you like to be?");
                String color = scan.next();               
                if (color.equalsIgnoreCase("red")&& 
                theGame.contains(NamedColor.RED)){
                    c = NamedColor.RED;
                    theGame.colorsInGame.remove(c);
                    isValidColor=true;
                }
                else if (color.equalsIgnoreCase("blue")&&
                theGame.contains(NamedColor.BLUE)){
                    c = NamedColor.BLUE;
                    theGame.colorsInGame.remove(c);
                    isValidColor=true;
                }
                else if (color.equalsIgnoreCase("green")&&
                theGame.contains(NamedColor.GREEN)){
                    c = NamedColor.GREEN;
                    theGame.colorsInGame.remove(c);
                    isValidColor=true;
                }
                else if (color.equalsIgnoreCase("black")&&
                theGame.contains(NamedColor.BLACK)){
                    c = NamedColor.BLACK;
                    theGame.colorsInGame.remove(c);
                    isValidColor=true;
                }

                else if (color.equalsIgnoreCase("pink")&&
                theGame.contains(NamedColor.PINK)){
                    c = NamedColor.PINK;
                    theGame.colorsInGame.remove(c);
                    isValidColor=true;
                }
                else if (color.equalsIgnoreCase("orange")&&
                theGame.contains(NamedColor.ORANGE)){
                    c = NamedColor.ORANGE;
                    theGame.colorsInGame.remove(c);
                    isValidColor=true;
                }
                else{
                    System.out.println("Invalid color");
                }
            } while (!isValidColor);

            theGame.players.add(new Player(userName, i+1, c));
        }

        theGame.dealingStartingHand(); 
        //deals the starting hand for each player
        theGame.displayPathsAvailable();

        theGame.playGame();
    }

    /**
     * Prints colors available to player
     * @return colors available
     */
    public String printColors(){
        String temp = "";
        for (NamedColor c: colorsInGame){
            temp = temp + c.toString() + " ";
        }
        return temp;
    }

    /**
     * This is where most of the game is played, 
     * ie turns are taken
     * 
     */
    public void playGame(){
        Player p = this.players.get(0);
        int i =0;
        Scanner scan = new Scanner(System.in);
        int start =0;
        int end = 0;
        boolean validInt = false;

        while(!checkEndCondition(p)){
            System.out.println();
            System.out.println("It is " + p.name + "'s turn. " + p.name + " has " 
                + p.tokens + " taxi's left.");
            System.out.println(p.name + " has " + p.score 
                + " points.");
            p.displayCardsAndRoutes();
            boolean validChoice = false;
            while(!validChoice){
                System.out.print("Would you like to draw transcards,");
                System.out.println(" dest ticket cards, or claim a route?");
                System.out.print("Enter claim, drawDest, or drawTrans");
                String decision = scan.next();
                if (decision.equalsIgnoreCase("claim")){
                    System.out.print("Would you like to see routes available? ");
                    System.out.print("Enter 'yes' for yes or literally any else for no)");
                    decision = scan.next();
                    if (decision.equalsIgnoreCase("yes")){
                        displayPathsAvailable();
                    }
                    System.out.print("Would you like to see your cards again? ");
                    System.out.print("(Enter 'yes' for yes or literally any else for no)");
                    decision = scan.next();
                    if (decision.equalsIgnoreCase("yes")){
                        p.displayCardsAndRoutes();
                    }
                    System.out.print("What is the number of the start of ");
                    System.out.println("the route you want to claim?");
                    boolean inRange = false;
                    while  (!validInt || !inRange){
                        validInt = false;
                        inRange = false;
                        try{
                            System.out.print("Enter the number/ID for"); 
                            System.out.print(" the start of the route (0-14)");
                            start = scan.nextInt();
                            validInt=true;

                        } catch (java.util.InputMismatchException e){
                            scan.next();
                            System.out.println("Please enter an integer.");
                            validInt=false;
                        }

                        if (start<0 || start>14){
                            System.out.println("Number "+ start 
                                + " is not in range.");
                        }
                        else {
                            inRange = true;
                        }
                    }
                    validInt=false;
                    inRange = false;
                    System.out.print("What is the number/ID of the ");
                    System.out.println("end of the route you want to claim?");
                    while (!validInt || !inRange){
                        validInt = false;
                        inRange = false;

                        try{
                            System.out.print("Enter the ID for the end ");
                            System.out.print("of the route");
                            end = scan.nextInt();
                            validInt=true;

                        } catch (java.util.InputMismatchException e){
                            scan.next();
                            System.out.println("Please enter an integer.");
                            validInt=false;
                        }

                        if (end<0 || end>14){
                            System.out.println("Number "+ end 
                                + " is not in range.");
                        }
                        else {
                            inRange = true;
                        }
                    }

                    if(claimRoute(p,start,end)){
                        validChoice = true;
                    }

                }
                else if (decision.equalsIgnoreCase("drawDest")){
                    drawDestCards(p);
                    validChoice = true;
                }
                else if (decision.equalsIgnoreCase("drawTrans")){ 
                    //draw trans cards
                    drawTransCard(p);
                    validChoice = true;
                }
                else {
                    System.out.println("That is not a valid decision");
                }
            }

            p.updateScore();
            if (i == players.size()-1){
                i = 0;
                p = this.players.get(i); 
                // if this is the last player, go back to the first player
            }
            else {
                i++;
                p = this.players.get(i);
            }
        }

        endGame(i);

    }

}

