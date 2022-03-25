/*
In the main class Main, create BankApplication object, add 5 new accounts each, with different balances.
And call all methods
 */

package Task2;

import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account(111, "Aisana", "Miss", 120125.22));
        accounts.add(new Account(222, "Ainazar", "Tigr", 220125.33));
        accounts.add(new Account(333, "Zhandos", "Daddy", 320125.44));
        accounts.add(new Account(444, "Samal", "Mammy", 330125.12));
        accounts.add(new Account(555, "Tanya", "GrandMa", 430125.66));
        BankApplication bankApplication = new BankApplication("Kaspi", accounts);

        System.out.println(bankApplication.getBankData());

        Account account = new Account(666, "Leo", "Messi", 333444.11);
        bankApplication.addAccount(account);
        System.out.println(bankApplication.getBankData());

        bankApplication.removeAccount(1);
        System.out.println(bankApplication.getBankData());

        System.out.println(bankApplication.getMaxAccount());

        System.out.println("Средний баланс: "+bankApplication.getAverageBalance());

        System.out.println("Общая сумма баланса: "+bankApplication.getTotalBalance());

        System.out.println("Количество аккаунтов; "+bankApplication.totalAccounts());


    }
}
