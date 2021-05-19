package ro.ibm.bootcamp2021.ATMCore.Operations.Common;

import ro.ibm.bootcamp2021.APIs.DBOperationsAPI;
import ro.ibm.bootcamp2021.ATMCore.CurrencyType;
import ro.ibm.bootcamp2021.ATMCore.ExchangeRates.ExchangeRate;
import ro.ibm.bootcamp2021.ATMCore.InputRequest;
import ro.ibm.bootcamp2021.ATMCore.Operations.AbstractRequestHandler;
import ro.ibm.bootcamp2021.AccountCore.Account;

public class ConvertRequestCurrencyProcess extends AbstractRequestHandler {
    @Override
    public void handleRequest(InputRequest request, Account currentAccount) {
        if(request != null){
            request.setAmount(chooseExchangeRate(currentAccount.getAccountCurrency(), request.getCurrencyType())
                    .convertAmount(request.getAmount()));
            request.setCurrencyType(currentAccount.getAccountCurrency());
            System.out.println(request);
            if(this.getNextProcess() != null){
                this.getNextProcess().handleRequest(request, currentAccount);
            }
        }
    }

    private ExchangeRate chooseExchangeRate(CurrencyType accountCurrency, CurrencyType amountCurrency){
        for(ExchangeRate rate : DBOperationsAPI.getExchangeRates()){
            if(rate.getAmountCurrency() == amountCurrency
                    && rate.getAccountCurrency() == accountCurrency){
                return rate;
            }
        }
        throw new UnsupportedOperationException();
    }
}
