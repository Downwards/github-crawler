package Utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

  public static synchronized void writeToFile(final String str, final String filename)
      throws IOException {
    try (final FileWriter fw = new FileWriter(filename, true)) {
      fw.write(str);
    }
  }
}
