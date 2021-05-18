package ro.ibm.bootcamp2021.Validators;

public interface AmountInputValidator {
    static boolean amountInputValidator(String receivedAmount){
        String amountStringFormat ="-?(\\d{1,3}\\s*?([.,]|$|\\s)\\s*?)+€?";
        return receivedAmount.matches(amountStringFormat);
    }
}
