package com.monitor.pojo;

public class TbInfo {
    private Integer id;

    private String stationid;

    private String inventersn;

    private String idesc;

    private String power;

    private String status;

    private String eday;

    private String etotal;

    private String errormsg;
    
    private String addtime;
    
    



	@Override
	public String toString() {
		return "TbInfo [id=" + id + ", stationid=" + stationid + ", inventersn=" + inventersn + ", idesc=" + idesc
				+ ", power=" + power + ", status=" + status + ", eday=" + eday + ", etotal=" + etotal + ", errormsg="
				+ errormsg + ", addtime=" + addtime + "]";
	}



	public String getAddtime() {
		return addtime;
	}



	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}



	public TbInfo(Integer id, String stationid, String inventersn, String idesc, String power, String status,
			String eday, String etotal, String errormsg, String addtime) {
		super();
		this.id = id;
		this.stationid = stationid;
		this.inventersn = inventersn;
		this.idesc = idesc;
		this.power = power;
		this.status = status;
		this.eday = eday;
		this.etotal = etotal;
		this.errormsg = errormsg;
		this.addtime = addtime;
	}



	public TbInfo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid == null ? null : stationid.trim();
    }

    public String getInventersn() {
        return inventersn;
    }

    public void setInventersn(String inventersn) {
        this.inventersn = inventersn == null ? null : inventersn.trim();
    }

    public String getIdesc() {
        return idesc;
    }

    public void setIdesc(String idesc) {
        this.idesc = idesc == null ? null : idesc.trim();
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getEday() {
        return eday;
    }

    public void setEday(String eday) {
        this.eday = eday == null ? null : eday.trim();
    }

    public String getEtotal() {
        return etotal;
    }

    public void setEtotal(String etotal) {
        this.etotal = etotal == null ? null : etotal.trim();
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg == null ? null : errormsg.trim();
    }
}