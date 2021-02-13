package ISF;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RandomNextInt {
    private static int RN1 = -1792635349;
    private static int A = Integer.MIN_VALUE;
    private static int C = Integer.MIN_VALUE;
    private static int M = Integer.MIN_VALUE;
    private static int RN2 = Integer.MIN_VALUE - 1;

    private static final Logger LOG = LogManager.getLogger(RandomNextInt.class);


    public static void main(String[] args) {
        berechne();
    }

    public static void berechne() {
        while (A < Integer.MAX_VALUE) {
            LOG.info("A ist: " + A);
            A++;
            C = Integer.MIN_VALUE;
            while (C < Integer.MAX_VALUE) {
                //LOG.info("C ist: " + C);
                C++;
                M = RN2-1;
                while (M < Integer.MAX_VALUE) {
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

