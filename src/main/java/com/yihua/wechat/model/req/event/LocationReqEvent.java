package com.yihua.wechat.model.req.event;

/**
 * Created by brokenq on 2015/7/14.
 */
public class LocationReqEvent extends BaseReqEvent {
//    地理位置纬度
    private String latitude;
//    地理位置经度
    private String longitude;
//    地理位置精度
    private String precision;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}
