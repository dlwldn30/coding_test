-- 코드를 입력하세요
SELECT
    p.product_code,
    sum(p.price*os.sales_amount) as sales
FROM 
    product p 
JOIN offline_sale os
    on os.product_id = p.product_id
GROUP BY
    p.product_code
ORDER BY
    sales desc, p.product_code asc
