package simulation;

public abstract class Cost
{

    protected double cost;

    public abstract double calculateCosts();

    public double getCost() {
        return cost;
    }
}