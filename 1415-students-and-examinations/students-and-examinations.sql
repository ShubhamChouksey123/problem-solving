# Write your MySQL query statement below


-- SELECT Students.student_id, Students.student_name, subject_name, COUNT(*) AS attended_exams FROM Examinations
-- INNER JOIN Students ON Examinations.student_id = Students.student_id
-- GROUP BY Examinations.student_id, subject_name
-- ORDER BY Students.student_id, COUNT(*) DESC;

SELECT Students.student_id, Students.student_name, Subjects.subject_name,  COUNT(Examinations.student_id) AS attended_exams
FROM Students JOIN Subjects 
LEFT JOIN Examinations ON Examinations.student_id = Students.student_id AND Examinations.subject_name = Subjects.subject_name
GROUP BY Students.student_id, Students.student_name ,Subjects.subject_name
ORDER BY Students.student_id, Students.student_name;