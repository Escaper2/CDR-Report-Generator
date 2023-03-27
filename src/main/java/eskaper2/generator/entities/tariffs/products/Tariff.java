package eskaper2.generator.entities.tariffs.products;

import eskaper2.generator.models.TypeOfCall;

import java.time.LocalDateTime;

public interface Tariff {

    double calculatePrice(LocalDateTime startTime, LocalDateTime endTime, TypeOfCall typeOfCall);

    String getTariffIndex();

    double getCost();
}
