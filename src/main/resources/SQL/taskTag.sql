CREATE TABLE `task_tag` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `tagId` int unsigned NOT NULL COMMENT 'tag表Id',
  `taskId` int unsigned NOT NULL COMMENT 'task表Id',
  PRIMARY KEY (`taskId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;