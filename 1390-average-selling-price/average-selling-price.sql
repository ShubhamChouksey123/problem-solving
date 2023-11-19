# Write your MySQL query statement below
# SELECT UnitsSold.product_id,  ROUND(SUM(units*price)/SUM(units), 2) AS average_price
# FROM Prices
# JOIN  UnitsSold
# ON UnitsSold.product_id = Prices.product_id AND purchase_date >= start_date AND purchase_date <= end_date
# GROUP BY UnitsSold.product_id;


SELECT Prices.product_id, COALESCE(ROUND(SUM(units*price)/SUM(units), 2), 0) AS average_price
FROM Prices
LEFT JOIN UnitsSold
ON Prices.product_id = UnitsSold.product_id
WHERE UnitsSold.product_id IS NULL OR (purchase_date >= start_date AND purchase_date <= end_date)
GROUP BY UnitsSold.product_id;