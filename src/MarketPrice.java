public class MarketPrice
{
    private             int             demand                  = 500000;    //Nachfrage [Stück/Year]
    private     final   double          reactionRate            = 0.5;       //Reaktionsrate [1/Year]
    private             double          marketPrice             = 100;       // Vorerst vorgeben zum Testen spätere Implementierung des Marktpreises;


    private             double          benefitMarge;                       //Gewinnmarge
    private             double          pricePressureCosts;                 //Preisdruck Kosten
    private             double          mismatchPrice;                      //Fehlanpassung Preis

    private             double          pricePressureDemand;              //Preisdruck Nachfrage
    private             double          mismatchDemand;                  //Fehlanpassung Nachfrage
    public static              double          investReaction;

    private             UnitCosts       unitCosts;             //Asso


    public MarketPrice(UnitCosts unitCosts)
    {
        setUnitCosts(unitCosts);
    }


    public double calcInvestReaction()
    {
        if(getBenefitMarge() > 1) {
            setInvestReaction( 1.05);
        }
        else if (getBenefitMarge() == 0)
        {
            setInvestReaction(1);
        }
        else {
            setInvestReaction(-0.05);
        }
        return (int) getInvestReaction();
    }

    /** calculating benefit marge
     *  BenefitMarge [ DYNAMIK ] ||  UnitCost [ DYNAMIK ]
     *  MarketPrice > UnitCost
     *
     * @return Double between
     */
    public double calcBenefitMarge()
    {
        setBenefitMarge((getMarketPrice() / getUnitCosts().getCosts()) - 1);

        return getBenefitMarge();
    }

    /**     Berechnung Fehlanpassung Nachfrage
     * calculating mismatch demand for price pressure demand
     * if demand is zero mismatchDemand is -1
     * production capacity isn't allowed to be zero
     * production is always positive
     * @return mismatchDemand is a factor which is greater than  x > 0
     */

    public double calcMismatchDemand()
    {
        if (getDemand() == 0)
        {
            return -1;
        }

        if (Production.getProductionCapacity() > 0)
        {
            setMismatchDemand((  getDemand() / Production.getProductionCapacity()) - 1);

            return getMismatchDemand();
        }
        else
        {
            System.out.println("ERROR: PRODUCTION CAPACITY IS LESS THAN ZERO");
            return 1;
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

            setPricePressureDemand(getMismatchDemand() * getMarketPrice() * getReactionRate() );
            return getPricePressureDemand();
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

        setMismatchPrice(   ( getUnitCosts().getCosts() / getMarketPrice() )    -    1);

        return getMismatchPrice();
    }


    //Berechnung Preisdruck
    public double calcPricePressureCosts()
    {
        setPricePressureCosts(getMismatchPrice() * getMarketPrice() * getReactionRate());
        return getPricePressureCosts();
    }

    /** calculate market price
     * calculation is based on Euler-Cauchy-Integration for INTEG(PressureDemand, PricePressureCost)
     * neuer Zustand = alter Zustand + Zustandsveränderung * Zeitschritt
     * @return
     */
    //Berechnung Marktpreis
    public double calcMarketPrice()
    {
        setMarketPrice((getMarketPrice() +  (getPricePressureDemand() + getPricePressureCosts())));

        return getMarketPrice();
    }


    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public int getDemand() {
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

    public UnitCosts getUnitCosts() {
        return unitCosts;
    }

    public void setUnitCosts(UnitCosts unitCosts) {
        this.unitCosts = unitCosts;
    }

    public void setInvestReaction(double investReaction)
    {
        this.investReaction = investReaction;
    }
}
