package eskaper2.generator.entities.tariffs.factory;

import eskaper2.generator.entities.tariffs.factory.TariffFactory;
import eskaper2.generator.entities.tariffs.products.Tariff;

public class TariffCreator {

    Tariff tariff;
    public TariffCreator(TariffFactory factory) {

        tariff = factory.createTariff();
    }

    public Tariff getTariff() {
        return tariff;
    }
}
