package support;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Process all files test/solutions/*.java into corresponding files in
 * test/exercises/*.java.
 */
public class Grind {

    static class Sink implements Consumer<String> {
        boolean removing = false;
        boolean hint = false;
        boolean eclipse;
        final PrintStream out;
        Sink(PrintStream out, boolean eclipse) { this.out = out; this.eclipse = eclipse;}
        public void accept(String line) {
            if (line.contains("import org.junit.Test;")) {
                out.println(line);
                out.println("import org.junit.Ignore;");
            } else if (line.contains("//BEGINREMOVE")) {
                removing = true;
            } else if (line.contains("//ENDREMOVE")) {
                removing = false;
            } else if (eclipse) {
                if (line.contains("// Hint")) {
                    out.println(line.replace("//","/*"));
                    hint = true;
                } else if (line.contains("<editor-fold")) {
                } else if (line.contains("</editor-fold")) {
                    out.println("     */");
                    hint = false;
                } else if (hint) {
                    out.println(line.replace("//"," *"));
                } else if (!removing) {
                    out.println(line);
                }
            } else if (!removing) {
                out.println(line);
            }
        }
    }

    String subst(String line, boolean eclipse) {
        return line.replace("package solutions;", "package exercises" + (eclipse ? ".eclipse" : ".otherides") + ";")
                .replace("@Test", "@Test @Ignore")
                .replace("//UNCOMMENT//", "")
                .replaceFirst("^(.*)//TODO//(.*)$", "$1$2 // TODO");
    }

    void processFile(Path input) {
        // NetBeans/IntelliJ
        Path output = Paths.get("test", "exercises", "otherides")
                .resolve(input.getName(input.getNameCount() - 1));
        System.out.println(input + " => " + output);

        try (Stream<String> lines = Files.lines(input);
             PrintStream out = new PrintStream(output.toFile())) {
            lines.map(s -> subst(s, false))
                    .forEachOrdered(new Sink(out, false));
        } catch (IOException ioe) {
            throw new UncheckedIOException(ioe);
        }

        // Eclipse
        output = Paths.get("test", "exercises", "eclipse")
                .resolve(input.getName(input.getNameCount() - 1));
        System.out.println(input + " => " + output);

        try (Stream<String> lines = Files.lines(input);
             PrintStream out = new PrintStream(output.toFile())) {
            lines.map(s -> subst(s, true))
                    .forEachOrdered(new Sink(out, true));
        } catch (IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }

    void run() throws IOException {
        Path dir = Paths.get("test", "solutions");
        try (Stream<Path> paths = Files.list(dir)) {
            paths.filter(p -> p.toString().endsWith(".java"))
                    .forEachOrdered(this::processFile);
        }
    }

    public static void main(String[] args) throws IOException {
        new Grind().run();
    }
}
