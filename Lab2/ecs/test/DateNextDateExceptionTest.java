import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateNextDateExceptionTest {
    private int year;
    private int month;
    private int day;

    public DateNextDateExceptionTest(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Parameters
    public static List<Integer[]> testData() {
        List<Integer[]> params = new ArrayList<Integer[]>();
        params.add(new Integer[] { 1500, 02, 31 });
        params.add(new Integer[] { 1500, 02, 29 });
        params.add(new Integer[] { -1, 10, 20 });
        params.add(new Integer[] { 1458, 15, 12 });
        params.add(new Integer[] { 1975, 6, -50 });
        return params;
    }

    @Test
    public void test_date_exceptions() {
        assertThrows(IllegalArgumentException.class, () -> new Date(year, month, day));
    }

}