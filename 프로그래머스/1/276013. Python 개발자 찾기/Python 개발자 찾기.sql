-- 코드를 작성해주세요
SELECT
    id,
    email,
    first_name,
    last_name
FROM
    developer_infos
WHERE
    SKILL_1 = 'Python' or SKILL_2 = 'Python' or SKILL_3 = 'Python'
ORDER BY
    ID asc