# Write your MySQL query statement below
# SELECT product_id, new_price, change_date, DATEDIFF('2019-08-16', change_date)
# FROM Products 
# WHERE change_date <= '2019-08-16'
# GROUP BY product_id
# HAVING MIN(DATEDIFF('2019-08-16', change_date));

# SELECT MIN(DATEDIFF('2019-08-16', change_date))
# FROM Products
# WHERE product_id = 2 AND change_date <= '2019-08-16';

SELECT product_id, new_price AS price
FROM Products 
WHERE(product_id, change_date) IN (
    SELECT product_id, MAX(change_date)
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
)

UNION 

SELECT product_id, 10 AS price
FROM Products 
GROUP BY product_id
HAVING MIN(change_date) > '2019-08-16';