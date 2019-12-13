package simulation;

public class LabourCost extends Cost {

    private  double wageRate;  //Lohnsatz [€/(Person*Year)]

    private  double incidentalExpenseRate = 30000 ;  //Nebenkostensatz [€/(Person*Year)]

    private Employee employe;


    public LabourCost(Employee employe)
    {
        this.employe          = employe;
        wageRate              = 40000 ;
        incidentalExpenseRate = 30000 ;

    }

    /**
     *  calculate labour cost [Cost/Year]
     *  Year is [ 1 ]
     *  WageRate is fix || ExpenseRate is fix
     *  DYNAMIK EMPLOYEE || Auswirkung Produktkapazität
     * @return Labourcost || costs for 1 year of work
     */

    @Override
    public double calculateCosts()
    {
         costs = ( wageRate + incidentalExpenseRate ) * employe.getEmployees();

        return costs;
    }

    public double getWageRate()
    {
        return wageRate;
    }

    public double getIncidentalExpenseRate()
    {
        return incidentalExpenseRate;
    }

    public Employee getEmploye()
    {
        return employe;
    }

    public void setEmploye(Employee employe)
    {
        this.employe = employe;
    }

    public void setWageRate(double wageRate)
    {
        this.wageRate = wageRate;
    }

    public void setIncidentalExpenseRate(double incidentalExpenseRate)
    {
        this.incidentalExpenseRate = incidentalExpenseRate;
    }
}
