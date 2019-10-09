package RestController;

import LogicGame.CardGame;
import LogicGame.Cards;
import LogicGame.Player;
import LogicGame.nickNameInsert;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class RestMainController
{
    public RestMainController() {
    }

    @GetMapping("/welcome")
    public ModelAndView welcomePage(){
        return new ModelAndView("card");
    }

    @GetMapping("/start")
    public List<Cards> inizializeCardPackage(){

        return new CardGame().inizializeCardPackage();
    }

    @GetMapping("/countPlayer")
    public List<Player> countPlayer(@RequestParam nickNameInsert namePlayers){
        return new CardGame().InitializeSessionGame(namePlayers);
    }

//    @GetMapping("/distributeCards")
//    public ModelAndView welcomePage(){
//        return new ModelAndView("card");
//    }
}
