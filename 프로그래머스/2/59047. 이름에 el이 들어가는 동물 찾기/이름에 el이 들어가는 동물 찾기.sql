-- 코드를 입력하세요
SELECT
    animal_id,
    name
FROM
    animal_ins
WHERE  
    name like '%EL%' and animal_type = 'dog'
ORDER BY
    name