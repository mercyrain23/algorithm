-- 303ms
WITH A AS(
    SELECT T.Request_at, count(Id) as cnt  
    FROM Trips T JOIN Users U
    ON T.Client_Id = U.Users_Id
    WHERE U.Banned = 'No'
    GROUP BY T.Request_at
),
B AS (
    SELECT T.Request_at, count(Id) as cancel
    FROM Trips T JOIN Users U
    ON T.Client_Id = U.Users_Id
    WHERE U.Banned = 'No' AND T.Status IN ('cancelled_by_driver', 'cancelled_by_client')
    GROUP BY T.Request_at
)

SELECT A.Request_at as Day, 0 + IFNULL(ROUND(B.cancel / A.cnt, 2), '0.00') as 'Cancellation Rate'
FROM A LEFT JOIN B
ON A.Request_at = B.Request_at
WHERE A.Request_at BETWEEN '2013-10-01' AND '2013-10-03'
ORDER BY A.Request_at