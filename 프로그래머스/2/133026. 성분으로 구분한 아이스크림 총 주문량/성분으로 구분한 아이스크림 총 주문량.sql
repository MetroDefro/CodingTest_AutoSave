-- 코드를 입력하세요
SELECT b.INGREDIENT_TYPE, SUM(a.TOTAL_ORDER) AS "TOTAL_ORDER"
FROM FIRST_HALF a JOIN ICECREAM_INFO b ON a.FLAVOR = b.FLAVOR
GROUP BY 1
ORDER BY 2