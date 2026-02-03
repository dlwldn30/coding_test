-- 코드를 입력하세요
SELECT
    CONCAT('/home/grep/src/',f.BOARD_ID,'/',f.FILE_ID,f.FILE_NAME,f.FILE_EXT) AS FILE_PATH
FROM
    used_goods_board b
LEFT JOIN 
    used_goods_file f
    on b.board_id = f.board_id
WHERE
    views = (select max(views) from used_goods_board g)

