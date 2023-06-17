import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  void constructor_date_ok() {
    Date d = new Date(2020, 5, 3);
    assertEquals(2020, d.getYear());
    assertEquals(5, d.getMonth());
    assertEquals(3, d.getDay());
  }

  @Test
  void constructor_date_not_ok() {
    boolean thrown = false;
    try {
      Date d = new Date(2020, 13, 90);
    } catch (IllegalArgumentException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }

  @Test
  void nextDate_tc01() {
    Date today = new Date(1700, 6, 20);
    Date expectedTomorrow = new Date(1700, 6, 21);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc02() {
    Date today = new Date(2005, 4, 15);
    Date expectedTomorrow = new Date(2005, 4, 16);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc03() {
    Date today = new Date(1901, 7, 20);
    Date expectedTomorrow = new Date(1901, 7, 21);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc04() {
    Date today = new Date(3456, 3, 27);
    Date expectedTomorrow = new Date(3456, 3, 28);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc05() {
    Date today = new Date(1500, 2, 17);
    Date expectedTomorrow = new Date(1500, 2, 18);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc06() {
    Date today = new Date(1700, 6, 29);
    Date expectedTomorrow = new Date(1700, 6, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc07() {
    Date today = new Date(1800, 11, 29);
    Date expectedTomorrow = new Date(1800, 11, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc08() {
    Date today = new Date(3453, 1, 29);
    Date expectedTomorrow = new Date(3453, 1, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc09() {
    Date today = new Date(444, 2, 29);
    Date expectedTomorrow = new Date(444, 3, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc10() {
    Date today = new Date(2005, 4, 30);
    Date expectedTomorrow = new Date(2005, 5, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc11() {
    Date today = new Date(3453, 1, 30);
    Date expectedTomorrow = new Date(3453, 1, 31);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc12() {
    Date today = new Date(3456, 3, 30);
    Date expectedTomorrow = new Date(3456, 3, 31);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc13() {
    Date today = new Date(1901, 7, 31);
    Date expectedTomorrow = new Date(1901, 8, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc14() {
    Date today = new Date(3453, 1, 31);
    Date expectedTomorrow = new Date(3453, 2, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc15() {
    Date today = new Date(3456, 12, 31);
    Date expectedTomorrow = new Date(3457, 1, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_invalid_tc16() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(1500, 2, 31));
  }

  @Test
  void nextDate_invalid_tc17() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(1500, 2, 29));
  }

  @Test
  void nextDate_invalid_tc18() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(-1, 10, 20));
  }

  @Test
  void nextDate_invalid_tc19() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(1458, 15, 12));
  }

  @Test
  void nextDate_invalid_tc20() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(1975, 6, -50));
  }

  @Test
  void nextDate_invalid_tc21() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(2002, 12, 35));
  }

  @Test
  void nextDate_invalid_tc22() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(2002, 04, 32));
  }

  @Test
  void nextDate_invalid_tc23() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(2004, 02, 32));
  }

  @Test
  void nextDate_invalid_tc24() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(2000, 02, 32));
  }

  @Test
  void toString_test_tc25() {
    Date date = new Date(2002, 05, 17);
    String expected = "2002/May/17";
    assertEquals(expected, date.toString());
  }

  @Test
  void return_value_equals_tc26() {
    Date date = new Date(2002, 05, 17);
    Date value = new Date(2005, 06, 30);
    assertFalse(date.equals(value));
  }

  @Test
  void leap_year_valid_tc27() {
    Date date = new Date(2000, 9, 25);
    assertTrue(date.isLeapYear());
  }

  @Test
  void invalid_month_tc28() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(2000, -1, 5));
  }

  @Test
  void invalid_30day_month_tc29() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(2023, 6, 32));
  }

  @Test
  void date_instance_check_tc30() {
    Date date = new Date(2000, 6, 30);
    assertFalse(date.equals("Date"));
  }

  @Test
  void date_equality_check_tc31() {
    Date date = new Date(2000, 6, 30);
    Date date2 = new Date(2000, 6, 30);
    assertTrue(date.equals(date2));
  }

  @Test
  void date_equality_check_tc32() {
    Date date1 = new Date(2023, 5, 8);
    Date date2 = new Date(2023, 5, 8);
    Date date3 = new Date(2022, 5, 8);
    Date date4 = new Date(2023, 4, 8);
    Date date5 = new Date(2023, 5, 7);
    assertTrue(date1.equals(date2));
    assertFalse(date1.equals(date3));
    assertFalse(date1.equals(date4));
    assertFalse(date1.equals(date5));
  }

  @Test
  void month_end_check_tc33() {
    Date date1 = new Date(2023, 1, 31);
    Date date2 = new Date(2023, 1, 30);
    Date date3 = new Date(2023, 2, 28);
    Date date4 = new Date(2024, 2, 29);
    Date date5 = new Date(2024, 2, 27);
    Date date6 = new Date(2023, 3, 31);
    Date date7 = new Date(2023, 3, 30);
    Date date8 = new Date(2023, 4, 30);
    Date date9 = new Date(2023, 4, 29);
    Date date10 = new Date(2023, 5, 31);
    Date date11 = new Date(2023, 5, 30);
    Date date12 = new Date(2023, 6, 30);
    Date date13 = new Date(2023, 7, 31);
    Date date14 = new Date(2023, 7, 30);
    Date date15 = new Date(2023, 8, 31);
    Date date16 = new Date(2023, 8, 30);
    Date date17 = new Date(2023, 9, 30);
    Date date18 = new Date(2023, 9, 29);
    Date date19 = new Date(2023, 10, 31);
    Date date20 = new Date(2023, 10, 30);
    Date date21 = new Date(2023, 11, 30);
    Date date22 = new Date(2023, 11, 29);
    Date date23 = new Date(2023, 12, 31);
    Date date24 = new Date(2023, 12, 30);
    Date date25 = new Date(2023, 2, 27);
    Date date26 = new Date(2023, 4, 28);
    Date date27 = new Date(2023, 6, 29);
    Date date28 = new Date(2024, 2, 28);
    Date date29 = new Date(2024, 2, 29);
    Date date30 = new Date(2024, 2, 27);
    // Date date31 = new Date(2023, 2, 29);
    Date date32 = new Date(2023, 2, 28);
    Date date33 = new Date(2023, 4, 30);
    Date date34 = new Date(2023, 9, 29);

    assertNotNull(date1.nextDate());
    assertNotNull(date2.nextDate());
    assertNotNull(date3.nextDate());
    assertNotNull(date4.nextDate());
    assertNotNull(date5.nextDate());
    assertNotNull(date6.nextDate());
    assertNotNull(date7.nextDate());
    assertNotNull(date8.nextDate());
    assertNotNull(date9.nextDate());
    assertNotNull(date10.nextDate());
    assertNotNull(date11.nextDate());
    assertNotNull(date12.nextDate());
    assertNotNull(date13.nextDate());
    assertNotNull(date14.nextDate());
    assertNotNull(date15.nextDate());
    assertNotNull(date16.nextDate());
    assertNotNull(date17.nextDate());
    assertNotNull(date18.nextDate());
    assertNotNull(date19.nextDate());
    assertNotNull(date20.nextDate());
    assertNotNull(date21.nextDate());
    assertNotNull(date22.nextDate());
    assertNotNull(date23.nextDate());
    assertNotNull(date24.nextDate());
    assertNotNull(date25.nextDate());
    assertNotNull(date26.nextDate());
    assertNotNull(date27.nextDate());
    assertNotNull(date28.nextDate());
    assertNotNull(date29.nextDate());
    assertNotNull(date30.nextDate());
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(2023, 2, 29));
    assertNotNull(date32.nextDate());
    assertNotNull(date33.nextDate());
    assertNotNull(date34.nextDate());
  }

  @Test
  void day_validation_leap_year_tc_34() {
    assertThrows(
        IllegalArgumentException.class,
        () -> new Date(2004, 2, 38));
  }
}