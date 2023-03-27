package eskaper2.generator.services;

import eskaper2.generator.entities.report.Cdr;
import eskaper2.generator.entities.report.Report;
import eskaper2.generator.entities.tariffs.factory.FactoryBuilder;
import eskaper2.generator.entities.tariffs.products.Tariff;
import eskaper2.generator.models.TypeOfTariff;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReportsGenerator implements  ReportsGeneratorService {

    private TextProcessor textProcessor;
    private HashSet<String> uniqueNumbers;
    private List<Cdr> cdrList;
    private List<Report> reportsList;
    public ReportsGenerator(String path) throws IOException {
        if (path == null) throw new IllegalArgumentException();
        File file = new File(path);
        if (!file.exists()) throw new IllegalArgumentException();

        textProcessor = new TextProcessor(path);
        uniqueNumbers = textProcessor.getUniqueNumbers();
        cdrList = textProcessor.getCdrList();
        reportsList = new ArrayList<Report>();
        createReports();

    }

    public void run(){

        for (Report report : reportsList) {

            report.printReport();
        }
    }

    public void createReports() {

        for (String number: uniqueNumbers) {

            List<Cdr> phoneCalls = new ArrayList<Cdr>();

            for (Cdr cdr : cdrList) {

                if (number.equals(cdr.getNumber())) {

                    phoneCalls.add(cdr);
                }
            }
            TypeOfTariff typeOfTariff = phoneCalls.get(0).getTypeOfTariff();
            Tariff tariff = FactoryBuilder.Build(typeOfTariff);

            String phoneNumber =  phoneCalls.get(0).getNumber();

            Report report = new Report(phoneCalls, tariff, phoneNumber);
            reportsList.add(report);
        }
    }

    public List<Report> getReportsList() {
        return reportsList;
    }

}
