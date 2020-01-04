package JDBC;

import simulation.Simulation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Table
{
    String name;
    ArrayList<Attribute> attributes = new ArrayList<>();


    public Table(String name)
    {
        this.name = name;
    }

    public Table addAttr(String name, Type type)
    {
        attributes.add(new Attribute(name, type));
        return this;
    }

    public Table addPrimaryKey(String name, Type type)
    {
        attributes.add(new PrimaryKey(name, type));
        return this;
    }


    public String create()
    {
        String sqlStatement = "CREATE TABLE " + name + "(";
        String sqlStatementPrimaryKey = "";

        for (int i = 0; i < attributes.size(); i++)
        {
            sqlStatement += attributes.get(i).create();
            if (i < attributes.size())
                sqlStatement += ", ";

            sqlStatementPrimaryKey = attributes.get(i).createPrimaryKey(sqlStatementPrimaryKey);
        }

        sqlStatement += "PRIMARY KEY (" + sqlStatementPrimaryKey + "));";

        return sqlStatement;
    }


    /**
     * accepts a unspecified amount of values to insert
     * @param values variable parameter list
     * @return amount of affected rows
     * @throws SQLException
     */
    public static int fill(Connection connection, String dbname, Double... values) throws SQLException
    {
        String insertStringSQL = createInsertString(dbname, values.length);

        PreparedStatement preparedStatement = connection.prepareStatement(insertStringSQL);

        for (int i = 1; i <= values.length; i++)
            preparedStatement.setDouble(i, values[i - 1]);

        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected;
    }


    /**
     * @param connection
     * @param tableName to select the table for data to insert
     * @param values to insert in the database
     * @param id to determain which ID is given
     * @return the amount of affected rows
     * @throws SQLException
     */
    public static int[] fill(Connection connection, String tableName, Double[][] values, String id) throws SQLException
    {
        // create a prepared statement
        String insertStringSQL = createInsertString(tableName, values[0].length);
        PreparedStatement preparedStatement = connection.prepareStatement(insertStringSQL);

        // saves Types for compare
        List <Integer> checkTypes = checkType(connection,tableName);
        for (int i = 0; i < values.length; i++) // row counter
        {
            for (int j = 0; j < values[0].length; j++) // column counter
            {
                // 12 = VARCHAR
                if (checkTypes.get(j) == 12 )
                {
                    if (i < 10)
                    {
                        // for a proper ID solution
                        String insertID = id + "00" + i;
                        // count start at 1
                        preparedStatement.setString(j + 1, insertID);
                    }
                    else if (i < 100)
                    {
                        // for a proper ID solution
                        String insertID = id + "0" + i;
                        // count start at 1
                        preparedStatement.setString(j + 1, insertID);
                    }
                    else
                    {
                        // for a proper ID solution
                        String insertID = id + i;
                        // count start at 1
                        preparedStatement.setString(j + 1, insertID);
                    }
                }

                // 3 = DECIMAL
                if (checkTypes.get(j) == 3)
                    preparedStatement.setDouble(j + 1, values[i][j]);
            }

             preparedStatement.addBatch();
        }

        // saves the amount of affected rows
        int[] rowsAffected = preparedStatement.executeBatch();

        preparedStatement.close();
        System.out.println("Rows inserted:" + rowsAffected.length);

        return rowsAffected;
    }


    /**
     * @param dbname for sql syntax
     * @param size important to determine the size of the inserted string
     * @return
     * @throws SQLException
     */
    public static String createInsertString(String dbname, Integer size) throws SQLException
    {
        String insertStmt = "INSERT INTO " + dbname + " VALUES( ";

        // sets ? for size
        for (int i = 0; i < size; i++)
        {
            insertStmt += "?";
            if (i + 1 < size) // sql syntax error so --> +1
                insertStmt += " , ";
        }

        insertStmt += " );";

        return insertStmt;
    }


    /**
     * @return amount of counted rows
     * @throws SQLException
     */
    public static int countRows(Connection connection, String tablename) throws SQLException
    {
        String sql = "SELECT COUNT(*) AS TOTAL FROM ? ;";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, tablename);
        ResultSet rs = stmt.executeQuery();

        int count = 0;
        while (rs.next())
        {
            count = rs.getInt("TOTAL");
        }

        stmt.close();

        return count;
    }


    /**
     * prints out all tables in the database
     * @throws SQLException
     */
    public static void showAllTables(Connection connection) throws SQLException
    {
        String catalog          = null;
        String schemaPattern    = "market_price";
        String tableNamePattern = null;
        String[] types          = null;

        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet result = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);

        while (result.next())
        {
            String tableName = result.getString(3);
            System.out.println(tableName);
        }

        result.close();
    }


    /**
     * checking if the type of attributes is in table
     * @return checked types
     * @throws SQLException
     */
    public static List<Integer> checkType(Connection connection, String tableName) throws SQLException
    {
        String   catalog           = null;
        String   schemaPattern     = null;
        String   tableNamePattern  = tableName;
        String   columnNamePattern = null;
        List<Integer> types        = new ArrayList<>();
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        // gets metadata for type checking
        ResultSet result = databaseMetaData.getColumns(catalog, schemaPattern,  tableNamePattern, columnNamePattern);

        while(result.next())
        {
            types.add(result.getInt(5));
        }

        return types;
    }


    /**
     * submit data to database
     * @param simulation1 contains the resultsets to save in databbase
     * @throws SQLException
     */
    public static void batchUpdate(Connection connection, Simulation simulation1) throws SQLException
    {
        Table.fill(connection,"capitalcost",simulation1.getCapitalCostResultSetA(),"A");
        Table.fill(connection,"capitalcost",simulation1.getCapitalCostResultSetB(),"B");

        Table.fill(connection,"materialcost",simulation1.getMaterialCostResultSetA(),"A");
        Table.fill(connection,"materialcost",simulation1.getMaterialCostResultSetB(),"B");

        Table.fill(connection,"labourcost",simulation1.getLabourCostResultSetA(),"A");
        Table.fill(connection,"labourcost",simulation1.getLabourCostResultSetB(),"B");

        Table.fill(connection,"employee",simulation1.getEmployeeResultSetA(),"A");
        Table.fill(connection,"employee",simulation1.getLabourCostResultSetB(),"B");

        Table.fill(connection,"production",simulation1.getProductionResultSetA(),"A");
        Table.fill(connection,"production",simulation1.getProductionResultSetB(),"B");

        Table.fill(connection,"productioncost",simulation1.getProductionCostResultSetA(),"A");
        Table.fill(connection,"productioncost",simulation1.getProductionCostResultSetB(),"B");

        Table.fill(connection,"unitcost",simulation1.getUnitCostResultSetA(),"A");
        Table.fill(connection,"unitcost",simulation1.getUnitCostResultSetB(),"B");

        Table.fill(connection,"marketprice",simulation1.getMarketPriceResultSet(),"0");
    }

}