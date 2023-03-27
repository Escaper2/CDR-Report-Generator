package eskaper2.generator.models;

public enum TypeOfTariff {
    Unlimited ("06"),
    Minute ("03"),
    Default("11");

    private final String  type;
    TypeOfTariff(String s) {
        type = s;
    }

    public String getType() {
        return type;
    }
}
