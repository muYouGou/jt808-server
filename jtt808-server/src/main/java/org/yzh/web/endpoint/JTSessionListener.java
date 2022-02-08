package org.yzh.web.endpoint;

import io.github.yezhihao.netmc.session.Session;
import io.github.yezhihao.netmc.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端创建session后，需要将当前车辆设置为上线状态
 * @author Hydra noah
 */
public class JTSessionListener implements SessionListener {

    private static final Logger log = LoggerFactory.getLogger(JTSessionListener.class.getSimpleName());


    @Override
    public void sessionCreated(Session session) {
        log.error("sessionCreated:==>"+session);

    }

    @Override
    public void sessionRegistered(Session session) {
        log.error("sessionRegistered:==>"+session);
    }

    @Override
    public void sessionDestroyed(Session session) {

         log.error("sessionDestroyed:==>"+session);
    }
}