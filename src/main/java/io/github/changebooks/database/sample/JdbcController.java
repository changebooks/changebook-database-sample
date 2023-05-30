package io.github.changebooks.database.sample;

import io.github.changebooks.code.jdbc.JdbcDriver;
import io.github.changebooks.code.jdbc.JdbcExecutor;
import io.github.changebooks.code.jdbc.Sharding;
import io.github.changebooks.code.jdbc.ShardingNum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author changebooks@qq.com
 */
@RequestMapping("jdbc")
@RestController
public class JdbcController {

    @Resource
    private JdbcExecutor jdbcExecutor;

    @Resource
    private JdbcDriver jdbcDriver;

    @Resource
    private ShardingNum shardingNum;

    @Resource
    private Sharding sharding;

    @GetMapping(value = "/update")
    public int update() {
        String command = "INSERT INTO demo (phone) VALUES (?)";
        return jdbcExecutor.executeUpdate(command, stat -> stat.setString(1, "13000000001"));
    }

    @GetMapping(value = "/query")
    public String query() {
        String command = "SELECT phone FROM demo WHERE id = ?";
        return jdbcExecutor.executeQuery(
                command,
                stat -> stat.setLong(1, 1),
                rs -> {
                    if (rs.next()) {
                        return rs.getString(1);
                    } else {
                        return null;
                    }
                }
        );
    }

    @GetMapping(value = "/driver")
    public String driver() {
        return "url: " + jdbcDriver.getUrl() + ", username: " + jdbcDriver.getUsername() + ", password: " + jdbcDriver.getPassword();
    }

    @GetMapping(value = "/sharding-num")
    public String shardingNum() {
        return "tableSize: " + shardingNum.getTableSize();
    }

    @GetMapping(value = "/sharding")
    public String sharding() {
        return "dbSize: " + sharding.getDbSize() + ", tableSize: " + sharding.getTableSize();
    }

}
