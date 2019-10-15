package LogicGame;

public class Player implements Comparable<Player>{

    private int idPlayer;
    private String nickName;
    private int point;

    public Player() {
    }

    public Player(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public Player(int idPlayer, String nickName) {
        this.idPlayer = idPlayer;
        this.nickName = nickName;
    }

    public Player(int idPlayer, String nickName, int point) {
        this.idPlayer = idPlayer;
        this.nickName = nickName;
        this.point = point;
    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }


    public int compareTo(Player o) {
        if (this.getPoint() == o.getPoint())
        {
            return 0;
        }
        else if (this.getPoint() > o.getPoint())
        {
            return 1;
        }
        else
            return -1;
    }
}
