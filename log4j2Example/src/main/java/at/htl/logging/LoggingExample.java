package at.htl.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoggingExample {

    private static final Logger LOG = LogManager.getLogger(LoggingExample.class);
    //private static final Logger LOG = LogManager.getRootLogger();

    public static void main(String[] args) {
    /*
        LOG.debug("This Will Be Printed On Debug");
        LOG.info("This Will Be Printed On Info");
        LOG.warn("This Will Be Printed On Warn");
        LOG.error("This Will Be Printed On Error");
        LOG.fatal("This Will Be Printed On Fatal");

        LOG.info("Appending string: {}.", "Hello, World");
*/
        squareNumbers();

    }


    public static void squareNumbers(){
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        while (true){
            try {
                LOG.info("Waiting for input");
                input = scanner.nextInt();

                if(input == 0)
                    break;

                System.out.println(input * input);

            }catch (InputMismatchException ex){
                LOG.error("Error while reading the line: Unable to parse");
                break;
            }
        }
    }
}
