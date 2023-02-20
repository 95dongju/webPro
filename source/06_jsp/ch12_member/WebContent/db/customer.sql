DROP TABLE CUSTOMER;

CREATE TABLE CUSTOMER(
    cID VARCHAR2(50) PRIMARY KEY,
    cPW VARCHAR2(50) NOT NULL,
    cNAME VARCHAR2(50) NOT NULL,
    cTEL VARCHAR2(50),
    cEMAIL VARCHAR2(50),
    cADDRESS VARCHAR2(250),
    cGENDER VARCHAR2(1) CHECK(cGENDER='m' OR cGENDER='f'),
    cBIRTH DATE,
    cRDATE DATE DEFAULT SYSDATE NOT NULL
);

-- 1. 회원가입시 ID 중복 체크 : public int confirmId(String cid)
SELECT COUNT(*) "cnt" FROM CUSTOMER WHERE CID='aaa';

-- 2. 회원가입 : public int joinCustomer(CustomerDto dto)
INSERT INTO CUSTOMER(CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH)
    VALUES ('aaa', '111', '홍', '010-3000-2000', 'h@h.com', '서울', 'm', TO_DATE('1994-12-12','YYYY-MM-DD'));

-- 3. 로그인 : public int loginCheck(String cid, String cpw)
SELECT CID, CPW FROM CUSTOMER WHERE CID='aaa' AND CPW='111';

-- 4. cid로 DTO 가져오기 : public CustomerDto getCustomer(String cid)
SELECT * FROM CUSTOMER;

-- 5. 정보 수정 : public int modifyCustomer(CustomerDto dto)
UPDATE CUSTOMER SET CPW = '111', CNAME = '홍길동', CTEL = '010-2222-1111', CEMAIL = 'hong@hong.com', CADDRESS = '봉천', CGENDER = 'm', CBIRTH = TO_DATE('1999-02-12', 'YYYY-MM-DD') WHERE CID = 'aaa';
COMMIT;