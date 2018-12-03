package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value={
    solutions.A_Lambdas.class,
    solutions.B_Comparators.class,
    solutions.C_DefaultMethods.class,
    solutions.D_SimpleStreams.class,
    solutions.E_IntermediateStreams.class,
    solutions.F_AdvancedStreams.class
})
public class JUnit4TestSuite {
}
