package io.github.changebooks.database.sample;

import io.github.changebooks.code.jdbc.JdbcDriver;
import io.github.changebooks.code.jdbc.JdbcExecutor;
import io.github.changebooks.code.jdbc.Sharding;
import io.github.changebooks.code.jdbc.ShardingNum;
import io.github.changebooks.database.autoconfigure.DsnProperties;
import io.github.changebooks.database.autoconfigure.ShardingNumProperties;
import io.github.changebooks.database.autoconfigure.ShardingProperties;
import io.github.changebooks.database.support.JdbcSupport;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author changebooks@qq.com
 */
@Configuration
@EnableConfigurationProperties({DsnProperties.class, ShardingNumProperties.class, ShardingProperties.class})
public class JdbcSupportImpl extends JdbcSupport {

    @Bean
    @Override
    public JdbcExecutor jdbcExecutor(JdbcDriver jdbcDriver) {
        return super.jdbcExecutor(jdbcDriver);
    }

    @Bean
    @Override
    public JdbcDriver jdbcDriver(DsnProperties dsnProperties) {
        return super.jdbcDriver(dsnProperties);
    }

    @Bean
    @Override
    public ShardingNum shardingNum(ShardingNumProperties shardingNumProperties) {
        return super.shardingNum(shardingNumProperties);
    }

    @Bean
    @Override
    public Sharding sharding(ShardingProperties shardingProperties) {
        return super.sharding(shardingProperties);
    }

}
