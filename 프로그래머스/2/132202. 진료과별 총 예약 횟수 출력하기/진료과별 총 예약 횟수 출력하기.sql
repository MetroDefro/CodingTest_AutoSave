-- 코드를 입력하세요
SELECT MCDP_CD AS "진료과 코드", COUNT(*) AS "5월예약건수"
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, '%c') = 5
GROUP BY 1
ORDER BY 2, 1