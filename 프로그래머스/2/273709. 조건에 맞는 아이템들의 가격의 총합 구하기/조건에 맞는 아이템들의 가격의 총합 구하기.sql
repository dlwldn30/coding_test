-- 코드를 작성해주세요
SELECT
    sum(price) as total_price
FROM 
    item_info
WHERE
    RARITY = 'LEGEND'