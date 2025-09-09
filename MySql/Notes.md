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



