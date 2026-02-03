-- 코드를 입력하세요
SELECT 
    c.car_id, 
    case when exists(
        select 1
        from car_rental_company_rental_history h
        where '2022-10-16 ' between h.start_date and h.end_date 
        and h.car_id = c.car_id) 
        then '대여중'
        else '대여 가능' end as availability
FROM car_rental_company_rental_history c
group by car_id
order by car_id desc