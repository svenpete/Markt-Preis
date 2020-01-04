package simulation;

public class CapitalCost extends Cost
{
    private final double DEPRECIATIONRATE;

    private final double SPECIFICCAPITALREQUIRMENT;

    private Production production;


    public CapitalCost(Double DEPRECIATIONRATE, Double SPECIFICCAPITALREQUIRMENT, Production production)
    {
        this.DEPRECIATIONRATE = DEPRECIATIONRATE;
        this.SPECIFICCAPITALREQUIRMENT = SPECIFICCAPITALREQUIRMENT;
        this.production = production;

    }

    /** Calculation for capitalcost
     * @return cost
     */
    @Override
    public double calculateCosts()
    {
        cost = ((DEPRECIATIONRATE * production.getProductionCapacity()
                                                * SPECIFICCAPITALREQUIRMENT) );
        return cost;
    }


    public double getDEPRECIATIONRATE()
    {
        return DEPRECIATIONRATE;
    }

    public double getSPECIFICCAPITALREQUIREMENT() {
        return SPECIFICCAPITALREQUIRMENT;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public Production getProduction()
    {
        return production;
    }

}
