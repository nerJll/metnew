package com.aixu.meeting.domain;

public class AikoRecepemp implements java.io.Serializable{

	private static final long serialVersionUID = -5393197104917662602L;

	private String rempId;

    private String rempEno;

    private String rempEname;

    private String rempResone;

    private String rempRestwo;

    private String rempResthree;

    public String getRempId() {
        return rempId;
    }

    public void setRempId(String rempId) {
        this.rempId = rempId == null ? null : rempId.trim();
    }

    public String getRempEno() {
        return rempEno;
    }

    public void setRempEno(String rempEno) {
        this.rempEno = rempEno == null ? null : rempEno.trim();
    }

    public String getRempEname() {
        return rempEname;
    }

    public void setRempEname(String rempEname) {
        this.rempEname = rempEname == null ? null : rempEname.trim();
    }

    public String getRempResone() {
        return rempResone;
    }

    public void setRempResone(String rempResone) {
        this.rempResone = rempResone == null ? null : rempResone.trim();
    }

    public String getRempRestwo() {
        return rempRestwo;
    }

    public void setRempRestwo(String rempRestwo) {
        this.rempRestwo = rempRestwo == null ? null : rempRestwo.trim();
    }

    public String getRempResthree() {
        return rempResthree;
    }

    public void setRempResthree(String rempResthree) {
        this.rempResthree = rempResthree == null ? null : rempResthree.trim();
    }

	public AikoRecepemp(String rempId, String rempEno, String rempEname, String rempResone, String rempRestwo,
			String rempResthree) {
		this.rempId = rempId;
		this.rempEno = rempEno;
		this.rempEname = rempEname;
		this.rempResone = rempResone;
		this.rempRestwo = rempRestwo;
		this.rempResthree = rempResthree;
	}

	public AikoRecepemp() {}

	@Override
	public String toString() {
		return "{\"rempId\":\"" + rempId + "\",\"rempEno\":\"" + rempEno + "\",\"rempEname\":\"" + rempEname
				+ "\",\"rempResone\":\"" + rempResone + "\",\"rempRestwo\":\"" + rempRestwo + "\",\"rempResthree\":\""
				+ rempResthree + "\"}";
	}
	
	
	
}