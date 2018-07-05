import Enums.SourceVariations.DataMask;
import Utils.DataRetrieveUtils;
import Utils.DataRetrieveUtilsImpl;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GitHubParser {

  private static final String FILE = "github/src/main/resources/links.txt";
  public static final String RESULT_FILE_NAME = "github/src/main/resources/result.txt";
  private static final DataRetrieveUtils dataRetrieveUtils = new DataRetrieveUtilsImpl();

  public static void main(String[] args) {
    new File(RESULT_FILE_NAME).delete();

    final ConcurrentLinkedQueue<String> users = new ConcurrentLinkedQueue<>(
        dataRetrieveUtils.usersByLink(FILE, DataMask.GITHUB));

    for (int ignored : new int[5]) {
      new Thread(new GitHubThread(users)).start();
    }
  }
}
