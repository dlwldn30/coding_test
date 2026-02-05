-- 코드를 입력하세요
SELECT category, price as max_price, product_name
FROM food_product f
WHERE price =  (select max(price) from food_product p Where category = f.category) and category in ('과자', '국', '김치', '식용유')
ORDER BY price desc