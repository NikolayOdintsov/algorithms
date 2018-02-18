import com.nkodintsov.sortings.merge.MergeSorting;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by nikolay.odintsov on 18.02.18.
 */
public class MergeSortingTest {

    @Test
    public void testSort() {
        //given
        int[] unsortedArray = {3, 4, 1, 6, 8, 2};
        int[] expectedResult = {1, 2, 3, 4, 6, 8};

        //when
        MergeSorting mergeSorting = new MergeSorting();
        int[] result = mergeSorting.sort(unsortedArray);

        //then
        assertNotNull(unsortedArray);
        assertArrayEquals(expectedResult, result);
    }

}