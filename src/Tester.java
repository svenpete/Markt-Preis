import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Tester
{
    public static void main(String[] args)
    {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator('.');
        DecimalFormat f               =   new DecimalFormat("###,##0.00", symbols);

        Production      produc          =   new Production();
        Employees       employe         =   new Employees(produc);

        LabourCosts     laCost          =   new LabourCosts(employe);
        CapitalCosts    caCost          =   new CapitalCosts(produc);
        MaterialCosts   maCost          =   new MaterialCosts(produc);

        ProductionCosts proCost         =   new ProductionCosts(caCost,maCost,laCost);
        Profit          profit          =   new Profit(proCost);
        UnitCosts       unCost          =   new UnitCosts(proCost);

        MarketPrice     marketPrice     =   new MarketPrice(unCost);


             int INITIAL_TIME   = 0; // 1
             double FINAL_TIME  = 1;   // 20 Years
             double TIME_STEP   = 1; // 20 steps

            for (double i = INITIAL_TIME; i < FINAL_TIME ; i = i + TIME_STEP) {


                System.out.println("Beschäftigte:           " + f.format(employe.computeEmployees()));
                System.out.println("Arbeitskosten:          " + f.format(laCost.calculateCosts()));
                System.out.println("Kapitalkosten:          "         +   f.format(caCost.calculateCosts()    ));
                System.out.println("Materialkosten:         "         +   f.format(maCost.calculateCosts()    ));

                // dont change order !
                System.out.println("ProduktionsKosten:      "         +   f.format(proCost.calculateCosts()   ));
                System.out.println("Profit:                 "         +   f.format(profit.calculateCosts()    ));


                System.out.println("Stückkosten:            "         +   f.format( (unCost.calculateCosts()   ))+"\n");
                System.out.println("GewinnMarge:            "         +   f.format(marketPrice.calcBenefitMarge()));

                System.out.println("Fehlanpassung Nachfrage:"         +   f.format(marketPrice.calcMismatchDemand()));
                System.out.println("Preisdruck Nachfrage:   "         +   f.format(marketPrice.calcPricePressureDemand()));
                System.out.println("Fehlanpassung Preis:    "         +   f.format(marketPrice.calcMismatchCost()));
                System.out.println("Preisdruckkosten:       "         +   f.format(marketPrice.calcPricePressureCosts()));


                System.out.println("Investreaktio: missing formular");
                System.out.println("Kapazitätsveränderung: "                + f.format(produc.calculateCapacityChange()));
                System.out.println("Produktionskapazität: mising formular");

                System.out.println("Marktpreis:             "                +  f.format(marketPrice.calcMarketPrice()));









            }

    }

}
