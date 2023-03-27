package eskaper2.generator.entities.tariffs.factory;
import eskaper2.generator.entities.tariffs.products.DefaultTariff;
import eskaper2.generator.entities.tariffs.products.Tariff;

public class DefaultTariffFactory extends TariffFactory {

    @Override
    public Tariff createTariff() {
        return new DefaultTariff();
    }
}
