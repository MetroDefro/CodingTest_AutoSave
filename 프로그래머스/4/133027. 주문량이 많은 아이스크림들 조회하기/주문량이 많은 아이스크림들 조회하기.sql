-- 코드를 입력하세요
SELECT b.FLAVOR
FROM FIRST_HALF a RIGHT JOIN JULY b ON a.SHIPMENT_ID = b.SHIPMENT_ID
GROUP BY b.FLAVOR
ORDER BY a.TOTAL_ORDER + SUM(b.TOTAL_ORDER) DESC
LIMIT 3