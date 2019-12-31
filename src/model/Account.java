package model;

import com.gilecode.yagson.YaGson;
import model.PlayerTypes.DayAndWaterPlayer;
import model.PlayerTypes.Player;
import view.AccountViews;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Account implements Serializable {
    private static ArrayList<Account> accounts = new ArrayList<>();

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    private String username;
    private String password;
    private int gameCoins = 0;
    private int shopCoins = 0;
    private Collection collection;
    private int zombiesKilled = 0;
    private Player player;

    public static void deleteAccount(Scanner scanner) throws IOException {
        AccountViews.askForUsername();
        String username = AccountViews.scanUsername(scanner);
        Account account = Account.getAccountByUsername(username);
        if (account == null) {
            AccountViews.userNotFoundError();
            return;
        }
        AccountViews.askForPassword();
        String password = AccountViews.scanPassword(scanner);
        if (Account.passwordMatchesAccount(account, password)) {
            accounts.remove(account);
            saveAccounts();
        } else {
            AccountViews.wrongPassowrdError();
        }
    }

    public static void createUser(Scanner scanner) throws IOException {
        AccountViews.askForUsername();
        String username = AccountViews.scanUsername(scanner);
        for (Account account :
                accounts) {
            if (account.getUsername().equals(username)) {
                AccountViews.accountExistsError();
                return;
            }
        }
        AccountViews.askForPassword();
        String password = AccountViews.scanPassword(scanner);
        Account newAccount = new Account(username, password);
        accounts.add(newAccount);
        AccountViews.accountCreateSuccesfully();
        saveAccounts();
    }

    public static Account login(Scanner scanner) {
        AccountViews.askForUsername();
        String username = AccountViews.scanUsername(scanner);
        Account account = Account.getAccountByUsername(username);
        if (account == null) {
            AccountViews.userNotFoundError();
            return null;
        }
        AccountViews.askForPassword();
        String password = AccountViews.scanPassword(scanner);
        if (!account.passwordMatches(password)) {
            AccountViews.wrongPasswordError();
            return null;
        }
        AccountViews.loginSuccesfull();
        return account;
    }


    public boolean passwordMatches(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public static boolean passwordMatchesAccount(Account account, String password) {
        if (account.getPassword() == password) return true;
        else return false;
    }


    public Player getPlayer() {
        return player;
    }

    public static void saveAccounts() throws IOException {
        YaGson gson = new YaGson();
        FileWriter fileWriter = new FileWriter("src/model/Accounts.json" , false);
        for (Account account :
                accounts) {
            gson.toJson(account, fileWriter);
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    public static Account getAccountByUsername(String username) {
        for (Account account :
                accounts) {
            if (account.username.equals(username)) {
                return account;
            }
        }
        return null;
    }

    public int getShopCoins() {
        return shopCoins;
    }

    public Collection getCollection () {
        return collection ;
    }


    public static ArrayList<Account> getAccounts() {
        sortAccountsByZombiesKilled();
        return accounts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public int getZombiesKilled(){
        return zombiesKilled;
    }

    public void setPassword(String username) {
        this.password = password;
    }

    private static void sortAccountsByZombiesKilled(){
        accounts.sort(Comparator.comparing(Account::getZombiesKilled));
    }

    public void setPlayer(Player player){
        this.player = player;
    }
}
