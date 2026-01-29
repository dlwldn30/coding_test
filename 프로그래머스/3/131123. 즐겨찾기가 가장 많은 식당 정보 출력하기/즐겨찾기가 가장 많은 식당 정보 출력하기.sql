SELECT food_type, rest_id, rest_name, favorites
FROM rest_info 
WHERE 
    (food_type, favorites) in
    (select food_type, max(favorites) favorites FROM rest_info
     GROUP BY food_type
    ) 
ORDER BY
    food_type desc
