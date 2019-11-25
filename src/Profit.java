import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Profit extends Costs //INTERFACE???????????????
{
    private final double profitMargin = 0.05;   //Profitmarge [1]
    private ProductionCosts productionCost;
    private double profit;


    Profit (ProductionCosts productionCosts)
    {
        setProductionCost(productionCosts);
    }



    /**
     * calculation for profit
     * profit could be calculated together with Productioncost.calculateCost
     * @return profit is double
     */
    @Override
    public double calculateCosts()
    {

        setProfit( (getProfitMargin() * getProductionCost().getCosts()
                                     / ( 1 + getProfitMargin())));

        /* //     show stop by step calculation

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator('.');
        DecimalFormat f               =   new DecimalFormat("###,##0.00", symbols);


        System.out.println(f.format(getProfitMargin()) + " * " + f.format(productionCost.getCosts()) +
                        " /  1 + " + f.format(getProfitMargin()));


        System.out.println( f.format(getProfitMargin() * productionCost.getCosts()) +
                "/" + f.format( 1  + getProfitMargin()));
        */

        return getProfit();
    }


    public void setProductionCost(ProductionCosts productionCost)
    {
        this.productionCost = productionCost;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getProfit() {
        return profit;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    public ProductionCosts getProductionCost() {
        return productionCost;
    }
}
