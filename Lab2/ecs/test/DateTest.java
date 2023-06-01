import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  void nextDate_sample() {
    Date d = new Date(2020, 5, 3);
    assertEquals(new Date(2020, 5, 4), d.nextDate());
  }

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
  void test1() {
    Date actual = new Date(1700, 06, 20);
    Date expected = new Date(1700, 06, 21);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test2() {
    Date actual = new Date(2005, 04, 15);
    Date expected = new Date(2005, 04, 16);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test3() {
    Date actual = new Date(1901, 07, 20);
    Date expected = new Date(1901, 07, 21);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test4() {
    Date actual = new Date(3456, 03, 27);
    Date expected = new Date(3456, 03, 28);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test5() {
    Date actual = new Date(1500, 02, 17);
    Date expected = new Date(1500, 02, 18);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test6() {
    Date actual = new Date(1700, 06, 29);
    Date expected = new Date(1700, 06, 30);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test7() {
    Date actual = new Date(1800, 11, 29);
    Date expected = new Date(1800, 11, 30);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test8() {
    Date actual = new Date(3453, 01, 29);
    Date expected = new Date(3453, 01, 30);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test9() {
    Date actual = new Date(444, 02, 29);
    Date expected = new Date(444, 03, 01);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test10() {
    Date actual = new Date(2005, 04, 30);
    Date expected = new Date(2005, 05, 01);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test11() {
    Date actual = new Date(3453, 01, 30);
    Date expected = new Date(3453, 01, 31);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test12() {
    Date actual = new Date(3456, 03, 30);
    Date expected = new Date(3456, 03, 31);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test13() {
    Date actual = new Date(1901, 07, 31);
    Date expected = new Date(1901, 8, 01);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test14() {
    Date actual = new Date(3453, 01, 31);
    Date expected = new Date(3453, 02, 01);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test15() {
    Date actual = new Date(3456, 12, 31);
    Date expected = new Date(3457, 01, 01);
    assertEquals(expected, actual.nextDate());
  }

  @Test
  void test16() {
    assertThrows(IllegalArgumentException.class, () -> new Date(1500, 02, 31));
  }

  @Test
  void test17() {
    assertThrows(IllegalArgumentException.class, () -> new Date(1500, 02, 29));
  }

  @Test
  void test18() {
    assertThrows(IllegalArgumentException.class, () -> new Date(-1, 10, 20));
  }

  @Test
  void test19() {
    assertThrows(IllegalArgumentException.class, () -> new Date(1458, 15, 12));
  }

  @Test
  void test20() {
    assertThrows(IllegalArgumentException.class, () -> new Date(1975, 6, -50));
  }

}
