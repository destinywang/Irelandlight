package com.irelandlight.vo;

/**
 * User: Matt
 * Date: 2016/12/21
 * Time: 17:04
 * Description: description
 */
public class AccountManagerDisplay {

    private String nickname;        //昵称
    private String telephone;       //用户联系方式
    private Integer defaultAddressId; //默认收货地址Id
    private String detail;          //详细地址
    private String consumerName;    //收货人姓名

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getDefaultAddressId() {
        return defaultAddressId;
    }

    public void setDefaultAddressId(Integer defaultAddressId) {
        this.defaultAddressId = defaultAddressId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    @Override
    public String toString() {
        return "AccountManagerDisplay{" +
                "nickname='" + nickname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", defaultAddressId=" + defaultAddressId +
                ", detail='" + detail + '\'' +
                ", consumerName='" + consumerName + '\'' +
                '}';
    }
}
