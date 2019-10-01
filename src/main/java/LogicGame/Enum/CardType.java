package LogicGame.Enum;

public enum CardType {
    PICCHE(1,CardColor.BLACK),
    FIORI(2,CardColor.BLACK),
    QUADRI(3,CardColor.RED),
    CUORI(4,CardColor.RED);

    private int idType;
    private CardColor color;

    CardType(int idType, CardColor color) {
        this.idType = idType;
        this.color = color;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public CardColor getColor() {
        return color;
    }

    public void setColor(CardColor color) {
        this.color = color;
    }
}
