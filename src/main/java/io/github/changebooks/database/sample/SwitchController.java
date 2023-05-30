package io.github.changebooks.database.sample;

import io.github.changebooks.code.base.Check;
import io.github.changebooks.database.sw.SwitchDatabase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author changebooks@qq.com
 */
@RequestMapping("switch")
@RestController
public class SwitchController {
    /**
     * 表名
     */
    private static final String TABLE_NAME = "demo_switch";

    @Resource
    private SwitchDatabase switchDatabase;

    @GetMapping(value = "/list")
    public Map<String, Boolean> list() {
        Map<Integer, Boolean> idPairs = switchDatabase.getPairs(TABLE_NAME, 1L);
        if (Check.isEmpty(idPairs)) {
            return null;
        }

        Map<String, Boolean> result = new HashMap<>(idPairs.size());

        for (Map.Entry<Integer, Boolean> entry : idPairs.entrySet()) {
            if (Check.isNull(entry)) {
                continue;
            }

            Integer switchId = entry.getKey();
            Boolean switchValue = entry.getValue();
            if (Check.isNull(switchId) || Check.isNull(switchValue)) {
                continue;
            }

            DemoSwitch record = DemoSwitch.fromId(switchId);
            if (Check.isNull(record)) {
                continue;
            }

            result.put(record.name(), switchValue);
        }

        return result;
    }

    @GetMapping(value = "/birthday-sw")
    public Boolean birthdaySw() {
        return switchDatabase.getValue(TABLE_NAME, 1L, DemoSwitch.SHOW_BIRTHDAY.id);
    }

    @GetMapping(value = "/show-birthday")
    public boolean showBirthday() {
        return switchDatabase.setValue(TABLE_NAME, 1L, DemoSwitch.SHOW_BIRTHDAY.id, true);
    }

    @GetMapping(value = "/hide-birthday")
    public boolean hideBirthday() {
        return switchDatabase.setValue(TABLE_NAME, 1L, DemoSwitch.SHOW_BIRTHDAY.id, false);
    }

}
