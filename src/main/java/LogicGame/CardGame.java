package LogicGame;

import EnumConverter.ActionTurn;
import EnumConverter.ConverterCardNumber;
import EnumConverter.ConverterCardType;
import Interface.Game;
import LogicGame.Enum.CardNumber;
import LogicGame.Enum.CardType;

import java.util.*;

public class CardGame implements Game {

    private List<Cards> card;
    private List<Player> playerList = new ArrayList<Player>();
    private Map<Player,List<Cards>> cardsPlayerMap = new HashMap<Player, List<Cards>>();

    private int currentPlayerIdx = 0;

    private static final int numberOfCardsPerPlayer = 2;

    private int numberOfPlayers;

    private Integer betPreviusPlayer;

    public CardGame() {
        card = inizializeCardPackage();
    }

    public List<Cards> inizializeCardPackage() {
        List<Cards> cards = new ArrayList<Cards>(52);
        final int type = 4;
        final int numberOfCard = 14;
        for (int i = 1; i <= type; i++) {
            CardType cardType = new ConverterCardType().IntToEnum(i);
            for (int num = 2; num <= numberOfCard; num++) {
                CardNumber cardNumber = new ConverterCardNumber().intToEnum(num);
                cards.add(new Cards(cardNumber, cardType, cardType.getColor()));
            }
        }
        return cards;
    }

    public List<Player> InitializeSessionGame(nickNameInsert namePlayers) {
//        this.numberOfPlayers = numberOfPlayers;
        System.out.println("Game started :)");
        int id = (int)(Math.random() * 10);
        return createUser(id,namePlayers);
//        playGameNow();
    }

    public List<Cards> updateCardPackage(CardsList cards){
        if(cards != null) {
            for (Cards c : cards.getCardsList()) {
                card.remove(c);
            }
        }
        return card;
    }

    public Map<Player,List<Cards>> distributeCardsForPlayers(Player player){

        Cards.shuffleCards(card);

        if(cardsPlayerMap.size() != 0){
            cardsPlayerMap.clear();
        }

        int m = 0;

//      p.setPoint(0);
        List<Cards> cards = new ArrayList<>();
        int cardLimit = m + numberOfCardsPerPlayer;
        for(int i = m; i < cardLimit; i++){
            Cards cardsGet = card.get(i);
            cards.add(cardsGet);
            card.remove(cardsGet);
        }
        m = cardLimit;
        cardsPlayerMap.put(player,cards);

        return cardsPlayerMap;
    }

    public boolean checkTurnPlayers(Map<Player,Integer> mapMoney,Integer countTurn){
        boolean turnFirstFinish = false;
        if(countTurn == 1) {
            ++countTurn;
            if (mapMoney.size() != 0) {
                for (Player player : playerList) {
                    Integer moneyPlayer = mapMoney.get(player);
                    turnFirstFinish = moneyPlayer != null;
                }
            }
        }
        return turnFirstFinish;
    }

    public int choosePlayerSelection(Player player,int countTurn){
        int i;
        final int first = 1;
        System.out.print("Show your card" + " " + player.getNickName() +"? Y/N: ");
        Scanner inChoose = new Scanner(System.in);
        String choose = inChoose.next();
        if(choose.equals("Y")) {
            displayCardsForPlayer(player);
        }
        System.out.println(countTurn == first ? ActionTurn.TURN_FIRST.getAction() : ActionTurn.OTHER_TURN.getAction());
        System.out.println("Chance for Player..." + player.getNickName());
        System.out.print("Please provide your option : ");

        Scanner in = new Scanner(System.in);
        i = in.nextInt();

        if(betPreviusPlayer == null && i == 3){
            System.out.println("Dont't possible check turn, select other option :");
            in = new Scanner(System.in);
            i = in.nextInt();
        }
        return i;
    }

    public void playGameNow(){
        List<Cards> selectedCard = new ArrayList<Cards>();
        Map<Player,Integer> mapMoney = new HashMap<>();
        Cards maxCard = null;
        Player maxPlayer = new Player(0);
            int countTurn = 1;
            final int first = 1;
                do {
                    boolean turnFirstFinish = checkTurnPlayers(mapMoney,countTurn);
                    if(turnFirstFinish) {
                        countTurn++;
                    }
                    Player player = getNextPlayer();

                    Integer playerMoney;
                    Integer blind;

                    int i = choosePlayerSelection(player,countTurn);

                    if (countTurn == first) {

                        switch (i) {
                            case 1:
                                System.out.println("Your Blind :");
                                Scanner in = new Scanner(System.in);
                                blind = in.nextInt();
                                this.betPreviusPlayer = blind;
                                mapMoney.put(player, blind);
                                break;
                            case 2:
                                playerList.remove(player);
                                break;
                        }
                    } else {
                        switch (i) {
                            case 1:
                                System.out.println("Your Bet :");
                                Scanner in = new Scanner(System.in);
                                blind = in.nextInt();
                                this.betPreviusPlayer = blind;
                                playerMoney = mapMoney.get(player);
                                Integer sumMoney = blind + playerMoney;
                                mapMoney.remove(player);
                                mapMoney.put(player, sumMoney);
                                break;
                            case 2:
                                Integer previusBet = betPreviusPlayer;
                                playerMoney = mapMoney.get(player);
                                mapMoney.remove(player);
                                mapMoney.put(player,playerMoney + (previusBet != null ? previusBet : 0));
                                break;
                            case 3:
                                this.betPreviusPlayer = null;
                                break;
                            case 4:
                            case 7:
                                playerList.remove(player);
                                break;
                            case 5:
                                playerMoney = mapMoney.get(player);
                                System.out.println("Your Blind Fucking Man:");
                                in = new Scanner(System.in);
                                blind = in.nextInt();
                                this.betPreviusPlayer = blind;
                                mapMoney.remove(player);
                                mapMoney.put(player,playerMoney + blind);
                                break;
                            case 6:
                                displayCardAllPlayer();
                                break;
                        }
                    }
                }
                while (playerList.size() != 1);

                if (maxPlayer.getIdPlayer() > 0) {

                    maxPlayer.setPoint((maxPlayer.getPoint()) + 1);
                    maxCard = null;
                    maxPlayer = null;
                    displayScores();
                }
            }



    public void displayWinners() {

    }

    private List<Player> createUser(int id, nickNameInsert namePlayers) {
//        if (playerList.size() != 0) {
//            playerList.clear();
////        }
//        for (int i = 0; i < playerList.size(); i++) {
                Player user = new Player(id, namePlayers.getNickName());
                playerList.add(user);
//        }
        return playerList;
//        distributeCardsForPlayers(playerList);
    }

    private Player getNextPlayer()
    {

        Player p;
        if (currentPlayerIdx == playerList.size())
        {
            currentPlayerIdx = 1;
            p = playerList.get(0);
        }
        else
        {
            p = playerList.get(currentPlayerIdx);
            currentPlayerIdx++;
        }

        return p;
    }

    private Player previusPlayer(){
        return playerList.get(currentPlayerIdx != 0 ? -1 : playerList.size() -1);

    }

    private void displayCardsForPlayer(Player pl)
    {
        List<Cards> card = cardsPlayerMap.get(pl);
        for(Cards cards : card){
            System.out.println("cards" +" " + pl.getNickName() + ":" + cards.getCardNumber() + ","
                    + cards.getCardColor() + "," + cards.getCardType());
        }
    }

    private void displayCardAllPlayer(){
        for(Player player : playerList){
            List<Cards> card = cardsPlayerMap.get(player);
            for(Cards cards : card){
                System.out.println("cards" + player.getNickName() + ":" + cards.getCardNumber() + ","
                        + cards.getCardColor() + "," + cards.getCardType());
            }
        }
    }

    private void displayScores()
    {
        for (Player pl : playerList)
        {
            System.out.println("Player " + pl.getIdPlayer() + " Score -> " + pl.getPoint());
        }

    }

    public static int getNumberOfCardsPerPlayer() {
        return numberOfCardsPerPlayer;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    //    public void initializePlayer(){
//        System.out.println("Card Game \n Player Options");
//			System.out.println("1. Start Game \n  \n2. Exit Game");
//			System.out.print("Please provide your option : ");
//
//			int i = 1;
//
//			while (i != 0) {
//				Scanner in = new Scanner(System.in);
//				i = in.nextInt();
//
//				switch (i) {
//					case 1:
//						System.out.println("Provide the Number of Players( should be greater than 1 and less than 4) : ");
//						in = new Scanner(System.in);
//						i = in.nextInt();
////						InitializeSessionGame(i);
////						displayWinners();
//						break;
//
//					case 2:
//						System.exit(0);
//				}
//
//				System.out.println();
//				System.out.println("Card Game \n Select User Options");
//				System.out.println("1. Start Game \n2. Exit Game");
//				System.out.print("Please provide your option : ");
//			}
//    }



}
