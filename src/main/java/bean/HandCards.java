package bean;

import java.util.Arrays;

public class HandCards {

    private Card[] cards = new Card[5];

    private String player;

    private int level;

    private int firstNum;

    private int secondNum;

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Card[] getCards() {
        return cards;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public HandCards(String player, String InputCards) {
        this.player = player;
        String[] cardName = InputCards.split(" ");
        for(int i=0;i<5;++i){
            cards[i] = new Card(cardName[i]);
        }
        Arrays.sort(cards);
    }

    @Override
    public String toString() {
        return "HandCards{" +
                "cards=" + Arrays.toString(cards) +
                ", player='" + player + '\'' +
                '}';
    }
}
