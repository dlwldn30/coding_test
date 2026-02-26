select i1.item_id, i1.item_name, i1.rarity
from item_tree it
join item_info ii on it.parent_item_id = ii.item_id
join item_info i1 on i1.item_id = it.item_id
where ii.rarity = 'rare'
order by i1.item_id desc
