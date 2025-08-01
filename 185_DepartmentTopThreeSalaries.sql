-- USING Subquery

SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Employee e
JOIN Department d ON e.departmentId = d.id
WHERE (
  SELECT COUNT(DISTINCT e2.salary)
  FROM Employee e2
  WHERE e2.departmentId = e.departmentId
    AND e2.salary > e.salary
) < 3;

-- Better approach: using DENSE_RANK()
/*
SELECT
  d.name AS Department,
  e.name AS Employee,
  e.salary AS Salary
FROM (
  SELECT *,
         DENSE_RANK() OVER (
           PARTITION BY departmentId
           ORDER BY salary DESC
         ) AS rank_in_dept
  FROM Employee
) e
JOIN Department d
  ON e.departmentId = d.id
WHERE e.rank_in_dept <= 3;
*/
