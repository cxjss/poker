import bean.HandCards;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CardTest {

    @Test
    public void test1(){
        HandCards handCards1 = new HandCards("Black","2H 3D 5S 9C KD");
        HandCards handCards2 = new HandCards("White","2C 3H 4S 8C AH");
        assertEquals("White wins",CardsJudge.judge(handCards1,handCards2));
    }

    @Test
    public void test2(){
        HandCards handCards1 = new HandCards("Black","2H 4S 4C 2D 4H");
        HandCards handCards2 = new HandCards("White","2S 8S AS QS 3S");
        assertEquals("Black wins",CardsJudge.judge(handCards1,handCards2));
    }

    @Test
    public void test3(){
        HandCards handCards1 = new HandCards("Black","2H 3D 5S 9C KD");
        HandCards handCards2 = new HandCards("White","2C 3H 4S 8C KH");
        assertEquals("Black wins",CardsJudge.judge(handCards1,handCards2));
    }

    @Test
    public void test4(){
        HandCards handCards1 = new HandCards("Black","2H 3D 5S 9C KD");
        HandCards handCards2 = new HandCards("White","2D 3H 5C 9S KH");
        assertEquals("Tie",CardsJudge.judge(handCards1,handCards2));
    }

    @Test
    public void test5(){
        HandCards handCards1 = new HandCards("Black","2H 3H 4H 5H 6H");
        HandCards handCards2 = new HandCards("White","3H 4H 5H 6H 6S");
        assertEquals("Black wins",CardsJudge.judge(handCards1,handCards2));
    }
}
