package ro.ibm.bootcamp2021.ATMCore;

public class InputRequest extends GeneralRequest{

    MenuOptions option;

    public InputRequest(MenuOptions option) {
        super(0.0, null);
        this.option = option;
    }

    public InputRequest(Double amount, CurrencyType currencyType) {
        super(amount, currencyType);
    }

    @Override
    public String toString() {
        return "InputRequest{" +
                "amount=" + amount +
                ", currencyType=" + currencyType +
                '}';
    }

    public MenuOptions getOption() {
        return option;
    }

    public void setOption(MenuOptions option) {
        this.option = option;
    }
}
