package exercises.eclipse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.util.Set;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JDK 9 added several new streams-producing APIs in the java.util.regex.Matcher
 * and java.util.Scanner classes. These APIs make it even easier to process text
 * using pattern matching and fluent streams pipelines. The exercises in this file
 * use the new JDK 9 pattern matching APIs.
 */
public class G_MatcherScanner {

    public static final String SONNET_PATH = "LambdaLab/files/SonnetI.txt";

    /**
     * Shakespeare used "poetic contractions" which (for purposes of this exercise)
     * are words that have an apostrophe (') in a position farther than one letter from
     * the end of the word. An example of modern English contraction is "can't" where
     * the apostrophe precedes the last letter of the word. An example of a poetic
     * contraction is "o'er" (over) where the apostrophe occurs earlier in the word.
     *
     * Use the Pattern WORD_PAT (defined below) to match words with an apostrophe
     * earlier in the word. Match the text from Shakespeare's first sonnet, which has
     * been loaded into the String variable SONNET, using the Matcher class, and
     * process the results using a Stream.
     */
    @Test @Ignore
    public void g1_wordsWithApostrophes() {
        Set<String> result = null; // TODO

        assertThat(result).isEqualTo(Set.of("Feed'st", "mak'st"));
    }
    /* Hint:
     * Use the Matcher.results() method, then convert each MatchResult into a String.
     */

    /**
     * Perform the same task as in exercise g1, except using Scanner instead of Matcher.
     * Use the Scanner class to process the String variable SONNET, matching words as
     * described above using WORD_PAT.
     */
    @Test @Ignore
    public void g2_wordsWithApostrophes() {
        Set<String> result = null; // TODO

        assertThat(result).isEqualTo(Set.of("Feed'st", "mak'st"));
    }
    /* Hint:
     * Use the Scanner.findAll() method, then convert each MatchResult into a String.
     */

    /**
     * Find all vowel trigraphs (that is, sequences of three consecutive vowels)
     * in the string variable SONNET. Replace each matching substring with
     * the substring converted to upper case and surrounded by square brackets "[]".
     * Use the predefined pattern TRIGRAPH_PAT to match vowel trigraphs.
     */
    @Test @Ignore
    public void g3_vowelTrigraphs() {
        final Pattern TRIGRAPH_PAT = Pattern.compile("[aeiou]{3}", Pattern.CASE_INSENSITIVE);
        String result = null; // TODO
        String expectedResult = "From fairest creatures we desire increase,\n" +
                "That thereby b[EAU]ty's rose might never die,\n" +
                "But as the riper should by time decease,\n" +
                "His tender heir might bear his memory:\n" +
                "But thou contracted to thine own bright eyes,\n" +
                "Feed'st thy light's flame with self-substantial fuel,\n" +
                "Making a famine where abundance lies,\n" +
                "Thy self thy foe, to thy sweet self too cruel:\n" +
                "Thou that art now the world's fresh ornament,\n" +
                "And only herald to the gaudy spring,\n" +
                "Within thine own bud buriest thy content,\n" +
                "And, tender churl, mak'st waste in niggarding:\n" +
                "Pity the world, or else this glutton be,\n" +
                "To eat the world's due, by the grave and thee.\n";
        assertThat(result).isEqualToNormalizingNewlines(expectedResult);
    }
    /* Hint:
     * Use the Matcher.replaceAll() method.
     */

    /**
     * Use Scanner to parse the SONNET string into whitespace-separated tokens.
     * Scanner's default token delimiter is whitespace, so no additional setup
     * needs to be done. Then, find the first such token that is of length 10
     * or more.
     *
     * (This task can be performed with String.split() or Pattern.splitAsStream(),
     * but the advantage of Scanner is that it operate on a file, an InputStream,
     * or a Channel, and all the input need not be loaded into memory.)
     */
    @Test @Ignore
    public void g4_firstLongWhitespaceSeparatedToken() {
        String result = null; // TODO

        assertThat(result).isEqualTo("contracted");
    }
    /* Hint:
     * Use the Scanner.tokens() method.
     */


// ========================================================
// END OF EXERCISES
// TEST INFRASTRUCTURE IS BELOW
// ========================================================

    /**
     * Pattern for use in exercises g1 and g2. This regex matches a word that contains
     * an apostrophe, by matching a word boundary, one or more letters, an apostrophe,
     * two or more letters, and a word boundary. Matching is case insensitive.
     */
    static final Pattern WORD_PAT = Pattern.compile("\\b[a-z]+'[a-z]{2,}\\b", Pattern.CASE_INSENSITIVE);

    /**
     * The text of Shakespeare's first sonnet, in a string. Note, this string
     * contains newline characters.
     */
    private String SONNET;

    @Before
    public void z_readFileIntoString() throws IOException {
        SONNET = new String(Files.readAllBytes(Paths.get(SONNET_PATH)),
                            StandardCharsets.UTF_8);
    }
}
