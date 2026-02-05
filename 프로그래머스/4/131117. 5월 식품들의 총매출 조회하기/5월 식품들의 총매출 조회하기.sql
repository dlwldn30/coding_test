-- 코드를 입력하세요
SELECT fp.product_id, product_name, sum(fp.price * fo.amount) as total_sales
FROM food_product fp
LEFT JOIN food_order fo
on fp.product_id = fo.product_id
WHERE MONTH(fo.produce_date) = 5
GROUP BY fp.PRODUCT_ID
ORDER BY total_sales desc, product_id asc