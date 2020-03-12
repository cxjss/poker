import bean.HandCards;
import utils.CardCatalog;
import utils.DrawGameJudge;

public class CardsJudge {

    public static String judge(HandCards cards1, HandCards cards2){
        CardCatalog.catalog(cards1);
        CardCatalog.catalog(cards2);
        if(cards1.getLevel()>cards2.getLevel()){
            return cards1.getPlayer()+" wins";
        }else if(cards1.getLevel()<cards2.getLevel()){
            return cards2.getPlayer()+" wins";
        }else{
            return DrawGameJudge.judge(cards1,cards2);
        }
    }
}
