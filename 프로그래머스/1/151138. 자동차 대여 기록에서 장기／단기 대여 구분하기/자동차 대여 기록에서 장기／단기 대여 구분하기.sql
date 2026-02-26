SELECT history_id, car_id, DATE_FORMAT(start_date, '%Y-%m-%d') start_date, DATE_FORMAT(end_date, '%Y-%m-%d') end_date,
        CASE
            WHEN (DATEDIFF(END_DATE, START_DATE)+1) >= 30 THEN '장기 대여'
            ELSE '단기 대여'
       END AS RENT_TYPE
FROM car_rental_company_rental_history
WHERE start_date like '2022-09%'
order by history_id desc