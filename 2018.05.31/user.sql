
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` char(20) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `score` int(11) NOT NULL DEFAULT '0' COMMENT '分数',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('tempUser1', '4'), ('tempUser2', '23'), ('tempUser3', '47'), ('tempUser4', '89'), ('tempUser5', '128');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
