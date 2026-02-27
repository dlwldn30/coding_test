select  i.item_id, i.item_name, i.rarity
from item_tree it
join item_info ii on ii.item_id = it.parent_item_id
join item_info i on i.item_id = it.item_id
where ii.rarity like 'rare'
order by i.item_id desc