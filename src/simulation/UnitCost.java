package simulation;

public class UnitCost extends Cost
{

    private final double taxRate;    //Steuersatz [1]

    private ProductionCost productionCosts;

    public UnitCost(ProductionCost productionCosts)
    {
         taxRate = 0.2;
         this.productionCosts = productionCosts;
    }



    /**
     * calculation for unitCosts
     * adding taxes to unitcost as final Parameter
     * @return super.costs as double
     */


    public double calculateCosts(Double capac)
    {

        costs = ( productionCosts.getCosts() /
                 capac )* (1 + taxRate);

        System.out.println( "Stückkosten (NO TAXES): "+    productionCosts.getCosts() /
                                capac );

        return costs;
    }


    public double getTaxRate()
    {
        return taxRate;
    }

    public ProductionCost getProductionCosts()
    {
        return productionCosts;
    }


    public void setProductionCosts(ProductionCost productionCosts)
    {
        this.productionCosts = productionCosts;
    }


    @Override
    public double calculateCosts() {
        return 0;
    }
}
