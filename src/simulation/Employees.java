package simulation;

public class Employees
{
    private     final   int         rationalisationFactor = 1;                //Rationalisierungsfaktor [1]

    private     double              employmentEffect      = 0.001  ;      //Beschäftigungseffekt [Person/(Stück/Year)]
    private     double              employees;                                   //Beschäftigte (SPEICHERN???)

    private     Production          production;

    public Employees(Production production)
    {
        setProduction(production);
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

        setEmployees( getEmploymentEffect() * Production.getProductionCapacity() / getRationalisationFactor());

        return getEmployees();
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
