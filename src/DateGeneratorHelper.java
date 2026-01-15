import java.time.LocalDate;

public class DateGeneratorHelper {

  public String date() {

    LocalDate now = LocalDate.now();
    int year = now.getYear();
    int month = now.getMonthValue();
    int day = now.getDayOfMonth();

    return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
  }
}
