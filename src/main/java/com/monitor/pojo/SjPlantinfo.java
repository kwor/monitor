package com.monitor.pojo;

public class SjPlantinfo {
    private Integer id;

    private String locale;

    private String plantId;

    private String name;

    private String userId;

    private String status;

    private String country;

    private String city;

    private String longitude;

    private String latitude;

    private String peakPower;

    private String createDate;

    private String imageUrl;

    private String operator;

    private String installer;

    private String currentPower;

    private String totalEnergy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale == null ? null : locale.trim();
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId == null ? null : plantId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getPeakPower() {
        return peakPower;
    }

    public void setPeakPower(String peakPower) {
        this.peakPower = peakPower == null ? null : peakPower.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getInstaller() {
        return installer;
    }

    public void setInstaller(String installer) {
        this.installer = installer == null ? null : installer.trim();
    }

    public String getCurrentPower() {
        return currentPower;
    }

    public void setCurrentPower(String currentPower) {
        this.currentPower = currentPower == null ? null : currentPower.trim();
    }

    public String getTotalEnergy() {
        return totalEnergy;
    }

    public void setTotalEnergy(String totalEnergy) {
        this.totalEnergy = totalEnergy == null ? null : totalEnergy.trim();
    }
}