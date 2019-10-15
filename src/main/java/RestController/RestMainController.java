package RestController;

import LogicGame.CardGame;
import LogicGame.Cards;
import LogicGame.Player;
import LogicGame.nickNameInsert;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class RestMainController
{
    public RestMainController() {
    }

    @GetMapping("/update")
    public  List<Cards> updateCardPackage(){ return new CardGame().updateCardPackage();
    }

    @GetMapping("/welcome")
    public ModelAndView welcomePage(){
        return new ModelAndView("card");
    }

    @GetMapping("/start")
    public List<Cards> inizializeCardPackage(){ return new CardGame().inizializeCardPackage(); }

    @GetMapping("/countPlayer")
    public List<Player> countPlayer(@RequestParam nickNameInsert namePlayers){ return new CardGame().InitializeSessionGame(namePlayers); }

    @GetMapping("/distribute")
    public Map<Player,List<Cards>> distributeCardsForPlayers(@RequestParam Player player) { return new CardGame().distributeCardsForPlayers(player);}

//    @GetMapping("/distributeCards")
//    public ModelAndView welcomePage(){
//        return new ModelAndView("card");
//    }
}
