package ISF;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RandomNextIntVarianteShort {
    private static short RN1 = 4999;
    private static short A = Short.MIN_VALUE;
    private static short C = Short.MIN_VALUE;
    private static short M = Short.MIN_VALUE;
    private static short RN2 = 500;

    private static final Logger LOG = LogManager.getLogger(RandomNextIntVarianteShort.class);


    public static void main(String[] args) {
        berechne();
    }

    public static void berechne() {
        while (A < Short.MAX_VALUE) {
            LOG.info("A ist: " + A);
            A++;
            C = Short.MIN_VALUE;
            while (C < Short.MAX_VALUE) {
                //LOG.info("C ist: " + C);
                C++;
                M = (short)(RN2-1);
                while (M < Short.MAX_VALUE) {
                    if ((A * RN1 + C)%M == RN2) {
                        LOG.info("A ist: " + A + "/ C ist: " + C + "/ M ist: " + M);
                        return;
                    }else{
                        M++;
                    }
                }
            }
        }
    }
}

