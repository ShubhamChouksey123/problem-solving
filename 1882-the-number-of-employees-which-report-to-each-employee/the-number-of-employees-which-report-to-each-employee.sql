# Write your MySQL query statement below
SELECT e2.employee_id AS employee_id, e2.name AS name, COUNT(*) AS reports_count, ROUND(AVG(e1.age) , 0) AS average_age
FROM Employees e1
JOIN Employees e2 ON e1.reports_to = e2.employee_id
GROUP BY e2.employee_id
ORDER BY e2.employee_id;
