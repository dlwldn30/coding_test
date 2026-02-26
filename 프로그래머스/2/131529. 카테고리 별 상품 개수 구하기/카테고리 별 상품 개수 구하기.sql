select left(product_code,2) category, count(*) as products
from product
group by left(product_code,2)
order by category;
