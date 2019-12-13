package simulation;

public class MaterialCosts extends Costs
{

    private final double materialCost = 100 ;    //Materialkostensatz [€/Stück] 100 Basis

    private Production production;

    public MaterialCosts(Production production)
    {
        setProduction(production);
    }


    /** calculate the materialcost
     * materialCostRate describes the cost of one unit
     * dt as parameter of time
     * @return suoer.costs as double
     */
    @Override
    public double calculateCosts()
    {
        setCosts(   (getMaterialCost() * Production.getProductionCapacity())       );
        return getCosts();
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
