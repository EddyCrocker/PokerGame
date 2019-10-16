package LogicGame;

import java.util.List;

public class CardsList {

    private List<Cards> cardsList;

    public CardsList() {
    }

    public List<Cards> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<Cards> cardsList) {
        this.cardsList = cardsList;
    }

    public CardsList(List<Cards> cardsList) {
        this.cardsList = cardsList;
    }
}
