create schema diary;

#맴버
CREATE TABLE `members` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `email` varchar(200) NOT NULL COMMENT '이메일',
    `password` varchar(200) NOT NULL COMMENT '비밀번호',
    `name` varchar(100) NOT NULL COMMENT '이름',
    `permission_group_id` bigint(20) NOT NULL COMMENT '퍼미션 그룹',
    `updated_at` datetime NOT NULL COMMENT '갱신일',
    `created_at` datetime NOT NULL COMMENT '생성일',
    PRIMARY KEY (`id`),
    KEY `email_IDX` (`email`),
    KEY `name_IDX` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='스페이스에 설정된 플랜 테이블';