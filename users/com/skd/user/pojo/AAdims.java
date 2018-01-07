package com.skd.user.pojo;

import java.util.Date;

/**
 * 1 管理员的pojo表
 * @author HEII
 *
 */

public class AAdims {

	/*`id` int(11) NOT NULL AUTO_INCREMENT,
	  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
	  `password` varchar(255) DEFAULT NULL COMMENT '管理员密码',
	  `name` varchar(255) NOT NULL COMMENT '姓名',
	  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
	  `qq` varchar(255) DEFAULT NULL,
	  `sex` varchar(255) DEFAULT NULL COMMENT '性别：0男 1 女',
	  `content` text NOT NULL,
	  `status` tinyint(4) NOT NULL COMMENT '状态；0：启用，1：启用',
	  `create_time` datetime NOT NULL COMMENT '创建时间',
	  `update_time` datetime NOT NULL COMMENT '更新时间',
	  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',*/

	private int id;
	private int role_id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String qq;
	private byte sex;
	private String content;
	private byte status;
	private Date create_time;
	private Date update_time;
	private Date last_login_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public byte getSex() {
		return sex;
	}
	public void setSex(byte sex) {
		this.sex = sex;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	@Override
	public String toString() {
		return "AAdims [id=" + id + ", role_id=" + role_id + ", email=" + email
				+ ", password=" + password + ", name=" + name + ", phone="
				+ phone + ", qq=" + qq + ", sex=" + sex + ", content="
				+ content + ", status=" + status + ", create_time="
				+ create_time + ", update_time=" + update_time
				+ ", last_login_time=" + last_login_time + "]";
	}


}
