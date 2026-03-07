-- 코드를 입력하세요
SELECT fp.product_id, fp.product_name, sum(fo.amount * fp.price) as total_sales
from food_product fp
join food_order fo on fp.product_id = fo.product_id
Where Month(fo.produce_date) = 5 and Year(fo.produce_date) = 2022
group by fp.product_id
order by total_sales desc, product_id asc
