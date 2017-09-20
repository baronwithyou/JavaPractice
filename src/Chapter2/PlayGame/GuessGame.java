package Chapter2.PlayGame;

public class GuessGame {
    public void startGame()
    {
        int guess1;
        int result = (int)(Math.random() * 10);
        Player guesser1 = new Player();
        do {
            guess1 = guesser1.guess();
            System.out.println("Player1 is guessing " + guess1 + ", But it is wrong");
        } while (result != guess1);
        System.out.println("The result is " + result + ", And Player have a right answer " + guess1);
    }
}
