-- Number of Unique Subjects Taught by Each Teacher
-- SQL Schema
-- Table: Teacher
--
-- +-------------+------+
-- | Column Name | Type |
-- +-------------+------+
-- | teacher_id  | int  |
-- | subject_id  | int  |
-- | dept_id     | int  |
--+-------------+------+
-- (subject_id, dept_id) is the primary key (combinations of columns with unique values) of this table.
-- Each row in this table indicates that the teacher with teacher_id teaches the subject subject_id in the department dept_id.

-- Write your MySQL query statement below
SELECT teacher_id, COUNT(DISTINCT(subject_id)) AS cnt FROM Teacher GROUP BY teacher_id;