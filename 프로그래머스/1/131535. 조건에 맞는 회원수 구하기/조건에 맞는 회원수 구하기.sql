-- 코드를 입력하세요
SELECT
    count(*) as USERS
FROM 
    user_info
WHERE
    joined like '2021%'and
    age BETWEEN 20 and 29