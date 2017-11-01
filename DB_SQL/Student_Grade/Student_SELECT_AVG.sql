SELECT *
FROM student T1, grade T2
WHERE T1.S_Id = T2.S_Id

-- 從你設計的資料表，若要得知一個班級的各科目平均，並由大排到小，該如何查詢？
SELECT T1.S_Class, AVG(T2.G_Math) AVG_Math, AVG(T2.G_Geography) AVG_Geography, AVG(T2.G_English) AVG_English, AVG(T2.G_Science) AVG_Science, AVG(T2.G_PE) AVG_PE,
		 AVG(T2.G_Math+T2.G_Geography+T2.G_English+T2.G_Science+T2.G_PE)/5 AVG_TOTAL
FROM student T1, grade T2
WHERE T1.S_Id = T2.S_Id
GROUP BY T1.S_Class
ORDER BY AVG_TOTAL
DESC

-- 又如果你想知道每位同學各個科目的成績與出席次數該如何查詢？
SELECT T1.S_Name, T2.G_Math, T2.G_Geography, T2.G_English, T2.G_Science, T2.G_PE
FROM student T1, grade T2
WHERE T1.S_Id = T2.S_Id