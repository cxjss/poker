package utils;

import bean.HandCards;

public class DrawGameJudge {

    public static String judge(HandCards cards1, HandCards cards2){
        if(cards1.getLevel()==Level.STRAIGHT_FLUSH){
            return isStraightFlush(cards1,cards2);
        }else if(cards1.getLevel()==Level.FOUR_KIND){
            return isFourKind(cards1,cards2);
        }else if(cards1.getLevel()==Level.FULL_HOUSE){
            return isFullHouse(cards1,cards2);
        }else if(cards1.getLevel()==Level.FLUSH){
            return isFlush(cards1,cards2);
        }else if(cards1.getLevel()==Level.STRAIGHT){
            return isStraight(cards1,cards2);
        }else if(cards1.getLevel()==Level.THREE_KIND){
            return isThreeKind(cards1,cards2);
        }else if(cards1.getLevel()==Level.TWO_PAIR){
            return isTwoPair(cards1,cards2);
        }else if(cards1.getLevel()==Level.ONE_PAIR){
            return isOnePair(cards1,cards2);
        }else if(cards1.getLevel()==Level.HIGH_CARD){
            return isHighCard(cards1,cards2);
        }
        return "Tie";
    }


    /**
     * 同花顺
     *
     * @param cards1
     * @param cards2
     * @return
     */
    public static String isStraightFlush(HandCards cards1, HandCards cards2) {
        return isStraight(cards1,cards2);
    }

    /**
     * 四条
     *
     * @param cards1
     * @param cards2
     * @return
     */
    public static String isFourKind(HandCards cards1, HandCards cards2) {
        if (cards1.getFirstNum() > cards2.getFirstNum()) {
            return cards1.getPlayer() + " wins";
        } else if (cards1.getFirstNum() < cards2.getFirstNum()) {
            return cards2.getPlayer() + " wins";
        }
        for (int i = 4, j = 4; i >= 0 && j >= 0; --i,--j) {
            while(cards1.getCards()[i].toNum()==cards1.getFirstNum()){
                --i;
            }
            while(cards2.getCards()[i].toNum()==cards2.getFirstNum()){
                --j;
            }
            if (cards1.getCards()[i].toNum() > cards2.getCards()[j].toNum()) {
                return cards1.getPlayer() + " wins";
            } else if (cards1.getCards()[i].toNum() < cards2.getCards()[j].toNum()) {
                return cards2.getPlayer() + " wins";
            }
        }
        return "Tie";
    }

    /**
     * 葫芦
     * @param cards1
     * @param cards2
     * @return
     */
    public static String isFullHouse(HandCards cards1, HandCards cards2) {
        if(cards1.getFirstNum()>cards2.getFirstNum()){
            return cards1.getPlayer() + " wins";
        }else if(cards1.getFirstNum()<cards2.getFirstNum()){
            return cards2.getPlayer() + " wins";
        }
        if(cards1.getSecondNum()>cards2.getSecondNum()){
            return cards1.getPlayer() + " wins";
        }else if(cards1.getSecondNum()<cards2.getSecondNum()){
            return cards2.getPlayer() + " wins";
        }
        return "Tie";
    }

    /**
     * 同花
     * @param cards1
     * @param cards2
     * @return
     */
    public static String isFlush(HandCards cards1, HandCards cards2) {
        return isHighCard(cards1,cards2);
    }

    /**
     * 顺子
     * @param cards1
     * @param cards2
     * @return
     */
    public static String isStraight(HandCards cards1, HandCards cards2) {
        if(cards1.getFirstNum()>cards2.getFirstNum()){
            return cards1.getPlayer() + " wins";
        }else if(cards1.getFirstNum()<cards2.getFirstNum()){
            return cards2.getPlayer() + " wins";
        }
        return "Tie";
    }

    /**
     * 三条
     * @param cards1
     * @param cards2
     * @return
     */
    public static String isThreeKind(HandCards cards1, HandCards cards2) {
        if(cards1.getFirstNum()>cards2.getFirstNum()){
            return cards1.getPlayer() + " wins";
        }else if(cards1.getFirstNum()<cards2.getFirstNum()){
            return cards2.getPlayer() + " wins";
        }
        for (int i = 4, j = 4; i >= 0 && j >= 0; --i,--j) {
            while(cards1.getCards()[i].toNum()==cards1.getFirstNum()){
                --i;
            }
            while(cards2.getCards()[i].toNum()==cards2.getFirstNum()){
                --j;
            }
            if (cards1.getCards()[i].toNum() > cards2.getCards()[j].toNum()) {
                return cards1.getPlayer() + " wins";
            } else if (cards1.getCards()[i].toNum() < cards2.getCards()[j].toNum()) {
                return cards2.getPlayer() + " wins";
            }
        }
        return "Tie";
    }

    /**
     * 两对
     * @param cards1
     * @param cards2
     * @return
     */
    public static String isTwoPair(HandCards cards1, HandCards cards2) {
        if(cards1.getSecondNum()>cards2.getSecondNum()){
            return cards1.getPlayer() + " wins";
        }else if(cards1.getSecondNum()<cards2.getSecondNum()){
            return cards2.getPlayer() + " wins";
        }
        if(cards1.getFirstNum()>cards2.getFirstNum()){
            return cards1.getPlayer() + " wins";
        }else if(cards1.getFirstNum()<cards2.getFirstNum()){
            return cards2.getPlayer() + " wins";
        }
        for (int i = 4, j = 4; i >= 0 && j >= 0; --i,--j) {
            while(cards1.getCards()[i].toNum()==cards1.getFirstNum()||
                    cards1.getCards()[i].toNum()==cards1.getSecondNum()){
                --i;
            }
            while(cards2.getCards()[i].toNum()==cards2.getFirstNum()||
                    cards2.getCards()[i].toNum()==cards2.getSecondNum()){
                --j;
            }
            if (cards1.getCards()[i].toNum() > cards2.getCards()[j].toNum()) {
                return cards1.getPlayer() + " wins";
            } else if (cards1.getCards()[i].toNum() < cards2.getCards()[j].toNum()) {
                return cards2.getPlayer() + " wins";
            }
        }
        return "Tie";
    }

    /**
     * 对子
     * @param cards1
     * @param cards2
     * @return
     */
    public static String isOnePair(HandCards cards1, HandCards cards2) {
        return isThreeKind(cards1,cards2);
    }

    /**
     * 散牌
     * @param cards1
     * @param cards2
     * @return
     */
    public static String isHighCard(HandCards cards1, HandCards cards2){
        for (int i = 4; i >= 0; --i) {
            if (cards1.getCards()[i].toNum() > cards2.getCards()[i].toNum()) {
                return cards1.getPlayer() + " wins";
            } else if (cards1.getCards()[i].toNum() < cards2.getCards()[i].toNum()) {
                return cards2.getPlayer() + " wins";
            }
        }
        return "Tie";
    }

}
