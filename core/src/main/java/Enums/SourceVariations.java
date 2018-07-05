package Enums;

public class SourceVariations {

  /*
  RegExp для получения логинов пользователей
   */
  public enum DataMask {
    GITHUB("github.com/([a-zA-Z0-9[-]]{1,39})");

    private final String mask;

    DataMask(final String mask) {
      this.mask = mask;
    }

    public String getMask() {
      return mask;
    }

  }
}
