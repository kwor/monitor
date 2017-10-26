package com.monitor.pojo;

public class History {
    private Integer id;

    private String equipmentId;

    private String addtime;

    private String info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquidmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

	@Override
	public String toString() {
		return "History [id=" + id + ", equipmentId=" + equipmentId + ", addtime=" + addtime + ", info=" + info + "]";
	}
    
}