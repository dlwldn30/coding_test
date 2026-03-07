select he.emp_no, he.emp_name, 
    case
        when avg(hg.score) >= 96 then 'S'
        when avg(hg.score) >= 90 then 'A'
        when avg(hg.score) >= 80 then 'B'
        else 'C'
    end as grade,
    case
        when avg(hg.score) >= 96 then he.sal * 0.2
        when avg(hg.score) >= 90 then he.sal * 0.15
        when avg(hg.score) >= 80 then he.sal * 0.1
        else 0
    end as bonus
from hr_employees he
join hr_department hd on he.dept_id = hd.dept_id
join hr_grade hg on he.emp_no = hg.emp_no
GROUP BY he.emp_no, he.emp_name, he.sal
ORDER BY he.emp_no;
