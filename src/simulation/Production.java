package simulation;

import java.util.ArrayList;
import java.util.zip.DeflaterOutputStream;

public class Production
{
    private Double productionCapacity;
    private Double capacityChange;
    private static double sumProductionCapacity;


    Production(Double productionCapacity)
    {
        this.productionCapacity = productionCapacity;
        sumProductionCapacity = 0;
    }

    public Double calculateCapacityChange(Double investReaction)
    {
        capacityChange = investReaction * productionCapacity;

        return capacityChange;
    }


    public Double calculateProductCapacity()
    {
        productionCapacity = productionCapacity + (capacityChange * 0.0625);



        return  productionCapacity;
    }

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

    public static double getSumProductionCapacity() {
        return sumProductionCapacity;
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
