package Utils;

import Enums.SourceVariations.DataMask;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataRetrieveUtilsImpl implements DataRetrieveUtils {

  private final Logger log = LogManager.getLogger(DataRetrieveUtils.class);

  public Queue<String> usersByLink(final String pathFile, final DataMask mask) {
    final Queue<String> users = new LinkedList<>();
    log.info("Loading users from file: {}.", pathFile);
    try {
      Files.lines(Paths.get(pathFile))
          .forEach(
              (line) -> {
                final Matcher matcher = Pattern.compile(mask.getMask()).matcher(line);
                if (matcher.find()) {
                  users.add(matcher.group(1));
                } else {
                  log.info("Line: {} - seems to be empty.", line);
                }
              }

          );
    } catch (IOException e) {
      log.error("Failed to read file.");
    }
    return users;
  }
}
