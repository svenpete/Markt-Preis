package JDBC;
public class ForgeinKey extends Attribute
{
    Table tableReference;
    Attribute attributeReference;
    boolean isPrimaryKey;

    public ForgeinKey(String name, Type type,
                      Table tableReference, Attribute attributeReference,boolean isPrimaryKey )
    {
        super(name, type);
        this.tableReference = tableReference;
        this.attributeReference = attributeReference;
        this.isPrimaryKey = isPrimaryKey;
    }

    public String create()
    {
        return super.create() + ", "
                + "FOREIGN KEY (" + name + ") REFERENCES"
                +tableReference.name
                + "(" + attributeReference.name + ")";

    }

   @Override
    public String createPrimaryKey(String sqlStatementPrimaryKey)
    {
        if (isPrimaryKey)
            return sqlStatementPrimaryKey.isEmpty()
                    ? name : sqlStatementPrimaryKey + ", name";

        else
        return sqlStatementPrimaryKey;
    }
}
