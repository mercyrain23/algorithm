-- 763 ms
select Department, Employee, Salary 
From (
    select D.Name as Department, E.Name as Employee, E.Salary,
             rank() over(partition by departmentId order by Salary desc) as num
    from Employee E Inner Join Department D 
    On E.DepartmentId = D.Id
) T
where T.num = 1

-- 525ms
SELECT D.Name as Department, E.Name as Employee, E.Salary
FROM Employee E JOIN Department D
ON E.DepartmentId = D.Id
WHERE (DepartmentId, Salary) IN (SELECT DepartmentId, MAX(Salary) FROM Employee GROUP BY DepartmentId)