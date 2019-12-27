package view;

public class MenuViews {
    public static void loginMenuAllowsCommandError(){
        System.out.println("Login menu Error: Please enter a correct command!");
        System.out.println("For more information, select help");
    }
    public static void loginMenuHelp(){
        System.out.println("crate account --> creates a new account");
        System.out.println("login --> login to your account to enter Main menu");
        System.out.println("leaderboard --> shows leaderboard");
    }
}
