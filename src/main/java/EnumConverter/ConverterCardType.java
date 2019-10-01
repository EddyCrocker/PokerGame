package EnumConverter;

import LogicGame.Enum.CardType;

public class ConverterCardType {

    public CardType IntToEnum(int id){
        switch (id){
            case 1:
                return CardType.PICCHE;
            case 2:
                return CardType.FIORI;
            case 3:
                return CardType.QUADRI;
            case 4:
                return CardType.CUORI;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
    }
}
