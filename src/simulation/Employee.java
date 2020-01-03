package simulation;

public class Employee
{
    private     final   double RATIONALISATIONFACTOR;

    private     double              employmentEffect;
    private     double              employees;

    private     Production          production;

    public Employee(Double RATIONALISATIONFACTOR, Double employmentEffect, Production production)
    {
        this.production = production;
        this.RATIONALISATIONFACTOR = RATIONALISATIONFACTOR;
        this.employmentEffect      = employmentEffect;
    }


    public double calculateEmployees()
    {

        employees = employmentEffect * production.getProductionCapacity() / RATIONALISATIONFACTOR;

        return employees;
    }


    public double getEmployees()
    {
        return employees;
    }

    public double getEmploymentEffect()
    {
        return employmentEffect;
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
