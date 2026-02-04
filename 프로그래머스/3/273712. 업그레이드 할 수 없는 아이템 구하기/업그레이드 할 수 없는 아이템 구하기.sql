-- 코드를 작성해주세요
SELECT ii.item_id, ii.item_name, ii.rarity
FROM
    item_info ii
    LEFT JOIN item_tree it
    ON ii.item_id = it.parent_item_id
WHERE 
    it.parent_item_id is null
ORDER BY item_id desc