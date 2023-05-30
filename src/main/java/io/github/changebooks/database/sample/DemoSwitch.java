package io.github.changebooks.database.sample;

/**
 * 开关枚举
 *
 * @author changebooks@qq.com
 */
public enum DemoSwitch {
    /**
     * 公开性别
     */
    SHOW_GENDER(10001, "公开性别"),

    /**
     * 公开生日
     */
    SHOW_BIRTHDAY(10002, "公开生日"),

    ;

    /**
     * 开关id
     */
    public final int id;

    /**
     * 备注
     */
    public final String remark;

    DemoSwitch(int id, String remark) {
        this.id = id;
        this.remark = remark;
    }

    /**
     * 通过开关id，获取开关枚举
     *
     * @param id 开关id
     * @return 开关枚举
     */
    public static DemoSwitch fromId(int id) {
        for (DemoSwitch v : values()) {
            if (v != null && v.id == id) {
                return v;
            }
        }

        return null;
    }

}
