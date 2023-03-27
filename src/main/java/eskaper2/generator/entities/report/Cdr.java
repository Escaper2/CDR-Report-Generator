package eskaper2.generator.entities.report;

import eskaper2.generator.models.TypeOfCall;
import eskaper2.generator.models.TypeOfTariff;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cdr {
    private String number;
    private TypeOfCall typeOfCall;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private TypeOfTariff typeOfTariff;
    public Cdr(String number, TypeOfCall typeOfCall, String startTime, String endTime, TypeOfTariff typeOfTariff){

        this.number = number;
        this.typeOfCall = typeOfCall;
        this.typeOfTariff = typeOfTariff;
        this.startTime = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        this.endTime = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));;
    }

    public String getNumber() {
        return number;
    }

    public TypeOfCall getTypeOfCall() {
        return typeOfCall;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public TypeOfTariff getTypeOfTariff() {
        return typeOfTariff;
    }
}
