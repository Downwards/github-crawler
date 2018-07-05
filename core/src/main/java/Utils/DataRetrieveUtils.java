package Utils;

import Enums.SourceVariations.DataMask;

import java.util.Queue;

public interface DataRetrieveUtils {

  Queue<String> usersByLink(String pathFile, DataMask mask);
}
