package gmo.cashregister.entity.market.order.type;

public enum Type {
    EAT_HERE("01"),
    TOGO("02"),
    DELIVERY("03");

    private String code;

    Type(String code) {
        this.code = code;
    }


    public String getCode() {
        return code;
    }
}
