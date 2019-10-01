package LogicGame;

import LogicGame.Enum.CardColor;
import LogicGame.Enum.CardNumber;
import LogicGame.Enum.CardType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards implements Comparable<Cards> {

    private CardNumber cardNumber;
    private CardType cardType;
    private CardColor cardColor;

    public Cards(CardNumber cardNumber, CardType cardType, CardColor cardColor) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cardColor = cardColor;
    }

    public Cards() {
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public void setCardColor(CardColor cardColor) {
        this.cardColor = cardColor;
    }

    public static List<Cards> getPackofCards()
    {
        List<Cards> crdLst = new ArrayList<Cards>();

        for (CardType types : CardType.values())
        {
            for (CardNumber cNums : CardNumber.values())
            {
                Cards cd = new Cards();
                cd.cardNumber = cNums;
                cd.cardType = types;
                crdLst.add(cd);
            }
        }
        return crdLst;
    }

    public static void shuffleCards(List<Cards> cards)
    {
        Collections.shuffle(cards);
    }

    public int compareTo(Cards o) {
        if (this.getCardNumber() == o.getCardNumber())
        {
            return 0;
        }
        else if (this.getCardNumber().getNumberId() > o.getCardNumber().getNumberId())
        {
            return 1;
        }
        else
            return -1;
    }

    @Override
    public String toString() {
        return "LogicGame.Cards{" +
                "cardNumber=" + cardNumber +
                ", cardType=" + cardType +
                '}';
    }
}
