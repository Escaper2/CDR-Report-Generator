package eskaper2.generator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TextProcessor {

    private List<String> text;
    private HashSet<String> uniqueStrings;
    public TextProcessor(String path) throws IOException {

        text = Files.readAllLines(Paths.get(path));

        for (String string: text) {

            String[] params = string.split(",");

            String number = params[0];
            String typeOfCall = params[1];
            String startTime = params[2];
            String endTime = params[3];
            String typeOfTariff = params[4];


            Cdr cdr = new Cdr(number, typeOfCall, startTime, endTime, typeOfTariff);
        }
    }

}
