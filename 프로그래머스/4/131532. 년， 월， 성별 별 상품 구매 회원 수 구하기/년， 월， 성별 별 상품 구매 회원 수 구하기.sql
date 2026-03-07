-- 코드를 입력하세요
SELECT Year(sales_date) as year, Month(sales_date) as month, gender, count(distinct os.user_id) as users
from online_sale os
join user_info ui on os.user_id = ui.user_id
where ui.gender is not null
group by Year(sales_date) , Month(sales_date) , gender
order by year, month, gender