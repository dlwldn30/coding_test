-- 코드를 입력하세요
SELECT animal_id, animal_type, name
FROM animal_ins ai
WHERE animal_id in (select animal_id FROM animal_outs 
                    WHERE sex_upon_outcome like '%spayed%'
                   or sex_upon_outcome like '%neutered%' and ai.animal_id = animal_id) and sex_upon_intake like '%intact%'
ORDER BY ai.animal_id