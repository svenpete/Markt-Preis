package JDBC;

import simulation.Simulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC
{

    public static Connection getConnection() throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306", "root","osca" );
        System.out.println("Connection established");
        return connection;
    }

    public static int updateStatement(Connection connection, String sqlStatement) throws SQLException
    {
        Statement statement = connection.createStatement();
        int tuppleUpdated = statement.executeUpdate(sqlStatement);

        System.out.println("SQL update exceute: " + sqlStatement);
        return tuppleUpdated;
    }

    private static void createSchema(Connection connection, String schemaName) throws SQLException
    {
        Schema schema = new Schema(schemaName);
        updateStatement(connection, schema.drop());
        updateStatement(connection, schema.create());
        updateStatement(connection, schema.use());
    }
        /*
    public static void main (String [] args)
    {
        try
        {
            System.out.println("hi");
            Connection connection = getConnection();

            createBlankDatabase(connection);

             Dataset dataset = new Dataset("capitalcost","cost","A");
            connection.close();
        }
            catch (SQLException e)
        {
            System.out.println("Fehlermeldung:" +   e.getMessage());
            System.out.println("SQL State:" + e.getSQLState());

            e.printStackTrace();

        }


    }
*/

    public static void createBlankDatabase(Connection connection) throws SQLException {
        createSchema(connection, "market_price");
        createTableCapitalCost(connection);
        createTableEmployee(connection);
        createTableLabourCost(connection);
        createTableMarketPrice(connection);
        createTableMaterialCost(connection);
        createTableProduction(connection);
        createTableProductionCost(connection);
        createTableUnitCost(connection);

    }

    public static void createDatabase(Connection connection,Simulation simulation1) throws SQLException {
        createSchema(connection, "market_price");
        createTableCapitalCost(connection);
        createTableEmployee(connection);
        createTableLabourCost(connection);
        createTableMarketPrice(connection);
        createTableMaterialCost(connection);
        createTableProduction(connection);
        createTableProductionCost(connection);
        createTableUnitCost(connection);
        Table.batchUpdate(connection,simulation1);
    }

    private static void createTableCapitalCost(Connection connection) throws SQLException
    {
        Table table_capital_cost = new Table("capitalcost")
                .addPrimaryKey("ID", Type.VARCHAR)
                .addAttr("DEPRECIATION_RATE", Type.DECIMAL)
                .addAttr("SPECIFIC_CAPITAL_REQUIREMENT", Type.DECIMAL)
                .addAttr("COST", Type.DECIMAL);


        String sqlStatemement = table_capital_cost.create();
        System.out.println(sqlStatemement);
        updateStatement(connection, sqlStatemement);

    }

    private static void createTableEmployee(Connection connection) throws SQLException
    {
        Table table_employee = new Table("employee")
                .addPrimaryKey("ID", Type.VARCHAR)
                .addAttr("RATIONALISATION_FACTOR", Type.DECIMAL)
                .addAttr("EMPLOYMENT_EFFECT", Type.DECIMAL)
                .addAttr("EMPLOYEE", Type.DECIMAL);


        String sqlStatemement = table_employee.create();
        System.out.println(sqlStatemement);
        updateStatement(connection, sqlStatemement);

    }

    private static void createTableLabourCost(Connection connection) throws SQLException
    {
        Table table_labour_cost = new Table("labourcost")
                .addPrimaryKey("ID", Type.VARCHAR)
                .addAttr("WAGE_RATE", Type.DECIMAL)
                .addAttr("INCIDENTAL_EXPENSE_RATE", Type.DECIMAL)
                .addAttr("COST", Type.DECIMAL);


        String sqlStatemement = table_labour_cost.create();
        System.out.println(sqlStatemement);
        updateStatement(connection, sqlStatemement);

    }

    private static void createTableMarketPrice(Connection connection) throws SQLException
    {
        Table table_market_price = new Table("marketprice")
                .addPrimaryKey("ID", Type.VARCHAR)
                .addAttr("DEMAND", Type.DECIMAL)
                .addAttr("REACTION_RATE", Type.DECIMAL)
                .addAttr("MARKET_PRICE", Type.DECIMAL)
                .addAttr("PRICE_PRESSURE_COST", Type.DECIMAL)
                .addAttr("MISMATCH_PRICE", Type.DECIMAL)
                .addAttr("PRICE_PRESSURE_DEMAND", Type.DECIMAL)
                .addAttr("MISMATCH_DEMAND", Type.DECIMAL)
                .addAttr("COST_ADJUSTMENT", Type.DECIMAL);

        String sqlStatemement = table_market_price.create();
        System.out.println(sqlStatemement);
        updateStatement(connection, sqlStatemement);

    }

    private static void createTableMaterialCost(Connection connection) throws SQLException
    {
        Table table_material_cost = new Table("materialcost")
                .addPrimaryKey("ID", Type.VARCHAR)
                .addAttr("MATERIAL_COST", Type.DECIMAL)
                .addAttr("COST", Type.DECIMAL);


        String sqlStatemement = table_material_cost.create();
        System.out.println(sqlStatemement);
        updateStatement(connection, sqlStatemement);

    }

    private static void createTableProduction(Connection connection) throws SQLException
    {
        Table table_production = new Table("production")
                .addPrimaryKey("ID", Type.VARCHAR)
                .addAttr("PRODUCTION_CAPACITY", Type.DECIMAL)
                .addAttr("capacityChange", Type.DECIMAL);


        String sqlStatemement = table_production.create();
        System.out.println(sqlStatemement);
        updateStatement(connection, sqlStatemement);

    }

    private static void createTableProductionCost(Connection connection) throws SQLException
    {
        Table table_production_cost = new Table("productioncost")
                .addPrimaryKey("ID", Type.VARCHAR)
                .addAttr("PROFIT_MARGIN", Type.DECIMAL)
                .addAttr("COST", Type.DECIMAL);

        String sqlStatemement = table_production_cost.create();
        System.out.println(sqlStatemement);
        updateStatement(connection, sqlStatemement);

    }

    private static void createTableUnitCost(Connection connection) throws SQLException
    {
        Table table_unit_cost = new Table("unitcost")
                .addPrimaryKey("ID", Type.VARCHAR)
                .addAttr("TAXRATE", Type.DECIMAL)
                .addAttr("BENEFIT_MARGE", Type.DECIMAL)
                .addAttr("INVEST_REACTION", Type.DECIMAL)
                .addAttr("COST", Type.DECIMAL);


        String sqlStatemement = table_unit_cost.create();
        System.out.println(sqlStatemement);
        updateStatement(connection, sqlStatemement);

    }


}
