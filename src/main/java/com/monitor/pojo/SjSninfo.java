package com.monitor.pojo;

public class SjSninfo {
    private Integer id;

    private String deviceId;

    private String dataloggerSn;

    private String deviceSn;

    private String manufacturer;

    private String model;

    private String type;

    private String lastUpdateTime;

    private String syspower;

    private String updatadate;

    private String tzone;

    private String dtype;

    private String etotal;

    private String etoday;

    private String emonth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDataloggerSn() {
        return dataloggerSn;
    }

    public void setDataloggerSn(String dataloggerSn) {
        this.dataloggerSn = dataloggerSn == null ? null : dataloggerSn.trim();
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn == null ? null : deviceSn.trim();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime == null ? null : lastUpdateTime.trim();
    }

    public String getSyspower() {
        return syspower;
    }

    public void setSyspower(String syspower) {
        this.syspower = syspower == null ? null : syspower.trim();
    }

    public String getUpdatadate() {
        return updatadate;
    }

    public void setUpdatadate(String updatadate) {
        this.updatadate = updatadate == null ? null : updatadate.trim();
    }

    public String getTzone() {
        return tzone;
    }

    public void setTzone(String tzone) {
        this.tzone = tzone == null ? null : tzone.trim();
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype == null ? null : dtype.trim();
    }

    public String getEtotal() {
        return etotal;
    }

    public void setEtotal(String etotal) {
        this.etotal = etotal == null ? null : etotal.trim();
    }

    public String getEtoday() {
        return etoday;
    }

    public void setEtoday(String etoday) {
        this.etoday = etoday == null ? null : etoday.trim();
    }

    public String getEmonth() {
        return emonth;
    }

    public void setEmonth(String emonth) {
        this.emonth = emonth == null ? null : emonth.trim();
    }
}