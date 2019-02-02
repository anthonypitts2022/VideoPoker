//Anthony Pits
//UNI: aep2195


public class Card implements Comparable<Card>{
	
	private int suit; // 1-4 --> C,D,H,S
	private int rank; // 1-13 --> ace, 2-10, jack,queen,king
    private String [] suitKey = {"clubs", "diamonds", "hearts", "spades"};
    private String [] rankKey = {"ace", "two", "three","four", "five", "six", "seven", 
                         "eight", "nine", "ten", "jack", "queen", "king"};
    
	public Card(int s, int r){
        suit = s;
        rank = r;
	}
    public int getRank(){
        return rank;
    }
    public int getSuit(){
        return suit;
    }
	
	public int compareTo(Card c){
        if(this.getRank()>c.getRank()){
            return 1;
        }
        else if(this.getRank()<c.getRank()){
            return -1;
        }
        else{
            return 0;
        }        
    }	
	
	public String toString(){
        String cardDetails = rankKey[rank-1] + " of " + suitKey[suit-1];
        return cardDetails;
	}
}


