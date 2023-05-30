package io.github.changebooks.database.sample;

import io.github.changebooks.code.base.Check;
import io.github.changebooks.code.base.JsonParser;
import io.github.changebooks.code.util.BooleanCast;
import io.github.changebooks.code.util.TypeCast;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局配置
 *
 * @author changebooks@qq.com
 */
public final class Setting implements Serializable {
    /**
     * 配置id
     */
    public static final int DENY_REG = 1101;
    public static final int LOG_LEVEL = 1102;

    /**
     * 关闭注册，0-开放、1-关闭
     */
    private Integer denyReg;

    /**
     * 日志级别
     */
    private String logLevel;

    /**
     * Map to Setting
     *
     * @param pairs [ settingId, settingValue ]
     * @return Setting
     */
    public static Setting fromMap(Map<Integer, String> pairs) {
        if (Check.isNull(pairs)) {
            return null;
        }

        String denyReg = pairs.get(Setting.DENY_REG);
        String logLevel = pairs.get(Setting.LOG_LEVEL);

        Setting record = new Setting();

        record.setDenyReg(TypeCast.toInt(denyReg, BooleanCast.FALSE));
        record.setLogLevel(logLevel);

        return record;
    }

    /**
     * Setting to Map
     *
     * @param record Setting
     * @return [ settingId, settingValue ]
     */
    public static Map<Integer, String> toMap(Setting record) {
        if (Check.isNull(record)) {
            return null;
        }

        Integer denyReg = record.getDenyReg();
        String logLevel = record.getLogLevel();

        Map<Integer, String> attributeMap = new HashMap<>(8);

        attributeMap.put(Setting.DENY_REG, String.valueOf(denyReg));
        attributeMap.put(Setting.LOG_LEVEL, logLevel);

        return attributeMap;
    }

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    public Integer getDenyReg() {
        return denyReg;
    }

    public void setDenyReg(Integer denyReg) {
        this.denyReg = denyReg;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

}
