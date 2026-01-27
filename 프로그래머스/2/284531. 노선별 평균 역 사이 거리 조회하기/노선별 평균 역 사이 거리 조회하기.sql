-- 코드를 작성해주세요
SELECT
    route,
    concat(round(sum(d_between_dist), 1), 'km') as total_distance,
    concat(round(avg(d_between_dist), 2), 'km') as average_distance
FROM
    subway_distance
GROUP BY
    route
ORDER BY
     ROUND(SUM(D_BETWEEN_DIST),1) DESC;