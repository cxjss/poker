package utils;

/**
 * 这个接口主要来存储
 */
public interface Level {

    //同花顺
    int STRAIGHT_FLUSH = 9;
    //四条
    int FOUR_KIND = 8;
    //葫芦
    int FULL_HOUSE = 7;
    //同花
    int FLUSH = 6;
    //顺子
    int STRAIGHT = 5;
    //三条
    int THREE_KIND = 4;
    //两对
    int TWO_PAIR = 3;
    //对子
    int ONE_PAIR = 2;
    //散排
    int HIGH_CARD = 1;
}
