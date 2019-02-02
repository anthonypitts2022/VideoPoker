Anthony Pitts
UNI: aep2195

                   Video Poker
             
This video poker program simulates a single-player game of poker. An overly simplified explanation is that
the player makes a bet, is dealt 5 cards, asked which ones to give back to the "dealer", given new cards, and that hand
evaluated for the best possible result, of which is multiplied by the original bet.
This program breaks down into 5 classes, and that will create the organization of this readMe. These five 
classes are: PokerTest, Card, Deck, Player, and Game.


              PokerTest
              
This class is a simple class which contains the main method that runs the game. One point of notice is that
there are two different Game constructors which are called, depending on whether there is a command line
argument added into String[] args when calling the PokerTest class. This was used for testing of each manner
of winning the poker hand. More on this will be touched in the Game class.
              
              Card
              
The Card class is used for a few purposes. The first of which is to hold the constructor of the instances (objects) 
of the Card class. The two parameters for each object of Card were suit and rank. Suit was a number varying from 
1-4 (Clubs,Diamonds,Hearts,Spades - respectively) and rank was a number varying from 1-13 (ace, 2-10, jack,queen,king
- respectively). In this class I used two String array instance variables, suitKey and rankKey, whose purposes
were to be used in the toString Method, which took a card's two parameters and translated them into user-understandable
words, such as "two of hearts" from h2. There are also getRank and getSuit methods in this class which are accessor
methods that return the rank and suit parameters of a given card, as an implicit parameter. Lastly, I designed my compareTo
method so that it compared the card given and the one in front of it and if the card in front had a higher rank, it was
swapped with the second card.
              
              Deck
              
The Deck class is a fairly simple class. The class has an instance variable, called deck, which is an array of cards,
which are objects of the Card class. The instance variable, top, is an indexing variable, to keep track of where in
the deck array the computer should pull from, in order to not repeat any cards. In the real world, this would be like
taking from the "top" of the deck. No instance variables were uninstantiated, so the Deck constructor is empty. The 
makeDeck method is used to create all 52 cards in the deck and put them in an array called deck. The outer for loop
keeps track of the suit and the inner for loop keeps track of the rank of the card. The getDeck method is used to 
access the deck variable. The reset top method is used when a new game is started, so that after the deck is shuffled,
the "dealer" will then draw from the top of the deck again, and not from however far the top variable got in the last
game's deck. The shuffle method is used to randomize the order that the cards are selected in. This immplements the 
generation of two random variables, which are stored as rand1 and rand2. Then a classic swap method is used, 1000 times,
which stores the card in the deck at rand1 in temp, places card in deck at rand2 in rand1, and puts temp in deck location
of rand2. The deal method is used to return the card in the deck at the location of the variable "top."
              
              Player
             
The player class uses the instance variable hand, which is an arraylist of objects of class Card. This is quite convient
since the player's hand changes in size, removes, and adds cards often in each round. There is also an instance variable
called bankroll which keeps track of the player's money, for betting purposes. The instance variable bet is used at the 
begining of each round, where the player makes a bet, which will be multiplied by his/her/their winnings at the end of the
round. The Player class constructor is used to instantiate the hand, bankroll, and bet values. The setHand method is used 
to automatically set the player's  hand, instead of drawing cards from the deck, for the version of the game where the
hand is chosen as a command-line argument. The getHand, getBet, and getBankroll methods are accessor methods to hand bet,
and bankroll variables, respectively. The addCard and removeCard methods take a card as an explicit parameter and add/remove
that card from the player's hand, respectively. The bets method is used to take the bet that the player selected and store
it into the instance variable, bet. The sortHand method uses the compareTo method to take the larger of two cards and swap
them so that that card come after the card with the smaller rank. The setBankroll method allows the programmer to set the 
bankroll variable as they please. The resetHand method is used to clear the hand arraylist at the end of each game.


              
              Game
              
The Game class is where the play method and check methods for each possible type of win, takes place. The instance variable
testerHand is the hand used if there was a command-line argument made into the String []args, which outlined the desired
hand. The normalGame instance variable is used to determine whether the game type being played filled args or if a normal
game without it being filled is being played. If true, there was no command-line argument, and vice versa. In this class 
object p of type Player and object d of type Deck are created. The Game constructor with "String[] testHand" as an explicit
parameter initializes the instance variables of the user-hand chosen game. There, testerHand is initialized and normalGame is 
set to false. The String array, suitKey, is used as a reference to compare args to, in order to make the args input viable 
parameters to objects of type Card. The following for loop is used to parse the leading letter and following number into a
suit and a rank, stored as c and argsrank, respectively. The other Game constructor just sets normalGame to true, indicating
the lack of a command line argument into args. 

The play method runs the sequential operations of how the poker game is played. First, the makeDeck and shuffle methods are
called (see deck class for reference). Then the player is welcomed and told their current bankroll. Then the player makes
their bet on the results of the round. If normalGame were false, the hand would be set to the testerHand, which is the 
translated equivilant of args. If normalgame were true, a hand of 5 cards would be dealt to the player and they would be
prompted on which cards to get rid of, one at a time from the right to left. They were prompted from right to left since
it allowed for the indexing of the hand array to stay constant in the first 5 elements, as cards were removed and added to
the array. Then, both versions of the games, have their hand's finalized and the hand is checked for winnings. The check 
methods are explaned in further detail below. Lastly, top and hand is reset, and the user can choose to play another game, 
if they played a normal game, without command-line arguments.

The checkHand method takes the hand as an explicit parameter. This method first sorts the hand and then uses the notYetWon
variable, which starts as true, so that once a method returns true, the notYetWon will be changed to false and it will not 
check anymore possible ways of winnings. This works because the program is ordered from best winnings result to least
winnings result. Also, if on any of the sub-check methods the return value is true, the player's bankroll is updated by adding
their bet multiplied by the winnings of that result, such as 250*bet for royal flush. 

The checkRoyalFlush method calls on the Flush method to see if the suits of the hand are all the same. Then, the if statements 
that follow check to see whether the hand has the specified ranks necessary for a royal flush. The result of all these checks
are stored in boolean variables. A final if statement is used to check whether the result of the Flush method and all the "royalRank"
or boolean checks on the specific ranks are all true, and if so this method returns true. If not, it returns false.

The checkStraightFlush method calls on the Straight method and the Flush method and if they are both true, then it returns true
and if either are false, it returns false.

The checkFourOfAKind method is broken up into three major if statements to consider the three possible ways four of a kind is true.
The first considers if the first and second cards in the hand have the same rank. The second and third consider if the 1st is the same
as the 3rd or if the 2nd is the same as the third. In each of these if statments, one more if / else statment is used to do one more
check to see whether there is enough matches, in terms of cards' ranks, to produce a four of a kind. If fourOfAKind is true it returns
true. If not, it returns false.

The checkFullHouse method intially goes through 3 for loops and 1 if statement in order to check if there is a threeOfAKind and if there
is then three of a kind variable is set to true and the index value for one of the triplets is recorded in threeOfAKindIndex. This
index is then used in the second half of this method to find where the other two elements in the array are stored, which were not 
part of the triplet. These two are compared to each other and if they are the same rank, the arePair variable is set to true. If this and
the threeOfAKind variable are both true, this method returns true, if not it returns false.

The checkFlush method uses two for loops, with one index in front of the other, initially, to check all the pairings of all cards to see
if they all have the same value for suit. If they do, than this method returns true, if not it returns false

The checkStraight method goes through one for statement, so that all the cards in the hand are checked. Each card is sent through 
multiple else if statements that check the basic condition that the rank of the card in front of the last is one digit larger and also
considers ace as high and low. If this were true throughout all iterations, the method would return true, if not it would return false.

The checkThreeOfAKind method has three for loops, one in front of the other, in front of the other, initially. This allows for all
combinations of three cards in the hand to be checked and evaluated for equivilancy in rank. If there is a point where all three
elements in the three loops, at different indicies, are equal, than this method returns true, if not it returns false.

The checkTwoPairs method has two for loops which are used to find a pair. Inside these loops, if a match between ranks of two different
indicies in the hand were found, a variable called pairCounter goes up by one. If throughout these iterations the pairCounter reaches
2, it means that there were two pairs found. If this is true, than the method returns true, if not it returns false.

The checkOnePair method is the same as the checkTwoPairs method, in term of the use of for loops, except it does not involve a 
pairCounter, since once one pair is found, the method returns true. If a pair is never found, the method returns false.

If all the previus check methods returned false, the program will print out "no pair"

              
              
              
              
              
