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

    public static void mainMenuAllowsCommandError(){
        System.out.println("Main menu Error: Please enter a valid command!");
        System.out.println("For more information, enter help");
    }

    public static void mainMenuHelp(){
        System.out.println("play --> goes to Play menu");
        System.out.println("profile --> goes to profile menu");
        System.out.println("shop --> goes to shop menu");
        System.out.println("exit --> goes to login menu");
    }

    public static void profileMenuAllowsCommandError(){
        System.out.println("Profile menu Error: Please enter a valid command!");
        System.out.println("For more information, enter help");
    }

    public static void profileMenuHelp(){
        System.out.println("change --> change the logined user");
        System.out.println("delete --> delete an account");
        System.out.println("rename --> rename your username");
        System.out.println("create --> create a new account");
        System.out.println("show --> shows the username of current user");
    }

    public static void collectionMenuAllowsCommandError(){
        System.out.println("Collection menu Error: Please enter a valid command!");
        System.out.println("For more information, enter help");
    }

    public static void collectionMenuHelp(){
        System.out.println("show hand --> shows selected cards");
        System.out.println("show  collection --> Show unselected cards");
        System.out.println("select [name] --> Select a card to add it to hand");
        System.out.println("remove [name] --> Remove a card from your hand");
        System.out.println("play --> start the game");
    }
    public static void plants(){
        System.out.println("Plants:");
    }
    public static void zombies(){
        System.out.println("Zombies:");
    }
    public static void cardDoenstExistsError(){
        System.out.println("Error: Card doesn't exists!");
    }

    public static void notEnoughMoneyError(){
        System.out.println("Error: not enough money!");
    }

    public static void shopMenuHelp(){
        System.out.println("show shop --> shows cards that you didn't buy yet!");
        System.out.println("show collection --> shows your own cards");
        System.out.println("buy [name] --> buy a new card");
        System.out.println("money --> shows your money");
    }

    public static void shopMenuAllowsCommandError(){
        System.out.println("Shop menu Error: Please enter a valid command!");
        System.out.println("For more information, enter help");
    }
}
