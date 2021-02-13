package OOP.Klassen;

public enum SwitchState {

    ON("on"), OFF("off"), FAILURE("failure");

    private String statusbezeichnung;

    private SwitchState(String statusbezeichnung) {
        this.statusbezeichnung = statusbezeichnung;
    }

    public String getStatusbezeichnung(){
        return statusbezeichnung;
    }

    @Override
    public String toString(){
        return statusbezeichnung;
    }
}
