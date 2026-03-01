select distinct(cr.car_id)
from car_rental_company_car cr
join car_rental_company_rental_history cc
on cr.car_id = cc.car_id
where Month(cc.start_date) = 10 and cr.car_type = '세단'
order by car_id desc
