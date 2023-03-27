package eskaper2.generator.entities.tariffs.factory;

import eskaper2.generator.entities.tariffs.factory.TariffFactory;
import eskaper2.generator.entities.tariffs.products.MinuteTariff;
import eskaper2.generator.entities.tariffs.products.Tariff;

public class MinuteTariffFactory extends TariffFactory {

    @Override
    public Tariff createTariff() {
        return  new MinuteTariff();
    }
}
