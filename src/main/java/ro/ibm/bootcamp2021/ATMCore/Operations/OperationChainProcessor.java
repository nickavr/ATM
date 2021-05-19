package ro.ibm.bootcamp2021.ATMCore.Operations;

import ro.ibm.bootcamp2021.ATMCore.Operations.Common.ConvertRequestCurrencyProcess;
import ro.ibm.bootcamp2021.ATMCore.Operations.Common.MenuDisplay;
import ro.ibm.bootcamp2021.ATMCore.Operations.Deposit.DepositIntoAccount;
import ro.ibm.bootcamp2021.ATMCore.Operations.Exchange.ExchangeAmount;
import ro.ibm.bootcamp2021.ATMCore.Operations.Retrieve.GetAmountFromDeposit;

public class OperationChainProcessor {

    static AbstractRequestHandler convertRequest = new ConvertRequestCurrencyProcess();
    static AbstractRequestHandler depositAmount = new DepositIntoAccount();
    static AbstractRequestHandler menuDisplay = new MenuDisplay();
    static AbstractRequestHandler retrieveAmount = new GetAmountFromDeposit();
    static AbstractRequestHandler exchangeAmount = new ExchangeAmount();

    public static void setSoldInterrogationProcess(AbstractRequestHandler requestHandler){
        if(requestHandler != null){
            requestHandler.setNextProcess(menuDisplay);
        }
    }

    public static void setDepositAmountProcess(AbstractRequestHandler requestHandler){
        if(requestHandler != null){
            convertRequest.setNextProcess(depositAmount);
            depositAmount.setNextProcess(menuDisplay);
            requestHandler.setNextProcess(convertRequest);
        }
    }

    public static void setRetrieveAmountProcess(AbstractRequestHandler requestHandler){
        if(requestHandler != null){
            retrieveAmount.setNextProcess(menuDisplay);
            requestHandler.setNextProcess(retrieveAmount);
        }
    }

    public static void setExchangeAmountProcess(AbstractRequestHandler requestHandler){
        if(requestHandler != null){
            convertRequest.setNextProcess(exchangeAmount);
            exchangeAmount.setNextProcess(menuDisplay);
            requestHandler.setNextProcess(convertRequest);
        }
    }
}
