package Chapter6;

import java.util.ArrayList;

public class DotCom {
    private String name;
    private ArrayList<String> targets;
    public void setName(String dotComName) {
        name = dotComName;
    }

    public void setLocationCells(ArrayList<String> locationCells) {
        targets = locationCells;
    }

    public String checkYourself(String guess) {
        String result = "miss";
        if (targets.contains(guess)) {
//            int index = targets.indexOf(guess);
            targets.remove(guess);
            result = "hit";
        }
        if (targets.isEmpty()) {
            System.out.println("恭喜你击沉了 " + name);
            result = "kill";
        }
        return result;
    }
}
