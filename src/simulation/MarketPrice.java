package simulation;

import java.util.ArrayList;

public class MarketPrice
{
    private             double          demand;    //Nachfrage [Stück/Year]
    private     final   double          reactionRate;       //Reaktionsrate [1/Year]
    private     static         double          marketPrice;       // for unitcot access




    private             double          pricePressureCosts;                 //Preisdruck Kosten
    private             double          mismatchPrice;                      //Fehlanpassung Preis

    private             double          pricePressureDemand;              //Preisdruck Nachfrage
    private             double          mismatchDemand;                  //Fehlanpassung Nachfrage

    private             double          costAdjustment;



    private ArrayList<UnitCost> unitCosts;



    public MarketPrice(Double demand, Double reactionRate, Double marketPrice, ArrayList<UnitCost> unitCosts)
    {
        this.demand                  = demand ;
        this.reactionRate            = reactionRate ;
        this.marketPrice             = marketPrice;
        this.unitCosts               = unitCosts;
    }



    // npassungskosten
    public double calcCostAdjustment(Double productionA, Double productionB, Double productionSUM)
    {
        costAdjustment = (-0.5) * (((productionA / productionSUM) * unitCosts.get(0).getBenefitMarge()
                                                                / (unitCosts.get(0).getBenefitMarge()+1)) +
                                 ((productionB / productionSUM) * unitCosts.get(1).getBenefitMarge())
                                                                / (unitCosts.get(1).getBenefitMarge()+1));
        return costAdjustment;
    }




    /**     Berechnung Fehlanpassung Nachfrage
     * calculating mismatch demand for price pressure demand
     * if demand is zero mismatchDemand is -1
     * production capacity isn't allowed to be zero
     * production is always positive
     * @return mismatchDemand is a factor which is greater than  x > 0
     */

    public double calcMismatchDemand(Double capacitySUM)
    {
        if (capacitySUM > 0)
        {
            mismatchDemand = (  demand / capacitySUM) - 1;

            return mismatchDemand;
        }
        else if (demand == 0)
        {
            mismatchDemand = -1;
            return mismatchDemand;
        }
        else {
            mismatchDemand = 1 ;
            return mismatchDemand;
        }

    }


    /**   Berechnung Preisdruck Nachfrage
     *  calculate price pressure demand
     *  checking to avoid nullpointer exception
     * @return pricePressureDemand if nothing is null otherwise return 0.00
     */
    public double calcPricePressureDemand()
    {
        try
        {

            pricePressureDemand =(mismatchDemand * marketPrice * reactionRate );
            return pricePressureDemand;
        }
        catch (NullPointerException e)
        {
            System.out.println("ERROR: CHECK IF marketPrice OR reactionRate OR mismatchDemand IS NULL");
            e.printStackTrace();
            return 0.00;
        }

    }

    //Berechnung Fehlanpassung Preis

    /** calculating mismatch price
     *  getUnitCosts / getMarketPrice
     * @return
     */
    public double calcMismatchCost()
    {

        mismatchPrice =   ( unitCosts.get(0).getCosts() / marketPrice )    -    1;

        return mismatchPrice;
    }


    //Berechnung Preisdruck
    public double calcPricePressureCosts(Double costAdjustment)
    {
        pricePressureCosts = (costAdjustment * marketPrice * reactionRate);
        return pricePressureCosts;
    }

    /** calculate market price
     * calculation is based on Euler-Cauchy-Integration for INTEG(PressureDemand, PricePressureCost)
     * neuer Zustand = alter Zustand + Zustandsveränderung * Zeitschritt
     * @return
     */
    //Berechnung Marktpreis
    public double calcMarketPrice( )
    {
        marketPrice =  marketPrice +  ((pricePressureDemand + pricePressureCosts)* 0.0625);

        return marketPrice;
    }


    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public double getDemand() {
        return demand;
    }

    public double getReactionRate() {
        return reactionRate;
    }

    public double getPricePressureCosts() {
        return pricePressureCosts;
    }


    public double getCostAdjustment() {
        return costAdjustment;
    }

    public void setPricePressureCosts(double pricePressureCosts) {
        this.pricePressureCosts = pricePressureCosts;
    }

    public double getMismatchPrice() {
        return mismatchPrice;
    }

    public void setMismatchPrice(double missmatchPrice) {
        this.mismatchPrice = missmatchPrice;
    }

    public double getPricePressureDemand() {
        return pricePressureDemand;
    }

    public void setPricePressureDemand(double pricePressureDemand) {
        this.pricePressureDemand = pricePressureDemand;
    }

    public double getMismatchDemand() {
        return mismatchDemand;
    }

    public void setMismatchDemand(double mismatchDemand) {
        this.mismatchDemand = mismatchDemand;
    }


}
