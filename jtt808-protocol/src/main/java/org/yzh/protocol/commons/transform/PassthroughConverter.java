package org.yzh.protocol.commons.transform;

import io.github.yezhihao.protostar.PrepareLoadStrategy;
import io.github.yezhihao.protostar.schema.ArraySchema;
import io.github.yezhihao.protostar.schema.MapSchema;
import io.github.yezhihao.protostar.schema.NumberSchema;
import org.yzh.protocol.commons.transform.passthrough.PeripheralStatus;
import org.yzh.protocol.commons.transform.passthrough.PeripheralSystem;

/**
 * 透传消息转换器
 * @author yezhihao
 * https://gitee.com/yezhihao/jt808-server
 */
public class PassthroughConverter extends MapSchema<Integer, Object> {

    public PassthroughConverter() {
        super(NumberSchema.BYTE_INT, 0);
    }

    @Override
    protected void addSchemas(PrepareLoadStrategy<Integer> schemaRegistry) {
        schemaRegistry
                .addSchema(0, ArraySchema.BYTES)
                .addSchema(PeripheralStatus.ID, PeripheralStatus.Schema.INSTANCE)
                .addSchema(PeripheralSystem.ID, PeripheralSystem.Schema.INSTANCE);
    }
}