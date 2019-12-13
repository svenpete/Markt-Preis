package simulation;

public class Employee
{
    private     final   int         rationalisationFactor;                //Rationalisierungsfaktor [1]

    private     double              employmentEffect;      //Beschäftigungseffekt [Person/(Stück/Year)]
    private     double              employees;                                   //Beschäftigte (SPEICHERN???)

    private     Production          production;

    public Employee(Production production)
    {
        this.production = production;
        rationalisationFactor = 1;
        employmentEffect      = 0.001;
    }

    /**
     *  Calculation for Working-Employees to accomplish the Productioncapacity
     *  employmentEffect represents the needed Employees to accomplish 1 ME
     *  rationalisationFactor cuts Employees or increases the Employees depending on
     *  rationalisationFactor = 1 remains untouched
     *  rationalisationFactor > 1 cuts Employees
     *  rationalisationFactor < 1 increases Employees
     * @return employees || depending on given parameters
     */

    public double computeEmployees()
    {

        employees = employmentEffect * production.getProductionCapacity() / rationalisationFactor;

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

    public int getRationalisationFactor()
    {
        return rationalisationFactor;
    }

    public void setEmployees(double employees)
    {
        this.employees = employees;
    }

    public void setProduction(Production production)
    {
        this.production = production;
    }
}
