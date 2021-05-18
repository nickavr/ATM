package ro.ibm.bootcamp2021.APIs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ro.ibm.bootcamp2021.AccountCore.Account;
import ro.ibm.bootcamp2021.Exceptions.UnknownPINException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DBOperationsAPI {
    private static List<Account> accountList = new ArrayList<>();

    //retrieving all accounts
    static{
        try {
            String fileData = loadFileDataInString("C:\\Users\\ZZ02SR826\\JAVApractice\\ATM\\src\\main\\resources\\clients.txt");

            Type accountListType = new TypeToken<ArrayList<Account>>(){}.getType();
            accountList = new Gson().fromJson(fileData, accountListType);
            System.out.println(accountList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadFileDataInString(String fileName) throws IOException {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static List<Account> getAccountList() {
        if(accountList == null){
            throw new UnsupportedOperationException();
        }
        return accountList;
    }

    public static Account searchAccount(Integer CVV, Integer PIN) throws UnknownPINException {
        Account account = null;

        for (Account a : accountList) {
            if(a.getCVV() == CVV && a.getPIN() == PIN){
                account = a;
            }
        }

        if(account == null){
            throw new UnknownPINException();
        }

        return account;
    }
}
