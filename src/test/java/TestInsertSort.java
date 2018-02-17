import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by nikolay.odintsov on 17.02.18.
 */
public class TestInsertSort {

    @Test
    public void testSort() {
        //given
        int[] unsortedArray = {3, 4, 1, 6, 8, 2};
        int[] expectedResult = {1, 2, 3, 4, 6, 8};

        //when
        InsertSorting insertSorting = new InsertSorting();
        int[] result = insertSorting.sort(unsortedArray);

        //then
        assertNotNull(result);
        assertArrayEquals(expectedResult, result);
    }
}
