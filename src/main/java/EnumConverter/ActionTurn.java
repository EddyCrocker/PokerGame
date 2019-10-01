package EnumConverter;

public enum ActionTurn {
    TURN_FIRST("1 Blind  \n3. Stop Game and Exit"),
    OTHER_TURN("1 Bet \n2 Call \n3 Check \n4 Fold \n5 Raise \n6 Showdown \n7 Stop Game and Exit ");

    private String action;

    ActionTurn(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
