package eskaper2.generator.models;

public enum TypeOfCall {
    Outgoing("01"),
    Ingoing("02");


    private final String type;
    TypeOfCall(String s) {
        type = s;
    }

    public String getType() {
        return type;
    }
}
