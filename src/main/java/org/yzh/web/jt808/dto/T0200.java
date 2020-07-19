package org.yzh.web.jt808.dto;

import org.yzh.framework.annotation.Property;
import org.yzh.framework.annotation.Type;
import org.yzh.framework.enums.DataType;
import org.yzh.framework.message.AbstractBody;
import org.yzh.web.jt808.common.MessageId;
import org.yzh.web.jt808.common.PositionAttributeUtils;
import org.yzh.web.jt808.dto.basics.BytesAttribute;
import org.yzh.web.jt808.dto.position.Attribute;

import java.util.List;
import java.util.Map;

@Type(MessageId.位置信息汇报)
public class T0200 extends AbstractBody {

    private Integer warningMark;
    private Integer status;
    private Integer latitude;
    private Integer longitude;
    private Integer altitude;
    private Integer speed;
    private Integer direction;
    private String dateTime;

    private List<BytesAttribute> bytesAttributes;

    private Map<Integer, Attribute> attributes;

    @Property(index = 0, type = DataType.DWORD, desc = "报警标志")
    public Integer getWarningMark() {
        return warningMark;
    }

    public void setWarningMark(Integer warningMark) {
        this.warningMark = warningMark;
    }

    @Property(index = 4, type = DataType.DWORD, desc = "状态")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Property(index = 8, type = DataType.DWORD, desc = "纬度")
    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    @Property(index = 12, type = DataType.DWORD, desc = "经度")
    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    @Property(index = 16, type = DataType.WORD, desc = "海拔")
    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    @Property(index = 18, type = DataType.WORD, desc = "速度")
    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @Property(index = 20, type = DataType.WORD, desc = "方向")
    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    @Property(index = 22, type = DataType.BCD8421, length = 6, desc = "时间")
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Property(index = 28, type = DataType.LIST, desc = "位置附加信息")
    public List<BytesAttribute> getBytesAttributes() {
        return bytesAttributes;
    }

    public void setBytesAttributes(List<BytesAttribute> bytesAttributes) {
        this.bytesAttributes = bytesAttributes;
        this.attributes = PositionAttributeUtils.transform(bytesAttributes);
    }

    public Map<Integer, Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<Integer, Attribute> attributes) {
        this.attributes = attributes;
        this.bytesAttributes = PositionAttributeUtils.transform(attributes);
    }
}