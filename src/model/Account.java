package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import control.LoginMenu;
import view.LoginMenuViews;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class Account implements Serializable {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static int idCounter = 0;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.id = idCounter;
        idCounter++;
        accounts.add(this);
    }

    //    private final String name;
    private String username;
    private String password;
    private int id;
    private int gameCoins = 0;
    private int shopCoins = 0;
    private Collection collection;
    private int zombiesKilled = 0;

    public static void deleteAccount (String username , String password) {
        Account account = Account.getAccountByUsername(username) ;
        if (account == null){
            LoginMenuViews.userNotFoundError();
            return;
        }
        if (Account.passwordMatchesAccount(account , password)) {
            accounts.remove(account) ;
            idCounter -- ;
        }
    }
    public static void createUser(Scanner scanner) {
        LoginMenuViews.askForUsername();
        String username = LoginMenuViews.scanUsername(scanner) ;
        for (Account account :
                accounts) {
            if (account.getUsername().equals(username)) {
                LoginMenuViews.accountExistsError();
                return ;
            }
        }
        LoginMenuViews.askForPassword();
        String password = LoginMenuViews.scanPassword(scanner) ;
        Account newAccount = new Account(username, password);
        accounts.add(newAccount);
//            newAccount.addToJson();
        return ;
    }


    public boolean passwordMatches(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
    }
    public boolean passwordMatchesAccount(Account account , String password) {
        if (account.getPassword() == password ) return true ;
        else return false ;
    }

    public void addToJson() {
        Gson json = new Gson();
        String objectToJson = json.toJson(this);
        System.out.println(objectToJson);
    }

    public static void saveAccount() throws FileNotFoundException {
//        Type accountType = new TypeToken<ArrayList<Account>>(){}.getType();
        System.out.println(accounts.size());
        Gson json = new Gson();
        String objectToJson = json.toJson(accounts);
        System.out.println(objectToJson);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("accounts.txt"));
        printWriter.write(objectToJson);
        printWriter.close();
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

    public static ArrayList<Account> getAccounts() {
        return accounts;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {this.username = username ;}
    public String getPassword() {return password ;}
    public void setPassword(String username) {this.password = password ;}
}
