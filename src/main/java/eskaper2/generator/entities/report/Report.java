package eskaper2.generator.entities.report;

import eskaper2.generator.entities.tariffs.products.Tariff;
import eskaper2.generator.models.TypeOfCall;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Report {
    private List<Cdr> listOfCdrs;
    private Tariff typeOfTariff;
    private double totalSum;
    private String reportPath;
    private String phoneNumber;

    public Report(List<Cdr> listOfCdrs, Tariff typeOfTariff, String phoneNumber) {
        this.listOfCdrs = listOfCdrs;
        this.typeOfTariff = typeOfTariff;
        this.reportPath = "Reports\\" + phoneNumber + ".txt";
        this.phoneNumber = phoneNumber;
        totalSum = 0;
    }

    // Format a single call record for printing in the report
    private String formatCallRecord(Cdr cdr) {
        Duration duration = Duration.between(cdr.getStartTime(), cdr.getEndTime());
        var callType = cdr.getTypeOfCall().equals(TypeOfCall.Ingoing) ? "02" : "01";
        String startTime = cdr.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String endTime = cdr.getEndTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String callDuration = String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
        double cost = typeOfTariff.calculatePrice(cdr.getStartTime(), cdr.getEndTime(), cdr.getTypeOfCall());
        return String.format("| %9s | %19s | %19s | %8s | %7.2f |\n", callType, startTime, endTime, callDuration, cost);
    }


    private void printReportHeader() {
        try (FileWriter fileWriter = new FileWriter(reportPath)) {
            String header = "Tariff index: " + typeOfTariff.getTariffIndex() + "\n"
                    + "------------------------------------------------------------------------------\n"
                    + "Report for phone number " + phoneNumber + ":\n"
                    + "------------------------------------------------------------------------------\n"
                    + "| Call Type |   Start Time        |     End Time        | Duration | Cost  |\n"
                    + "------------------------------------------------------------------------------\n";
            fileWriter.write(header);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Print the footer of the report
    private void printReportFooter() {
        try (FileWriter fileWriter = new FileWriter(reportPath, true)) {
            String footer = "------------------------------------------------------------------------------\n"
                    + String.format("%57s |%10.2f rubles |\n", "Total Cost:", typeOfTariff.getCost())
                    + "------------------------------------------------------------------------------\n";
            fileWriter.write(footer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Print the report to the specified file
    public void printReport() {
        printReportHeader();
        try (FileWriter fileWriter = new FileWriter(reportPath, true)) {
            for (Cdr cdr : listOfCdrs) {
                String callRecord = formatCallRecord(cdr);
                fileWriter.write(callRecord);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printReportFooter();
    }


}
