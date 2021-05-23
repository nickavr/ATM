package ro.ibm.bootcamp2021.Admin.OperationsChain;

public class ChainProcessor {
    private static AdminAbstractRequestHandler processRequestAmount = new ProcessAdminAmount();
    private static AdminAbstractRequestHandler addAmount = new AddAmountToATM();
    private static AdminAbstractRequestHandler withdrawAmount = new WithdrawAmountFromATM();
    private static AdminAbstractRequestHandler unlockUser = new UnlockUser();
    private static AdminAbstractRequestHandler traceTransactions = new TraceATMActions();
    private static AdminAbstractRequestHandler wrongCode = new WrongCodeProcess();

    public static void setAdminProcess(AdminAbstractRequestHandler requestHandler){
        if(requestHandler != null){
            traceTransactions.setNextProcess(processRequestAmount);
            processRequestAmount.setNextProcess(addAmount);
            addAmount.setNextProcess(withdrawAmount);
            withdrawAmount.setNextProcess(wrongCode);
            requestHandler.setNextProcess(traceTransactions);
        }
    }
}
