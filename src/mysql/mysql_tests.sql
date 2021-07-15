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