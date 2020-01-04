package simulation;

public class Employee
{
    private final double RATIONALISATIONFACTOR;
    private final double EMPLOYMENTEFFECT;

    private       double employees;
    private Production   production;


    public Employee(Double RATIONALISATIONFACTOR, Double EMPLOYMENTEFFECT, Production production)
    {
        this.production            = production;
        this.RATIONALISATIONFACTOR = RATIONALISATIONFACTOR;
        this.EMPLOYMENTEFFECT      = EMPLOYMENTEFFECT;
    }


    /**
     * calculates the employees
     * @return employees
     */
    public double calculateEmployees()
    {
        employees = EMPLOYMENTEFFECT * production.getProductionCapacity() / RATIONALISATIONFACTOR;
        return employees;
    }


    public double getEmployees()
    {
        return employees;
    }

    public double getEMPLOYMENTEFFECT()
    {
        return EMPLOYMENTEFFECT;
    }

    public Production getProduction()
    {
        return production;
    }

    public double getRATIONALISATIONFACTOR()
    {
        return RATIONALISATIONFACTOR;
    }

    public void setProduction(Production production)
    {
        this.production = production;
    }

}
