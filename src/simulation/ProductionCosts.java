package simulation;

public class ProductionCosts extends Costs
{

    private final double profitMargin = 0.05;   //Profitmarge [1]

    private CapitalCosts Capitalcost;
    private MaterialCosts Materialcost;
    private LabourCosts Labourcost;

     // create references because of missing attributes for calculations
    public ProductionCosts(CapitalCosts Ccost, MaterialCosts Mcost, LabourCosts Lcost)
    {
    setCapitalcost(Ccost);
    setMaterialcost(Mcost);
    setLabourcost((Lcost));
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

        setCosts(((getLabourcost().getCosts() + getCapitalcost().getCosts()
                + getMaterialcost().getCosts()) * (1 + getProfitMargin())) );

        /*
        DecimalFormatSymbols symbols     = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator('.');
        DecimalFormat f                  =   new DecimalFormat("###,##0.00", symbols);

        System.out.println("ProfitMarge: SumCost: " + f.format(Labourcost.getCosts() + Capitalcost.getCosts()
               + Materialcost.getCosts()));

        System.out.println("ProfitMarge: " + f.format((Labourcost.getCosts() + Capitalcost.getCosts()
                + Materialcost.getCosts()) * profitMargin));
         */

        return getCosts();
    }

    public double getProfitMargin()
    {
        return profitMargin;
    }

    public void setCapitalcost(CapitalCosts capitalcost)
    {
        Capitalcost = capitalcost;
    }

    public void setLabourcost(LabourCosts labourcost)
    {
        Labourcost = labourcost;
    }

    public void setMaterialcost(MaterialCosts materialcost)
    {
        Materialcost = materialcost;
    }

    public CapitalCosts getCapitalcost()
    {
        return Capitalcost;
    }

    public LabourCosts getLabourcost()
    {
        return Labourcost;
    }

    public MaterialCosts getMaterialcost()
    {
        return Materialcost;
    }
}
