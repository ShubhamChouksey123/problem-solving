
# SELECT 
#     COUNT(CASE WHEN action = "confirmed" then 1 ELSE NULL END) 
# from Confirmations;


SELECT s.user_id,  
ROUND(COUNT(CASE WHEN action = "confirmed" THEN 1 ELSE NULL END)/COUNT(*), 2) AS confirmation_rate
FROM Signups s
LEFT JOIN Confirmations ON s.user_id = Confirmations.user_id
GROUP BY user_id;


# SELECT s.user_id,  
# COUNT(CASE WHEN action = 'confirmed' THEN 1 ELSE 0 )/COUNT(*) AS confirmation_rate
# FROM Signups s
# LEFT JOIN Confirmations ON s.user_id = Confirmations.user_id
# GROUP BY user_id;
