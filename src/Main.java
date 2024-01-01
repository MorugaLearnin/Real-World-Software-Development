import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final String RESOURCES = "src/resources";

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + "/" + args[0]);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;

        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.US);
        for(final String line: lines) {
            final String[] columns = line.split (";");
//            for(String column: columns) {
//
//            }
            final LocalDate date = LocalDate.parse(columns[0].replace("\uFEFF", ""), DATE_PATTERN);
            System.out.println(date.getMonth());
            if(date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }
    }
}