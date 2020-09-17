-- 질문게시판
CREATE TABLE `qna_board` (
	`qna_no`       INT auto_increment, -- qna_no
	`qna_title`    VARCHAR(300)  NOT NULL, -- qna_title
	`qna_content`  VARCHAR(4000) NOT NULL, -- qna_content
	`qna_userid`   VARCHAR(50)   NOT NULL, -- qna_userid
	`qna_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- qna_datetime
    PRIMARY KEY (`qna_no`)
);

-- 답글
CREATE TABLE `reply_board` (
	`reply_no`        INT auto_increment, -- replyno
	`reply_content`  VARCHAR(4000) NOT NULL, -- reply_contentㄴ
	`reply_userid`   VARCHAR(50)   NOT NULL, -- reply_userid
	`reply_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, -- reply_datetime
	`qna_no`         INT           NOT NULL,  -- qna_no
    PRIMARY KEY (`reply_no`),
    CONSTRAINT `reply_to_qna_fk1` FOREIGN KEY (`qna_no`) REFERENCES `qna_board` (`qna_no`)
);

   insert into qna_board(qna_title, qna_content, qna_userid) 
   values('관통 테스트1', '뷰로 만드는 질문게시판1', 'ssafy'),
         ('관통 테스트2', '뷰로 만드는 질문게시판2', 'admin'),
         ('관통 테스트3', '뷰로 만드는 질문게시판3', 'ssafy'),
         ('관통 테스트4', '뷰로 만드는 질문게시판4', 'ssafy'),
         ('관통 테스트5', '뷰로 만드는 질문게시판5', 'admin'),
         ('관통 테스트6', '뷰로 만드는 질문게시판6', 'ssafy'),
         ('관통 테스트7', '뷰로 만드는 질문게시판7', 'admin'),
         ('관통 테스트8', '뷰로 만드는 질문게시판8', 'ssafy');
         
         
	insert into reply_board(reply_content, reply_userid, qna_no) 
   values ('상단 네이게이션 바에 "관련정책" 항목이 있습니다. 그곳에서 정보를 얻으실 수 있을 것 같아요 참고사이트를 봐주세요', ' admin', 13);

commit;