package simulation;

public class ProductionCost extends Cost
{

    private final double profitMargin;   //Profitmarge [1]

    private CapitalCost capitalCost;
    private MaterialCost materialCost;
    private LabourCost labourCost;

     // create references because of missing attributes for calculations
    public ProductionCost(CapitalCost capitalCost, MaterialCost materialCost, LabourCost labourCost)
    {
        profitMargin = 0.05;
        this.capitalCost = capitalCost;
        this.materialCost = materialCost;
        this.labourCost = labourCost;
    }


    /**
     * Calculation production cost
     * adding labour cost, capital cost and material cost
     * adding profitMargin as cost
     * profitMargin is final
     * @return super.costs is double
     */

    @Override
    public double calculateCosts()
    {

        costs = (labourCost.getCosts() + capitalCost.getCosts()
                + materialCost.getCosts()) * (1 + profitMargin) ;

        /*
        DecimalFormatSymbols symbols     = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator('.');
        DecimalFormat f                  =   new DecimalFormat("###,##0.00", symbols);

        System.out.println("ProfitMarge: SumCost: " + f.format(Labourcost.getCosts() + Capitalcost.getCosts()
               + Materialcost.getCosts()));

        System.out.println("ProfitMarge: " + f.format((Labourcost.getCosts() + Capitalcost.getCosts()
                + Materialcost.getCosts()) * profitMargin));
         */

        return costs;
    }

    public double getProfitMargin()
    {
        return profitMargin;
    }

    public void setCapitalCost(CapitalCost capitalCost)
    {
        this.capitalCost = capitalCost;
    }

    public void setLabourCost(LabourCost labourCost)
    {
        this.labourCost = labourCost;
    }

    public void setMaterialCost(MaterialCost materialCost)
    {
        this.materialCost = materialCost;
    }

    public CapitalCost getCapitalCost()
    {
        return capitalCost;
    }

    public LabourCost getLabourCost()
    {
        return labourCost;
    }

    public MaterialCost getMaterialCost()
    {
        return materialCost;
    }
}
