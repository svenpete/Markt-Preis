package simulation;

public class ProductionCost extends Cost
{
    private final double PROFITMARGIN;

    private CapitalCost  capitalCost;
    private MaterialCost materialCost;
    private LabourCost   labourCost;


    /**
     * create references because of missing attributes for calculations
     */
    public ProductionCost(CapitalCost capitalCost, MaterialCost materialCost, LabourCost labourCost)
    {
        PROFITMARGIN      = 0.05;
        this.capitalCost  = capitalCost;
        this.materialCost = materialCost;
        this.labourCost   = labourCost;
    }


    /**
     * Calculation production cost
     * adding labour cost, capital cost material cost and profit margin
     * @return costs
     */
    @Override
    public double calculateCosts()
    {
        cost = (labourCost.getCost() + capitalCost.getCost() + materialCost.getCost()) * (1 + PROFITMARGIN);
        return cost;
    }


    public double getPROFITMARGIN()
    {
        return PROFITMARGIN;
    }

}
