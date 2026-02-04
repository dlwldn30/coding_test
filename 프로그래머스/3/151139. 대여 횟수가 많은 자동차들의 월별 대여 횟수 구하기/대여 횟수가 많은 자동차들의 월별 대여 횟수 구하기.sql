-- 코드를 입력하세요
SELECT
    MONTH(start_date) AS MONTH,
    car_id,
    count(*) as records
FROM
    car_rental_company_rental_history
WHERE
    start_date BETWEEN '2022-08-01' AND '2022-10-31'
    AND car_id in (select car_id
               FROM car_rental_company_rental_history
               WHERE start_date BETWEEN '2022-08-01' AND '2022-10-31'
               GROUP BY car_id
               HAVING count(*) >= 5)
GROUP BY
    MONTH(start_date), car_id
ORDER BY
    MONTH(start_date) asc, car_id desc

    