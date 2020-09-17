CREATE TABLE `notice` (
  `notice_no` int NOT NULL AUTO_INCREMENT,
  `notice_id` varchar(20) DEFAULT NULL,
  `notice_title` varchar(100) DEFAULT NULL,
  `notice_content` varchar(2000) DEFAULT NULL,
  `notice_regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`notice_no`)
);         
         
insert into notice(notice_id, notice_title, notice_content) 
   values('admin', '공지사항1', '으헤으헤'),
         ('admin', '공지사항2', 's으아으아'),
         ('admin', '공지사항3', 's으아으아'),
         ('admin', '공지사항2', 's으아으아4'),
         ('admin', '공지사항2', 's으아으아5'),
         ('admin', '공지사항2', 's으아으아6'),
         ('admin', '공지사항2', 's으아으아8'),
		 ('admin', '공지사항2', 's으아으idod아4'),
         ('admin', '공지사항2', 's으아으아5'),
         ('admin', '공지사항2', 's으아으아6'),
         ('admin', '공지사항2', 's으아으아8');

commit;