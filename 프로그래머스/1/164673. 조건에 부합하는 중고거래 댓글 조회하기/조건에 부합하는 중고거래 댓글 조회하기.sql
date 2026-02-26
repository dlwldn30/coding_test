SELECT title, ugb.board_id, ugr.reply_id, ugr.writer_id, ugr.contents, DATE_FORMAT(ugr.created_date, '%Y-%m-%d') created_date
FROM used_goods_board ugb
JOIN used_goods_reply ugr
    on ugb.board_id = ugr.board_id
WHERE ugb.created_date like "2022-10%"
ORDER BY ugr.created_date asc, ugb.title asc;
    