package ro.ibm.bootcamp2021.APIs;

import ro.ibm.bootcamp2021.AccountCore.Account;
import ro.ibm.bootcamp2021.AccountCore.AccountSecurityActions;
import ro.ibm.bootcamp2021.Exceptions.NullAccountException;
import ro.ibm.bootcamp2021.Exceptions.UnknownCVVCodeException;
import ro.ibm.bootcamp2021.Exceptions.UnknownPINException;

import java.util.Scanner;

public class AuthentificationAPI {

    private static Account account = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void beginSession(){
        try{
            Integer CVV = inputCVV();
            Integer PIN = inputPIN();
            account = DBOperationsAPI.searchAccount(CVV, PIN);
            System.out.println("Welcome, " + account.getFirstName() + ' ' + account.getLastName());
        } catch (UnknownCVVCodeException | UnknownPINException | NullAccountException e) {
            e.printStackTrace();
        }
    }

    public static Account getAccount() {
        if(account != null){
            return account;
        }
        throw new UnsupportedOperationException();
    }

    private static Integer inputCVV() throws UnknownCVVCodeException {
        System.out.println("Input your CVV: ");
        Integer CVV = scanner.nextInt();
        AccountSecurityActions.checkCVVCode(CVV);
        return CVV;
    }

    private static Integer inputPIN() throws UnknownPINException {
        System.out.println("Input PIN: ");
        Integer PIN = scanner.nextInt();
        AccountSecurityActions.checkPIN(PIN);
        return PIN;
    }
}
