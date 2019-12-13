package simulation;

public class MarketPrice
{
    private             double          demand;    //Nachfrage [Stück/Year]
    private     final   double          reactionRate;       //Reaktionsrate [1/Year]
    private             double          marketPrice;       // Vorerst vorgeben zum Testen spätere Implementierung des Marktpreises;


    private             double          benefitMarge;                       //Gewinnmarge
    private             double          pricePressureCosts;                 //Preisdruck Kosten
    private             double          mismatchPrice;                      //Fehlanpassung Preis

    private             double          pricePressureDemand;              //Preisdruck Nachfrage
    private             double          mismatchDemand;                  //Fehlanpassung Nachfrage
    public        double          investReaction;

    private UnitCost unitCosts;             //Asso


    public MarketPrice(UnitCost unitCosts)
    {
        demand                  = 500000 ;
        reactionRate            = 0.5 ;
        marketPrice             = 100;
        this.unitCosts = unitCosts;
    }


    public double calcInvestReaction()
    {
        if(benefitMarge > 0.1) {
             investReaction = (1 * 0.0625);
        }
        else if (benefitMarge < -0.1)
        {
            investReaction= ( -1 * 0.0625);
        }
        else {
            investReaction = (benefitMarge * 0.0625) ;
        }
        return  investReaction;
    }

    /** calculating benefit marge
     *  BenefitMarge [ DYNAMIK ] ||  UnitCost [ DYNAMIK ]
     *  MarketPrice > UnitCost
     *
     * @return Double between
     */
    public double calcBenefitMarge()
    {
        benefitMarge =(marketPrice / unitCosts.getCosts()) - 1;

        return benefitMarge;
    }

    /**     Berechnung Fehlanpassung Nachfrage
     * calculating mismatch demand for price pressure demand
     * if demand is zero mismatchDemand is -1
     * production capacity isn't allowed to be zero
     * production is always positive
     * @return mismatchDemand is a factor which is greater than  x > 0
     */

    public double calcMismatchDemand(Double capac)
    {
        if (capac > 0)
        {
            mismatchDemand = (  demand / capac) - 1;

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

        mismatchPrice =   ( unitCosts.getCosts() / marketPrice )    -    1;

        return mismatchPrice;
    }


    //Berechnung Preisdruck
    public double calcPricePressureCosts()
    {
        pricePressureCosts = (mismatchPrice * marketPrice * reactionRate);
        return pricePressureCosts;
    }

    /** calculate market price
     * calculation is based on Euler-Cauchy-Integration for INTEG(PressureDemand, PricePressureCost)
     * neuer Zustand = alter Zustand + Zustandsveränderung * Zeitschritt
     * @return
     */
    //Berechnung Marktpreis
    public double calcMarketPrice()
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

    public double getBenefitMarge() {
        return benefitMarge;
    }

    public void setBenefitMarge(double benefitMarge) {
        this.benefitMarge = benefitMarge;
    }

    public double getPricePressureCosts() {
        return pricePressureCosts;
    }

    public double getInvestReaction()
    {
        return investReaction;
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

    public UnitCost getUnitCosts() {
        return unitCosts;
    }

    public void setUnitCosts(UnitCost unitCosts) {
        this.unitCosts = unitCosts;
    }

    public void setInvestReaction(double investReaction)
    {
        this.investReaction = investReaction;
    }
}
