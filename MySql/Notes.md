# Mysql

## If conditions

> The IF() function returns a value if a condition is TRUE, or another value if a condition is FALSE.

```mysql-sql
SELECT IF(500<1000, 'YES', 'NO');
```

Or else

```mysql-sql
CASE
    WHEN City IS NULL THEN Country
    ELSE City
END
```

## DATE_SUB

```mysql-sql
SELECT DATE_SUB('2017-06-15', INTERVAL 10 DAY);
```

## Even or Odd
```mysql-sql
SELECT number,
       CASE 
         WHEN number % 2 = 0 THEN 'Even'
         ELSE 'Odd'
       END AS parity
FROM Numbers;
```

## UNION ALL

The UNION ALL command combines the result set of two or more SELECT statements (allows duplicate values).

ex:
```mysql-sql
SELECT City FROM Customers
UNION ALL
SELECT City FROM Suppliers
ORDER BY City;
```

