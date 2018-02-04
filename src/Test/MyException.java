package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Exception;

public class MyException {
    public static void main(String []args) {
//        try {
//            File f = new File("MySong.txt");
//            new FileInputStream(f);
//            System.out.println("成功打开");
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date d = sdf.parse("2016-06-");
//        } catch (FileNotFoundException | ParseException e) {
//            if (e instanceof FileNotFoundException)
//                System.out.println("MySong.txt不存在");
//            if (e instanceof ParseException)
//                System.out.println("日期格式解析错误");
//
//            e.printStackTrace();
//        }
        Account account = new Account(200);
        try {
            account.withdraw(300);
            System.out.println("账户余额为" + account.getBalance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}

class Account{
    double balance;
    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public void withdraw(double amt) throws OverdraftException{
        if (balance < amt)
            throw new OverdraftException("账户已透支");// 如果抛出异常，后面的代码将不会执行
        balance -= amt;
    }

    class OverdraftException extends java.lang.Exception {
        OverdraftException() { }

        OverdraftException(String msg) {
            super(msg);
        }
    }
}
