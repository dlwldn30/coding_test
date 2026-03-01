select name, datetime
from animal_ins
Where animal_id not in (select animal_id from animal_outs)
order by datetime asc
limit 3