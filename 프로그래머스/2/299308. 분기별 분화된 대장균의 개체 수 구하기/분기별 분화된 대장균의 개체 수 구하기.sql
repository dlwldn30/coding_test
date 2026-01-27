-- 코드를 작성해주세요
SELECT
    concat(quarter(differentiation_date), 'Q') as quarter,
    count(id) as ecoli_count
FROM
    ecoli_data
GROUP BY
   quarter
ORDER BY
    quarter asc