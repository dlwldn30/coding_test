-- 코드를 작성해주세요
select ii.item_id, item_name, rarity 
from item_info ii
left join item_tree it
on it.item_id = ii.item_id
order by item_id