package Leumit.auto;
import org.apache.logging.log4j.Logger;
import com.aventstack.extentreports.ExtentTest;

public class LogManager {

    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(LogManager.class);
    private static ExtentTest test;

    public static void setExtentTest(ExtentTest testObj) {
        test = testObj;
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void info(String message) {
        logger.info(message);
        test.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
        test.warning(message);
    }

    public static void error(String message) {
        logger.error(message);
        test.fail(message);
    }

}
