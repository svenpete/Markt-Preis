import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class Simulation
{
    //Simulationsparameter


    public static void main(String[] args)
    {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator('.');
        DecimalFormat   f               =   new DecimalFormat("###,##0.00", symbols);

        Production      produc          =   new Production();
        Employees       employe         =   new Employees(produc);

        LabourCosts     laCost          =   new LabourCosts(employe);
        CapitalCosts    caCost          =   new CapitalCosts(produc);
        MaterialCosts   maCost          =   new MaterialCosts(produc);

        ProductionCosts proCost         =   new ProductionCosts(caCost,maCost,laCost);
        Profit          profit          =   new Profit(proCost);
        UnitCosts       unCost          =   new UnitCosts(proCost);

        MarketPrice     marketPrice     =   new MarketPrice(unCost);

            /*
             int INITIAL_TIME = 0;
             int FINAL_TIME   = 20;
             double TIME_STEP = 0.05;




            System.out.println("MarketPrice: " + f.format(marketPrice.getMarketPrice()));
            System.out.println("Produktionskapazität: " + f.format(produc.getProductionCapacity()));
            System.out.println("Beschäftigte: " + f.format(employe.computeEmployees()));

            System.out.println("Arbeitskosten: " + f.format(laCost.calculateCosts()));
            System.out.println("Kapitalkosten: " + f.format(caCost.calculateCosts()));
            System.out.println("Materialkosten: " + f.format(maCost.calculateCosts()));

            // dont change order !
            System.out.println("ProduktionsKosten: " + f.format(proCost.calculateCosts()));
            System.out.println("Profit: " + f.format(profit.calculateCosts()));


            System.out.println("Stückkosten: " + f.format(unCost.calculateCosts()));
            System.out.println("GewinnMarge: " + f.format(marketPrice.calcBenefitMarge()));

            System.out.println("Fehlanpassung Nachfrage: " + f.format(marketPrice.calcMismatchDemand()));
            System.out.println("Preisdruck Nachfrage: " + f.format(marketPrice.calcPricePressureDemand()));
            System.out.println("Fehlanpassung Preis: " + f.format(marketPrice.calcMismatchCost()));
            System.out.println("Preisdruckkosten: " + f.format(marketPrice.calcPricePressureCosts()));


            System.out.println("Investreaktio: missing formular");//+   f.format(marketPrice.caclPricePressureCosts()));
            System.out.println("Kapazitätsveränderung: " + f.format(produc.calculateCapacityChange()));
            System.out.println("Produktionskapazität: mising formular");

            System.out.println("Marktpreis: " + f.format(marketPrice.calcMarketPrice()));
        */
    }

}
