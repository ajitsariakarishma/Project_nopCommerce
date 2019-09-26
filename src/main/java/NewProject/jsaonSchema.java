package NewProject;

import java.sql.SQLOutput;
import java.util.Scanner;



public class jsaonSchema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.next();
        name = name.trim().replaceAll("[^a-zA-Z]", "#");
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
    }





