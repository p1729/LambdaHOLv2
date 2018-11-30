package exercises.eclipse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers simple stream pipelines,
 * including intermediate operations and basic collectors.
 * <p>
 * Some of these exercises use a BufferedReader variable
 * named "reader" that the test has set up for you.
 */
public class D_SimpleStreams {

    public static final String SONNET_PATH = "LambdaLab/files/SonnetI.txt";

    /**
     * Given a list of words, create an output list that contains
     * only the odd-length words, converted to upper case.
     */
    @Test @Ignore
    public void d1_upcaseOddLengthWords() {
        List<String> input = Arrays.asList(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

        List<String> result = null; // TODO

        assertThat(result).containsExactly("BRAVO", "CHARLIE", "DELTA", "FOXTROT");
    }
    /* Hint 1:
     * Use filter() and map().
     */
    /* Hint 2:
     * To create the result list, use collect() with one of the
     * predefined collectors on the Collectors class.
     */


    /**
     * Take the third through fifth words of the list, extract the
     * second letter from each, and join them, separated by commas,
     * into a single string. Watch for off-by-one errors.
     */
    @Test @Ignore
    public void d2_joinStreamRange() {
        List<String> input = Arrays.asList(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

        String result = ""; // TODO

        assertThat(result).isEqualTo("h,e,c");
    }
    /* Hint 1:
     * Use Stream.skip() and Stream.limit().
     */
    /* Hint 2:
     * Use Collectors.joining().
     */


    /**
     * Count the number of lines in the text file. (Remember to
     * use the BufferedReader named "reader" that has already been
     * opened for you.)
     *
     * @throws IOException
     */
    @Test @Ignore
    public void d3_countLinesInFile() throws IOException {
        long count = 0; // TODO

        assertThat(count).isEqualTo(14);
    }
    /* Hint 1:
     * Use BufferedReader.lines() to get a stream of lines.
     */
    /* Hint 2:
     * Use Stream.count().
     */


    /**
     * Find the length of the longest line in the text file.
     *
     * @throws IOException
     */
    @Test @Ignore
    public void d4_findLengthOfLongestLine() throws IOException {
        int longestLength = 0; // TODO

        assertThat(longestLength).isEqualTo(53);
    }
    /* Hint 1:
     * Use Stream.mapToInt() to convert a stream of objects to an IntStream.
     */
    /* Hint 2:
     * Look at java.util.OptionalInt to get the result.
     */
    /* Hint 3:
     * Think about the case where the OptionalInt might be empty
     * (that is, where it has no value).
     */


    /**
     * Find the longest line in the text file.
     *
     * @throws IOException
     */
    @Test @Ignore
    public void d5_findLongestLine() throws IOException {
        String longest = null; // TODO

        assertThat(longest).isEqualTo("Feed'st thy light's flame with self-substantial fuel,");
    }
    /* Hint 1:
     * Use Stream.max() with a Comparator.
     */
    /* Hint 2:
     * Use static methods on Comparator to help create a Comparator instance.
     */


    /**
     * Select the longest words from the input list. That is, select the words
     * whose lengths are equal to the maximum word length.
     */
    @Test @Ignore
    public void d6_selectLongestWords() {
        List<String> input = Arrays.asList(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel");

        List<String> result = null; // TODO

        assertThat(result).containsExactly("charlie", "foxtrot");
    }
    /* Hint:
     * Consider making two passes over the input stream.
     */

    /**
     * Select the list of words from the input list whose length is greater than
     * the word's position in the list (starting from zero) .
     */
    @Test @Ignore
    public void d7_selectByLengthAndPosition() {
        List<String> input = Arrays.asList(
                "alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel");

        List<String> result = null; // TODO

        assertThat(result).containsExactly("alfa", "bravo", "charlie", "delta", "foxtrot");
    }
    /* Hint:
     * Instead of a stream of words (Strings), run an IntStream of indexes of
     * the input list, using index values to get elements from the input list.
     */


// ========================================================
// END OF EXERCISES
// TEST INFRASTRUCTURE IS BELOW
// ========================================================


    private BufferedReader reader;

    @Before
    public void z_setUpBufferedReader() throws IOException {
        reader = Files.newBufferedReader(
                Paths.get(SONNET_PATH), StandardCharsets.UTF_8);
    }

    @After
    public void z_closeBufferedReader() throws IOException {
        reader.close();
    }

}
