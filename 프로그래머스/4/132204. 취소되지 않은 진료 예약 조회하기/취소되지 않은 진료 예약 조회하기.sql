-- 코드를 입력하세요
SELECT a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd
FROM appointment a
JOIN patient p on a.pt_no = p.pt_no
JOIN doctor d on a.mddr_id = d.dr_id
WHERE DATE(a.apnt_ymd) = '2022-04-13' 
    and a.apnt_cncl_yn = 'N'
    and a.mcdp_cd = 'cs'
ORDER BY
    a.apnt_ymd asc
