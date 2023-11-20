# Write your MySQL query statement below


SELECT MAX(num) as num
FROM (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(*) = 1
) AS a;

# SELECT num, COUNT(*)
# FROM MyNumbers
# GROUP BY num
# HAVING COUNT(*) = 1;