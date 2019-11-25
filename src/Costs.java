public abstract class Costs
{

    private double costs;

    public abstract double calculateCosts();    //Methode zur Berechnung der einzelnen Kosten

    public double getCosts()
    {
        return costs;
    }

    public void setCosts(double costs)
    {
        this.costs = costs;
    }


}