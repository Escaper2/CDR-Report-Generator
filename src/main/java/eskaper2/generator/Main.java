package eskaper2.generator;

import eskaper2.generator.services.ReportsGenerator;
import eskaper2.generator.services.ReportsGeneratorService;
import eskaper2.generator.services.TextProcessor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src", "main", "resources", "cdr.txt");
        ReportsGeneratorService service = new ReportsGenerator(path.toString());

        service.run();

    }
}