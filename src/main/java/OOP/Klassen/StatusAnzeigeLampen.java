package OOP.Klassen;

public class StatusAnzeigeLampen {
    
    private boolean isSwitchedOnLichtAnzeige;
    private boolean isSwitchedOnMotorAnzeige;
    
    
    public StatusAnzeigeLampen(){
        this.isSwitchedOnLichtAnzeige = false;
        this.isSwitchedOnMotorAnzeige = false;
    }
    
    public void switchOnLichtAnzeige(){
        this.isSwitchedOnLichtAnzeige = true;
    }

    public void switchOnMotorAnzeige(){
        this.isSwitchedOnMotorAnzeige = true;
    }

    public boolean getIsSwitchedOnLichtAnzeige() {
        return isSwitchedOnLichtAnzeige;
    }

    public boolean getIsSwitchedOnMotorAnzeige() {
        return isSwitchedOnMotorAnzeige;
    }
}
