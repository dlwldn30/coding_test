select category, price as max_price, product_name
from food_product f
where category in ('과자', '국', '김치', '식용유') and price = (select max(price) from food_product
                                                       where f.category = category)
order by price desc