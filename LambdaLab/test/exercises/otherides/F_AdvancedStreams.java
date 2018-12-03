package exercises.otherides;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers advanced stream operations,
 * including grouping collectors, composition of collectors,
 * and customized collectors.
 */
public class F_AdvancedStreams {

    public static final String SONNET_PATH = "LambdaLab/files/SonnetI.txt";

    /**
     * Categorize the words from the text file into a map, where the map's key
     * is the length of each word, and the value corresponding to a key is a
     * list of words of that length. Don't bother with uniqueness or lower-
     * casing the words. As before, use the BufferedReader variable named
     * "reader" that has been set up for you to read from the text file, and
     * use SPLIT_PATTERN for splitting the line into words.
     *
     * @throws IOException
     */
    @Test @Ignore
    public void f1_mapLengthToWordList() throws IOException {
        Map<Integer, List<String>> result = null; // TODO

        assertThat(result.size()).isEqualTo(11);
        assertThat(result)
                .containsEntry(1, List.of("a"))
                .containsEntry(2, List.of("we", "as", "by", "to", "to", "to", "in", "or", "be", "To", "by"))
                .containsEntry(3, List.of("die", "But", "the", "His", "his", "But", "own", "thy", "Thy", "thy",
                        "foe", "thy", "too", "art", "now", "the", "And", "the", "own", "bud",
                        "thy", "And", "the", "eat", "the", "due", "the", "and"))
                .containsEntry(4, List.of("From", "That", "rose", "time", "heir", "bear", "thou", "eyes", "with",
                        "self", "fuel", "lies", "self", "self", "Thou", "that", "only", "Pity",
                        "else", "this", "thee"))
                .containsEntry(5, List.of("might", "never", "riper", "might", "thine", "flame", "where", "sweet",
                        "cruel", "fresh", "gaudy", "thine", "churl", "waste", "world", "grave"))
                .containsEntry(6, List.of("desire", "should", "tender", "memory", "bright", "Making", "famine",
                        "herald", "spring", "Within", "tender", "mak'st"))
                .containsEntry(7, List.of("fairest", "thereby", "decease", "Feed'st", "light's", "world's",
                        "buriest", "content", "glutton", "world's"))
                .containsEntry(8, List.of("increase", "beauty's", "ornament"))
                .containsEntry(9, List.of("creatures", "abundance"))
                .containsEntry(10, List.of("contracted", "niggarding"))
                .containsEntry(11, List.of("substantial"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Collectors.groupingBy().
    // </editor-fold>


    /**
     * Categorize the words from the text file into a map, where the map's key
     * is the length of each word, and the value corresponding to a key is a
     * count of words of that length. Don't bother with uniqueness or lower-
     * casing the words. This is the same as the previous exercise except
     * the map values are the count of words instead of a list of words.
     *
     * @throws IOException
     */
    @Test @Ignore
    public void f2_mapLengthToWordCount() throws IOException {
        Map<Integer, Long> result = null; // TODO

        assertThat(result.size()).isEqualTo(11);
        assertThat(result)
                .containsEntry(1, 1L)
                .containsEntry(2, 11L)
                .containsEntry(3, 28L)
                .containsEntry(4, 21L)
                .containsEntry(5, 16L)
                .containsEntry(6, 12L)
                .containsEntry(7, 10L)
                .containsEntry(8, 3L)
                .containsEntry(9, 2L)
                .containsEntry(10, 2L)
                .containsEntry(11, 1L);
    }
    // Hint 1:
    // <editor-fold defaultstate="collapsed">
    // Use the overload of Collectors.groupingBy() that has
    // a "downstream" parameter.
    // </editor-fold>
    // Hint 2:
    // <editor-fold defaultstate="collapsed">
    // Use Collectors.counting().
    // </editor-fold>


    /**
     * Gather the words from the text file into a map, accumulating a count of
     * the number of occurrences of each word. Don't worry about upper case and
     * lower case. Extra challenge: implement two solutions, one that uses
     * groupingBy() and the other that uses toMap().
     *
     * @throws IOException
     */
    @Test @Ignore
    public void f3_wordFrequencies() throws IOException {
        Map<String, Long> result = null; // TODO

        assertThat(result.size()).isEqualTo(87);
        assertThat(result)
                .containsEntry("tender", 2L)
                .containsEntry("the", 6L)
                .containsEntry("churl", 1L)
                .containsEntry("thine", 2L)
                .containsEntry("world", 1L)
                .containsEntry("thy", 4L)
                .containsEntry("self", 3L);
        assertThat(result).doesNotContainKey("lambda");
    }
    // Hint 1:
    // <editor-fold defaultstate="collapsed">
    // For Collectors.groupingBy(), consider that each word needs to be in
    // a category of its own, that is, each word is categorized as itself.
    // </editor-fold>
    // Hint 2:
    // <editor-fold defaultstate="collapsed">
    // For Collectors.toMap(), the first occurrence of a word should be mapped to 1.
    // If two elements of the Stream are generating the same key, you will need to
    // provide a merging function.
    // </editor-fold>


    /**
     * From the words in the text file, create nested maps, where the outer map is a
     * map from the first letter of the word to an inner map. (Use a string of length
     * one as the key.) The inner map, in turn, is a mapping from the length of the
     * word to a list of words with that length. Don't bother with any lowercasing
     * or uniquifying of the words.
     *
     * For example, given the words "foo bar baz bazz foo" the string
     * representation of the result would be:
     *     {b={3=[bar, baz], 4=[bazz]}, f={3=[foo, foo]}}
     *
     * @throws IOException
     */
    @Test @Ignore
    public void f4_nestedMaps() throws IOException {
        Map<String, Map<Integer, List<String>>> result = null; // TODO

        assertThat(result.size()).isEqualTo(25);
        assertThat(result)
                .containsEntry("A", Map.of(3, List.of("And", "And")))
                .containsEntry("a", Map.of(1, List.of("a"),
                        2, List.of("as") ,
                        3, List.of("art", "and") ,
                        9, List.of("abundance")))
                .containsEntry("b", Map.of(2, List.of("by", "be", "by"),
                        3, List.of("bud") ,
                        4, List.of("bear") ,
                        6, List.of("bright"),
                        7, List.of("buriest"),
                        8, List.of("beauty's")))
                .containsEntry("i", Map.of(2, List.of("in"),
                        8, List.of("increase")))
                .containsEntry("l", Map.of(4, List.of("lies"),
                        7, List.of("light's")))
                .containsEntry("r", Map.of(4, List.of("rose"),
                        5, List.of("riper")))
        ;
    }
    // Hint 1:
    // <editor-fold defaultstate="collapsed">
    // The nested map structure that's desired is the result of applying a
    // "downstream" collector that's the same operation as the first-level collector.
    // </editor-fold>
    // Hint 2:
    // <editor-fold defaultstate="collapsed">
    // Both collection operations are Collectors.groupingBy().
    // </editor-fold>


    /**
     * Given a stream of integers, compute separate sums of the even and odd values
     * in this stream. Since the input is a stream, this necessitates making a single
     * pass over the input.
     */
    @Test @Ignore
    public void f5_separateOddEvenSums() {
        IntStream input = new Random(987523).ints(20, 0, 100);

        int sumEvens = 0; // TODO
        int sumOdds  = 0; // TODO

        assertThat(sumEvens).isEqualTo(516);
        assertThat(sumOdds).isEqualTo(614);
    }
    // Hint 1:
    // <editor-fold defaultstate="collapsed">
    // Use Collectors.partitioningBy().
    // </editor-fold>
    // Hint 2:
    // <editor-fold defaultstate="collapsed">
    // The collect(Collector) method we need is defined on Stream<T>, but not on
    // IntStream, LongStream or DoubleStream.
    // </editor-fold>


    /**
     * Given a stream of strings, accumulate (collect) them into the result string
     * by inserting the input string at both the beginning and end. For example, given
     * input strings "x" and "y" the result should be "yxxy". Note: the input stream
     * is a parallel stream, so you MUST write a proper combiner function to get the
     * correct result.
     */
    @Test @Ignore
    public void f6_insertBeginningAndEnd() {
        Stream<String> input = Arrays.asList(
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t")
            .parallelStream();

        String result = input.collect(null, null, null).toString();
        // TODO fill in lambda expressions or method references
        // TODO in place of the nulls in the line above.

        assertThat(result).isEqualTo("tsrqponmlkjihgfedcbaabcdefghijklmnopqrst");
    }
    // Hint 1:
    // <editor-fold defaultstate="collapsed">
    // The collector state (that is, the object being accumulated and
    // combined) can be a single StringBuilder, which is manipulated
    // by lambda expressions in the three-arg form of the collect() method.
    // </editor-fold>
    // Hint 2:
    // <editor-fold defaultstate="collapsed">
    // The combiner function must take its second argument and merge
    // it into the first argument, mutating the first argument.
    // </editor-fold>
    // Hint 3:
    // <editor-fold defaultstate="collapsed">
    // The second argument to the combiner function happens AFTER the first
    // argument in encounter order, so the second argument needs to be split
    // in half and prepended/appended to the first argument.
    // </editor-fold>

    /**
     * f7: Count the total number of words and the number of distinct, lower
     * case words in a stream, in one pass. This exercise uses a helper class
     * TotalAndDistinct that defines methods that are called by the method
     * Stream.collect(). Your task is to fill in the implementation of the
     * accumulate() and combine() methods in the helper class. You don't need
     * to modify the test method itself.
     *
     * The stream is run in parallel, so you must write a combine() method
     * that works properly.
     */
    static class TotalAndDistinct {
        private int count = 0;
        private final Set<String> set = new HashSet<>();

        // rely on implicit no-arg constructor

        void accumulate(String s) {
            // TODO write code to accumulate a single string into this object
        }

        void combine(TotalAndDistinct other) {
            // TODO write code to combine the other object into this one
        }

        int getTotalCount() { return count; }
        int getDistinctCount() { return set.size(); }
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // The operations you need to write are actually quite simple.
    // Don't overthink it.
    // </editor-fold>

    @Test @Ignore
    public void f7_countTotalAndDistinctWords() {
        List<String> allWords = reader.lines()
                                      .map(String::toLowerCase)
                                      .flatMap(SPLIT_PATTERN::splitAsStream)
                                      .collect(Collectors.toList());

        TotalAndDistinct totalAndDistinct =
            Collections.nCopies(100, allWords)
                       .parallelStream()
                       .flatMap(List::stream)
                       .collect(TotalAndDistinct::new,
                                TotalAndDistinct::accumulate,
                                TotalAndDistinct::combine);

        assertThat(totalAndDistinct.getDistinctCount()).isEqualTo(81);
        assertThat(totalAndDistinct.getTotalCount()).isEqualTo(10700);
    }

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
