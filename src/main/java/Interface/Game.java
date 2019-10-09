package Interface;

import LogicGame.Player;
import LogicGame.nickNameInsert;

import java.util.List;

public interface Game {

    List<Player> InitializeSessionGame(nickNameInsert name);

    void displayWinners();
}
