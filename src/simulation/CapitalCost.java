package simulation;

public class CapitalCost extends Cost
{
    private final double    depreciationRate;    //Abschreibungssatz [1/Year]
    private final double       specificCapitalRequirement;     //spezifischer Kapitalbedarf [€/(Stück/Year)]


    private Production production;  // vl ÄNDERN

    public CapitalCost(Double depreciationRate, Double specificCapitalRequirement, Production production)
    {
        this.depreciationRate = depreciationRate;
        this.specificCapitalRequirement  = specificCapitalRequirement ;
        this.production = production;

    }

    /** Calculation for CapitalCost  //Berechnung der Kapitalkosten
     *  product of depreciationRate [ fix ]  ||  specificCapitalRequirement [ fix ] ||  ProductionCapacity  [ DYNAMIK ]
     *  ProductionCapacity x2 > x1  increase
     *  ProductionCapacity X2 < x1 decrease
     * @return super.cost
     */
    @Override
    public double calculateCosts()
    {
        costs =((depreciationRate * production.getProductionCapacity()
                                                * specificCapitalRequirement) );

        return costs;
    }


    public double getDepreciationRate() {
        return depreciationRate;
    }

    public double getSpecificCapitalRequirement() {
        return specificCapitalRequirement;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public Production getProduction()
    {
        return production;
    }

}
