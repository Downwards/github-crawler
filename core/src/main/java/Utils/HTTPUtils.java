package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Semaphore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HTTPUtils {

  private static final int REQUEST_DELAY = 2000; //crawler.requestDelayMs
  private static final int MAX_PARALLEL_REQUESTS = 1; //crawler.maxParallelRequests

  private static final Logger log = LogManager.getLogger(HTTPUtils.class);
  private static final Semaphore sem = new Semaphore(MAX_PARALLEL_REQUESTS);

  public static String getRequest(final URL url, final int timeout) {
    log.info("Initialize GET request. URL: {} ", url);
    try {
      sem.acquire();

      final HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      con.setConnectTimeout(timeout);
      con.setReadTimeout(timeout);

      if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
        log.info("Request succeeded.");
        final StringBuilder content = new StringBuilder();

        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
          String inputLine;
          while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
          }
        }
        con.disconnect();

        Thread.sleep(REQUEST_DELAY);
        sem.release();

        return content.toString();
      }

      if (con.getResponseCode() == HttpURLConnection.HTTP_FORBIDDEN){
        log.error("Response code: {}", con.getResponseCode());
        sem.release();
        throw new RuntimeException("API rate limit exceeded.");
      }
      else{
        log.error("Response code: {}", con.getResponseCode());
        sem.release();
        return String.valueOf(con.getResponseCode());
      }

    } catch (final IOException | InterruptedException e) {
      log.error("Failed to execute request.");
      throw new RuntimeException();
    }
  }
}
