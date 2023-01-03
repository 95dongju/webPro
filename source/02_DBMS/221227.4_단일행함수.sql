-- [IV] �������Լ�
-- �Լ� = �������Լ�, �׷��Լ�(�����Լ�)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD HH') FROM EMP; -- ������ ������ ����
SELECT ENAME, INITCAP(ENAME) FROM EMP; -- �������Լ� (INPUT 1�� > OUTPUT 1��)
SELECT SUM(SAL), AVG(SAL) FROM EMP; -- �׷��Լ� (INPUT 14�� > OUTPUT 1��)
    -- �׷��Լ��� �� ���� �л�, ǥ�������� ���� ���� ��
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO; -- �׷��Լ� (INPUT N�� > OUTPUT 1��)

-- ��1. ������ �Լ��� ����: ���ڰ����Լ�, ���ڰ����Լ�, ��¥�����Լ�, ����ȯ�Լ�, NVL(), ETC...
-- 1. ���ڰ����Լ�
-- DUAL ���̺�: ����Ŭ���� ������ 1�� 1��¥�� DUMMY TABLE
SELECT ABS(-1) FROM DUAL;
SELECT * FROM TAB;
SELECT ABS(-1) FROM DUMMY; -- ���밪
SELECT FLOOR(34.5678) FROM DUAL; -- �Ҽ������� ����
SELECT FLOOR(34.5678*10)/100 FROM DUAL; -- �Ҽ��� �ι�°���� ����(����)
SELECT TRUNC(34.5678, 2) FROM DUAL; --�Ҽ��� N��° �ڸ����� ����
SELECT TRUNC(34.5678) FROM DUAL; -- �Ű����� 1���� ���� �Ҽ������� �˾Ƽ� ����
SELECT TRUNC(34.5678, 1) FROM DUAL; -- �ι�° �Ű��������� ������ �Ҽ������� ���� (���� �ڸ�)

-- ex. EMP ���̺��� �̸�, �޿�(���� �ڸ����� ����)
SELECT ENAME, SAL, TRUNC(SAL, -2) FROM EMP;  -- ���� �ڸ�

SELECT CEIL(34.5678) FROM DUAL; -- �Ҽ������� �ø�

SELECT ROUND(34.5678) FROM DUAL; -- �Ҽ������� �ݿø�
SELECT ROUND(34.5678*10)/10 FROM DUAL; -- ���� �ڸ����� �ݿø�
SELECT ROUND(34.5678,2) FROM DUAL; -- �Ҽ��� �ι�° �ڸ����� �ݿø�

SELECT MOD(9,2) FROM DUAL; -- ������ ������

--ex. Ȧ���⵵�� �Ի��� ����� ��� ������ ���
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'RR'),2)=1;

-- 2. ���ڰ����Լ�
-- (1) ��ҹ��� ����
SELECT INITCAP('WELCOME TO ORACLE') FROM DUAL; -- ù ���ڸ� �빮�ڷ�
SELECT INITCAP('welcome to oracle') FROM DUAL;
SELECT UPPER('ABCabc') FROM DUAL; -- �� �빮�ڷ�
SELECT LOWER('ABCabc') FROM DUAL; -- �� �ҹ��ڷ�

--ex. �̸��� Scott�� ������ ��� �ʵ�
SELECT * FROM EMP WHERE UPPER(ENAME)='SCOTT';
SELECT * FROM EMP WHERE INITCAP(ENAME)='Scott';
--ex. job�� MANAGER�� ������ ��� �ʵ�
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager';
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';

-- (2) ���ڿ���(CONCAT�Լ�, || ������)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT(CONCAT ('AB','CD'), CONCAT('EF','GH')) FROM DUAL;
-- ex. SMITH�� manager��
SELECT CONCAT(CONCAT(ENAME,'�� '), CONCAT(JOB,'��')) FROM EMP;

SELECT ENAME || '�� ' || JOB || '��' FROM EMP;