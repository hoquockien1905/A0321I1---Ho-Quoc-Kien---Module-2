package bai_8_clean_code_va_refactoring.bai_tap;

public class KataTennis {

    public static final int FOUR = 4;

    public static void main(String[] args) {
        System.out.println(getScore("John", "Peter", 0, 3));
    }

    public static String getScore(String firstPlayerName, String secondPlayerName, int scoreOfFirstPlayer, int scoreOfSecondPlayer) {
        String score = "";
        int tempScore = 0;
        boolean isEqualPoint = scoreOfFirstPlayer == scoreOfSecondPlayer;
        if (isEqualPoint) {
            return getStringOfEqualPoint(scoreOfFirstPlayer);
        } else if (isGreaterOrEqualFour(scoreOfFirstPlayer, scoreOfSecondPlayer)) {
            return getWinningPlayer(getMinusResult(scoreOfFirstPlayer, scoreOfSecondPlayer));
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) {
                    tempScore = scoreOfFirstPlayer;
                } else {
                    score += "-";
                    tempScore = scoreOfSecondPlayer;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }

    public static int getMinusResult(int scoreOfFirstPlayer, int scoreOfSecondPlayer) {
        return scoreOfFirstPlayer - scoreOfSecondPlayer;
    }

    public static boolean isGreaterOrEqualFour(int scoreOfFirstPlayer, int scoreOfSecondPlayer) {
        return scoreOfFirstPlayer >= FOUR || scoreOfSecondPlayer >= FOUR;
    }

    public static String getWinningPlayer(int minusResult) {
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    public static String getStringOfEqualPoint(int scoreOfFisrtPlayer) {
        switch (scoreOfFisrtPlayer) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
}

