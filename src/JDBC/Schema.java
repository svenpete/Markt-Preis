package JDBC;
public class Schema
{
    String name = null;

    Schema (String name)
    {
        this.name = name;
    }

    public String create()
    {
        return "Create Schema " + name + ";";
    }
    public String use()
    {
        return "USE " + name + ";";
    }
    public String drop()
    {
        return "DROP SCHEMA IF EXISTS " + name + ";" ;
    }

}
