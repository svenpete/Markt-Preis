package JDBC;

public enum  Type
{


    BOOLEAN(  "Boolean"),
    INTEGER( "Integer"),
    DECIMAL( "DECIMAL(12,2)"),
    VARCHAR("VARCHAR(255)");



    private String  sqlTypeString;

    Type(String sqlTypeString)
    {
        this.sqlTypeString = sqlTypeString;
    }

    public String getSqlTypeString() {
        return sqlTypeString;
    }
}
