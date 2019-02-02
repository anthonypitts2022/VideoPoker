//Anthony Pitts

import java.util.Scanner;
import java.util.ArrayList;
public class Game {
	private ArrayList<Card> testerHand;
    boolean normalGame;//for game w/o String args
    Player p = new Player();
    Deck d = new Deck();
    
	public Game(String[] testHand){
        testerHand = new ArrayList<Card>();
        normalGame=false;
        String [] suitKey = {"c", "d", "h", "s"};
        for(int l=0;l<5;l++){
            int argsRank = Integer.parseInt((testHand[l]).substring(1,(testHand[l].length())));
            for(int i=0; i<4;i++){
                if((testHand[l]).substring(0,1).equals(suitKey[i])){
                    int c =i+1;
                    Card newCard = new Card(c, argsRank);
                    testerHand.add(newCard);
                }
            }
        }
	}
	
	public Game(){
       normalGame=true;
	}
	
	public void play(){
        Scanner input = new Scanner(System.in);
        d.makeDeck();
        d.shuffle();
        System.out.println("Welcome to the Video Poker! How many tokens would you like to bet this round(1-5)?");
        System.out.println("You have " + p.getBankroll() + " tokens.");
        p.bets(input.nextInt());
        if(normalGame==false){
            p.setHand(testerHand);
        }
        if(normalGame){
            for(int i=0; i<=4; i++){
                Card card = d.deal();
                p.addCard(card);
            }
            System.out.println("Your hand is: " + p.getHand());
            System.out.println("Would you like to trade in your first card from the RIGHT? (type 0=no or 1=yes)");
            if(input.nextInt()==1){
                p.removeCard(4);
                Card card = d.deal();
                p.addCard(card);
            }
            System.out.println("Would you like to trade in your second card from the RIGHT? (type 0=no or 1=yes)");
            if(input.nextInt()==1){
                p.removeCard(3);
               Card card = d.deal();
                p.addCard(card);
            }
            System.out.println("Would you like to trade in your third card from the RIGHT? (type 0=no or 1=yes)");
            if(input.nextInt()==1){
                p.removeCard(2);
                Card card = d.deal();
                p.addCard(card);
            }
            System.out.println("Would you like to trade in your fourth card from the RIGHT? (type 0=no or 1=yes)");
            if(input.nextInt()==1){
                p.removeCard(1);
                Card card = d.deal();
                p.addCard(card);
            }
            System.out.println("Would you like to trade in your fifth card from the RIGHT? (type 0=no or 1=yes)");
            if(input.nextInt()==1){
                p.removeCard(0);
                Card card = d.deal();
                p.addCard(card);
            }
        }
	for(int l=0; l<p.getHand.length; l++){
		System.out.println(p.getHand().get(l).toString());	
	}
        checkHand(p.getHand());
        d.resetTop();
        p.resetHand();
        if(normalGame){
            System.out.println("Want to Play Again?(type 0 for no or 1 for yes)");
            if(input.nextInt()==1){
                play();
        }
	}
    }
	
	public void checkHand(ArrayList<Card> hand){
        p.sortHand();
        boolean notYetWon=true;
        if(notYetWon){
            if(checkRoyalFlush()){
                p.setBankroll(p.getBankroll() + (250*(p.getBet())));
                System.out.println("Royal Flush!");
                notYetWon=false;
            }
        }
        if(notYetWon){
            if(checkStraightFlush()){
                p.setBankroll(p.getBankroll() + (50*(p.getBet())));
                System.out.println("Straight Flush!");
                notYetWon=false;
            }
        }
        if(notYetWon){
            if(checkFourOfAKind()){
                p.setBankroll(p.getBankroll() + (25*(p.getBet())));
                System.out.println("Four of a kind!");
                notYetWon=false;
            }
        }
        if(notYetWon){
            if(checkFullHouse()){
                p.setBankroll(p.getBankroll() + (6*(p.getBet())));
                System.out.println("Full House!");
                notYetWon=false;
            }
        }
        if(notYetWon){
            if(checkFlush()){
                p.setBankroll(p.getBankroll() + (5*(p.getBet())));
                System.out.println("Flush!");
                notYetWon=false;
            }
        }
        if(notYetWon){
            if(checkStraight()){
                p.setBankroll(p.getBankroll() + (4*(p.getBet())));
                System.out.println("Straight!");
                notYetWon=false;
            }
        }
        if(notYetWon){
            if(checkThreeOfAKind()){
                p.setBankroll(p.getBankroll() + (3*(p.getBet())));
                System.out.println("Three of a kind!");
                notYetWon=false;
            }
        }
        if(notYetWon){
            if(checkTwoPairs()){
                p.setBankroll(p.getBankroll() + (2*(p.getBet())));
                System.out.println("Two Pairs!");
                notYetWon=false;
            }
        }
        if(notYetWon){
            if(checkOnePair()){
                p.setBankroll(p.getBankroll() + (p.getBet()));
                System.out.println("One Pair!");
                notYetWon=false;
            }
        }
        if(notYetWon){
            System.out.println("No pair");
        }
    }
	
	
	public boolean checkRoyalFlush(){
        boolean suitsMatch=false;
        if(checkFlush()){
            suitsMatch=true;
        }
        boolean royalRank1=false;
        boolean royalRank2=false;
        boolean royalRank3=false;
        boolean royalRank4=false;
        boolean royalRank5=false;
        if((p.getHand().get(0).getRank())==1){
            royalRank1=true;
        }
        if((p.getHand().get(1).getRank())==10){
            royalRank2=true;
        }
        if((p.getHand().get(2).getRank())==11){
            royalRank3=true;
        }
        if((p.getHand().get(3).getRank())==12){
            royalRank4=true;
        }
        if((p.getHand().get(4).getRank())==13){
            royalRank5=true;
        }
        if(suitsMatch && royalRank1 &&royalRank2 && royalRank3
           && royalRank4 && royalRank5){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkStraightFlush(){
        if(checkStraight() && checkFlush()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkFourOfAKind(){
        boolean fourOfAKind=false;
        boolean notSameRank = false;
        if((p.getHand().get(0).getRank())==(p.getHand().get(1).getRank())){
            for(int i=1;i<5;i++){
                if((p.getHand().get(0).getRank())==(p.getHand().get(i).getRank())){
                    fourOfAKind=true;
                }
                else{
                    if(notSameRank==true){
                        fourOfAKind=false;
                        i=5;
                    }
                    notSameRank = true;
                }
            }
        }
        else{
            if((p.getHand().get(0).getRank())==(p.getHand().get(2).getRank())){
                for(int i=3;i<5;i++){
                    if((p.getHand().get(0).getRank())==(p.getHand().get(i).getRank())){
                        fourOfAKind=true;
                    }
                    else{
                        fourOfAKind=false;
                        i=5;
                    }
                }
            }
            else if(((p.getHand().get(1).getRank())==(p.getHand().get(2).getRank()))){
                for(int i=3;i<5;i++){
                    if((p.getHand().get(1).getRank())==(p.getHand().get(i).getRank())){
                        fourOfAKind=true;
                    }
                    else{
                        i=5;
                        fourOfAKind=false;
                    }
                }
            }
            else{
                fourOfAKind=false;
            }
        }
        if(fourOfAKind){
            return true;   
            }
        else{
            return false;
        }
    }
    public boolean checkFullHouse(){
        boolean threeOfAKind = false;
        int duplicateCounter=0;
        int threeOfAKindIndex=-1;
        for(int i=0;i<3;i++){
            for(int a=i+1; a<4; a++){
                for(int b=a+1;b<5;b++){
                    if((((p.getHand().get(a).getRank())) == (p.getHand().get(i).getRank()))
                       && (((p.getHand().get(a).getRank())) == (p.getHand().get(b).getRank()))){
                           threeOfAKind=true;
                           threeOfAKindIndex=a;
                           b=5;
                           a=4;
                           i=3;
                    }
                }
            }
        }
        boolean pairCheck=false;
        int pairIndex1=threeOfAKindIndex;
        int pairIndex2=threeOfAKindIndex;
        if(threeOfAKind){
            for(int i=0;i<5;i++){
                if((p.getHand().get(i).getRank())!=
                   (p.getHand().get(threeOfAKindIndex).getRank())){
                        if(pairCheck){
                            pairIndex2=i;
                        }
                        else{
                            pairIndex1=i;
                            pairCheck=true;
                        }
                }
            }
        }
        boolean arePair=false;
        if(threeOfAKind){
            if(((p.getHand().get(pairIndex1).getRank())==
                    (p.getHand().get(pairIndex2).getRank()))&&(pairIndex1!=pairIndex2)){
                         arePair=true;
            }
        }
        if(threeOfAKind==true && arePair==true){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkFlush(){
        boolean suitsMatch=true;
        for(int a=0;a<4;a++){
            for(int i=0;i<5; i++){
                if((p.getHand().get(a).getSuit())!=(p.getHand().get(i).getSuit())){
                    suitsMatch=false;
                    break;
                }
            }
        }
        if(suitsMatch){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkStraight(){
        boolean rankInOrder=false;
        for(int i=0;i<4; i++){
            if((((p.getHand().get(i).getRank()))+1) == ((p.getHand().get(i+1).getRank()))){
                rankInOrder=true;
            }
            else if(((((p.getHand().get(i).getRank()))==13)&&(((p.getHand().get(1).getRank()))==1))){
                rankInOrder=true;
            }
            else if((((p.getHand().get(i).getRank())==1)&&((p.getHand().get(4).getRank())==13))){
                rankInOrder=true;
            }
            else{
                rankInOrder=false;
                i=5;
            } 
        }
        if(rankInOrder){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkThreeOfAKind(){
        boolean threeOfAKind = false;
        int duplicateCounter=0;
        for(int i=0;i<3;i++){
            for(int a=i+1; a<4; a++){
                for(int b=a+1;b<5;b++){
                    if((((p.getHand().get(a).getRank())) == (p.getHand().get(i).getRank()))
                       && (((p.getHand().get(a).getRank())) == (p.getHand().get(b).getRank()))){
                           threeOfAKind=true;
                           b=5;
                           a=4;
                           i=3;
                    }
                }
            }
        }
        return threeOfAKind;
    }
    public boolean checkTwoPairs(){
        boolean twoPairs = false;
        int pairCounter=0;
        for(int i=0;i<4;i++){
            for(int a=i+1; a<5; a++){
                if(((p.getHand().get(a).getRank())) == (p.getHand().get(i).getRank())){
                    pairCounter++;
                    if(pairCounter==2){
                        twoPairs = true;
                        a=5;
                        i=4;
                    }
                }
            }
        }
        return twoPairs;
    }
    public boolean checkOnePair(){
        boolean onePair = false;
        for(int i=0;i<4;i++){
            for(int a=i+1; a<5; a++){
                if(((p.getHand().get(a).getRank())) == (p.getHand().get(i).getRank())){
                    onePair = true;
                    a=5;
                    i=4;
                }
            }
        }
        return onePair;
    } 
    

}
