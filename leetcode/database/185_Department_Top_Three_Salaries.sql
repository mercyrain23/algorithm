-- 760ms
SELECT D.Name as Department, E.Name as Employee, E.Salary
FROM Employee E JOIN Department D
ON E.DepartmentId = D.Id
WHERE E.Id IN (
        SELECT Id
        FROM (
            SELECT Id, dense_rank() over (partition by DepartmentId order by salary desc) as drank
            FROM Employee
        ) T
        WHERE drank <= 3
)

-- 607ms
SELECT D.Name as Department, E.Name as Employee, E.Salary
FROM (
    SELECT Employee.*, dense_rank() over (PARTITION BY DepartmentId ORDER BY Salary DESC) as drank
    FROM Employee
) E
JOIN Department D ON E.DepartmentId = D.Id
WHERE drank <= 3


-- 919ms
SELECT
    d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
FROM
    Employee e1
        JOIN
    Department d ON e1.DepartmentId = d.Id
WHERE
    3 > (SELECT
            COUNT(DISTINCT e2.Salary)
        FROM
            Employee e2
        WHERE
            e2.Salary > e1.Salary
                AND e1.DepartmentId = e2.DepartmentId
        )
;