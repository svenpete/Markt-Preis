package simulation;

public class UnitCost extends Cost
{

    private final double TAXRATE;
    private double benefitMarge;
    private double investReaction;

    private ProductionCost productionCosts;
    private Production production;

    public UnitCost(double TAXRATE, ProductionCost productionCosts, Production production)
    {

         this.TAXRATE = TAXRATE;
         this.productionCosts = productionCosts;
         this.production = production;


    }

    /** calculating benefit marge
     *  BenefitMarge [ DYNAMIK ] ||  UnitCost [ DYNAMIK ]
     *  MarketPrice > UnitCost
     *
     * @return Double between
     */
    public double calcBenefitMarge(Double marketPrice)
    {
        benefitMarge =(marketPrice / cost) - 1;

        return benefitMarge;
    }

    /**
     * calculation for unitCosts
     * adding taxes to unitcost as final Parameter
     * @return super.costs as double
     */

    @Override
    public double calculateCosts()
    {

        cost = ( productionCosts.getCost() /
                 production.getProductionCapacity() )* (1 + TAXRATE);



        return cost;
    }


    // calculate different for simulation with 1 company
    public double calcInvestReaction()
    {
        if(benefitMarge > 0.1) {
            investReaction = 1 ;
        }
        else if (benefitMarge < -0.1)
        {
            investReaction= -1 ;
        }
        else {
            investReaction = benefitMarge  ;
        }
        return  investReaction;
    }

    // calculate different for simulation with 2 company
    public double calcInvestReactionI()
    {
        if(benefitMarge > 0.1) {
            investReaction = 0.2;
        }
        else if (benefitMarge < -0.1)
        {
            investReaction= -0.2 ;
        }
        else {
            investReaction = benefitMarge * 2 ;
        }
        return  investReaction;
    }

    public double getTAXRATE()
    {
        return TAXRATE;
    }

    public double getBenefitMarge() {
        return benefitMarge;
    }

    public double getInvestReaction() {
        return investReaction;
    }

}
