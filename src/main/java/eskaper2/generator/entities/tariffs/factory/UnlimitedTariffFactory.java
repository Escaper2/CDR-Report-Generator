package eskaper2.generator.entities.tariffs.factory;

import eskaper2.generator.entities.tariffs.factory.TariffFactory;
import eskaper2.generator.entities.tariffs.products.Tariff;
import eskaper2.generator.entities.tariffs.products.UnlimitedTariff;

public class UnlimitedTariffFactory extends TariffFactory {

    @Override
    public Tariff createTariff() {
        return new UnlimitedTariff();
    }
}
