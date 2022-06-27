CREATE TABLE `task_tag` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'taskTagId',
  `tag_id` int unsigned NOT NULL COMMENT 'tag表Id',
  `task_id` int unsigned NOT NULL COMMENT 'task表Id',
  `create_time` bigint NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` bigint NOT NULL DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;