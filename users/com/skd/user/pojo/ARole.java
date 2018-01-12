package com.skd.user.pojo;

import java.util.Date;
import java.util.List;

/**
 * 角色pojo
 *
 * @author YanJiang 2018年1月11日
 *
 */
public class ARole {
	private int id;
	private String name;
	private String content;
	private int status;
	private Date create_time;
	private Date update_time;
	/* ======关联对象===== */

	private List<AAdims> adimsList;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the create_time
	 */
	public Date getCreate_time() {
		return create_time;
	}

	/**
	 * @param create_time
	 *            the create_time to set
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	/**
	 * @return the update_time
	 */
	public Date getUpdate_time() {
		return update_time;
	}

	/**
	 * @param update_time
	 *            the update_time to set
	 */
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * @return the adimsList
	 */
	public List<AAdims> getAdimsList() {
		return adimsList;
	}

	/**
	 * @param adimsList
	 *            the adimsList to set
	 */
	public void setAdimsList(List<AAdims> adimsList) {
		this.adimsList = adimsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ARole [id=" + id + ", name=" + name + ", content=" + content
				+ ", status=" + status + ", create_time=" + create_time
				+ ", update_time=" + update_time + ", adimsList=" + adimsList
				+ "]";
	}

}
