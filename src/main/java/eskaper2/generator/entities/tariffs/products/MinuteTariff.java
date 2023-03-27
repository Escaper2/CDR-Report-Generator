package eskaper2.generator.entities.tariffs.products;

import eskaper2.generator.models.TypeOfCall;
import eskaper2.generator.models.TypeOfTariff;

import java.time.Duration;
import java.time.LocalDateTime;

public class MinuteTariff implements Tariff {

    private String tariffIndex;

    private double cost;
    public MinuteTariff(){
        tariffIndex = TypeOfTariff.Minute.getType();
        cost = 0;
    }
    @Override
    public double calculatePrice(LocalDateTime startTime, LocalDateTime endTime, TypeOfCall typeOfCall) {

        double durationInMinutes = Duration.between(startTime, endTime).toMinutesPart();
        double durationInSeconds = Duration.between(startTime, endTime).toSecondsPart();
        durationInMinutes += (durationInSeconds /100) ;

        double temp = durationInMinutes * 1.5;
        cost += (double) Math.round(temp * 100) / 100;

        return (double) Math.round(temp * 100) / 100;

    }

    @Override
    public String getTariffIndex() {
        return tariffIndex;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
