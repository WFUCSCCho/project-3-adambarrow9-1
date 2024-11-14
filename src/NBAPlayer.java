// @file: Proj1.java
// @description: class to define NBAPlayer object
// @author: Adam Barrow
// @date: October 24 , 2024


public class NBAPlayer implements Comparable<NBAPlayer> {

    //private fields
    private int playerID;
    private int gamesPlayed;
    private int gamesStarted;
    private double minutesPerGame;
    private double pointsPerGame;
    private int fieldGoalsMade;
    private int fieldGoalsAttempted;
    private double fieldGoalPercentage;
    private int threesMade;
    private int threesAttempted;
    private double threePointPercentage;
    private int freeThrowsMade;
    private int freeThrowsAttempted;
    private double freeThrowPercentage;
    private String player;
    private String position;
    private String team;


    // default constructor;
    public NBAPlayer() {
        this.playerID = -1;
        this.gamesPlayed = 0;
        this.gamesStarted = 0;
        this.minutesPerGame = 0.0;
        this.pointsPerGame = 0.0;
        this.fieldGoalsMade = 0;
        this.fieldGoalsAttempted = 0;
        this.fieldGoalPercentage = 0.0;
        this.threesMade = 0;
        this.threesAttempted = 0;
        this.threePointPercentage = 0.0;
        this.freeThrowsMade = 0;
        this.freeThrowsAttempted = 0;
        this.freeThrowPercentage = 0.0;
        this.player = "no name";
        this.position = "no position";
        this.team = "no team";
    }

    // copy constructor
    public NBAPlayer (NBAPlayer player1) {
        this.playerID = player1.getPlayerID();
        this.gamesPlayed = player1.getGamesPlayed();
        this.gamesStarted = player1.getGamesStarted();
        this.minutesPerGame = player1.getMinutesPerGame();
        this.pointsPerGame = player1.getPointsPerGame();
        this.fieldGoalsMade = player1.getFieldGoalsMade();
        this.fieldGoalsAttempted = player1.getFieldGoalsAttempted();
        this.fieldGoalPercentage = player1.getFieldGoalPercentage();
        this.threesMade = player1.getThreesMade();
        this.threesAttempted = player1.getThreesAttempted();
        this.threePointPercentage = player1.getThreePointPercentage();
        this.freeThrowsMade = player1.getFreeThrowsMade();
        this.freeThrowsAttempted = player1.getFreeThrowsAttempted();
        this.freeThrowPercentage = player1.getFreeThrowPercentage();
        this.player = player1.getPlayer();
        this.position = player1.getPosition();
        this.team = player1.getTeam();
    }




    // constructor
    public NBAPlayer(int playerID, int gamesPlayed, int gamesStarted,
                     double minutesPerGame, double pointsPerGame, int fieldGoalsMade,
                     int fieldGoalsAttempted, double fieldGoalPercentage, int threesMade,
                     int threesAttempted, double threePointPercentage, int freeThrowsMade,
                     int freeThrowsAttempted, double freeThrowPercentage, String player,
                     String position, String team){


        this.playerID = playerID;
        this.gamesPlayed = gamesPlayed;
        this.gamesStarted = gamesStarted;
        this.minutesPerGame = minutesPerGame;
        this.pointsPerGame = pointsPerGame;
        this.fieldGoalsMade = fieldGoalsMade;
        this.fieldGoalsAttempted = fieldGoalsAttempted;
        this.fieldGoalPercentage = fieldGoalPercentage;
        this.threesMade = threesMade;
        this.threesAttempted = threesAttempted;
        this.threePointPercentage = threePointPercentage;
        this.freeThrowsMade = freeThrowsMade;
        this.freeThrowsAttempted = freeThrowsAttempted;
        this.freeThrowPercentage = freeThrowPercentage;
        this.player = player;
        this.position = position;
        this.team = team;
    }


    // method to convert an NBAPlayer object to a string
    @Override public String toString() {
        String playerInfo;
        playerInfo = "Player ID: " + playerID  + ", Games Played: " + gamesPlayed + ", Games Started: " + gamesStarted
                + ", Minutes Per Game: " + minutesPerGame + ", Points per Game: " + pointsPerGame +
                ", Field Goals Made: " + fieldGoalsMade + ", Field Goals Attempted: " + fieldGoalsAttempted +
                ", Field Goal Percentage: " + fieldGoalPercentage + ", Threes Made: " + threesMade +
                ", Threes Attempted: " + threesAttempted + ", Three Point Percentage: " + threePointPercentage + ", Free Throws Made: " +
                freeThrowsMade + ", Free Throws Attempted: " + freeThrowsAttempted + ", Free Throw Percentage: " + freeThrowPercentage +
                ", Player: " + player + ", Position: " + position + ", Team: " + team;
        return playerInfo;
    }

    // returns true if every field is identical, false otherwise
    public boolean equals(NBAPlayer otherPlayer){
        if (this.playerID != otherPlayer.getPlayerID()){
            return false;
        }
        if (this.gamesPlayed != otherPlayer.getGamesPlayed()){
            return false;
        }
        if (this.gamesStarted != otherPlayer.getGamesStarted()){
            return false;
        }
        if (this.minutesPerGame != otherPlayer.getMinutesPerGame()){
            return false;
        }
        if (this.pointsPerGame != otherPlayer.getPointsPerGame()){
            return false;
        }
        if (this.fieldGoalsMade != otherPlayer.getFieldGoalsMade()){
            return false;
        }
        if (this.fieldGoalsAttempted != otherPlayer.getFieldGoalsAttempted()){
            return false;
        }
        if (this.fieldGoalPercentage != otherPlayer.getFieldGoalPercentage()){
            return false;
        }
        if (this.threesMade != otherPlayer.getThreesMade()){
            return false;
        }
        if (this.threesAttempted != otherPlayer.getThreesAttempted()){
            return false;
        }
        if (this.threePointPercentage != otherPlayer.getThreePointPercentage()){
            return false;
        }
        if (this.freeThrowsMade != otherPlayer.getFreeThrowsMade()){
            return false;
        }
        if (this.freeThrowsAttempted != otherPlayer.getFreeThrowsAttempted()){
            return false;
        }
        if (this.freeThrowPercentage != otherPlayer.getFreeThrowPercentage()){
            return false;
        }
        if (this.player != otherPlayer.getPlayer()){
            return false;
        }
        if (this.position != otherPlayer.getPosition()){
            return false;
        }
        if (this.team != otherPlayer.getTeam()){
            return false;
        }
        return true;
    }

    // returns -1 if player is less than parameter player, 0 if equal, and 1 if greater
    // comparison based on field goal percentage

    public int compareTo(NBAPlayer otherPlayer){

        if (equals(otherPlayer)){
            return 0;
        }

        else if (this.fieldGoalPercentage < otherPlayer.getFieldGoalPercentage()){
            return -1;
        }
        else {
            return 1;
        }
    }



    // getters for every field
    public int getPlayerID(){
        return playerID;
    }
    public int getGamesPlayed(){
        return gamesPlayed;
    }
    public int getGamesStarted(){
        return gamesStarted;
    }
    public double getMinutesPerGame() {
        return minutesPerGame;
    }
    public double getPointsPerGame() {
        return pointsPerGame;
    }
    public int getFieldGoalsMade(){
        return fieldGoalsMade;
    }
    public int getFieldGoalsAttempted() {
        return fieldGoalsAttempted;
    }
    public double getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }
    public int getThreesMade() {
        return threesMade;
    }
    public int getThreesAttempted (){
        return threesAttempted;
    }
    public double getThreePointPercentage() {
        return threePointPercentage;
    }
    public int getFreeThrowsMade() {
        return freeThrowsMade;
    }
    public int getFreeThrowsAttempted() {
        return freeThrowsAttempted;
    }
    public double getFreeThrowPercentage() {
        return freeThrowPercentage;
    }
    public String getPlayer() {
        return player;
    }
    public String getPosition() {
        return position;
    }
    public String getTeam() {
        return team;
    }




}

