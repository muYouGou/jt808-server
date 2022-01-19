package org.yzh.web.service.impl;

import org.springframework.stereotype.Component;
import org.yzh.handle.BaseHandle;

/**
 * @author Hydra noah
 * 处理注册事情
 */
@Component
public class RegisterHandle implements BaseHandle {

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        System.out.println("应用被关闭了");
    }
}
