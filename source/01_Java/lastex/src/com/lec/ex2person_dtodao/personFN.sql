-- ���α׷� �䱸���׿� �ʿ��� DML

-- 1�� ������ ������ �Է�
INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, '���켺', (SELECT jNO FROM JOB WHERE jNAME='���'), 90, 80, 81);

SELECT JNAME FROM JOB;

-- 2�� ������ ���ϴ� ������ �Է� �޾� ������ ��ȸ�� ������ �߰��Ͽ� ������ ���� ������ �̸�(��ȣ) ���
SELECT ROWNUM RN, A.* 
        FROM (SELECT  pNAME || '(' || pNO || '��)' "pNAME", jNAME, KOR, ENG, MAT, KOR+ENG+MAT "TOT" 
            FROM PERSON P, JOB J
            WHERE P.jNO=J.jNO AND jNAME='���' ORDER BY TOT DESC) A
        WHERE jNAME = '���';


-- 3�� ������ ��� ���� ���, �̸�, ������, ����, ����, ����, ����
SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT pNAME || '(' || pNO || '��)' "pNAME", jNAME, KOR, ENG, MAT, KOR+ENG+MAT "TOT" 
            FROM PERSON P, JOB J
            WHERE P.jNO=J.jNO ORDER BY TOT DESC) A);