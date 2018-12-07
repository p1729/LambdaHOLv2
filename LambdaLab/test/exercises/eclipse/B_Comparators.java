package exercises.eclipse;

import model.Person;
import org.junit.Test;
import org.junit.Ignore;

import java.util.Comparator;
import java.util.function.IntBinaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Exercises to create comparators using lambda expressions
 * and using the Comparator combinators. Some of the exercises
 * use a Person class, which is a simple POJO containing a last
 * name, first name, and age, with the obvious constructors and
 * getters.
 */
public class B_Comparators {

    final Person michael = new Person("Michael", "Jackson", 51);
    final Person rod = new Person("Rod", "Stewart", 71);
    final Person paul = new Person("Paul", "McCartney", 74);
    final Person mick = new Person("Mick", "Jagger", 73);
    final Person jermaine = new Person("Jermaine", "Jackson", 61);

    /**
     * Write a Comparator that compare instances of String using their length.
     * For instance FOUR (4 letters) is greater than TWO (three letters)
     */
    @Test @Ignore
    public void comparator01() {
        Comparator<String> compareByLength = null; // TODO

        assertThat(compareByLength.compare("FOUR", "TWO")).isGreaterThan(0);
        assertThat(compareByLength.compare("ONE", "SEVEN")).isLessThan(0);
        assertThat(compareByLength.compare("ONE", "TWO")).isEqualTo(0);
    }
    /* Hint:
     * Check the static factory methods of the Comparator interface. Remember
     * how you implemented functions in the previous exercises. Write it using
     * a method reference.
     */

    /**
     * Write a Comparator that compare instances of String using their length.
     * If the lengths are the same, then use the alphabetical order.
     */
    @Test @Ignore
    public void comparator02() {
        Comparator<String> compareByLengthThenAlphabetical = null; // TODO

        assertThat(compareByLengthThenAlphabetical.compare("FOUR", "TWO")).isGreaterThan(0);
        assertThat(compareByLengthThenAlphabetical.compare("ONE", "SEVEN")).isLessThan(0);
        assertThat(compareByLengthThenAlphabetical.compare("ONE", "TWO")).isLessThan(0);
        assertThat(compareByLengthThenAlphabetical.compare("FOUR", "FIVE")).isGreaterThan(0);
        assertThat(compareByLengthThenAlphabetical.compare("EIGHT", "EIGHT")).isEqualTo(0);
    }
    /* Hint:
     * Use the previous comparator and check the default methods of the
     * Comparator interface.
     * Check also the factory methods of the Comparator interface, and remember
     * that String is comparable.
     */

    /**
     * Write a Comparator that compares instances of Person using their lastName.
     */
    @Test @Ignore
    public void comparator03() {
        Comparator<Person> comparebyLastName = null; // TODO

        assertThat(comparebyLastName.compare(michael, rod)).isLessThan(0);
        assertThat(comparebyLastName.compare(paul, paul)).isEqualTo(0);
        assertThat(comparebyLastName.compare(michael, jermaine)).isEqualTo(0);
    }
    /* Hint:
     * Check the static factory methods of the Comparator interface. Remember
     * how you implemented functions in the previous exercises. Write it using
     * a method reference.
     */

    /**
     * Write a Comparator that compares instances of Person using their
     * lastName, and if their last name is the same, uses their first name.
     */
    @Test @Ignore
    public void comparator04() {
        Comparator<Person> comparebyLastNameThenFirstName = null; // TODO

        assertThat(comparebyLastNameThenFirstName.compare(michael, rod)).isLessThan(0);
        assertThat(comparebyLastNameThenFirstName.compare(paul, paul)).isEqualTo(0);
        assertThat(comparebyLastNameThenFirstName.compare(michael, jermaine)).isGreaterThan(0);
    }
    /* Hint:
     * Use the previous comparator and check the default methods of the Comparator interface.
     */

    /**
     * Write a Comparator that compares the people in the order reversed from
     * the one you wrote in the comparator04() exercise. That is, the person
     * with the greater last name should be ordered first. If two persons have
     * the same last name, the one with the greater first name should be
     * ordered first.
     */
    @Test @Ignore
    public void comparator05() {
        Comparator<Person> comparebyLastNameThenFirstNameReversed = null; // TODO

        assertThat(comparebyLastNameThenFirstNameReversed.compare(michael, rod)).isGreaterThan(0);
        assertThat(comparebyLastNameThenFirstNameReversed.compare(paul, paul)).isEqualTo(0);
        assertThat(comparebyLastNameThenFirstNameReversed.compare(michael, jermaine)).isLessThan(0);
    }
    /* Hint:
     * Use the previous comparator and check the default methods of the Comparator interface.
     */

    /**
     * Write a Comparator that compares the people in the same order than the
     * one you wrote in comparator04(), but that supports null values. The null
     * values should be considered greater than any non-null values.
     */
    @Test @Ignore
    public void comparator06() {
        Comparator<Person> comparebyLastNameThenFirstNameWithNull = null; // TODO

        assertThat(comparebyLastNameThenFirstNameWithNull.compare(michael, rod)).isLessThan(0);
        assertThat(comparebyLastNameThenFirstNameWithNull.compare(paul, paul)).isEqualTo(0);
        assertThat(comparebyLastNameThenFirstNameWithNull.compare(michael, jermaine)).isGreaterThan(0);
        assertThat(comparebyLastNameThenFirstNameWithNull.compare(mick, null)).isLessThan(0);
        assertThat(comparebyLastNameThenFirstNameWithNull.compare(null, mick)).isGreaterThan(0);
    }
    /* Hint:
     * Use the previous comparator and check the static methods of the Comparator interface.
     */

    /**
     * Write a Comparator that compares two people by age.
     * Try to write the comparator so as to avoid boxing of primitives.
     */
    @Test @Ignore
    public void comparator07() {
        Comparator<Person> comparebyAge = null; // TODO

        assertThat(comparebyAge.compare(michael, rod)).isLessThan(0);
        assertThat(comparebyAge.compare(paul, paul)).isEqualTo(0);
        assertThat(comparebyAge.compare(mick, jermaine)).isGreaterThan(0);
    }
    /* Hint:
     * Look for static methods on the Comparator interface that
     * have primitive specializations.
     */

    /**
     * Write a lambda expression that compares two int values and returns an
     * int result that is less than, equal to, or greater than zero, like
     * a comparator. Watch out for overflow. The Comparator interface takes
     * two objects, but in this case we are comparing int primitives, so the
     * functional interface we use is IntBinaryOperator.
     */
    @Test @Ignore
    public void comparator08() {
        IntBinaryOperator intCompare = null; // TODO

        assertThat(intCompare.applyAsInt(0, 1)).isLessThan(0);
        assertThat(intCompare.applyAsInt(1, 1)).isEqualTo(0);
        assertThat(intCompare.applyAsInt(2, 1)).isGreaterThan(0);
        assertThat(intCompare.applyAsInt(Integer.MIN_VALUE, Integer.MAX_VALUE)).isLessThan(0);
        assertThat(intCompare.applyAsInt(Integer.MAX_VALUE, Integer.MIN_VALUE)).isGreaterThan(0);
    }
    /* Hint:
     * Use a ternary operator (cond ? result1 : result2) instead of subtraction.
     */

    /**
     * Write a method reference that compares two int values and returns an
     * int result that is less than, equal to, or greater than zero, like
     * a comparator.
     */
    @Test @Ignore
    public void comparator09() {
        IntBinaryOperator intCompare = null; // TODO

        assertThat(intCompare.applyAsInt(0, 1)).isLessThan(0);
        assertThat(intCompare.applyAsInt(1, 1)).isEqualTo(0);
        assertThat(intCompare.applyAsInt(2, 1)).isGreaterThan(0);
        assertThat(intCompare.applyAsInt(Integer.MIN_VALUE, Integer.MAX_VALUE)).isLessThan(0);
        assertThat(intCompare.applyAsInt(Integer.MAX_VALUE, Integer.MIN_VALUE)).isGreaterThan(0);
    }
    /* Hint:
     * Use a method reference to a static method on the Integer class.
     */

    interface DoubleToIntBiFunction {
        int applyAsInt(double a, double b);
    }

    /**
     * Write a method reference that compares two double values and returns an
     * int result that is less than, equal to, or greater than zero, like
     * a comparator. There is no functional interface that takes two doubles and returns
     * an int, so we define one here. Comparing double values introduces
     * special cases such NaN. Consider all NaN values to be equal to each other
     * and greater than any non-NaN value.
     */
    @Test @Ignore
    public void comparator10() {
        DoubleToIntBiFunction doubleCompare = null; // TODO

        assertThat(doubleCompare.applyAsInt(0.0, 1.0)).isLessThan(0);
        assertThat(doubleCompare.applyAsInt(1.0, 1.0)).isEqualTo(0);
        assertThat(doubleCompare.applyAsInt(2.0, 1.0)).isGreaterThan(0);
        assertThat(doubleCompare.applyAsInt(Double.NaN, Double.NaN)).isEqualTo(0);
        assertThat(doubleCompare.applyAsInt(Double.NaN, 0.0)).isGreaterThan(0);
        assertThat(doubleCompare.applyAsInt(0.0, Double.NaN)).isLessThan(0);
    }
    /* Hint:
     * Use a method reference to a static method on the Double class.
     */

    /**
     * Write a comparator that compare instances of the Person
     * class using the following rules:
     * - the instances are first compared using their last names
     * - then compared with their first names, which may be null
     *   (null should compare as greater than any non-null string)
     * - then compared with their age in descending order
     */
    @Test @Ignore
    public void comparator11() {
        Comparator<Person> cmp = null; // TODO

        assertThat(cmp.compare(michael, rod)).isLessThan(0);
        assertThat(cmp.compare(paul, paul)).isEqualTo(0);
        assertThat(cmp.compare(michael, jermaine)).isGreaterThan(0);
        assertThat(cmp.compare(mick, null)).isLessThan(0);
        assertThat(cmp.compare(null, mick)).isGreaterThan(0);
    }
}
