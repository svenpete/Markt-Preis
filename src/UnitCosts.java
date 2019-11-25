public class UnitCosts extends Costs
{

    private final double taxRate = 0.2;    //Steuersatz [1]

    private ProductionCosts productionCosts;

    public UnitCosts(ProductionCosts productionCosts)
    {
         setProductionCosts(productionCosts);
    }



    /**
     * calculation for unitCosts
     * adding taxes to unitcost as final Parameter
     * @return super.costs as double
     */


    public double calculateCosts()
    {

         setCosts(( getProductionCosts().getCosts() /
                 Production.getProductionCapacity() )* (1 + getTaxRate()));

        System.out.println( "Stückkosten (NO TAXES): "+    getProductionCosts().getCosts() /
                                Production.getProductionCapacity() );

        return getCosts();
    }


    public double getTaxRate()
    {
        return taxRate;
    }

    public ProductionCosts getProductionCosts()
    {
        return productionCosts;
    }

    public void setProductionCosts(ProductionCosts productionCosts)
    {
        this.productionCosts = productionCosts;
    }


}
