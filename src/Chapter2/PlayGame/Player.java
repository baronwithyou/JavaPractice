package Chapter2.PlayGame;

public class Player {
    private int number = 0;
    public int guess()
    {
        number = (int)(Math.random() * 10);
        return number;
    }
}
