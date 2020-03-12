package utils;

import bean.HandCards;

public class CardCatalog {

    public static void catalog(HandCards cards){
        if(isStraightFlush(cards)){
            cards.setLevel(Level.STRAIGHT_FLUSH);
        }else if(isFourKind(cards)){
            cards.setLevel(Level.FOUR_KIND);
        }else if(isFullHouse(cards)){
            cards.setLevel(Level.FULL_HOUSE);
        }else if(isFlush(cards)) {
            cards.setLevel(Level.FLUSH);
        }else if(isStraight(cards)){
            cards.setLevel(Level.STRAIGHT);
        }else if(isThreeKind(cards)) {
            cards.setLevel(Level.THREE_KIND);
        }else if(isTwoPair(cards)){
            cards.setLevel(Level.TWO_PAIR);
        }else if(isOnePair(cards)){
            cards.setLevel(Level.ONE_PAIR);
        }else {
            cards.setLevel(Level.HIGH_CARD);
        }
    }

    /**
     * 9 同花顺
     * @param cards
     * @return
     */
    public static boolean isStraightFlush(HandCards cards) {
        if (isStraight(cards) && isFlush(cards)) {
            cards.setFirstNum(cards.getCards()[4].toNum());
            return true;
        }
        return false;
    }

    /**
     * 8 四条
     * @param cards
     * @return
     */
    public static boolean isFourKind(HandCards cards) {
        int[] nums = new int[15];
        for (int i = 0; i < 5; ++i) {
            ++nums[cards.getCards()[i].toNum()];
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 4) {
                cards.setFirstNum(i);
                return true;
            }
        }
        return false;
    }

    /**
     * 7 葫芦
     * @param cards
     * @return
     */
    public static boolean isFullHouse(HandCards cards) {
        boolean flag2 = false;
        boolean flag3 = false;
        int[] nums = new int[15];
        for (int i = 0; i < 5; ++i) {
            ++nums[cards.getCards()[i].toNum()];
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 3) {
                flag3 = true;
                cards.setFirstNum(i);
            } else if (nums[i] == 2) {
                flag2 = true;
                cards.setSecondNum(i);
            }
        }
        if (flag2 && flag3) {
            return true;
        }
        return false;
    }

    /**
     * 6 同花
     * @param cards
     * @return
     */
    public static boolean isFlush(HandCards cards) {
        boolean flag = true;
        for (int i = 1; i < 5; ++i) {
            if (cards.getCards()[i].getSuit() != cards.getCards()[i-1].getSuit()) {
                flag = false;
                break;
            }
        }
        if(flag){
            return true;
        }
        return false;
    }

    /**
     * 5 顺子
     * @param cards
     * @return
     */
    public static boolean isStraight(HandCards cards) {
        boolean flag = true;
        for (int i = 1; i < 5; ++i) {
            if (cards.getCards()[i].toNum()!=cards.getCards()[i-1].toNum()+1) {
                flag = false;
                break;
            }
        }
        if(flag){
            cards.setFirstNum(cards.getCards()[4].toNum());
            return true;
        }
        return false;
    }

    /**
     * 4 三条
     * @param cards
     * @return
     */
    public static boolean isThreeKind(HandCards cards) {
        int[] nums = new int[15];
        for (int i = 0; i < 5; ++i) {
            ++nums[cards.getCards()[i].toNum()];
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 3) {
                cards.setFirstNum(i);
                return true;
            }
        }
        return false;
    }

    /**
     * 3 两对
     * @param cards
     * @return
     */
    public static boolean isTwoPair(HandCards cards) {
        boolean flag21 = false;
        boolean flag22 = false;
        int[] nums = new int[15];
        for (int i = 0; i < 5; ++i) {
            ++nums[cards.getCards()[i].toNum()];
        }
        for (int i = 0; i < nums.length; ++i) {
            if(!flag21){
                if(nums[i]==2){
                    flag21 = true;
                    cards.setFirstNum(i);
                }
            }else{
                if(nums[i]==2){
                    flag22 = true;
                    cards.setSecondNum(i);
                }
            }
        }
        if (flag21 && flag22) {
            return true;
        }
        return false;
    }

    /**
     * 对子
     * @param cards
     * @return
     */
    public static boolean isOnePair(HandCards cards) {
        int[] nums = new int[15];
        for (int i = 0; i < 5; ++i) {
            ++nums[cards.getCards()[i].toNum()];
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 2) {
                cards.setFirstNum(i);
                return true;
            }
        }
        return false;
    }


}
