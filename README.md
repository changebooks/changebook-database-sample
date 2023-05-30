# changebook-database-sample
### Database Sample

### 测试表
```
CREATE TABLE demo
(
    id    int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    phone varchar(255)     NOT NULL DEFAULT '' COMMENT '手机号',
    PRIMARY KEY (id)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4 COMMENT = '测试表';
```

### jdbc
```
http://localhost:8080/jdbc/update
http://localhost:8080/jdbc/query
http://localhost:8080/jdbc/driver
http://localhost:8080/jdbc/sharding-num
http://localhost:8080/jdbc/sharding
```

### 扩展表
```
CREATE TABLE demo_attribute
(
    id              bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    base_id         bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主表id',
    attribute_id    int(11) unsigned    NOT NULL DEFAULT '0' COMMENT '属性id',
    attribute_value varchar(255)                 DEFAULT NULL COMMENT '值',
    version         int(11) unsigned    NOT NULL DEFAULT '1' COMMENT '版本',
    created_at      datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at      datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uk_base_id_attribute_id (base_id, attribute_id),
    KEY idx_attribute_id_attribute_value (attribute_id, attribute_value)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '扩展表';
```

### 扩展属性
```
http://localhost:8080/attribute/set
http://localhost:8080/attribute/get
```

### 开关表
```
CREATE TABLE demo_switch
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    base_id      bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '主表id',
    switch_id    int(11) unsigned    NOT NULL DEFAULT '0' COMMENT '开关id',
    switch_value int(11) unsigned    NOT NULL DEFAULT '0' COMMENT '值，0-关、1-开',
    created_at   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE KEY uk_base_id_switch_id (base_id, switch_id),
    KEY idx_switch_id_switch_value (switch_id, switch_value)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '开关表';
```

### 开关
```
http://localhost:8080/switch/show-birthday
http://localhost:8080/switch/hide-birthday
http://localhost:8080/switch/birthday-sw
http://localhost:8080/switch/list
```

### 配置表
```
CREATE TABLE setting
(
    setting_id    int(11) unsigned NOT NULL DEFAULT '0' COMMENT '配置id',
    setting_value varchar(255)              DEFAULT NULL COMMENT '值',
    created_at    datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at    datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (setting_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '配置表';
```

### 配置
```
http://localhost:8080/setting/deny-reg
http://localhost:8080/setting/allow-reg
http://localhost:8080/setting/reg-sw
http://localhost:8080/setting/all
```
