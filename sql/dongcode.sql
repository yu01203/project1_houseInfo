-- dongcode
CREATE TABLE `dongcode` (
	`num`        INT primary key auto_increment, -- 번호
	`sido_code`  VARCHAR(10) NOT NULL, -- 시도코드
	`sido_name`  VARCHAR(10) NOT NULL, -- 시도명
	`gugun_code` VARCHAR(10) NOT NULL, -- 구군코드
	`gugun_name` VARCHAR(10) NOT NULL, -- 구군명
	`dong_code`  VARCHAR(10) NOT NULL, -- 법정동코드
	`dong_name`  VARCHAR(10) NOT NULL, -- 법정동명
	`lat`        VARCHAR(50) NULL,     -- 위도
	`lng`        VARCHAR(50) NULL      -- 경도
);