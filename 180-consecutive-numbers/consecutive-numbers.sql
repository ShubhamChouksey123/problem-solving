# Write your MySQL query statement below

# Write your MySQL query statement below
SELECT DISTINCT(l1.num) AS ConsecutiveNums
FROM Logs l1
INNER JOIN Logs l2 ON l1.num = l2.num AND l1.id + 1 = l2.id 
INNER JOIN Logs l3 ON l1.num = l3.num AND l1.id + 2 = l3.id;

# SELECT l1.id, l1.num, l2.id, l2.num, l3.id, l3.num
# FROM Logs l1
# INNER JOIN Logs l2 ON l1.num = l2.num AND l1.id + 1 = l2.id 
# INNER JOIN Logs l3 ON l1.num = l3.num AND l1.id + 2 = l3.id
# ORDER BY l1.id, l2.id;
