-- 코드를 작성해주세요
select
    ROUND(AVG(IFNULL(length, 10)), 2) as average_length
FROM
    fish_info
