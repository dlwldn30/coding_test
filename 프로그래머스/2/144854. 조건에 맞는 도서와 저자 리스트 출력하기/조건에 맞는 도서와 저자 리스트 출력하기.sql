-- 코드를 입력하세요
SELECT 
    b.book_id as book_id,
    a.author_name as author_id,
    DATE_FORMAT(b.published_date, "%Y-%m-%d")as published_date
FROM
    BOOK b
    JOIN author a
    on a.author_id = b.author_id
WHERE
    category = '경제'
ORDER BY
    published_date asc