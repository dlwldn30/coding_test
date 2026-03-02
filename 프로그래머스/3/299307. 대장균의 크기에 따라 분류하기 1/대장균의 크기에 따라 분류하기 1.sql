-- 코드를 작성해주세요
SELECT
    id,
    CASE
        when size_of_colony <= 100 then 'LOW'
        when size_of_colony between 101 and 1000 then 'MEDIUM'
        when size_of_colony > 1000 then 'HIGH'
    END as size
FROM 
    ecoli_data
ORDER BY
    id