package exercises.otherides;

import org.junit.Test;
import org.junit.Ignore;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This set of exercises covers new default methods on
 * the Collections and related APIs.
 */
public class C_DefaultMethods {

    /**
     * Given a list of StringBuilders, modify each StringBuilder
     * in-place by appending the string "new" to each one.
     */
    @Test @Ignore
    public void c01_appendNew() {
        List<StringBuilder> sbList = Arrays.asList(
            new StringBuilder("alfa"),
            new StringBuilder("bravo"),
            new StringBuilder("charlie"));

        // TODO write code to modify sbList

        List<String> actualStrings = sbList.stream().map(StringBuilder::toString).collect(Collectors.toList());
        assertThat(actualStrings).containsExactly("alfanew", "bravonew", "charlienew");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Iterable.forEach().
    // </editor-fold>


    /**
     * Remove the words that have odd lengths from the list.
     */
    @Test @Ignore
    public void c02_removeOddLengthWords() {
        List<String> list = new ArrayList<>(Arrays.asList(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot"));

        // TODO write code to modify list

        assertThat(list).containsExactly("alfa", "echo");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Collection.removeIf().
    // </editor-fold>


    /**
     * Replace every word in the list with its upper case equivalent.
     */
    @Test @Ignore
    public void c03_upcaseAllWords() {
        List<String> list = Arrays.asList(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

        // TODO code to modify list

        assertThat(list).containsExactly("ALFA", "BRAVO", "CHARLIE", "DELTA", "ECHO", "FOXTROT");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use List.replaceAll().
    // </editor-fold>


    /**
     * Given a map whose keys are Integers and whose values are StringBuilders,
     * append to each StringBuilder the string representation of its corresponding
     * Integer key. This should mutate each StringBuilder value in-place.
     */
    @Test @Ignore
    public void c04_appendToMapValues() {
        Map<Integer, StringBuilder> map = new TreeMap<>();
        map.put(1, new StringBuilder("alfa"));
        map.put(2, new StringBuilder("bravo"));
        map.put(3, new StringBuilder("charlie"));

        // TODO write code to modify map

        assertThat(map.size()).isEqualTo(3);
        assertThat(valuesToString(map))
                .containsEntry(1, "alfa1")
                .containsEntry(2, "bravo2")
                .containsEntry(3, "charlie3");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.forEach().
    // </editor-fold>


    /**
     * Given a map whose keys are Integers and whose values are Strings,
     * append to each String the string representation of its corresponding
     * Integer key.
     */
    @Test @Ignore
    public void c05_replaceMapValues() {
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "alfa");
        map.put(2, "bravo");
        map.put(3, "charlie");

        // TODO write code to modify map

        assertThat(map.size()).isEqualTo(3);
        assertThat(map)
                .containsEntry(1, "alfa1")
                .containsEntry(2, "bravo2")
                .containsEntry(3, "charlie3");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.replaceAll().
    // </editor-fold>


    /**
     * Given a list of words, populate a map whose keys are the lengths of
     * each word, and whose values are list of words with that length.
     */
    @Test @Ignore
    public void c06_mapOfListOfStringsByLength() {
        List<String> list = Arrays.asList(
            "aardvark", "bison", "capybara",
            "alligator", "bushbaby", "chimpanzee",
            "avocet", "bustard", "capuchin");
        Map<Integer, List<String>> result = new TreeMap<>();

        // TODO write code to populate result

        assertThat(result).containsOnlyKeys(5, 6, 7, 8, 9, 10);
        assertThat(result)
                .containsEntry(5, Arrays.asList("bison"))
                .containsEntry(6, Arrays.asList("avocet"))
                .containsEntry(7, Arrays.asList("bustard"))
                .containsEntry(8, Arrays.asList("aardvark", "capybara", "bushbaby", "capuchin"))
                .containsEntry(9, Arrays.asList("alligator"))
                .containsEntry(10, Arrays.asList("chimpanzee"));
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.computeIfAbsent() within Iterable.forEach().
    // </editor-fold>

    /**
     * Given a list of words, populate a map whose keys are the initial characters of
     * each word, and whose values are the concatenation of the words with that
     * initial character. When concatenating the words, they should be
     * separated by a colon (':').
     */
    @Test @Ignore
    public void c07_mapOfStringByInitialCharacter() {
        List<String> list = Arrays.asList(
            "aardvark", "bison", "capybara",
            "alligator", "bushbaby", "chimpanzee",
            "avocet", "bustard", "capuchin");
        Map<Character, String> result = new TreeMap<>();

        // TODO write code to populate result

        assertThat(result).containsOnlyKeys('a', 'b', 'c');
        assertThat(result)
                .containsEntry('a', "aardvark:alligator:avocet")
                .containsEntry('b', "bison:bushbaby:bustard")
                .containsEntry('c', "capybara:chimpanzee:capuchin");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Use Map.merge() within Iterable.forEach().
    // </editor-fold>


    /**
     * For some reason the provided map doesn't have mappings for all the keys. This
     * is a problem, because if we call get() on a key that isn't present, it returns
     * null, and we need to add checks to protect against NullPointerException.
     * Write code to ensure that all missing keys are mapped to the empty string.
     */
    @Test @Ignore
    public void c08_mapWithMissingValues() {
        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        Map<String, String> map = new HashMap<>(Map.of("a", "alfa",
                "b", "bravo",
                "c", "charlie",
                "d", "delta"));

        // TODO write code to fix the map

        assertThat(map.size()).isEqualTo(7);
        assertThat(map)
                .containsEntry("a", "alfa")
                .containsEntry("b", "bravo")
                .containsEntry("c", "charlie")
                .containsEntry("d", "delta")
                .containsEntry("e", "")
                .containsEntry("f", "")
                .containsEntry("g", "");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Check the Map.putIfAbsent() default method.
    // </editor-fold>


    /**
     * In the previous example, we added map entries that had a default value.
     * We've now determined that's incorrect, and we want to undo that. This
     * time, we want to remove the entry if the value is the empty string.
     */
    @Test @Ignore
    public void c09_mapRemoveEntriesWithEmptyValues() {
        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        Map<String, String> map = new HashMap<>(Map.of("a", "alfa",
                "b", "bravo",
                "c", "charlie",
                "d", "delta",
                "e", "",
                "f", "",
                "g", ""));

        // TODO write code to fix the map

        assertThat(map.size()).isEqualTo(4);
        assertThat(map)
                .containsEntry("a", "alfa")
                .containsEntry("b", "bravo")
                .containsEntry("c", "charlie")
                .containsEntry("d", "delta");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Check the two-arg Map.remove() default method.
    // </editor-fold>


    /**
     * We need another way to deal with the problem of the previous example.
     * Instead of removing entries whose value is the empty string, we want
     * to replace the empty-string values with a value that's the key itself.
     * Write the code to do that.
     */
    @Test @Ignore
    public void c10_mapReplaceEmptyValues() {
        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        Map<String, String> map = new HashMap<>(Map.of("a", "alfa",
                "b", "bravo",
                "c", "charlie",
                "d", "delta",
                "e", "",
                "f", "",
                "g", ""));

        // TODO write code to fix the map

        assertThat(map.size()).isEqualTo(7);
        assertThat(map)
                .containsEntry("a", "alfa")
                .containsEntry("b", "bravo")
                .containsEntry("c", "charlie")
                .containsEntry("d", "delta")
                .containsEntry("e", "e")
                .containsEntry("f", "f")
                .containsEntry("g", "g");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Check the Map.replace() default method that takes 3 arguments.
    // </editor-fold>


    /**
     * We are still dealing with a map with missing entries. For entries that
     * are present, we want to convert the value to upper case; and for keys
     * that are not present, we want to add an entry where the value is the
     * same as the key.
     */
    @Test @Ignore
    public void c11_computeWithMissingEntries() {
        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        Map<String, String> map = new HashMap<>(Map.of("a", "alfa",
                "b", "bravo",
                "c", "charlie",
                "d", "delta"));

        // TODO write code transform the map

        assertThat(map.size()).isEqualTo(7);
        assertThat(map)
                .containsEntry("a", "ALFA")
                .containsEntry("b", "BRAVO")
                .containsEntry("c", "CHARLIE")
                .containsEntry("d", "DELTA")
                .containsEntry("e", "e")
                .containsEntry("f", "f")
                .containsEntry("g", "g");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Check the Map.compute() default method, and read the Javadoc carefully
    // regarding the mappings that aren't present.
    // </editor-fold>


    /**
     * The map now has several entries, some with valid values, and some
     * with values that are the empty string. This time, we want to convert
     * the non-empty values to upper case, but we want to remove the entries
     * for which the values are the empty string.
     */
    @Test @Ignore
    public void c12_computeAndRemoveSomeEntries() {
        List<String> keys = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
        Map<String, String> map = new HashMap<>(Map.of("a", "alfa",
                "b", "bravo",
                "c", "charlie",
                "d", "delta",
                "e", "",
                "f", "",
                "g", ""));

        // TODO write code transform the map

        assertThat(map.size()).isEqualTo(4);
        assertThat(map)
                .containsEntry("a", "ALFA")
                .containsEntry("b", "BRAVO")
                .containsEntry("c", "CHARLIE")
                .containsEntry("d", "DELTA");
    }
    // Hint:
    // <editor-fold defaultstate="collapsed">
    // Check the Map.compute() default method, read the Javadoc carefully
    // for the handling of null values returned from the function.
    // </editor-fold>

    private Map<Integer, String> valuesToString(Map<Integer, StringBuilder> map) {
        return map.entrySet().stream().collect(
                Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().toString()));
    }
}
