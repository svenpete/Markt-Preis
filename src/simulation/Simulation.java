package simulation;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Simulation
{
    private Double [] marketPrice;
    private Double [] profit;
    private Double [] produktionsKapazität;
    /*private Double [] employee;
    private Double [] profit;
    private Double [] produktionsKapazität;
    */

    public Simulation()
    {

    }

    public void simulate(Integer initalTime, Integer finalTime, Integer finalStep)
    {

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator('.');
        DecimalFormat f                 =   new DecimalFormat("###,##0.0000", symbols);


        Production      produc          =   new Production();
        Employee employe         =   new Employee(produc);

        LabourCost laCost          =   new LabourCost(employe);
        CapitalCost caCost          =   new CapitalCost(produc);
        MaterialCost maCost          =   new MaterialCost(produc);

        ProductionCost proCost         =   new ProductionCost(caCost,maCost,laCost);
        Profit          profit          =   new Profit(proCost);
        UnitCost unCost          =   new UnitCost(proCost);

        MarketPrice     marketPrice     =   new MarketPrice(unCost);

        // safe
        Double [] map = new Double[finalTime];
        Double [] producCap = new Double[finalTime];
        Double [] prof= new Double[finalTime];

        for (int i = initalTime; i < finalTime ; i = i + finalStep)
        {

            // dont change order nor methods  work !
            System.out.println("Beschäftigte:           "         +   f.format(employe.computeEmployees()) +"\t");

            System.out.println("Arbeitskosten:          "         +   f.format(laCost.calculateCosts())+"\t");
            System.out.println("Kapitalkosten:          "         +   f.format(caCost.calculateCosts()    )+"\t");
            System.out.println("Materialkosten:         "         +   f.format(maCost.calculateCosts()    )+"\t");


            System.out.println("ProduktionsKosten:      "         +   f.format(proCost.calculateCosts()   )+"\t");

            prof[i] = profit.getProfit();
            System.out.println("Profit:                 "         +   f.format(profit.calculateCosts()    )+"\t");


            System.out.println("Stückkosten:            "         +   f.format( (unCost.calculateCosts(produc.getProductionCapacity())   ))+"\n");

            System.out.println("GewinnMarge:            "         +   f.format(marketPrice.calcBenefitMarge())+"\t");

            System.out.println("Fehlanpassung Nachfrage:"         +   f.format(marketPrice.calcMismatchDemand(produc.getProductionCapacity()))+"\t");
            System.out.println("Preisdruck Nachfrage:   "         +   f.format(marketPrice.calcPricePressureDemand())+"\t");
            System.out.println("Fehlanpassung Preis:    "         +   f.format(marketPrice.calcMismatchCost())+"\t");
            System.out.println("Preisdruckkosten:       "         +   f.format(marketPrice.calcPricePressureCosts())+"\t");

            System.out.println("Investreaktio: "                   +  f.format(marketPrice.calcInvestReaction())+"\t");
            System.out.println("Kapazitätsveränderung: "           +  f.format(produc.calculateCapacityChange(marketPrice.getInvestReaction()))+"\t");

            producCap[i] = produc.getProductionCapacity();
            System.out.println("Produktionskapazität:"             +  f.format(produc.calculateProductCapacity())+"\t");

            map[i] = marketPrice.getMarketPrice();
            System.out.println("Marktpreis:             "          +  f.format(marketPrice.calcMarketPrice())+"\t \n");

        }

        setMarketPrice(map);
        setProduktionsKapazität(producCap);
        setProfit(prof);
    }

    public Double[] getProfit() {
        return profit;
    }

    public Double[] getProduktionsKapazität() {
        return produktionsKapazität;
    }

    public Double[] getMarketPrice() {
        return marketPrice;
    }

    public Double getMarketPrice(int i)
    {
        return marketPrice[i];
    }

    public Double getProduktionsKapazität(int i)
    {
        return marketPrice[i];
    }

    public Double getProfit(int i)
    {
        return profit[i];
    }

    private void setProfit(Double[] profit) {
        this.profit = profit;
    }

    private void setProduktionsKapazität(Double[] produktionsKapazität) {
        this.produktionsKapazität = produktionsKapazität;
    }


    public void setMarketPrice(Double[] marketPrice) {
        this.marketPrice = marketPrice;
    }
}
