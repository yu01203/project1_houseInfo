CREATE TABLE `policy_board` (
	`policy_no`       INT auto_increment, -- policy_no
	`policy_title`    VARCHAR(300)  NOT NULL, -- policy_title
	`policy_content`  VARCHAR(10000) NOT NULL, -- policy_content
	`policy_userid`   VARCHAR(50)   NOT NULL, -- policy_userid
	`policy_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,  -- policy_datetime
    PRIMARY KEY (`policy_no`)
);

   insert into policy_board(policy_title, policy_content, policy_userid) 
   values('청년지원정책', '내용을 많이 많이', 'admin');

commit;