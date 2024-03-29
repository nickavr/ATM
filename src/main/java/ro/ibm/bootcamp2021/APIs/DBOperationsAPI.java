package ro.ibm.bootcamp2021.APIs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ro.ibm.bootcamp2021.ATMCore.ATMCore;
import ro.ibm.bootcamp2021.ATMCore.ExchangeRates.ExchangeRate;
import ro.ibm.bootcamp2021.AccountCore.Account;
import ro.ibm.bootcamp2021.Exceptions.NullAccountException;
import ro.ibm.bootcamp2021.Exceptions.UnknownPINException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DBOperationsAPI {
    private static List<Account> accountList = new ArrayList<>();
    private static List<ExchangeRate> exchangeRates = new ArrayList<>();
    private static List<String> ATMtransactions = new ArrayList<>();
    private static ATMCore atmCore;
    static Type accountListType;
    static Type ratesListType;
    static final String atmTransactions = "C:\\Users\\ZZ02SR826\\JAVApractice\\ATM\\src\\main\\resources\\ATMTransactions.txt";
    static final String clientsFilePath = "C:\\Users\\ZZ02SR826\\JAVApractice\\ATM\\src\\main\\resources\\clients.txt";
    static final String ratesFilePath = "C:\\Users\\ZZ02SR826\\JAVApractice\\ATM\\src\\main\\resources\\currencies.txt";
    static final String ATMValuesFilePath = "C:\\Users\\ZZ02SR826\\JAVApractice\\ATM\\src\\main\\resources\\ATMValues.txt";

    //retrieving all accounts
    static{
        try {
            String clientsFileData = loadFileDataInString(clientsFilePath);
            String ratesFileData = loadFileDataInString(ratesFilePath);
            String ATMValuesFileData = loadFileDataInString(ATMValuesFilePath);

            accountListType = new TypeToken<ArrayList<Account>>(){}.getType();
            ratesListType = new TypeToken<ArrayList<ExchangeRate>>(){}.getType();

            Gson gsonParser = new Gson();

            accountList = gsonParser.fromJson(clientsFileData, accountListType);
            exchangeRates = gsonParser.fromJson(ratesFileData, ratesListType);
            atmCore = gsonParser.fromJson(ATMValuesFileData, ATMCore.class);

            System.out.println(atmCore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadFileDataInString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void rewriteAccountsFileData() throws IOException {
        String clientsFileData = new Gson().toJson(accountList, accountListType);
        FileWriter writer = new FileWriter(clientsFilePath, false);
        writer.write(clientsFileData);
        writer.close();
        rewriteATMValues();
    }

    public static void rewriteATMValues() throws IOException {
        String atmFileData = new Gson().toJson(atmCore, ATMCore.class);
        FileWriter writer = new FileWriter(ATMValuesFilePath, false);
        writer.write(atmFileData);
        writer.close();
    }

    public static void addNewTransactionToFile(String transaction) throws IOException {
        try(FileWriter fw = new FileWriter(atmTransactions, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(transaction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList getAllTransactions(){
        try(FileReader fr = new FileReader(atmTransactions)) {
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                ATMtransactions.add(line);
                line = br.readLine();
            }
            br.close();
            return (ArrayList) ATMtransactions;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UnsupportedOperationException("Transactions could not be read");
    }

    public static ATMCore getAtmCore(){
        if(atmCore != null){
            return atmCore;
        }
        throw new UnsupportedOperationException();
    }

    public static List<Account> getAccountList() {
        if(accountList == null){
            throw new UnsupportedOperationException();
        }
        return accountList;
    }

    public static List<ExchangeRate> getExchangeRates() {
        if(exchangeRates == null){
            throw new UnsupportedOperationException();
        }
        return exchangeRates;
    }

    public static Account searchAccount(Integer CVV, Integer PIN) throws NullAccountException {
        if(accountList == null){
            throw new UnsupportedOperationException();
        }
        for (Account a : accountList) {
            if(a.getCVV().intValue() == CVV.intValue() && a.getPIN().intValue() == PIN.intValue()){
                return a;
            }
        }
        throw new NullAccountException();
    }
}
