package ro.ibm.bootcamp2021.ATMCore;

public class InputRequest {
    Double amount;
    CurrencyType currencyType;
    MenuOptions option;

    public InputRequest(MenuOptions option) {
        this.option = option;
    }

    public InputRequest(Double amount, CurrencyType currencyType) {
        this.amount = amount;
        this.currencyType = currencyType;
    }

    @Override
    public String toString() {
        return "InputRequest{" +
                "amount=" + amount +
                ", currencyType=" + currencyType +
                '}';
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public Double getAmount() {
        return amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public MenuOptions getOption() {
        return option;
    }

    public void setOption(MenuOptions option) {
        this.option = option;
    }
}
