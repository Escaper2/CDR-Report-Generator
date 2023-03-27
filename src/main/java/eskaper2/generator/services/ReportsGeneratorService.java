package eskaper2.generator.services;

import eskaper2.generator.entities.report.Report;

import java.util.HashSet;
import java.util.List;

public interface ReportsGeneratorService {

    void createReports();
    List<Report> getReportsList();

    void run();
}
