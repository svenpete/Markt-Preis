package simulation;

public class MaterialCost extends Cost
{

    private final double MATERIALCOSTUNIT;   //Materialkostensatz [€/Stück] 100 Basis

    private Production production;

    public MaterialCost(Double MATERIALCOSTUNIT, Production production)
    {
        this.production = production;
        this.MATERIALCOSTUNIT = MATERIALCOSTUNIT;
    }


    /** calculate the materialcost
     * materialCostRate describes the cost of one unit
     * dt as parameter of time
     * @return suoer.costs as double
     */
    @Override
    public double calculateCosts()
    {
        cost =  (MATERIALCOSTUNIT * production.getProductionCapacity())   ;
        return cost;
    }


    public double getMATERIALCOSTUNIT()
    {
        return MATERIALCOSTUNIT;
    }


    public Production getProduction()
    {
        return production;
    }


    public void setProduction(Production production)
    {
        this.production = production;
    }



}
