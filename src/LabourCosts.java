public class LabourCosts extends Costs {

    private  int wageRate              = 40000;  //Lohnsatz [€/(Person*Year)]

    private  int incidentalExpenseRate = 30000;  //Nebenkostensatz [€/(Person*Year)]

    private Employees employe;


    public LabourCosts(Employees employe)
    {
        setEmploye(employe);

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
         setCosts(((getWageRate() + getIncidentalExpenseRate()) * getEmploye().getEmployees()));

        return getCosts();
    }

    public int getWageRate()
    {
        return wageRate;
    }

    public int getIncidentalExpenseRate()
    {
        return incidentalExpenseRate;
    }

    public Employees getEmploye()
    {
        return employe;
    }

    public void setEmploye(Employees employe)
    {
        this.employe = employe;
    }

    public void setWageRate(int wageRate)
    {
        this.wageRate = wageRate;
    }

    public void setIncidentalExpenseRate(int incidentalExpenseRate)
    {
        this.incidentalExpenseRate = incidentalExpenseRate;
    }
}
