package simulation;

public class Production
{
    private Double        productionCapacity;
    private Double        capacityChange;
    private static double sumProductionCapacity;


    Production(Double productionCapacity)
    {
        this.productionCapacity = productionCapacity;
        sumProductionCapacity   = 0;
    }


    /**
     * calculating capacity change
     * @return capacity change
     */
    public Double calculateCapacityChange(Double investReaction)
    {
        capacityChange = investReaction * productionCapacity;
        return capacityChange;
    }


    /**
     * calculating product capacity
     * @return production capacity
     */
    public Double calculateProductCapacity()
    {
        productionCapacity = productionCapacity + (capacityChange * 0.0625);
        return  productionCapacity;
    }


    /**
     * calculating sum of production capacity
     * @return sum of product capacity
     */
    public static Double calcSumProductionCapacity(Double productionCapacityA, Double productionCapacityB)
    {
        sumProductionCapacity = productionCapacityA + productionCapacityB;
        return sumProductionCapacity;
     }


    public Double getCapacityChange()
    {
        return capacityChange;
    }

    public Double getProductionCapacity()
    {
        return productionCapacity;
    }

    public static double getSumProductionCapacity()
    {
        return sumProductionCapacity;
    }

}
