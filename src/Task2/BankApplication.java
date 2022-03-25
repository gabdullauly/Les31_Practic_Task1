/*
Create a BankApplication class with parameters:
- String name;
- ArrayList <Account> accounts;
+ void addAccount (Account a); // Adds a new Account object
+ void removeAccount (int i); // Removes the object from the list at index
+ Account getMaxAccount (); // Returns the Account object with the highest balance
+ double getAverageBalance (); // Returns the average user balance
+ double getTotalBalance (); // Returns the amount of users balance
+ int totalAccounts (); // Returns the number of users
+ String getBankData (); // Returns the bank name, number of accounts, balance amount and average balance value
 */

package Task2;

import java.util.ArrayList;

public class BankApplication {
    private String name;
    private ArrayList<Account> accounts;
    public BankApplication(){}
    public BankApplication(String name, ArrayList<Account> accounts){
        this.name = name;
        this.accounts = accounts;
    }
    public String getName(){
        return name;
    }
    public ArrayList<Account> getAccounts(){
        return accounts;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAccounts(ArrayList<Account> accounts){
        this.accounts = accounts;
    }
    public void addAccount (Account account){
        accounts.add(account);
    }
    public void removeAccount (int index){
        accounts.remove(index);
    }
    public Account getMaxAccount (){
        double maxBalance = 0;
        Account maxAccount = new Account();
        for (Account account : accounts) {
            if (account.getBalance() > maxBalance) {
                maxBalance = account.getBalance();
                maxAccount = account;
            }
        }
        return maxAccount;
    }
    public double getAverageBalance (){
        double averageBalance = 0;
        for (Account account : accounts) {
            averageBalance = averageBalance + account.getBalance();
        }
        return averageBalance/ accounts.size();
    }
    public double getTotalBalance (){
        double totalBalance = 0;
        for (Account accounts: accounts) {
            totalBalance = totalBalance + accounts.getBalance();
        }
        return totalBalance;
    }
    public int totalAccounts (){
        return accounts.size();
    }
    public String getBankData(){
        String s = name+"\n";
        for (Account accounts: accounts) {
            s = s+accounts.getId()+" "+accounts.getName()+" "+accounts.getSurname()+" "+accounts.getBalance()+"\n";
        }
        return s;
    }
}
