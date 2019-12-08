package view;

public class LoginMenuViews {
    public static void askForUsername(){
        System.out.println("Please enter a username:");
    }
    public static void askForPassword(){
        System.out.println("Please enter a password:");
    }
    public static void accountExistsError(){
        System.out.println("Error: an account with this username exists, Please choose another username!");
    }
}
