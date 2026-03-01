-- 코드를 입력하세요
SELECT
    b.category as category,
    sum(sales) as total_sales
FROM
    book b
JOIN book_sales bs
    ON b.book_id = bs.book_id
WHERE
    MONTH(sales_date) = 1
GROUP BY
    b.category
ORDER BY
    b.category