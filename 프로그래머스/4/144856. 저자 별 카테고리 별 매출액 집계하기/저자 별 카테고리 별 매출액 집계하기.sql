-- 코드를 입력하세요
SELECT b.author_id, a.author_name, b.category, sum(b.price * bs.sales) as total_sales
from book b
join author a on b.author_id = a.author_id
join book_sales bs on b.book_id = bs.book_id
Where Year(sales_date) = 2022 and Month(sales_date) = 1
group by author_id,b.category
ORDER BY b.author_id asc, b.category desc