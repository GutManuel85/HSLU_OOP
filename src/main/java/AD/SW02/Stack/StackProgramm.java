package AD.SW02.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StackProgramm {

    public static final Logger LOGGER = LogManager.getLogger(StackProgramm.class);

    public static void main(String[] args){

        Stack stack = new Stack(3);
        stack.push("toll");
        stack.push("sind");
        stack.push("Datenstrukturen");
        for(int i = 2; i >= 0; i--) {
            LOGGER.info(stack.pop());
        }
    }
}
