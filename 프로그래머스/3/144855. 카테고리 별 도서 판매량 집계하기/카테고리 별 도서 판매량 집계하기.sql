select b.category, sum(sales) as total_sales
from book b
join book_sales bs on b.book_id = bs.book_id
where Month(sales_date) = 1
group by b.category
order by b.category asc