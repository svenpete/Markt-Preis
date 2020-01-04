package simulation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Simulation
{

    // resultsets
    private Double [] [] capitalCostResultSetA;
    private Double [] [] capitalCostResultSetB;
    private Double [] [] employeeResultSetA;
    private Double [] [] employeeResultSetB;
    private Double [] [] labourCostResultSetA;
    private Double [] [] labourCostResultSetB;
    private Double [] [] materialCostResultSetA;
    private Double [] [] materialCostResultSetB;
    private Double [] [] productionResultSetA;
    private Double [] [] productionResultSetB;
    private Double [] [] totalProductionResultSet;
    private Double [] [] productionCostResultSetA;
    private Double [] [] productionCostResultSetB;
    private Double [] [] unitCostResultSetA;
    private Double [] [] unitCostResultSetB;
    private Double [] [] marketPriceResultSet;

    public Simulation()
    {

    }

    /**
     *
     * @param finalTime how often the simulation is runned
     * @param finalStep steps for calculation
     * @param parm are input parameter
     * @throws SQLException
     */
    public void simulate(Integer finalTime, Integer finalStep, List<Double> parm) throws SQLException {



        //Company A
        Production      productionA     =   new Production(parm.get(0));
        Employee        employeeA       =   new Employee(parm.get(1),parm.get(2),productionA);
        LabourCost      labourCostA     =   new LabourCost(parm.get(3),parm.get(4),employeeA);
        CapitalCost     capitalCostA    =   new CapitalCost(parm.get(5) ,parm.get(6),productionA);
        MaterialCost    materialCostA   =   new MaterialCost(parm.get(7),productionA);
        ProductionCost  productionCostA =   new ProductionCost(capitalCostA,materialCostA,labourCostA);
        UnitCost        unitCostA       =   new UnitCost(parm.get(8),productionCostA, productionA);


        //Company B
        Production      productionB          =   new Production(parm.get(9));
        Employee        employeeB            =   new Employee(parm.get(10),parm.get(11),productionB);
        LabourCost      labourCostB          =   new LabourCost(parm.get(12),parm.get(13),employeeB);
        CapitalCost     capitalCostB         =   new CapitalCost(parm.get(14) ,parm.get(15),productionB);
        MaterialCost    materialCostB        =   new MaterialCost(parm.get(16),productionB);
        ProductionCost  productionCostB      =   new ProductionCost(capitalCostB,materialCostB,labourCostB);
        UnitCost        unitCostB            =   new UnitCost(parm.get(17),productionCostB, productionB);

        // fill for calculations
        ArrayList<UnitCost> unitCosts = new ArrayList<>();
        unitCosts.add(unitCostA);
        unitCosts.add(unitCostB);

        MarketPrice     marketPrice         =   new MarketPrice(parm.get(18),parm.get(19),parm.get(20),unitCosts);

        // initialize the resultsets
        createResultSets(finalTime);


        /**
         * dont change order nor methods  work !
         * iterate through with given parameter finalTime
         * and saves results in the resultSet of the simulation
         */

        for (int i = 0; i < finalTime ; i = i + finalStep)
        {


            employeeA.calculateEmployees();
            employeeResultSetA[i][0] = i * 1.00;
            employeeResultSetA[i][1] = employeeA.getRATIONALISATIONFACTOR();
            employeeResultSetA[i][2] = employeeA.getEMPLOYMENTEFFECT();
            employeeResultSetA[i][3] = employeeA.getEmployees();

            employeeB.calculateEmployees();
            employeeResultSetB[i][0] = i * 1.00;
            employeeResultSetB[i][1] = employeeB.getRATIONALISATIONFACTOR();
            employeeResultSetB[i][2] = employeeB.getEMPLOYMENTEFFECT();
            employeeResultSetB[i][3] = employeeB.getEmployees();


            labourCostA.calculateCosts();
            labourCostResultSetA[i][0] = i * 1.00;
            labourCostResultSetA[i][1] = labourCostA.getWageRate();
            labourCostResultSetA[i][2] = labourCostA.getIncidentalExpenseRate();
            labourCostResultSetA[i][3] = labourCostA.getCost();


            labourCostB.calculateCosts();
            labourCostResultSetB[i][0] = i * 1.00;
            labourCostResultSetB[i][1] = labourCostB.getWageRate();
            labourCostResultSetB[i][2] = labourCostB.getIncidentalExpenseRate();
            labourCostResultSetB[i][3] = labourCostB.getCost();

            capitalCostA.calculateCosts();
            capitalCostResultSetA[i][0] = i * 1.00;
            capitalCostResultSetA[i][1] = capitalCostA.getDEPRECIATIONRATE();
            capitalCostResultSetA[i][2] = capitalCostA.getSPECIFICCAPITALREQUIREMENT();
            capitalCostResultSetA[i][3] = capitalCostA.getCost();

            capitalCostB.calculateCosts();
            capitalCostResultSetB[i][0] = i * 1.00;
            capitalCostResultSetB[i][1] = capitalCostB.getDEPRECIATIONRATE();
            capitalCostResultSetB[i][2] = capitalCostB.getSPECIFICCAPITALREQUIREMENT();
            capitalCostResultSetB[i][3] = capitalCostB.getCost();

            materialCostA.calculateCosts();
            materialCostResultSetA[i][0] = i * 1.00;
            materialCostResultSetA[i][1] = materialCostA.getMATERIALCOSTUNIT();
            materialCostResultSetA[i][2] = materialCostA.getCost();

            materialCostB.calculateCosts();
            materialCostResultSetB[i][0] = i * 1.00;
            materialCostResultSetB[i][1] = materialCostB.getMATERIALCOSTUNIT();
            materialCostResultSetB[i][2] = materialCostB.getCost();

            productionCostA.calculateCosts();
            productionCostResultSetA[i][0] = i * 1.00;
            productionCostResultSetA[i][1] = productionCostA.getPROFITMARGIN();
            productionCostResultSetA[i][2] = productionCostA.getCost();

            productionCostB.calculateCosts();
            productionCostResultSetB[i][0] = i * 1.00;
            productionCostResultSetB[i][1] = productionCostB.getPROFITMARGIN();
            productionCostResultSetB[i][2] = productionCostB.getCost();

            unitCostA.calculateCosts();
            unitCostResultSetA[i][0] = i * 1.00;
            unitCostResultSetA[i][1] = unitCostA.getTAXRATE();
            unitCostResultSetA[i][3] = unitCostA.getInvestReaction();
            unitCostResultSetA[i][4] = unitCostA.getCost();


            unitCostB.calculateCosts();
            unitCostResultSetB[i][0] = i * 1.00;
            unitCostResultSetB[i][1] = unitCostA.getTAXRATE();
            unitCostResultSetB[i][3] = unitCostB.getInvestReaction();
            unitCostResultSetB[i][4] = unitCostB.getCost();


            unitCostA.calcBenefitMarge(marketPrice.getMarketPrice());
            unitCostResultSetA[i][2] = unitCostA.getBenefitMarge();
            unitCostB.calcBenefitMarge(marketPrice.getMarketPrice());
            unitCostResultSetB[i][2] = unitCostB.getBenefitMarge();



            Production.calcSumProductionCapacity(productionA.getProductionCapacity(),
                                                                                    productionB.getProductionCapacity());
            totalProductionResultSet[i][0] = i * 1.00;
            totalProductionResultSet[i][1] = Production.getSumProductionCapacity();



            marketPrice.calcMismatchDemand(Production.getSumProductionCapacity());
            marketPrice.calcPricePressureDemand();

            marketPrice.calcCostAdjustment(productionA.getProductionCapacity(),
                                            productionB.getProductionCapacity(),Production.getSumProductionCapacity());

            marketPrice.calcPricePressureCosts(marketPrice.getCostAdjustment());

            marketPriceResultSet[i][0] = i * 1.00;
            marketPriceResultSet[i][1] = marketPrice.getDEMAND();
            marketPriceResultSet[i][2] = marketPrice.getREACTIONRATE();

            marketPriceResultSet[i][3] = marketPrice.getMarketPrice();
            marketPriceResultSet[i][4] = marketPrice.getPricePressureCosts();
            marketPriceResultSet[i][5] = marketPrice.getMismatchPrice();
            marketPriceResultSet[i][6] = marketPrice.getPricePressureDemand();
            marketPriceResultSet[i][7] = marketPrice.getMismatchDemand();
            marketPriceResultSet[i][8] = marketPrice.getCostAdjustment();


            unitCostA.calcInvestReactionI();
            unitCostB.calcInvestReactionI();

            productionA.calculateCapacityChange(unitCostA.getInvestReaction());
            productionA.calculateProductCapacity();
            productionResultSetA[i][0] = i * 1.00;
            productionResultSetA[i][1] = productionA.getProductionCapacity();
            productionResultSetA[i][2] = productionA.getCapacityChange();

            productionB.calculateCapacityChange(unitCostB.getInvestReaction());
            productionB.calculateProductCapacity();
            productionResultSetB[i][0] = i * 1.00;
            productionResultSetB[i][1] = productionB.getProductionCapacity();
            productionResultSetB[i][2] = productionB.getCapacityChange();


            marketPrice.calcMarketPrice();


        }


    }


    private void createResultSets(Integer size)
    {
        capitalCostResultSetA = new Double[size][4];
        capitalCostResultSetB = new Double[size][4];
        employeeResultSetA = new Double[size][4];
        employeeResultSetB = new Double[size][4];
        labourCostResultSetA = new Double[size][4];
        labourCostResultSetB = new Double[size][4];
        materialCostResultSetA = new Double[size][3];
        materialCostResultSetB = new Double[size][3];
        productionResultSetA = new Double[size][3];
        productionResultSetB = new Double[size][3];
        totalProductionResultSet = new Double[size][2];
        productionCostResultSetA = new Double[size][3];
        productionCostResultSetB = new Double[size][3];
        unitCostResultSetA = new Double[size][5];
        unitCostResultSetB = new Double[size][5];
        marketPriceResultSet = new Double[size][9];


    }

    public Double[][] getCapitalCostResultSetA() {
        return capitalCostResultSetA;
    }

    public Double[][] getCapitalCostResultSetB() {
        return capitalCostResultSetB;
    }

    public Double[][] getEmployeeResultSetA() {
        return employeeResultSetA;
    }

    public Double[][] getEmployeeResultSetB() {
        return employeeResultSetB;
    }

    public Double[][] getLabourCostResultSetA() {
        return labourCostResultSetA;
    }

    public Double[][] getLabourCostResultSetB() {
        return labourCostResultSetB;
    }

    public Double[][] getMaterialCostResultSetA() {
        return materialCostResultSetA;
    }

    public Double[][] getMaterialCostResultSetB() {
        return materialCostResultSetB;
    }

    public Double[][] getProductionResultSetA() {
        return productionResultSetA;
    }

    public Double[][] getProductionResultSetB() {
        return productionResultSetB;
    }

    public Double[][] getTotalProductionResultSet() {
        return totalProductionResultSet;
    }

    public Double[][] getProductionCostResultSetA() {
        return productionCostResultSetA;
    }

    public Double[][] getProductionCostResultSetB() {
        return productionCostResultSetB;
    }

    public Double[][] getUnitCostResultSetA() {
        return unitCostResultSetA;
    }

    public Double[][] getUnitCostResultSetB() {
        return unitCostResultSetB;
    }

    public Double[][] getMarketPriceResultSet() {
        return marketPriceResultSet;
    }
}
