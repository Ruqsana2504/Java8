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
}
