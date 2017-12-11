package HeadFirst.Chapter14;

import java.io.Serializable;

public class GameCharacter implements Serializable{
    private int power;
    private String type;
    private String[] weapon;

    public GameCharacter(int power, String type) {
        this.power = power;
        this.type = type;
    }

    // 构造函数不能加上void，否则会出错
    public GameCharacter(int power, String type, String []weapon) {
        this.power = power;
        this.type = type;
        this.weapon = weapon;
    }

    public String getType() {
        return type;
    }
}
