USE db_users;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`)
);
 
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
);
 
CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `user_fk_idx` (`user_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');


INSERT INTO `users` (`username`, `password`, `email`) VALUES ('alex', 'alex', 'alex@m.com');
INSERT INTO `users` (`username`, `password`, `email`) VALUES ('admin', 'admin', 'admin@m.com');
INSERT INTO `users` (`username`, `password`, `email`) VALUES ('superadmin', 'superadmin', 'supadmin@m.com');



INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1); -- user alex has role USER
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 2); -- user admin has role ADMIN
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3, 1); -- user admin has role USER
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3, 2); -- user admin has role ADMIN








































