package simulation;

public class UnitCost extends Cost
{
    private final double TAXRATE;
    private       double benefitMarge;
    private       double investReaction;

    private ProductionCost productionCosts;
    private Production     production;


    public UnitCost(double TAXRATE, ProductionCost productionCosts, Production production)
    {
         this.TAXRATE         = TAXRATE;
         this.productionCosts = productionCosts;
         this.production      = production;
    }


    /** calculating benefit marge
     *  BenefitMarge [DYNAMIK] ||  UnitCost [DYNAMIK]
     *  MarketPrice > UnitCost
     * @return benefit marge between market price and unit cost
     */
    public double calcBenefitMarge(Double marketPrice)
    {
        benefitMarge = (marketPrice / cost) - 1;
        return benefitMarge;
    }


    /**
     * calculation for unit costs
     * @return cost
     */
    @Override
    public double calculateCosts()
    {
        cost = ( productionCosts.getCost() / production.getProductionCapacity() ) * (1 + TAXRATE);
        return cost;
    }


    /**
     * calculate different invest reaction for simulation with one company
     * @return invest reaction
     */
    public double calcInvestReaction()
    {
        if(benefitMarge > 0.1)
            investReaction = 1;
        else if (benefitMarge < - 0.1)
            investReaction = -1;
        else
            investReaction = benefitMarge;

        return  investReaction;
    }


    /**
     * calculate different invest reaction for simulation with two companies
     * @return invest reaction
     */
    public double calcInvestReactionI()
    {
        if(benefitMarge > 0.1)
            investReaction = 0.2;
        else if (benefitMarge < - 0.1)
            investReaction = -0.2;
        else
            investReaction = benefitMarge * 2;

        return investReaction;
    }


    public double getTAXRATE()
    {
        return TAXRATE;
    }

    public double getBenefitMarge()
    {
        return benefitMarge;
    }

    public double getInvestReaction()
    {
        return investReaction;
    }

}
