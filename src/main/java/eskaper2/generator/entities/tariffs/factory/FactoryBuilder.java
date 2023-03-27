package eskaper2.generator.entities.tariffs.factory;

import eskaper2.generator.entities.tariffs.products.Tariff;
import eskaper2.generator.models.TypeOfTariff;

public class FactoryBuilder {

    public static Tariff Build(TypeOfTariff typeOfTariff) {
        if (typeOfTariff == TypeOfTariff.Default) {
            return new TariffCreator(new DefaultTariffFactory()).getTariff();
        }

        if (typeOfTariff == TypeOfTariff.Minute){
            return new TariffCreator(new MinuteTariffFactory()).getTariff();
        }

        return new TariffCreator(new UnlimitedTariffFactory()).getTariff();
    }
}
