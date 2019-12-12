package simulation;

public class Production
{
    private static Double productionCapacity = 100000.00 ; // Klasse für simulation



    private double capacityChange; //Kapazitätsveränderung


    Production()
    {

    }

    public double calculateCapacityChange()
    {
        setCapacityChange(MarketPrice.investReaction * getProductionCapacity());

        return getCapacityChange();
    }




    public double calculateProductCapacity()
    {
        setProductionCapacity( (getProductionCapacity() + getCapacityChange()) );
        return  getProductionCapacity();
    }





    public double getCapacityChange()
    {
        return capacityChange;
    }

    public static Double getProductionCapacity()
    {
        return productionCapacity;
    }




    public void setCapacityChange(double capacityChange)
    {
        this.capacityChange = capacityChange;
    }

    public void setProductionCapacity(Double productionCapacity)
    {
        Production.productionCapacity = productionCapacity;
    }
}
