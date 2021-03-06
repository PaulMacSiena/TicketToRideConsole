# TicketToRideConsole
READ THIS IN RAW VIEW

Ticket to Ride Console. Code Transported from Private Repository. 
Email me at pj16macf@siena.edu if you would like to see the commit history.
A group project for Advanced Programming in the Spring of 2019.

Authors: Paul Macfarlane, Aidan Canavan, Shannon Leary, Marco Rea, Matthew Fletcher
TO START GAME RUN STATIC STARTGAME() METHOD IN BOARD CLASS!

TRY TO FOLLOW DIRECTIONS AS YOU PLAY.

RECOMMEND USING ZOOM!

OPEN UP "Map.jpg" as a guide for claiming routes. 

The Rules: 

Contents of the game:
	* each start with 5 cards and 2 dest ticket 
	* 1 board map (with each of the destinations and paths) 
	* 60 taxis, 15 of each color for each player 
	* 44 transportation cards (8 rainbow/taxis, 6 of all the other colors - blue, green, black, pink, red, orange) 
	* 18 Destination Ticket Cards 
	* 1 rule leaflet
	* 1 score pad 

Object of the Game 
	* Claiming a route between two adjacent locations on the board 
	* Successfully completing a continuous path of routes between the two Locations listed on your 
	* destination ticket(s) -
	* Connecting Tourist attractions 
	* Lose points for each of your dest ticket cards you do not complete by the end 
	

Game Turns 
	* Start with youngest player and proceed clockwise 
	* Everyone plays a turn until the game ends
	* Per turn, you must do one (and only one) of the following three actions 
		* Draw Transportations cards
		* Claim a Route 
		* Draw Destination Ticket Cards 

Drawing Trans Card 
	* 6 colors: blue, green, black, pink, red, orange 
	* also a taxi (which we have as cyan) 
	* taxis can substitute for any other card 
	* Action set: various conditions in drawTransCard(Player p)
		* take any card from one of the 5 face up cards, replace that card with a card from the top of the deck 
			* if you take a face up taxi, you can’t take any more cards during the round 
			* you can not take a face up taxi as a second card either 
		* take the face down from the top of the deck
		
	* if at anytime there are 3 taxis in the face up cards, must discard all 5 cards, and replace them with cards from the deck 
	* when the deck is empty, shuffle the discards to make a new deck 

Claiming a Route: see claimRoute(Player p, int locationStart,int locationEnd) in Board Class
	* A route is a set of spaces of the same color that links two adjacent locations
	* Some locations are connected by Double Routes (two Routes of the same length connecting the same location) 
	* A single player cannot claim both routes of a double route 
	* In two-player games, once one Route of a double route is claimed, the other one cannot be claimed by the other player -
	* To claim a route, you must discard the number of cards from your hand equal to the number of spaces of this route and place a plastic 
	* most routes require a specific set of cards, for example, a blue route must be claimed by discarding blue (or taxi) cards 
	* gray routes can be claimed with any set of cards of one color (with taxis as well of course) 
	* you can claim any route on the board, even it is not connected to a route you previously claimed 
	* you cannot claim more than one route per turn 
	* if you do not have enough plastic taxis left to place one on each space of a given route, you cannot claim that route 

Drawing ticket cards:
	* each ticket card shows two destinations and a point value 
	* at the end of the game you score the point value of each ticket card completed
	* to complete a dest ticket card, you must connect the two locations listed on the card by creating a continuous path of routes you have claimed 
	* if you cannot, you will lose that many points 
	* you can have as many or a few ticket cards as you like  
	* when choosing to “draw ticket cards”, you take two cards from the top of the deck 
	* you must keep at least one, but can keep both 
	* any returned cards are placed at the bottom of the destination ticket card deck
	* you cannot discard a destination ticket card once you have chosen to keep it 
	* if there is only one destination ticket card left in the deck, you can draw, but you must keep the card 
	* ticket cards must be kept secret till the end of the game 

Game end and final scoring:
	* When a player has two or fewer taxis left in their supply, each player, including that player, get one last turn 
	* first each player scores points for each route claimed based on the route scoring table on the board 
		* (1pt for 1 space routes, 2pts for 2 space, 4pts for 3 space, 7pts for 4 space)
	* then each player reveals ticket cards and add the value for ones completed, and subtracts value for ones left incomplete 
	* finally, each player scores one point for each tourist attraction that is connected to one or more of the routes they claimed 
	* the player with the most points wins the game 
	* if there is a tie, the tiebreaker is who had the most completed destination ticket card wins 
	* if there is still a tie, they share the victory
