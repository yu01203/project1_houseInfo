-- shop
CREATE TABLE `shop` (
	`no`          INT primary key, -- 상가업소번호
	`name`        VARCHAR(50) NOT NULL, -- 상호명
	`main_code`   VARCHAR(30) NOT NULL, -- 대분류코드
	`main_name`   VARCHAR(30) NOT NULL, -- 대분류명
	`middle_code` VARCHAR(30) NOT NULL, -- 중분류코드
	`middle_name` VARCHAR(30) NOT NULL, -- 중분류명
	`sub_code`    VARCHAR(30) NOT NULL, -- 소분류코드
	`sub_name`    VARCHAR(30) NOT NULL, -- 소분류명
	`sido_code`   VARCHAR(10) NOT NULL, -- 시도코드
	`sido_name`   VARCHAR(10) NOT NULL, -- 시도명
	`gugun_code`  VARCHAR(10) NOT NULL, -- 시군구코드
	`gugun_name`  VARCHAR(10) NOT NULL, -- 시군구명
	`dong_code`   VARCHAR(10) NOT NULL, -- 법정동코드
	`dong_name`   VARCHAR(10) NOT NULL, -- 법정동명
	`jibun`       VARCHAR(50) NOT NULL, -- 지번주소
	`road`        VARCHAR(50) NULL,     -- 도로명주소
	`lng`         VARCHAR(50) NULL,     -- 경도
	`lat`         VARCHAR(50) NULL      -- 위도
);
