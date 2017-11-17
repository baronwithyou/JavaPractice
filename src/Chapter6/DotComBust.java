package Chapter6;

import java.util.ArrayList;

public class DotComBust {
    GameHelper helper = new GameHelper();
    ArrayList<DotCom> dotComList = new ArrayList<>();
    private int numOfGuess = 0;
    private static int test1 = 1;
    private static int test2 = 2;
    private static int test3 = 3;
    public static void main(String []args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

    private void setUpGame() {
        // 非静态方法可以调用该类的静态方法
        System.out.println(DotComBust.test(10));
        System.out.println(test1);
        DotCom one = new DotCom();
        one.setName("baidu.com");
        DotCom two = new DotCom();
        two.setName("Alibaba.com");
        DotCom three = new DotCom();
        three.setName("Tecent.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        for (DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocations = helper.placeDotCom(4);
            dotComToSet.setLocationCells(newLocations);
        }
    }

    private void startPlaying() {
        while (!dotComList.isEmpty()) {
            String userGuess = helper.getUserInput("请输入一个guess: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuess++;
        String result = "miss";
        for (DotCom dotComToCheck : dotComList) {
            result = dotComToCheck.checkYourself(userGuess);
            if (result.equals("kill"))
                dotComList.remove(dotComToCheck);
            if (!result.equals("miss"))
                break;
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("恭喜你成功击杀所有敌军" + numOfGuess);
    }

    public static String test(int test1) {
        return "This is a test" + DotComBust.test1;
    }
}
