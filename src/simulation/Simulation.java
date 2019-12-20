package simulation;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class Simulation
{
    private Double [] marketPrice;
    private Double [] totalProduction;
    private Double [] produktionsKapazitätA;
    private Double [] produktionsKapazitätB;
    private Double [] profit;
    /*private Double [] employee;
    private Double [] profit;
    private Double [] produktionsKapazität;
    */

    public Simulation()
    {

    }

    public void simulate( Integer finalTime, Integer finalStep)
    {

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator('.');
        DecimalFormat f                 =   new DecimalFormat("###,##0.0000", symbols);

        //Company A
        Production      productionA    =  new Production(200000.00);
        Employee        employeeA      =  new Employee(1.00,0.0009,productionA);
        LabourCost      labourCostA     =   new LabourCost(40000.00,30000.00,employeeA);
        CapitalCost     capitalCostA    =   new CapitalCost(0.1 ,10.00,productionA);
        MaterialCost    materialCostA   =   new MaterialCost(100.00,productionA);
        ProductionCost productionCostA  =   new ProductionCost(capitalCostA,materialCostA,labourCostA);
        UnitCost unitCostA              =   new UnitCost(0.2,productionCostA, productionA);


        //Company B
        Production      productionB          =  new Production(200000.00);
        Employee        employeeB                   =   new Employee(1.00,0.001,productionB); // need produc due
        LabourCost      labourCostB          =   new LabourCost(40000.00,30000.00,employeeB);
        CapitalCost     capitalCostB         =   new CapitalCost(0.1 ,10.00,productionB);
        MaterialCost    materialCostB    =   new MaterialCost(100.00,productionB);
        ProductionCost productionCostB         =   new ProductionCost(capitalCostB,materialCostB,labourCostB);
        UnitCost unitCostB              =   new UnitCost(0.2,productionCostB, productionB);

        ArrayList<UnitCost> unitCosts = new ArrayList<>();
        unitCosts.add(unitCostA);
        unitCosts.add(unitCostB);

        MarketPrice     marketPrice     =   new MarketPrice(1000000.00,1.00,300.00,unitCosts);




        // nachfrage




        // safe for drawing
        Double [] map = new Double[finalTime ];
        Double [] producCap = new Double[finalTime ];
        Double [] tProduc = new Double[finalTime ];
        Double [] aProduc = new Double[finalTime ];
        Double [] bProduc = new Double[finalTime ];


        for (int i = 0; i < finalTime ; i = i + finalStep)
        {
            System.out.println("Nachfrage:               "         +   f.format(marketPrice.getDemand()));
            // dont change order nor methods  work !
            System.out.println("BeschäftigteA:           "         +   f.format(employeeA.computeEmployees()) +"\t");
            System.out.println("BeschäftigteB:           "         +   f.format(employeeB.computeEmployees()) +"\t");

            System.out.println("ArbeitskostenA:          "         +   f.format(labourCostA.calculateCosts())+"\t");
            System.out.println("ArbeitskostenB:          "         +   f.format(labourCostB.calculateCosts())+"\t");

            System.out.println("KapitalkostenA:          "         +   f.format(capitalCostA.calculateCosts()    )+"\t");
            System.out.println("KapitalkostenB:          "         +   f.format(capitalCostB.calculateCosts()    )+"\t");

            System.out.println("MaterialkostenA:         "         +   f.format(materialCostA.calculateCosts()    )+"\t");
            System.out.println("MaterialkostenB:         "         +   f.format(materialCostB.calculateCosts()    )+"\t");

            System.out.println("ProduktionsKostenA:      "         +   f.format(productionCostA.calculateCosts()   )+"\t");
            System.out.println("ProduktionsKostenB:      "         +   f.format(productionCostB.calculateCosts()   )+"\t");

            System.out.println("StückkostenA:            "         +   f.format( (unitCostA.calculateCosts()   ))+"\n");
            System.out.println("StückkostenB:            "         +   f.format( (unitCostB.calculateCosts()   ))+"\n");

            System.out.println("GewinnMargeA:            "         +   f.format(unitCostA.calcBenefitMarge(marketPrice.getMarketPrice()))+"\t");
            System.out.println("GewinnMargeB:            "         +   f.format(unitCostB.calcBenefitMarge(marketPrice.getMarketPrice()))+"\t");

            System.out.println("ProduktionSUM:           "         +   f.format(Production.calcSumProductionCapacity(productionA.getProductionCapacity(),
                                                                                    productionB.getProductionCapacity())));
            tProduc[i] = Production.getSumProductionCapacity(); ;

            System.out.println("Fehlanpassung Nachfrage: "         +   f.format(marketPrice.calcMismatchDemand(Production.getSumProductionCapacity()))+"\t");
            System.out.println("PreisDruckNachfrage: "              +   f.format(marketPrice.calcPricePressureDemand()));

            System.out.println("AnpassungsKosten:     "         + f.format(marketPrice.calcCostAdjustment(productionA.getProductionCapacity(),
                                                                                productionB.getProductionCapacity(),Production.getSumProductionCapacity())));

            System.out.println("Preisdruckkosten:   "         +   f.format(marketPrice.calcPricePressureCosts(marketPrice.getCostAdjustment()))+"\t");

            System.out.println("InvestreaktionA: "                   +  f.format(unitCostA.calcInvestReactionI())+"\t");
            System.out.println("InvestreaktionB: "                   +  f.format(unitCostB.calcInvestReactionI())+"\t");

            System.out.println("KapazitätsveränderungA: "           +  f.format(productionA.calculateCapacityChange(unitCostA.getInvestReaction()))+"\t");
            System.out.println("KapazitätsveränderungB: "           +  f.format(productionB.calculateCapacityChange(unitCostB.getInvestReaction()))+"\t");

            //producCap[i] = productionA.getProductionCapacity();
            System.out.println("ProduktionskapazitätA:"             +  f.format(productionA.getProductionCapacity())+"\t");
            aProduc[i] = productionA.getProductionCapacity();
            productionA.calculateProductCapacity();

            System.out.println("ProduktionskapazitätB:"             +  f.format(productionB.getProductionCapacity())+"\t \n");
            bProduc[i] = productionA.getProductionCapacity();
            productionB.calculateProductCapacity();

            System.out.println("Marktpreis:"                        + f.format(marketPrice.getMarketPrice()));
            map[i] = marketPrice.getMarketPrice();
            marketPrice.calcMarketPrice();


        }

        this.marketPrice = map;
        this.produktionsKapazitätA = aProduc;
        this.produktionsKapazitätB = bProduc;
        this.totalProduction = tProduc;
    }

    public Double[] getProfit() {
        return profit;
    }



    public Double[] getMarketPrice() {
        return marketPrice;
    }

    public Double getMarketPrice(int i)
    {
        return marketPrice[i];
    }

    public Double getProduktionsKapazitätA(int i)
    {
        return produktionsKapazitätA[i];
    }

    public Double getProduktionsKapazitätB(int i)
    {
        return produktionsKapazitätB[i];
    }

    public Double getProfit(int i)
    {
        return profit[i];
    }

    private void setProfit(Double[] profit) {
        this.profit = profit;
    }



    public Double getTotalProduction(int i) {
        return totalProduction[i];
    }

    public void setMarketPrice(Double[] marketPrice) {
        this.marketPrice = marketPrice;
    }
}
