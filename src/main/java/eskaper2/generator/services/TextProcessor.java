package eskaper2.generator.services;

import eskaper2.generator.entities.report.Cdr;
import eskaper2.generator.entities.tariffs.factory.TariffFactory;
import eskaper2.generator.models.TypeOfCall;
import eskaper2.generator.models.TypeOfTariff;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TextProcessor {

    private List<String> text;
    private HashSet<String> uniqueNumbers;

    private List<Cdr> cdrList;
    public TextProcessor(String path) throws IOException {

        text = Files.readAllLines(Paths.get(path));
        cdrList = new ArrayList<Cdr>();
        uniqueNumbers = new HashSet<String>();

        for (String string: text) {

            String[] params = string.split(",");

            String typeOfCallString = params[0].trim();
            String number = params[1].trim();
            String startTime = params[2].trim();
            String endTime = params[3].trim();
            String typeOfTariffString = params[4].trim();


            TypeOfTariff typeOfTariff;
            typeOfTariff = TypeOfTariff.Minute;
            if (typeOfTariffString.equals(TypeOfTariff.Default.getType())) typeOfTariff = TypeOfTariff.Default;
            if (typeOfTariffString.equals(TypeOfTariff.Unlimited.getType())) typeOfTariff = TypeOfTariff.Unlimited;


            TypeOfCall typeOfCall;
            typeOfCall = TypeOfCall.Ingoing;
            if (typeOfCallString.equals(TypeOfCall.Outgoing.getType())) typeOfCall = TypeOfCall.Outgoing;

            Cdr cdr = new Cdr(number, typeOfCall, startTime, endTime, typeOfTariff);

            cdrList.add(cdr);
            uniqueNumbers.add(cdr.getNumber());
        }
    }

    public List<Cdr> getCdrList() {
        return cdrList;
    }

    public HashSet<String> getUniqueNumbers() {
        return uniqueNumbers;
    }
}
