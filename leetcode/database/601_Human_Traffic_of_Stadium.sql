-- 1
SELECT distinct S1.*
FROM Stadium S1, Stadium S2, Stadium S3
WHERE S1.people >= 100 AND S2.people >= 100 AND S3.people >= 100
AND 
(
    (S1.id - S2.id = 1 and S1.id - S3.id = 2 and S2.id - S3.id =1) -- S1, S2, S3
    or
    (S2.id - S1.id = 1 and S2.id - S3.id = 2 and S1.id - S3.id =1) -- S2, S1, S3
    or
    (S3.id - S2.id = 1 and S2.id - S1.id =1 and S3.id - S1.id = 2) -- S3, S2, S1
)
ORDER BY S1.id

-- 2
SELECT DISTINCT B.id, B.visit_date, B.people
FROM 
(
    SELECT id as id1, 
            lead(id, 1) over (order by id) as id2,
            lead(id, 2) over (order by id) as id3
    FROM Stadium
    WHERE people >= 100
) A
LEFT JOIN Stadium B ON (A.id1 = B.id OR A.id2 = B.id OR A.id3 = B.id)
WHERE id1+1 = id2 AND id2+1 = id3
ORDER BY id

-- 3
WITH 
People as (
    SELECT *
    FROM Stadium
    WHERE people >= 100
),
Rank_Diff as (
    SELECT *,
            id-row_number() over(order by id) as diff
    FROM People
)
SELECT id, visit_date, people
FROM Rank_Diff
WHERE diff IN (SELECT diff FROM Rank_Diff GROUP BY 1 HAVING COUNT(id) >= 3);