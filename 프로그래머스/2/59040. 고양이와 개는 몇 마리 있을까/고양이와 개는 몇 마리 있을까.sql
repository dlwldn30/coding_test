-- 코드를 입력하세요
SELECT
    animal_type,
    count(*) as count
FROM 
    animal_ins
WHERE
    animal_type in ('Dog', 'Cat')
GROUP BY
    animal_type
ORDER BY
    case
        when animal_type = 'cat' then 1
        when animal_type = 'dog' then 2
    end;