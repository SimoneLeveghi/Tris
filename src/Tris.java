public class Tris {
    private int[][] grid = new int[3][3];
    private Player currentPlayer;

    public Tris(Player firstPlayer) {
        this.currentPlayer = firstPlayer;
    }

    private void switchPlayer() {
        if(currentPlayer == Player.PLAYER1) {
            currentPlayer = Player.PLAYER2;
        }
        else {
            currentPlayer = Player.PLAYER1;
        }
    }

    public boolean place(int i, int j) {
        if(!(i >= 0 && i < 3 && j >= 0 && j < 3) || (this.grid[i][j] != 0 || isGameOver())) return false;

        this.grid[i][j] = currentPlayer.getValue();
        switchPlayer();

        return true;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public Player getGameWinner() {
        int gameStatus = 0;

        for(int[] row : grid) {
            int orizSum = 0;
            for(int cell : row) {
                orizSum += cell;
            }

            if(Math.abs(orizSum) == 3) {
                gameStatus = orizSum % 2;
            }
        }

        for(int i = 0; i < grid.length; ++i) {
            int vertSum = 0;
            for(int j = 0; j < grid[i].length; ++j) {
                vertSum += this.grid[j][i];
            }

            if(Math.abs(vertSum) == 3) {
                gameStatus = vertSum % 2;
            }
        }

        int leftDiagSum = 0;
        for(int i = 0; i < grid.length; ++i) {
            leftDiagSum += grid[i][i];
        }
        if(Math.abs(leftDiagSum) == 3) {
            gameStatus = leftDiagSum % 2;
        }

        int rightDiagSum = 0;
        for(int i = 0; i < grid.length; ++i) {
            rightDiagSum += grid[2 - i][i];
        }
        if(Math.abs(rightDiagSum) == 3) {
            gameStatus = rightDiagSum % 2;
        }

        if(gameStatus == 1) {
            return Player.PLAYER1;
        }
        else if(gameStatus == -1) {
            return Player.PLAYER2;
        }
        return null;
    }

    public boolean isGameOver() {
        boolean gameOver = true;

        if(getGameWinner() == null) {
            for (int[] row : this.grid) {
                for(int cell : row) {
                    if(cell == 0) {
                        gameOver = false;
                    }
                }
            }
        }

        return gameOver;
    }

    public void resetGame() {
        Player winnerPlayer;
        if((winnerPlayer = getGameWinner()) != null) {
            if(winnerPlayer == Player.PLAYER1) {
                currentPlayer = Player.PLAYER2;
            }
            else {
                currentPlayer = Player.PLAYER1;
            }
        }
        this.grid = new int[3][3];
    }
}

