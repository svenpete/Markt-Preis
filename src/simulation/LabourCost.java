package simulation;

public class LabourCost extends Cost
{
    private double   wageRate;
    private double   incidentalExpenseRate;
    private Employee employe;


    public LabourCost(Double wageRate, Double incidentalExpenseRate, Employee employee)
    {
        this.employe               = employee;
        this.wageRate              = wageRate ;
        this.incidentalExpenseRate = incidentalExpenseRate ;
    }


    /**
     * calculates the labour costs
     * @return cost
     */
    @Override
    public double calculateCosts()
    {
        cost = ( wageRate + incidentalExpenseRate ) * employe.getEmployees();
        return cost;
    }


    public double getWageRate()
    {
        return wageRate;
    }

    public double getIncidentalExpenseRate()
    {
        return incidentalExpenseRate;
    }

}
