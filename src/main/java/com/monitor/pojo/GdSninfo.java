package com.monitor.pojo;

public class GdSninfo {
    private Integer id;

    private String username;

    private String stationid;

    private String stationname;

    private String stationPic;

    private String currentpower;

    private String capacity;

    private String valueEdaytotal;

    private String valueEtotal;

    private String valueDayincome;

    private String valueTotalincome;
    
    

    @Override
	public String toString() {
		return "GdSninfo [id=" + id + ", username=" + username + ", stationid=" + stationid + ", stationname="
				+ stationname + ", stationPic=" + stationPic + ", currentpower=" + currentpower + ", capacity="
				+ capacity + ", valueEdaytotal=" + valueEdaytotal + ", valueEtotal=" + valueEtotal + ", valueDayincome="
				+ valueDayincome + ", valueTotalincome=" + valueTotalincome + "]";
	}

	public GdSninfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GdSninfo(Integer id, String username, String stationid, String stationname, String stationPic,
			String currentpower, String capacity, String valueEdaytotal, String valueEtotal, String valueDayincome,
			String valueTotalincome) {
		super();
		this.id = id;
		this.username = username;
		this.stationid = stationid;
		this.stationname = stationname;
		this.stationPic = stationPic;
		this.currentpower = currentpower;
		this.capacity = capacity;
		this.valueEdaytotal = valueEdaytotal;
		this.valueEtotal = valueEtotal;
		this.valueDayincome = valueDayincome;
		this.valueTotalincome = valueTotalincome;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid == null ? null : stationid.trim();
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname == null ? null : stationname.trim();
    }

    public String getStationPic() {
        return stationPic;
    }

    public void setStationPic(String stationPic) {
        this.stationPic = stationPic == null ? null : stationPic.trim();
    }

    public String getCurrentpower() {
        return currentpower;
    }

    public void setCurrentpower(String currentpower) {
        this.currentpower = currentpower == null ? null : currentpower.trim();
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity == null ? null : capacity.trim();
    }

    public String getValueEdaytotal() {
        return valueEdaytotal;
    }

    public void setValueEdaytotal(String valueEdaytotal) {
        this.valueEdaytotal = valueEdaytotal == null ? null : valueEdaytotal.trim();
    }

    public String getValueEtotal() {
        return valueEtotal;
    }

    public void setValueEtotal(String valueEtotal) {
        this.valueEtotal = valueEtotal == null ? null : valueEtotal.trim();
    }

    public String getValueDayincome() {
        return valueDayincome;
    }

    public void setValueDayincome(String valueDayincome) {
        this.valueDayincome = valueDayincome == null ? null : valueDayincome.trim();
    }

    public String getValueTotalincome() {
        return valueTotalincome;
    }

    public void setValueTotalincome(String valueTotalincome) {
        this.valueTotalincome = valueTotalincome == null ? null : valueTotalincome.trim();
    }
}