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
public class DateNextDateOkTest {
    private Date actualDate;
    private Date expectedDate;

    public DateNextDateOkTest(Date actualDate, Date expectedDate) {
        this.actualDate = actualDate;
        this.expectedDate = expectedDate;
    }

    @Parameters
    public static List<Date[]> testData() {
        List<Date[]> params = new ArrayList<Date[]>();
        params.add(new Date[] { new Date(2020, 5, 27), new Date(2020, 5, 28) });
        params.add(new Date[] { new Date(1700, 06, 20), new Date(1700, 06, 21) });
        params.add(new Date[] { new Date(2005, 04, 15), new Date(2005, 04, 16) });
        params.add(new Date[] { new Date(1901, 07, 20), new Date(1901, 07, 21) });
        params.add(new Date[] { new Date(3456, 03, 27), new Date(3456, 03, 28) });
        params.add(new Date[] { new Date(1500, 02, 17), new Date(1500, 02, 18) });
        params.add(new Date[] { new Date(1700, 06, 29), new Date(1700, 06, 30) });
        params.add(new Date[] { new Date(1800, 11, 29), new Date(1800, 11, 30) });
        params.add(new Date[] { new Date(3453, 01, 29), new Date(3453, 01, 30) });
        return params;
    }

    @Test
    public void test_valid_date_() {
        Date nextDate = actualDate.nextDate();
        assertEquals(expectedDate, nextDate);
    }

}