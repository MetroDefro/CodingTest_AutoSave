-- 코드를 입력하세요
SELECT DATE_FORMAT(DATETIME, '%H') AS "HOUR", COUNT(*) AS "COUNT"
FROM ANIMAL_OUTS
WHERE DATE_FORMAT(DATETIME, '%H') >= 9 AND DATE_FORMAT(DATETIME, '%H') <= 19
GROUP BY 1
ORDER BY 1