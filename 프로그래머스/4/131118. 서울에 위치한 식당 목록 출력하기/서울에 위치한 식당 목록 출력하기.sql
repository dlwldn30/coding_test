-- 코드를 입력하세요
SELECT ri.rest_id, ri.rest_name, ri.food_type, ri.favorites, address, round(avg(review_score),2) as score
FROM rest_info ri
    JOIN rest_review rr on ri.rest_id = rr.rest_id
WHERE ri.address like '서울%'
GROUP BY 
 ri.rest_name
   
ORDER BY score desc, ri.favorites desc