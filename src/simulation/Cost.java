package simulation;

public abstract class Cost
{
    protected double cost;

    //abstract method for calculating costs
    public abstract double calculateCosts();

    public double getCost()
    {
        return cost;
    }

}