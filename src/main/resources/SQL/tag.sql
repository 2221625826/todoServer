CREATE TABLE `tag` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'tagId',
  `user_id` int unsigned NOT NULL COMMENT 'userId',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `create_time` bigint NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` bigint NOT NULL DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
