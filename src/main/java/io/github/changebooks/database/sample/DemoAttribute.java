package io.github.changebooks.database.sample;

import io.github.changebooks.code.base.Check;
import io.github.changebooks.code.base.JsonParser;
import io.github.changebooks.code.util.TypeCast;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 扩展表
 *
 * @author changebooks@qq.com
 */
public final class DemoAttribute implements Serializable {
    /**
     * 属性id
     */
    public static final int PHONE = 1101;
    public static final int COUNTRY_CODE = 1102;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 国家码
     */
    private int countryCode;

    /**
     * Map to DemoAttribute
     *
     * @param attributeMap [ attributeId, attributeValue ]
     * @return DemoAttribute
     */
    public static DemoAttribute fromMap(Map<Integer, String> attributeMap) {
        if (Check.isNull(attributeMap)) {
            return null;
        }

        String phone = attributeMap.get(DemoAttribute.PHONE);
        String countryCode = attributeMap.get(DemoAttribute.COUNTRY_CODE);

        DemoAttribute record = new DemoAttribute();

        record.setPhone(phone);
        record.setCountryCode(TypeCast.toInt(countryCode, 0));

        return record;
    }

    /**
     * DemoAttribute to Map
     *
     * @param record DemoAttribute
     * @return [ attributeId, attributeValue ]
     */
    public static Map<Integer, String> toMap(DemoAttribute record) {
        if (Check.isNull(record)) {
            return null;
        }

        String phone = record.getPhone();
        int countryCode = record.getCountryCode();

        Map<Integer, String> attributeMap = new HashMap<>(8);

        attributeMap.put(DemoAttribute.PHONE, phone);
        attributeMap.put(DemoAttribute.COUNTRY_CODE, String.valueOf(countryCode));

        return attributeMap;
    }

    @Override
    public String toString() {
        return JsonParser.toJson(this);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

}
