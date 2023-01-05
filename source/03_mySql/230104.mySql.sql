-- DCL(계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL(제약조건, 시퀀스없음)
-- DML(outer join, and;&&, or;||, 일부단일행함수)
-- Java에서 쓸 데이터 넣고 연습해보기

show databases; -- database들의 리스트
-- (1) DCL
create user user01 identified by 'password';
grant all on *.* to user01; -- 권한 부여
grant all privileges on *.* to user01; -- 데이터베이스에 관한 모든 권한
flush privileges; -- 권한 부여
revoke all privileges on *.* from user01; -- 권한 박탈
drop user user01; -- 계정 삭제