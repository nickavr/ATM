package ro.ibm.bootcamp2021.APIs;

import com.google.gson.Gson;
import ro.ibm.bootcamp2021.AccountCore.Account;
import ro.ibm.bootcamp2021.Exceptions.UnknownCVVCodeException;
import ro.ibm.bootcamp2021.Exceptions.UnknownPINException;

public class AuthentificationAPI {

    private static Account account = null;

    public static void beginSession(Integer CVV, Integer PIN){
        try{
            account.checkCVVCode(CVV);
            account.checkPIN(PIN);
            //TODO: read txt file and transform to json obj array
        } catch (UnknownCVVCodeException | UnknownPINException e) {
            e.printStackTrace();
        }

    }

    public static Account getAccount() {
        return account;
    }
}
