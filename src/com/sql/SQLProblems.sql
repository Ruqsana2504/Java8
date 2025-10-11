package src.com.sql;

public class SQLProblems {

    --1.Second-highest salary in Employee table
    SELECT name, salary
    FROM employee
    WHERE salary = (
    SELECT MAX(SALARY)
    FROM EMPLOYEE
    WHERE SALARY < (SELECT MAX(SALARY) FROM EMPLOYEE)
    );

    --2.Given two tables (customer and order), find customers who have made zero orders
    Customer(CustomerId, CustomerName)
    Orders(OrderId, CustomerId)

    SELECT * FROM Customer
    INNER JOIN ORDERS
    ON CUSTOMER.CUSTOMERID = ORDERS.CUSTOMERID
    WHERE ORDERS.CUSTOMERID IS NULL;

    --3. Delete duplicate rows - TCS
    DELETE e1
    FROM EMPLOYEE e1
    JOIN EMPLOYEE e2
    ON e1.NAME = e2.NAME
    AND e1.DEPT = e2.DEPT
    AND e1.ID > e2.ID;
}
