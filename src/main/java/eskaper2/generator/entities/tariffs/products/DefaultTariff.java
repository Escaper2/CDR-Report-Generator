package eskaper2.generator.entities.tariffs.products;

import eskaper2.generator.models.TypeOfCall;
import eskaper2.generator.models.TypeOfTariff;

import java.time.Duration;
import java.time.LocalDateTime;

public class DefaultTariff implements Tariff {
    private double remainingMinutesForOutgoingTariff;

    private String tariffIndex;

    private double cost;

    public DefaultTariff(){
        remainingMinutesForOutgoingTariff = 100;
        tariffIndex = TypeOfTariff.Default.getType();
        cost = 0;
    }
    @Override
    public double calculatePrice(LocalDateTime startTime, LocalDateTime endTime, TypeOfCall typeOfCall) {

        if (typeOfCall == TypeOfCall.Ingoing) return 0;

        double durationInMinutes = Duration.between(startTime, endTime).toMinutesPart();
        double durationInSeconds = Duration.between(startTime, endTime).toSecondsPart();
        durationInMinutes += (durationInSeconds /100) ;

        remainingMinutesForOutgoingTariff -= durationInMinutes;

        if (remainingMinutesForOutgoingTariff > 0) {

            double temp = durationInMinutes * 0.5;
            cost += (double) Math.round(temp * 100) / 100;
            return  (double) Math.round(temp * 100) / 100;
        }

        double temp = durationInMinutes * 1.5;
        cost += (double) Math.round(temp * 100) / 100;
        return cost;

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
