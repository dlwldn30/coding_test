-- 코드를 작성해주세요
SELECT item_id, item_name, rarity
FROM item_info
where item_id not in (select parent_item_id as item_id from item_tree where parent_item_id is not null)
order by item_id desc