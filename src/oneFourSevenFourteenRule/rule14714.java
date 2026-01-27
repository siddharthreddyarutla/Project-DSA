package oneFourSevenFourteenRule;

import java.time.LocalDate;

public class rule14714 {

  public static void main(String[] args) {

    LocalDate todayDate = LocalDate.of(2026, 1,26);

    System.out.println("1 - " + todayDate);
    System.out.println("4 - " + todayDate.plusDays(4));
    System.out.println("7 - " + todayDate.plusDays(7));
    System.out.println("14 - " + todayDate.plusDays(14));
  }
}
