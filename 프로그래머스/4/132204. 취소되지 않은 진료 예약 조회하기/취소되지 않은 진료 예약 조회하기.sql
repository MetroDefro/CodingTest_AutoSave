-- 코드를 입력하세요
SELECT b.APNT_NO, a.PT_NAME, a.PT_NO, b.MCDP_CD, c.DR_NAME, b.APNT_YMD
FROM PATIENT a
    JOIN APPOINTMENT b ON a.PT_NO = b.PT_NO
    JOIN DOCTOR c ON c.DR_ID = b.MDDR_ID
WHERE b.MCDP_CD = "CS" AND b.APNT_YMD LIKE "2022-04-13%" AND b.APNT_CNCL_YN = "N"
ORDER BY 6