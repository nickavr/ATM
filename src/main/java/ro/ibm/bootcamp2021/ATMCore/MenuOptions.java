package ro.ibm.bootcamp2021.ATMCore;

public enum MenuOptions {
    INTEROGARE_SOLD(0), RETRAGERE(1), DEPUNERE(2), EXCHANGE(3);

    private Integer operationCode;
    MenuOptions(Integer code) {
        operationCode = code;
    }

    public Integer getOperationCode() {
        return operationCode;
    }
}
