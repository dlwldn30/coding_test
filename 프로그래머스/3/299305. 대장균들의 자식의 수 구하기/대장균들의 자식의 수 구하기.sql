-- 코드를 작성해주세요
SELECT ed1.id, ifnull(count(ed2.parent_id), 0) as child_count
FROM ECOLI_DATA ed1
LEFT JOIN ecoli_data ed2
    ON ed1.id = ed2.parent_id
GROUP BY ed1.id
ORDER BY id