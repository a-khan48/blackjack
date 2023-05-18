import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    ///instance vars
    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public void createFullDeck() {
        for(Suits cardSuit : Suits.values()) {
            for(Values cardValue : Values.values()) {
                ///will add new card to the deck
                this.deck.add(new Card(cardSuit,cardValue));
            }
        }

    }

    public String toString() {
        String cardListOutput = "";
        int i = 0;
        for (Card aCard : this.deck) {
            cardListOutput += "\n" + aCard.toString();
        }
        return cardListOutput;
    }

    public void shuffleDeck(){
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex =0;
        int originalSize = this.deck.size();
        for (int i = 0 ; i<originalSize; i++){
            randomCardIndex = random.nextInt((this.deck.size()-1-0)+1)+ 0;
            tmpDeck.add(this.deck.get(randomCardIndex));
            this.deck.remove(randomCardIndex);
        }
        this.deck = tmpDeck;
        Collections.shuffle(deck);
    }



    public Card getCard(int i){
        return this.deck.get(i);
    }

    public void removeCard(int i){
        this.deck.remove(i);
    }

    public void addCard(Card addCard) {
        this.deck.add(addCard);
    }

    public int deckSize() {
        return this.deck.size();
    }

    // Draws from the deck
    public void draw(Deck comingFrom) {
        this.deck.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }

    // This will move cards back into the deck to continue playing
    public void moveAllToDeck(Deck moveTo) {
        int thisDeckSize = this.deck.size();

        //put cards into the moveTo deck
        for(int i = 0; i < thisDeckSize; i++){
            moveTo.addCard(this.getCard(i));
        }
        for(int i = 0; i < thisDeckSize; i++){
            this.removeCard(0);
        }
    }

    //returns value of total value of cards in deck
    public int cardsValue() {
        int totalValue = 0;
        int aces = 0;
        for (Card aCard : this.deck){
            switch(aCard.getValue()){
                case TWO: totalValue += 2; break;
                case THREE: totalValue += 3; break;
                case FOUR: totalValue += 4; break;
                case FIVE: totalValue += 5; break;
                case SIX: totalValue += 6; break;
                case SEVEN: totalValue += 7; break;
                case EIGHT: totalValue += 8; break;
                case NINE: totalValue += 9; break;
                case TEN: totalValue += 10; break;
                case JACK: totalValue += 10; break;
                case QUEEN: totalValue += 10; break;
                case KING: totalValue += 10; break;
                case ACE: totalValue += 1; break;
            }
        }
        for(int i = 0; i < aces; i++) {
            if(totalValue > 10) {
                totalValue += 1;
            }
            else {
                totalValue += 11;
            }
        }
        return totalValue;
    }


}