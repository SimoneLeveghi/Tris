public enum Player {
    PLAYER1(1),
    PLAYER2(-1);

    private int value;
    private Player(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
