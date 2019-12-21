package view;

import java.util.Scanner;

public class LoginMenuViews {
    public static void askForUsername(){
        System.out.println("Please enter a username:");
    }
    public static void askForPassword(){
        System.out.println("Please enter a password:");
    }
    public static String scanUsername(Scanner scanner) {
        return scanner.nextLine() ;
    }
    public static void userNotFoundError(){
        System.out.println("Error: user not found! please write a correct username.");
    }
    public static void wrongPasswordError(){
        System.out.println("Error: wrong password");
    }
    public static String scanPassword(Scanner scanner) {
        return scanner.nextLine() ;
    }
    public static void accountExistsError(){
        System.out.println("Error: an account with this username exists, Please choose another username!");
    }
}
