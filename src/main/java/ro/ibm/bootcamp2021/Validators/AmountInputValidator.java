package ro.ibm.bootcamp2021.Validators;

public interface AmountInputValidator {
    static boolean amountInputValidator(String receivedAmount){
        //TODO: validate input
//        String amountStringFormat ="-?(\\d{1,10}\\s*?([.,]|$|\\s)\\s*?)+€?";
//        return receivedAmount.matches(amountStringFormat);
        return true;
    }
}
