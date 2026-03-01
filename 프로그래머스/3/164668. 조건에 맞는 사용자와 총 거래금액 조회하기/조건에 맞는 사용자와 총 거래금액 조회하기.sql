select user_id, nickname, sum(price) as total_sales
from used_goods_board ugb
left join used_goods_user ugu on ugb.writer_id = ugu.user_id
where status = 'Done'
group by user_id
having sum(price) >= 700000
order by total_sales asc