package simulation;

public class Profit extends Cost
{
    private final double profitMargin;
    private double profit;
    private ProductionCost productionCosts;


    Profit (Double profitMargin, ProductionCost productionCosts)
    {
        this.productionCosts = productionCosts;
        this.profitMargin = profitMargin;  // Parameter simulation 0.05 standard
    }


    /**
     * calculation for profit
     * profit could be calculated together with Productioncost.calculateCost
     * @return profit is double
     */
    @Override
    public double calculateCosts()
    {

        profit = ( profitMargin * productionCosts.getCosts()
                                / ( 1 + profitMargin) );

        /* //     show stop by step calculation

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator('.');
        DecimalFormat f               =   new DecimalFormat("###,##0.00", symbols);


        System.out.println(f.format(getProfitMargin()) + " * " + f.format(productionCost.getCosts()) +
                        " /  1 + " + f.format(getProfitMargin()));


        System.out.println( f.format(getProfitMargin() * productionCost.getCosts()) +
                "/" + f.format( 1  + getProfitMargin()));
        */

        return profit;
    }



    public double getProfit() {
        return profit;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public ProductionCost getProductionCost() {
        return productionCosts;
    }


    public void setProductionCost(ProductionCost productionCost)
    {
        this.productionCosts = productionCost;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
