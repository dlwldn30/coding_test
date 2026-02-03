-- 코드를 입력하세요
SELECT id, name, host_id
FROM places
WHERE 
    host_id in (
        select host_id
        from places
        Group by host_id
        having count(*) >= 2
    )
ORDER BY id