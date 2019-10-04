package RestController;

import LogicGame.CardGame;
import LogicGame.Cards;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/rest")
//@CrossOrigin(origins = "http://localhost:8080")
@EnableAutoConfiguration
public class RestMainController
{
    public RestMainController() {
    }

    @GetMapping("/start")
    public List<Cards> inizializeCardPackage(){
        return new CardGame().inizializeCardPackage();
    }
}
