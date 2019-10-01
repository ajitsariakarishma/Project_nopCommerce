package NewProject;

import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;


public class jsaonSchema {

    public static boolean isWord(String name)
    {
        return Pattern.matches("^[a-zA-z]{3,10}$",name);
    }


    public static void method1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.next();
        //boolean ans = Pattern.matches("D*",name);
        //System.out.println(ans);

        name = name.trim().replaceAll("[^a-zA-Z]{3,7}", "#");
        char ch[] = name.toCharArray();
        int i = 0;
        for (char x : ch) {
            switch (x) {
                case '#':
                    i++;
                    break;
            }
        }
        if (i > 0) {
            System.out.println("Enter a valid name only letters are allowed");}
            else if (name.length() < 3) {
                System.out.println("enter a valid name");
            } else if (name.length() > 16) {
                System.out.println("enter a valid name");
            }
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.next();
        if(isWord(name)==false){
            System.out.println("input valid name");
        }else{
            System.out.println("valid entry");
        }
      //if using test NG then can use assertion as follow
        //Assert.AssertTrue(isWord,"Name entered is not valid");
    }


    }





