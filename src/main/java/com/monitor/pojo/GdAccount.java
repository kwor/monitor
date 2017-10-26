package com.monitor.pojo;

public class GdAccount {
    private Integer id;

    private String account;

    private String stationname;

    private String creationdate;

    private String creationdate2;

    private String sn;

    private String stationid;
    
    

    @Override
	public String toString() {
		return "GdAccount [id=" + id + ", account=" + account + ", stationname=" + stationname + ", creationdate="
				+ creationdate + ", creationdate2=" + creationdate2 + ", sn=" + sn + ", stationid=" + stationid + "]";
	}

	public GdAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GdAccount(Integer id, String account, String stationname, String creationdate, String creationdate2,
			String sn, String stationid) {
		super();
		this.id = id;
		this.account = account;
		this.stationname = stationname;
		this.creationdate = creationdate;
		this.creationdate2 = creationdate2;
		this.sn = sn;
		this.stationid = stationid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname == null ? null : stationname.trim();
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate == null ? null : creationdate.trim();
    }

    public String getCreationdate2() {
        return creationdate2;
    }

    public void setCreationdate2(String creationdate2) {
        this.creationdate2 = creationdate2 == null ? null : creationdate2.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid == null ? null : stationid.trim();
    }
}