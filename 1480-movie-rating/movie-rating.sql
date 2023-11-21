
(SELECT name AS results
FROM MovieRating
JOIN Users ON MovieRating.user_id = Users.user_id
GROUP BY MovieRating.user_id
ORDER BY COUNT(*) DESC, name
LIMIT 1)

UNION ALL

(SELECT title AS results
FROM MovieRating
JOIN Movies ON MovieRating.movie_id = Movies.movie_id
WHERE MONTH(created_at) = 2 AND YEAR(created_at) = 2020
GROUP BY MovieRating.movie_id
ORDER BY AVG(rating) DESC, title LIMIT 1)



