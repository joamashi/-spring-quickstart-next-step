-- CMD 또는 SQL Developer에서 실행
-- sqlplus system/oracle1234@localhost:1521/XE

-- users 테이블 생성
CREATE TABLE users (
    user_id        NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username       VARCHAR2(100) NOT NULL,
    email          VARCHAR2(200) UNIQUE NOT NULL,
    password       VARCHAR2(100) NOT NULL,
    role           VARCHAR2(50) DEFAULT 'USER',
    profile_image  VARCHAR2(500),          -- 프로필 이미지 경로
    refresh_token  VARCHAR2(500),          -- JWT 리프레시 토큰 저장용
    created_at     DATE DEFAULT SYSDATE,
    updated_at     DATE,
    deleted_yn     CHAR(1) DEFAULT 'N'
);

-- 실행 결과 확인
-- SELECT * FROM users;