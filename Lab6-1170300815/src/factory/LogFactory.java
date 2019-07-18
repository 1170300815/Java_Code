package factory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * 
 * @author 范天祥
 *
 */
public class LogFactory {

  public static ConsoleHandler consoleHandler = null;
  public static FileHandler fileHandler = null;
  public static final String DATE_PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
  public static final String DATE_PATTERN_NOMARK = "yyyyMMddHHmmss";

  public static Logger initLog(int typeFile, String name) {

    Logger log = Logger.getLogger(name);
    log.setLevel(Level.INFO);
    addFileHandle(typeFile, log, Level.INFO, "src/settings/" + name + ".txt");
    log.setUseParentHandlers(false);
    return log;

  }

  public static Logger getLogger(int typeFile, String name) {
    return initLog(typeFile, name);
  }

  public static void setLogLevel(Logger log, Level level) {
    log.setLevel(level);
  }

  public static void addConsoleHandler(Logger log, Level level) {

    consoleHandler = new ConsoleHandler();
    consoleHandler.setLevel(level);
    log.addHandler(consoleHandler);

  }

  public static void addFileHandle(int type, Logger log, Level level, String filepath) {

    try {
      fileHandler = new FileHandler(filepath, true);
      fileHandler.setLevel(level);
      if (type == 1) {
        fileHandler.setFormatter(new Formatter() {
          @Override
          public String format(LogRecord record) {
            return record.getMessage() + "\r\n";
          }

        });
      }
    } catch (SecurityException e) {
      // e.printStackTrace();
    } catch (IOException e) {
      // e.printStackTrace();
    }
    log.addHandler(fileHandler);
  }

  public static String getCurrentDateStr(String pattern) {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date);
  }

  public static void close() {
    fileHandler.close();
  }
}
