-- 코드를 작성해주세요
SELECT
    ii.item_id,
    item_name
FROM
    item_info ii
JOIN
    item_tree it
    ON ii.item_id = it.item_id
WHERE
    parent_item_id is null
ORDER BY
    item_id asc