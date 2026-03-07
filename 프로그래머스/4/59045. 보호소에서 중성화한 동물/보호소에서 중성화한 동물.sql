-- 코드를 입력하세요
SELECT animal_id, animal_type, name
from animal_outs ao
where animal_id in (select animal_id from animal_ins where sex_upon_intake like '%intact%')
and (SEX_UPON_OUTCOME LIKE 'Spayed%' OR ao.SEX_UPON_OUTCOME LIKE 'Neutered%')
order by animal_id