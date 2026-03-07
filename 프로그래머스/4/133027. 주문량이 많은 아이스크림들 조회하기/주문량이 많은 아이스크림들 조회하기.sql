-- 코드를 입력하세요
SELECT f.flavor
from first_half f
join july j on f.flavor = j.flavor
group by f.flavor
ORDER BY (f.total_order + SUM(j.total_order)) DESC
limit 3;