package org.yzh.senddto;

import org.yzh.config.StatusConfig;

import java.util.Date;

/**
 * @author hydra noah
 * 注册实体类
 */
public class RegisterDto {

    private String simNo;

    /**
     * 当前时间
     */
    private Date now = new Date();

    /**
     * 0 上线
     * 1 下线
     */
    private Integer status;

    public static RegisterDto createRegisterDto(String simNo, Integer statuss) {
        RegisterDto r = new RegisterDto();
        r.setSimNo(simNo);
        r.status = statuss;
        return r;
    }


    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
