package Test;

public class SimplifyPath {
    public static String[] getSplitString(String string) {
        // split通过正则表达式来分割字符串
        return string.split("/+");
    }

    public static void main(String []args) {
        String []tmp = getSplitString("/a/./b/../../c/");
        for (String item : tmp) {
            System.out.println(item);
        }
    }
}
