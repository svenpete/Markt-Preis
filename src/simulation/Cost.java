package simulation;

public abstract class Cost
{

    protected double costs;

    public abstract double calculateCosts();    //Methode zur Berechnung der einzelnen Kosten

    public double getCosts() {
        return costs;
    }
}