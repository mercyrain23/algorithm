-- 377 ms
select distinct Num as ConsecutiveNums
from (
    select Num, 
        LEAD(Num) OVER (ORDER BY Id) as Num2,
        Lag(Num) OVER (ORDER BY Id) as Num3
    from Logs
) T
where Num = Num2 and Num2 = Num3

-- 387ms
SELECT DISTINCT
    l1.Num AS ConsecutiveNums
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num
;