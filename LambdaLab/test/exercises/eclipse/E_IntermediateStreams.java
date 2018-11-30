package exercises.eclipse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers more advanced stream operations
 * longer stream pipelines, and simple reductions.
 */
public class E_IntermediateStreams {

    public static final String SONNET_PATH = "LambdaLab/files/SonnetI.txt";

    /**
     * Convert a list of strings into a list of characters.
     */
    @Test @Ignore
    public void e1_stringsToCharacters() {
        List<String> input = Arrays.asList("alfa", "bravo", "charlie");

        List<Character> result = null; // TODO

        assertThat(result).containsExactly('a', 'l', 'f', 'a', 'b', 'r', 'a', 'v', 'o', 'c', 'h', 'a', 'r', 'l', 'i', 'e');
    }
    /* Hint 1:
     * Use String.chars() and Stream.flatMap().
     */
    /* Hint 2:
     * Pay attention to the return type of String.chars() and boxing conversion.
     */


    /**
     * Collect all the words from the text file into a list.
     * Use the regular expression Pattern SPLIT_PATTERN to split
     * a string into words, and use Pattern.splitAsStream(String)
     * to do the splitting. SPLIT_PATTERN is defined at the bottom
     * of this file. As before, use the BufferedReader variable
     * named "reader" that has been set up for you to read from
     * the text file.
     *
     * @throws IOException
     */
    @Test @Ignore
    public void e2_listOfAllWords() throws IOException {
        List<String> output = null; // TODO

        assertThat(output)
                .containsExactly(
                        "From", "fairest", "creatures", "we", "desire", "increase",
                        "That", "thereby", "beauty's", "rose", "might", "never", "die",
                        "But", "as", "the", "riper", "should", "by", "time", "decease",
                        "His", "tender", "heir", "might", "bear", "his", "memory",
                        "But", "thou", "contracted", "to", "thine", "own", "bright", "eyes",
                        "Feed'st", "thy", "light's", "flame", "with", "self", "substantial", "fuel",
                        "Making", "a", "famine", "where", "abundance", "lies",
                        "Thy", "self", "thy", "foe", "to", "thy", "sweet", "self", "too", "cruel",
                        "Thou", "that", "art", "now", "the", "world's", "fresh", "ornament",
                        "And", "only", "herald", "to", "the", "gaudy", "spring",
                        "Within", "thine", "own", "bud", "buriest", "thy", "content",
                        "And", "tender", "churl", "mak'st", "waste", "in", "niggarding",
                        "Pity", "the", "world", "or", "else", "this", "glutton", "be",
                        "To", "eat", "the", "world's", "due", "by", "the", "grave", "and", "thee"
                );
    }
    /* Hint:
     * Use Stream.flatMap().
     */


    /**
     * Read the words from the text file, and create a list containing the words
     * of length 8 or longer, converted to lower case, and sorted alphabetically.
     *
     * @throws IOException
     */
    @Test @Ignore
    public void e3_longLowerCaseSortedWords() throws IOException {
        List<String> output = null; // TODO

        assertThat(output)
                .containsExactly(
                        "abundance", "beauty's", "contracted", "creatures",
                        "increase", "niggarding", "ornament", "substantial"
                );
    }
    /* Hint:
     * Use Stream.sorted().
     */


    /**
     * Read the words from the text file, and create a list containing the words
     * of length 8 or longer, converted to lower case, and sorted reverse alphabetically.
     * (Same as above except for reversed sort order.)
     *
     * @throws IOException
     */
    @Test @Ignore
    public void e4_longLowerCaseReverseSortedWords() throws IOException {
        List<String> result = null; // TODO

        assertThat(result)
                .containsExactly(
                        "substantial", "ornament", "niggarding", "increase",
                        "creatures", "contracted", "beauty's", "abundance"
                );
    }
    /* Hint:
     * Use Comparator.reverseOrder().
     */


    /**
     * Read words from the text file, and sort unique, lower-cased words by length,
     * then alphabetically within length, and place the result into an output list.
     *
     * @throws IOException
     */
    @Test @Ignore
    public void e5_sortedLowerCaseDistinctByLengthThenAlphabetically() throws IOException {
        List<String> result = null; // TODO

        assertThat(result)
                .containsExactly(
                        "a", "as", "be", "by", "in", "or", "to", "we",
                        "and", "art", "bud", "but", "die", "due", "eat", "foe",
                        "his", "now", "own", "the", "thy", "too", "bear", "else",
                        "eyes", "from", "fuel", "heir", "lies", "only",
                        "pity", "rose", "self", "that", "thee", "this", "thou",
                        "time", "with", "churl", "cruel", "flame", "fresh", "gaudy",
                        "grave", "might", "never", "riper", "sweet", "thine",
                        "waste", "where", "world", "bright", "desire", "famine",
                        "herald", "mak'st", "making", "memory", "should", "spring",
                        "tender", "within", "buriest", "content", "decease",
                        "fairest", "feed'st", "glutton", "light's", "thereby", "world's", "beauty's",
                        "increase", "ornament", "abundance", "creatures", "contracted", "niggarding",
                        "substantial"
                );
    }
    /* Hint 1:
     * Use Stream.distinct().
     */
    /* Hint 2:
     * Use Comparator.thenComparing().
     */

    /**
     * Compute the value of 21!, that is, 21 factorial. This value is larger than
     * Long.MAX_VALUE, so you must use BigInteger.
     */
    @Test @Ignore
    public void e6_bigFactorial() {
        BigInteger result = BigInteger.ONE; // TODO

        assertThat(result).isEqualTo(new BigInteger("51090942171709440000"));
    }
    /* Hint 1:
     * Use one of the range methods of LongStream to help create
     * the BigInteger instances.
     */
    /* Hint 2:
     * Use Stream.reduce() to "collapse" all elements of a stream into
     * a single value.
     */


    /**
     * Get the last word in the text file.
     *
     * @throws IOException
     */
    @Test @Ignore
    public void e7_getLastWord() throws IOException {
        String result = null; // TODO

        assertThat(result).isEqualTo("thee");
    }
    /* Hint:
     * Use Stream.reduce() and think about the order of the arguments.
     */

    /**
     * Create a list containing ArrayList.class and all its super classes.
     */
    @Test @Ignore
    public void e8_selectTheSuperClassesOfArrayList() {
        Class<?> origin = ArrayList.class;

        List<String> result = null; // TODO

        assertThat(result).containsExactly(ArrayList.class, AbstractList.class, AbstractCollection.class, Object.class);
    }
    /* Hint:
     * There is a getSuperClass() method on the Class class.
     * Creating a stream of these classes can be made with Stream.iterate().
     * Then you need to close that stream when the current class is null.
     * Java 9 added the takeWhile() method on the stream interface.
     */


    /**
     * Count the length of a stream dropping the first elements on a predicate.
     */
    @Test @Ignore
    public void e9_countTheElementsAfterAPredicate() {

        Random rand = new Random(314L);
        Stream<String> stream = Stream.iterate(
                "",
                (String s) -> {
                    final int nextInt = rand.nextInt(10);
                    return (nextInt == 0 && !s.isEmpty()) ? s.substring(0, s.length() - 1) :
                            (nextInt == 8 || nextInt == 9) ? s + "+"
                                    : s;
                }).limit(100);

        long count = 0L; // TODO

        assertThat(count).isEqualTo(53);
    }
    /* Hint:
     * Java 9 added the dropWhile() method on the stream interface.
     */


// ========================================================
// END OF EXERCISES
// TEST INFRASTRUCTURE IS BELOW
// ========================================================


    // Pattern for splitting a string into words
    static final Pattern SPLIT_PATTERN = Pattern.compile("[- .:,]+");

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
