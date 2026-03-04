select MONTH(start_date) as month, car_id, count(car_id) as records
from car_rental_company_rental_history
where start_date between '2022-08-01' and '2022-10-31'
    and car_id in (select car_id from car_rental_company_rental_history
                   where start_date between '2022-08-01' and '2022-10-31'
                  group by car_id having count(*) >= 5)
group by Month(start_date), car_id
ORDER BY
    MONTH(start_date) asc, car_id desc
    
