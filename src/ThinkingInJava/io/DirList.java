package ThinkingInJava.io;

import java.io.*;

public class DirList {
    public static void main(String []args) {
        File path = new File("./string");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
    }
}

class DirFilter implements FilenameFilter {

    public DirFilter(String regex) {

    }

    @Override
    public boolean accept(File dir, String name) {
        return false;
    }
}