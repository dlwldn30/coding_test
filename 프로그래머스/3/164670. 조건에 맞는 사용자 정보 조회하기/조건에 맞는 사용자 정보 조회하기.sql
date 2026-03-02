select user_id, nickname, concat(city, ' ', street_address1, ' ', street_address2) as '전체주소',
    concat(substring(tlno, 1, 3), '-', substring(tlno, 4, 4), '-', substring(tlno, 8, 4)) as 전화번호
from used_goods_user ugu
inner join (select writer_id from used_goods_board group by writer_id having(count(*)) >= 3) b
    on ugu.user_id = b.writer_id
order by user_id desc