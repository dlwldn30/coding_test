-- 코드를 입력하세요
SELECT b.author_id, a.author_name, b.category, sum(b.price * bs.sales) as total_sales
FROM book b
JOIN author a on a.author_id = b.author_id
JOIN book_sales bs on bs.book_id = b.book_id
WHERE bs.sales_date BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY a.author_id, b.category
ORDER BY b.author_id asc, b.category desc
