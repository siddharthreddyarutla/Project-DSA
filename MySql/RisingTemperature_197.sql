--+---------------+---------+
--| Column Name   | Type    |
--+---------------+---------+
--| id            | int     |
--| recordDate    | date    |
--| temperature   | int     |
--+---------------+---------+
--id is the column with unique values for this table.
--There are no different rows with the same recordDate.
--This table contains information about the temperature on a certain day.

--Write a solution to find all dates' id with higher temperatures compared to its previous dates (yesterday).
--
--Return the result table in any order.



-- sol:

SELECT W.id FROM Weather W JOIN Weather WC ON DATE_SUB(W.recordDate, INTERVAL 1 DAY) = WC.recordDate
WHERE W.temperature > WC.temperature;