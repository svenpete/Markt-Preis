package simulation;

import java.util.ArrayList;

public class UnitCost extends Cost
{

    private final double taxRate;    //Steuersatz [1]
    private double benefitMarge;
    private double investReaction;



    private ProductionCost productionCosts;
    private Production production;

    public UnitCost(double taxRate, ProductionCost productionCosts, Production production)
    {

         this.taxRate = taxRate;
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
        benefitMarge =(marketPrice / costs) - 1;

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

        costs = ( productionCosts.getCosts() /
                 production.getProductionCapacity() )* (1 + taxRate);

        System.out.println( "Stückkosten (NO TAXES): "+    productionCosts.getCosts() /
                                production.getProductionCapacity() );

        return costs;
    }



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

    public double calcInvestReactionI()  // SIMULATION GROß
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

    public double getTaxRate()
    {
        return taxRate;
    }

    public ProductionCost getProductionCosts()
    {
        return productionCosts;
    }

    public double getBenefitMarge() {
        return benefitMarge;
    }

    public double getInvestReaction() {
        return investReaction;
    }


    public void setProductionCosts(ProductionCost productionCosts)
    {
        this.productionCosts = productionCosts;
    }


}
