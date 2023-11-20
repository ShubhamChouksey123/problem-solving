# Write your MySQL query statement below
# SELECT COUNT(*) FROM Product;

SELECT customer_id 
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT(product_key)) = (SELECT COUNT(*) FROM Product);