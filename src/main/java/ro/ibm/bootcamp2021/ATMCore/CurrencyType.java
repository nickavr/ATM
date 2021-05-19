package ro.ibm.bootcamp2021.ATMCore;

public enum CurrencyType {
    RON("RON"), EURO("€"), DOLLAR("$");

    private String currencySign;

    CurrencyType(String currencySign) {
        this.currencySign = currencySign;
    }

    public String getCurrencySign() {
        return currencySign;
    }


    public static CurrencyType getCurrencyWithCode(String currencyCode){
        for(CurrencyType currency: CurrencyType.values()){
            if(currency.toString().equals(currencyCode)){
                return currency;
            }
        }
        throw new UnsupportedOperationException();
    }

    public static CurrencyType getCurrencyWithSign(String currencySign){
        for(CurrencyType currency: CurrencyType.values()){
            if(currency.getCurrencySign().equals(currencySign)){
                return currency;
            }
        }
        throw new UnsupportedOperationException();
    }
}
