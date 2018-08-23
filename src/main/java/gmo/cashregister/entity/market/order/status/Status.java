package gmo.cashregister.entity.market.order.status;

public enum Status {
    STATUS_ADD("000"),
    STATUS_VALIDATE("001"),
    STATUS_PREPARATION("002"),
    STATUS_READY("003"),
    STATUS_INDELIVERING("004"),
    STATUS_DELIVER("005"),
    STATUS_SERVED("006"),
    STATUS_PAY("100"),
    STATUS_CANCEL("101"),
    STATUS_REPAY("102"),
    STATUS_FREE("103"),
    STATUS_CLOSE("104");

    private String code;

    Status(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
