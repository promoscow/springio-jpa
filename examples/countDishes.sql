select
    d1_0.id,
    d1_0.active,
    d1_0.name,
    d1_0.price,
    d1_0.restaurant_id
from
    dishes d1_0
where
    d1_0.name=?
select
    r1_0.id,
    d1_0.restaurant_id,
    d1_0.id,
    d1_0.active,
    d1_0.name,
    d1_0.price,
    r1_0.name
from
    restaurants r1_0
        left join
    dishes d1_0
    on r1_0.id=d1_0.restaurant_id
where
    r1_0.id=?
select
    o1_0.restaurant_id,
    o1_0.id,
    o1_0.date,
    o1_0.user_id
from
    orders o1_0
where
    o1_0.restaurant_id=?
