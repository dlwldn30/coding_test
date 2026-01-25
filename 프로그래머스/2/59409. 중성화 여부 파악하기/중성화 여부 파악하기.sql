-- 코드를 입력하세요
SELECT
    animal_id,
    name,
    CASE
    when SEX_upon_intake like '%Neutered%'
        or sex_upon_intake like '%spayed%' then 'O'
    else 'X'
    END as '중성화'
FROM 
    animal_ins
ORDER BY
    animal_id

        