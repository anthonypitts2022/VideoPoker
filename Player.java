
// Anthony Pitts

import java.util.ArrayList;
import java.util.Collections;
public class Player {
	
		
	private ArrayList<Card> hand;
	private int bankroll;
    private int bet;

	public Player(){	
        hand = new ArrayList<Card>();
        bankroll = 10;
        bet = 0;
	}
    public void setHand(ArrayList<Card> testerHand){
        hand = testerHand;
    }
    public ArrayList<Card> getHand(){
        return hand;
    }

	public void addCard(Card c){
        hand.add(c);
	}

	public void removeCard(int c){
        hand.remove(c);
    }
		
    public void bets(int amt){
        bankroll = bankroll - amt;
        bet = amt;
    }
    public int getBet(){
        return bet;
    }

    public int getBankroll(){
        return bankroll;
    }
    public void sortHand(){
        for (int i=0; i<5; i++){
            for(int a=0; a<4; a++){
                int result = hand.get(a).compareTo(hand.get(a+1));
                if(result==1){
                    Collections.swap(hand,a,(a+1));
                }
            }
        }  
    }
    public void setBankroll(int a){
        bankroll = a;
    }
    public void resetHand(){
        hand.clear();
    }
}


