
public class TennisGame1 implements TennisGame {

    private int pointPlayer1 = 0;
    private int pointPlayer2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void addPointToAPlayer(String playerName) {
        if (playerName == "player1")
            pointPlayer1 += 1;
        else
            pointPlayer2 += 1;
    }

    public String showScoreOfTheMatch() {
        String score = "";
        if (equalScore(pointPlayer1, pointPlayer2)) {
            if (pointPlayer1 > 2) {
                score = "Deuce";
            } else {
                score = setScore(pointPlayer1) + "-All";
            }
        } else if (isAdvantageOrWin()) {
            score = setAdvantageOrWin();
        } else {
            score = setScore(pointPlayer1) + "-" + setScore(pointPlayer2);
        }
        return score;
    }

    private String setAdvantageOrWin() {
        String score;
        int minusResult = pointPlayer1 - pointPlayer2;
        if (minusResult > 0) {
            switch (minusResult) {
                case 1:
                    score = "Advantage player1";
                    break;
                default:
                    score = "Win for player1";
            }
        } else {
            switch (minusResult) {
                case -1:
                    score = "Advantage player2";
                    break;
                default:
                    score = "Win for player2";
            }
        }
        return score;
    }

    private String setScore(int pointPlayer) {
        String score;
        switch (pointPlayer) {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
            default:
                score = "Forty";
                break;
        }
        return score;
    }

    private boolean equalScore(int scorePlayer1, int scorePlayer2) {
        return scorePlayer1 == scorePlayer2;
    }

    private boolean isAdvantageOrWin() {
        return pointPlayer1 >= 4 || pointPlayer2 >= 4;
    }

}
