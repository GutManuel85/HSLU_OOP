package OOP.Programm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ADCheck {

    public static final Logger LOG = LogManager.getLogger(ADCheck.class);

    public static void main(String[] args){
        LOG.info("Log: HalloWelt");
        LOG.error("Log: Hallowelt");
    }
}
