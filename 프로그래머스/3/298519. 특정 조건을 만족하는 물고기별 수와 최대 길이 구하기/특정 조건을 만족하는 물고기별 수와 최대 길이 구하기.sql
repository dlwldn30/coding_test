-- 코드를 작성해주세요
select count(id) as fish_count, max(length) as max_length, fish_type
FROM fish_info
GROUP BY fish_type
HAVING avg(IFNULL(length, 10)) >= 33
ORDER BY fish_type asc