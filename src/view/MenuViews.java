package view;

public class MenuViews {
    public static void loginMenuAllowsCommandError() {
        System.out.println("Login menu Error: Please enter a valid command!");
        System.out.println("For more information, enter help");
    }

    public static void loginMenuHelp() {
        System.out.println("crate account --> creates a new account");
        System.out.println("login --> login to your account to enter Main menu");
        System.out.println("leaderboard --> shows leaderboard");
        System.out.println("exit --> exits program");
    }

    public static void leaderboardAllowsCommandError() {
        System.out.println("Leaderboard Error: Please enter a valid command!");
        System.out.println("For more information, enter help");
    }

    public static void leaderboardHelp(){
        System.out.println("show --> shows Learboard by number of zombies killed");
        System.out.println("exit --> goes to Login menu");
    }
}
