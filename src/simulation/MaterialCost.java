package simulation;

public class MaterialCost extends Cost
{

    private final double materialCost;   //Materialkostensatz [€/Stück] 100 Basis

    private Production production;

    public MaterialCost(Production production)
    {
        this.production = production;
        materialCost = 100 ;
    }


    /** calculate the materialcost
     * materialCostRate describes the cost of one unit
     * dt as parameter of time
     * @return suoer.costs as double
     */
    @Override
    public double calculateCosts()
    {
        costs =  (materialCost * production.getProductionCapacity())   ;
        return costs;
    }


    public double getMaterialCost()
    {
        return materialCost;
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
