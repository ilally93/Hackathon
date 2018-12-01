import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> myDeck;

    public Deck(boolean joker) {
        myDeck = new ArrayList<Card>();
        String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};
        String[] numbers = {"1", "2", "3", "4", "5","6","7","8","9","10","Jack","Queen","King"};

        for (int i =0; i < suits.length; i++) {
            
            for (int j = 0; j < numbers.length; j ++) { 
                Card myCard = new Card(suits[i],numbers[j]);
                myDeck.add(myCard);
            }

        }

        int i = 0;
        while (joker && i < 4) {
            Card myCard = new Card("N/A", "Joker");
            myDeck.add(myCard);
            i += 1;
        }
                
    }

    public String toString() {
        String theString = "";
        for (int i = 0; i < myDeck.size() - 1; i++) {
            theString += myDeck.get(i) + "\n\n";
        }
        theString += myDeck.get(myDeck.size() - 1);

        return theString;
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < myDeck.size(); i++) {
            int myInt = rand.nextInt(myDeck.size());
            Card temp = myDeck.get(i);
            myDeck.set(i, myDeck.get(myInt));
            myDeck.set(myInt, temp);
        }
        for (int i = 0; i < myDeck.size(); i++) {
            int myInt = rand.nextInt(myDeck.size());
            Card temp = myDeck.get(i);
            myDeck.set(i, myDeck.get(myInt));
            myDeck.set(myInt, temp);
        }
    }

    public static void main(String[] args) {
        Deck jokerDeck = new Deck(true);
        System.out.println(jokerDeck);

        jokerDeck.shuffle();
        System.out.println(jokerDeck);
    }
}