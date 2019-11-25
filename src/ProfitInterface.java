public interface ProfitInterface {

    final double profitMargin = 0.05;   //Profitmarge [1]

    default double calculateCosts(Double Produktionscost, Double productionVolume, Double taxRate)
    {
        double costs = (Produktionscost/ productionVolume) * (1 + taxRate);
        return costs;
    }

}
