package ro.ibm.bootcamp2021.ATMCore;

import javax.lang.model.type.UnknownTypeException;

public enum MenuOptions {
    INTEROGARE_SOLD(0), RETRAGERE(1), DEPUNERE(2),
    EXCHANGE(3), END_SESSION(4);

    private Integer operationCode;
    MenuOptions(Integer code) {
        operationCode = code;
    }

    public Integer getOperationCode() {
        return operationCode;
    }

    public static MenuOptions getOptionWithCode(Integer code){
        for(MenuOptions option : MenuOptions.values()){
            if(option.getOperationCode() == code){
                return option;
            }
        }
        throw new UnsupportedOperationException();
    }
}
