public class CapitalCosts extends Costs
{
    private final double    depreciationRate            = 0.1;    //Abschreibungssatz [1/Year]
    private final int       specificCapitalRequirement  = 1;      //spezifischer Kapitalbedarf [€/(Stück/Year)]

    private Production production;  // vl ÄNDERN

    public CapitalCosts(Production produc)
    {

        setProduction(produc);

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
        setCosts((getDepreciationRate() * getProduction().getProductionCapacity()
                                                * getSpecificCapitalRequirement()));

        return getCosts();
    }


    public double getDepreciationRate() {
        return depreciationRate;
    }

    public int getSpecificCapitalRequirement() {
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
