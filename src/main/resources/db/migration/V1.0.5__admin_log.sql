CREATE TABLE `admin_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `admin_name` varchar(255) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `detail` varchar(2000),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

