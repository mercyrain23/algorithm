-- 299ms
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N=N-1;
    RETURN (
        # Write your MySQL query statement below.
        SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT N, 1
    );
END

-- 276
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT max(Salary)
      From (
          SELECT Salary, dense_rank() over(order by salary desc) as rnum
          FROM Employee
      ) T
      where rnum = N
      
  );
END