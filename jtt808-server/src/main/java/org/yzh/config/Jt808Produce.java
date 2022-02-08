package org.yzh.config;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;

/**
 * @author guope
 * @description:
 * @date 2022-02-01 00:07
 */

@Component
public class Jt808Produce {

    private static final Logger log = LoggerFactory.getLogger(Jt808Produce.class.getSimpleName());

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    /**
     * 车辆行程各个站点用时计算
     */
    public void sendTripByCarUseTimeInfo(List<?> arr, Long vehicleId, String tripNo, Integer status){

        String topic="vms_trip_use_time_info";
        String key="{\"vehicleId\":"+ vehicleId +",\"timestamp\":"+System.currentTimeMillis()+" }";
        this.send(topic,key, JSON.toJSONString(arr));
    }




    /**
     * 发布消息
     * @param topic
     * @param key
     * @param value
     */
    private void send(String topic,String key,String value){
        kafkaTemplate.send(topic,key, value).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("sent message=[{}] failed!", topic+":"+key+":"+value, throwable);
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("sent message=[{}] successful!", topic+":"+key+":"+value);
            }
        });
    }
}
