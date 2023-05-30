package io.github.changebooks.database.sample;

import io.github.changebooks.code.base.Check;
import io.github.changebooks.database.attribute.AttributeDatabase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author changebooks@qq.com
 */
@RequestMapping("attribute")
@RestController
public class AttributeController {
    /**
     * 表名
     */
    private static final String TABLE_NAME = "demo_attribute";

    @Resource
    private AttributeDatabase attributeDatabase;

    @GetMapping(value = "/get")
    public DemoAttribute get() {
        Map<Integer, String> attributeMap = attributeDatabase.getPairs(TABLE_NAME, 1L);
        return DemoAttribute.fromMap(attributeMap);
    }

    @GetMapping(value = "/set")
    public int set() {
        DemoAttribute record = new DemoAttribute();
        record.setPhone("13000000001");
        record.setCountryCode(86);

        Map<Integer, String> attributeMap = DemoAttribute.toMap(record);
        if (Check.isEmpty(attributeMap)) {
            return 0;
        } else {
            return attributeDatabase.batchSave(TABLE_NAME, 1L, attributeMap);
        }
    }

}
