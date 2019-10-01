package EnumConverter;

import LogicGame.Enum.CardNumber;

public class ConverterCardNumber {

    public CardNumber intToEnum(int id){
        switch (id){
            case 2:
                return CardNumber.TWO;
            case 3:
                return CardNumber.THREE;
            case 4:
                return CardNumber.FOUR;
            case 5:
                return CardNumber.FIVE;
            case 6:
                return CardNumber.SIX;
            case 7:
                return CardNumber.SEVEN;
            case 8:
                return CardNumber.EIGHT;
            case 9:
                return CardNumber.NINE;
            case 10:
                return CardNumber.TEN;
            case 11:
                return CardNumber.JACK;
            case 12:
                return CardNumber.QUEEN;
            case 13:
                return CardNumber.KING;
            case 14:
                return CardNumber.ACE;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
    }
}
