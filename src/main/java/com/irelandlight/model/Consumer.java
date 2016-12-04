package com.irelandlight.model;

import java.util.Date;

/**
 * 消费者实体
 *
 * Created by destiny on 2016/12/2.
 */
public class Consumer {
    /**
     * 主键
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后修改时间
     */
    private Date lastUpdate;
    /**
     * 逻辑删除
     */
    private Integer visibility;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String headUrl;
    /**
     * 积分
     */
    private Integer score;
    /**
     * 余额
     */
    private Double wallet;
    /**
     * 性别
     */
    private String gender;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 生日
     */
    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", lastUpdate=" + lastUpdate +
                ", visibility=" + visibility +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", nickName='" + nickName + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", score=" + score +
                ", wallet=" + wallet +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
