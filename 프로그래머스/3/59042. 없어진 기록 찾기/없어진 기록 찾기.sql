-- 코드를 입력하세요
SELECT
    ao.animal_id,
    ao.name
FROM
    animal_outs ao
LEFT JOIN
    animal_ins ai
    on ao.animal_id = ai.animal_id
WHERE 
    ai.animal_id is null
ORDER BY
    ao.animal_id
