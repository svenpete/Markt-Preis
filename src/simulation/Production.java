package simulation;

public class Production
{
    private Double productionCapacity;
    private Double capacityChange;

    Production()
    {
        productionCapacity = 100000.00;
    }

    public Double calculateCapacityChange(Double investReaction)
    {
        capacityChange = investReaction * productionCapacity;

        return capacityChange;
    }


    public Double calculateProductCapacity()
    {
        productionCapacity = productionCapacity + capacityChange;

        return  productionCapacity;
    }


    public Double getCapacityChange()
    {
        return capacityChange;
    }

    public Double getProductionCapacity()
    {
        return productionCapacity;
    }



    public void setCapacityChange(Double capacityChange)
    {
        this.capacityChange = capacityChange;
    }

    public void setProductionCapacity(Double productionCapacity)
    {
        this.productionCapacity = productionCapacity;
    }
}
