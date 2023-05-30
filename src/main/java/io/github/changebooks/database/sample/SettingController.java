package io.github.changebooks.database.sample;

import io.github.changebooks.code.base.Check;
import io.github.changebooks.code.util.BooleanCast;
import io.github.changebooks.code.util.TypeCast;
import io.github.changebooks.database.setting.SettingDatabase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author changebooks@qq.com
 */
@RequestMapping("setting")
@RestController
public class SettingController {

    @Resource
    private SettingDatabase settingDatabase;

    @GetMapping(value = "/all")
    public Setting all() {
        Map<Integer, String> pairs = settingDatabase.getPairs();
        if (Check.isNull(pairs)) {
            return null;
        } else {
            return Setting.fromMap(pairs);
        }
    }

    @GetMapping(value = "/reg-sw")
    public Boolean regSw() {
        String value = settingDatabase.getValue(Setting.DENY_REG);
        if (Check.isNull(value)) {
            return null;
        }

        int result = TypeCast.toInt(value, BooleanCast.FALSE);
        return BooleanCast.fromInt(result);
    }

    @GetMapping(value = "/deny-reg")
    public boolean denyReg() {
        return settingDatabase.setValue(Setting.DENY_REG, String.valueOf(BooleanCast.TRUE));
    }

    @GetMapping(value = "/allow-reg")
    public boolean allowReg() {
        return settingDatabase.setValue(Setting.DENY_REG, String.valueOf(BooleanCast.FALSE));
    }

}
