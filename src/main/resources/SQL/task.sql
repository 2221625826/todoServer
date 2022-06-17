CREATE TABLE `task` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `priority` tinyint DEFAULT '0' COMMENT '优先级，0-A，1-B，2-C，3-D...',
  `title` varchar(200) DEFAULT NULL COMMENT '标题，用于展示',
  `desc` varchar(1000) DEFAULT NULL COMMENT '详细描述',
  `topicId` int DEFAULT NULL COMMENT '主题表Id，唯一',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '状态，0-待办，1-进行中，2-已完成，3-已废弃',
  `create_time` bigint NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` bigint NOT NULL DEFAULT '0' COMMENT '修改时间',
  `complete_time` bigint DEFAULT '0' COMMENT '完成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
