with ids as (
    select min(id) from Person group by Email
)

delete from Person
where Id not in (
    select * from ids
)
