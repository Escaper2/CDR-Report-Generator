package eskaper2.generator.entities.tariffs.products;

import eskaper2.generator.models.TypeOfCall;
import eskaper2.generator.models.TypeOfTariff;

import java.time.Duration;
import java.time.LocalDateTime;

public class UnlimitedTariff  implements Tariff {
    private double remainingMinutes;
    private double cost;
    private String tariffIndex;

    public UnlimitedTariff(){
        remainingMinutes = 300;
        cost = 0;
        tariffIndex = TypeOfTariff.Unlimited.getType();
    }

    public double getRemainingMinutes() {
        return remainingMinutes;
    }

    @Override
    public double calculatePrice(LocalDateTime startTime, LocalDateTime endTime, TypeOfCall typeOfCall) {

        double durationInMinutes = Duration.between(startTime, endTime).toMinutesPart();
        double durationInSeconds = Duration.between(startTime, endTime).toSecondsPart();
        durationInMinutes += (durationInSeconds /100) ;

        remainingMinutes -= durationInMinutes;

        if (remainingMinutes < 0) {

            double temp = (remainingMinutes * -1);
            cost += (double) Math.round(temp * 100) / 100;
            remainingMinutes = 0;
        }

        return  cost;
    }

    @Override
    public String getTariffIndex() {
        return tariffIndex;
    }

    public double getCost() {
        return cost + 100;
    }
}
