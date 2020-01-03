package simulation;

public class CapitalCost extends Cost
{
    private final double DEPRECIATIONRATE;    //Abschreibungssatz

    private final double SPECIFICCAPITALREQUIRMENT;     //spezifischer Kapitalbedarf


    private Production production;

    public CapitalCost(Double DEPRECIATIONRATE, Double SPECIFICCAPITALREQUIRMENT, Production production)
    {
        this.DEPRECIATIONRATE = DEPRECIATIONRATE;
        this.SPECIFICCAPITALREQUIRMENT = SPECIFICCAPITALREQUIRMENT;
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
        cost =((DEPRECIATIONRATE * production.getProductionCapacity()
                                                * SPECIFICCAPITALREQUIRMENT) );

        return cost;
    }


    public double getDEPRECIATIONRATE() {
        return DEPRECIATIONRATE;
    }

    public double getSPECIFICCAPITALREQUIRMENT() {
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
