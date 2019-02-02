//Anthony Pitts

import java.util.concurrent.ThreadLocalRandom;

public class Deck {
	private Card[] deck = new Card[52];
	private int top=-1;//keeps track of how deep in deck
    
	public Deck(){   
	}
    public void makeDeck(){
        int b=0;
        for(int i=1; i<=4; i++){
            for(int a=1; a<=13; a++){
                Card createdCard = new Card(i, a);
                deck[b] = createdCard;
                b++;
            }
        }
    }
    public Card[] getDeck(){
        return deck;
    }
    public void resetTop(){
        top=-1;
    }
       
	
	public void shuffle(){
        for(int i=0; i<1000; i++){
            int rand1 = ThreadLocalRandom.current().nextInt(0,52);
            int rand2 = ThreadLocalRandom.current().nextInt(0,52);
            Card temp;
            temp = deck[rand1];
            deck[rand1]=deck[rand2];
            deck[rand2]=temp;
        }
	}
	
	public Card deal(){
        top++;
        return deck[top];
	}
}
	
