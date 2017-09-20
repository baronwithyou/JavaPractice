package Chapter2;

public class first {
    public static void main(String[] args) {
//        创建数组
        String[] languageList = {
            "Javascript", "PHP", "Java", "C"
        };
        int languageCount = languageList.length;
//        Math.random()返回[0, 1)的随机数
        int languageRandom = (int)(Math.random() * languageCount);
        System.out.println(Math.random());
        System.out.println(languageList[languageRandom]);
    }
}
