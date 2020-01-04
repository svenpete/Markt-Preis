package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dataset
{
    private String   sql;
    private String   tableName;
    private String   columnName;
    private String   company;
    private Double[] data;


    public Dataset(String tableName, String columnName, String company) throws SQLException
    {
        this.tableName  = tableName;
        this.columnName = columnName;
        this.company    = company;
        this.sql        = "SELECT " + columnName + ", ID FROM " + tableName + " WHERE ID LIKE '" + company + "%'";
        getResultSet();
    }


    /**
     * excute a query and saves the values of the resultset in data
     * @throws SQLException
     */
    public  void getResultSet() throws SQLException
    {
        Connection connection = JDBC.getConnection();
        Statement statement = connection.createStatement();

        JDBC.updateStatement(connection, "USE market_price");

        ResultSet rs = statement.executeQuery(sql);

        List<Double> values = new ArrayList<>();
        List<String> id     = new ArrayList<>();

        while (rs.next())
        {
            values.add(rs.getDouble(columnName));
            id.add(rs.getString("ID"));
        }

        data = values.toArray(new Double[0]);
    }


    public Double[] getData()
    {
        return data;
    }

    public String getTableName()
    {
        return tableName;
    }

    public String getColumnName()
    {
        return columnName;
    }

}
