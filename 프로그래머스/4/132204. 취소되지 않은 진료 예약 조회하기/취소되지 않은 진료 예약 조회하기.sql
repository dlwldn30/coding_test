-- 코드를 입력하세요
SELECT a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd
from appointment a
join doctor d on d.dr_id = a.mddr_id
join patient p on p.pt_no = a.pt_no
where Date(a.apnt_ymd) = ('2022-04-13') and a.mcdp_cd = 'cs' and a.apnt_cncl_yn = 'N'
order by a.apnt_ymd