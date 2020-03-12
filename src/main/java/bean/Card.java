package bean;

import java.io.Serializable;

/**
 * 定义一个卡片类
 */
public class Card implements Comparable, Serializable {
    //大小
    private char num;
    //花色
    private char suit;

    public char getNum() {
        return num;
    }

    public void setNum(char num) {
        this.num = num;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public Card() {
    }

    public Card(String card) {
        this.num = card.charAt(0);
        this.suit = card.charAt(1);
    }

    @Override
    public String toString() {
        return "Card{" +
                "num=" + num +
                ", suit=" + suit +
                '}';
    }

    public int toNum(){
        if(num == 'T')
            return 10;
        else if(num == 'J')
            return 11;
        else if(num == 'Q')
            return 12;
        else if(num == 'K')
            return 13;
        else if(num == 'A')
            return 14;
        else
            return num-'0';
    }

    @Override
    public int compareTo(Object o) {
        return toNum()-((Card)o).toNum();
    }
}
