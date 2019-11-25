public class Production
{
    private double investReaction; //WITH LOOKUP!?!?!?!?

    private double capacityChange; //Kapazitätsveränderung

    private static double productionCapacity = 100000; //Produktionskapazität == Produktionsmenge

    Production()
    {

    }

    public double calculateCapacityChange()
    {
        setCapacityChange(getInvestReaction() * getProductionCapacity());

        return getCapacityChange();
    }
    // Investreaction with lookup

   /* public double calculateInvestReaction()
    {

    }
    */

    public double calculateProductCapacity()
    {
        return  productionCapacity;
    }


    public double getInvestReaction()
    {
        return investReaction;
    }

    public double getCapacityChange()
    {
        return capacityChange;
    }

    public static double getProductionCapacity()
    {
        return productionCapacity;
    }


    public void setInvestReaction(double investReaction)
    {
        this.investReaction = investReaction;
    }

    public void setCapacityChange(double capacityChange)
    {
        this.capacityChange = capacityChange;
    }

    public static void setProductionCapacity(double productionCapacity)
    {
        Production.productionCapacity = productionCapacity;
    }
}
