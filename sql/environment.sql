-- environment
CREATE TABLE `environment` (
	`no`          INT primary key auto_increment, -- 번호
	`name`        VARCHAR(20) NOT NULL, -- 업체명
	`env_code`    VARCHAR(5)  NOT NULL, -- 업종코드
	`env_name`    VARCHAR(10) NOT NULL, -- 업종명
	`ins`    VARCHAR(20) NULL,     -- 점검기관명
	`address` VARCHAR(50) NOT NULL  -- 소재지주소
);