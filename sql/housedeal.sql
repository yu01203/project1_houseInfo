-- housedeal
CREATE TABLE `housedeal` (
	`no`          INT primary key auto_increment, -- 번호
	`name`        VARCHAR(50) NOT NULL, -- 주택이름
	`type`        VARCHAR(30) NOT NULL, -- 거래유형
	`deal_amount` VARCHAR(30) NOT NULL, -- 거래금액
	`rent`        VARCHAR(30) NULL,     -- 월세
	`build_year`  VARCHAR(30) NULL,     -- 건축년도
	`gugun_code`  VARCHAR(30) NOT NULL, -- 구군코드
	`dong_name`   VARCHAR(30) NOT NULL, -- 법정동명
	`deal_year`   VARCHAR(30) NULL,     -- 거래년
	`deal_month`  VARCHAR(30) NULL,     -- 거래월
	`deal_day`    VARCHAR(30) NULL,     -- 거래일
	`area`        VARCHAR(30) NULL,     -- 면적
	`floor`       VARCHAR(30) NULL,     -- 층
	`jibun`       VARCHAR(30) NULL      -- 지번
);