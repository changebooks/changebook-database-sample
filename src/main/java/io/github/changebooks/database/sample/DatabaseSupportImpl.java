package io.github.changebooks.database.sample;

import io.github.changebooks.database.attribute.AttributeDatabase;
import io.github.changebooks.database.attribute.AttributeMapper;
import io.github.changebooks.database.attribute.EnableDatabaseAttribute;
import io.github.changebooks.database.setting.EnableDatabaseSetting;
import io.github.changebooks.database.setting.SettingDatabase;
import io.github.changebooks.database.setting.SettingMapper;
import io.github.changebooks.database.support.DatabaseSupport;
import io.github.changebooks.database.sw.EnableDatabaseSwitch;
import io.github.changebooks.database.sw.SwitchDatabase;
import io.github.changebooks.database.sw.SwitchMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author changebooks@qq.com
 */
@Configuration
@EnableDatabaseAttribute
@EnableDatabaseSwitch
@EnableDatabaseSetting
public class DatabaseSupportImpl extends DatabaseSupport {

    @Bean
    @Override
    public AttributeDatabase attributeDatabase(AttributeMapper attributeMapper) {
        return super.attributeDatabase(attributeMapper);
    }

    @Bean
    @Override
    public SwitchDatabase switchDatabase(SwitchMapper switchMapper) {
        return super.switchDatabase(switchMapper);
    }

    @Bean
    @Override
    public SettingDatabase settingDatabase(SettingMapper settingMapper) {
        return super.settingDatabase(settingMapper);
    }

}
