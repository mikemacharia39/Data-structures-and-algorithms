-- Query the list of CITY names from STATION that do not end with vowels.
-- Your result cannot contain duplicates.
SELECT CITY FROM STATION WHERE CITY RLIKE '[^aeiouAEIOU]$' GROUP BY CITY;

-- Query the list of CITY names from STATION that do not end with vowels.
-- Your result cannot contain duplicates.

SELECT DISTINCT CITY FROM STATION WHEN CITY RLIKE '^[^aeiouAEIOU].*|.*[^aeiouAEIOU]$';


-- Query the list of CITY names from STATION that do not start with vowels and do not end with vowels.
-- Your result cannot contain duplicates.
SELECT DISTINCT CITY FROM STATION WHERE CITY RLIKE '^[^aeiouAEIOU]' AND CITY RLIKE '[^aeiouAEIOU]$';

-- Query the Name of any student in STUDENTS who scored higher than  Marks.
-- Order your output by the last three characters of each name.
-- If two or more students both have names ending in the same last three characters (i.e.: Bobby, Robby, etc.),
-- secondary sort them by ascending ID.
SELECT Name FROM STUDENTS WHERE Marks > 75 ORDER BY SUBSTRING(Name, -3), ID ASC;
-- OR
SELECT Name FROM STUDENTS WHERE Marks > 75 ORDER BY RIGHT(Name, 3), ID ASC;


-- Max Longitude to 4 decimal places that is lesser than 137.2345
SELECT FORMAT(MAX(LAT_N), 4) FROM STATION WHERE LAT_N < 137.2345;

-- ROUND UP, get AVG and REPLACE a character with another
SELECT CEIL(AVG(Salary) - AVG(REPLACE(Salary, '0',''))) FROM EMPLOYEES;

-- TO CALCULATE MEDIAN IN MYSQL
SELECT MAX(FORMAT(S.LAT_N,4)) FROM STATION S WHERE (SELECT CEIL(COUNT(S.ID)/2)-1 FROM STATION) =
(SELECT COUNT(S1.ID) FROM STATION S1 WHERE S1.LAT_N > S.LAT_N);

-- TO CALCULATE GRADE BASED ON MIN AND MAX MARKS
-- https://www.hackerrank.com/challenges/the-report/problem
SELECT IF (GRADE < 8, NULL, NAME), GRADE, MARKS FROM STUDENTS JOIN GRADES
WHERE MARKS BETWEEN MIN_MARK AND MAX_MARK ORDER BY GRADE DESC, NAME;


-- Create a query to print the below pattern
-- *
-- * *
-- * * *
-- * * * *
-- * * * * *
set @row = 0;
select repeat('* ', @row := @row + 1) from information_schema.tables where @row < 20;


-- MySQL triggers

CREATE TRIGGER after_members_insert
AFTER INSERT
ON members FOR EACH ROW
BEGIN
    IF NEW.birthDate IS NULL THEN
        INSERT INTO reminders(memberId, message)
        VALUES(new.id,CONCAT('Hi ', NEW.name, ', please update your date of birth.'));
    END IF;
END
