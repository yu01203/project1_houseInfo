 CREATE TABLE `members` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `pw` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(2000) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `joindate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  
  PRIMARY KEY (`id`)
);
   
insert into members(id, name, pw, email, address, phone) 
values('ssafy', 'ssafy', 'ssafy', 'ssafy@a.com', 'korea', 01000000001),
      ('admin', 'admin', 'admin', 'admin@a.com', 'korea', 01000000002);   

commit;