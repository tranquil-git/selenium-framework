package Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    // Khởi tạo Logger
    private static final Logger Log = LogManager.getLogger(Log.class.getName());

    public static void info(String message) {
        Log.info(message);
    }

    public static void error(String message) {
        Log.error(message);
    }
}
