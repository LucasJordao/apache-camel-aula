SELECT b.*
FROM book b
INNER JOIN category c ON c.id = b.category_id
WHERE c.name = :categoryName
LIMIT 1;