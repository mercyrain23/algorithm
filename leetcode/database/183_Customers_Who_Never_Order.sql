# 475ms
select Name as Customers
from Customers C left join Orders O
on C.Id = O.CustomerId
where O.id is null

# 415ms 
select Name as Customers
from customers
where customers.id not in ( select customerid from orders )