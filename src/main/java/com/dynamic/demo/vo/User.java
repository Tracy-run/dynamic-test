package com.dynamic.demo.vo;

/**
 * @Author: 逍遥子
 * @Date: 2020/10/21 9:14
 */
public class User {

    private Long id;//主键
    private String username;//用户名
    private String password;//密码
    private String name;//真实姓名
    private String post;//岗位
    private Long roleId;//所属角色id
    private String roleName;//所属角色名称
    private String mail;//邮箱
    private String mobile;//手机号码
    private String departmentMobile;//部门电话
    private String groupName;//所属集团
    private String companyName;//所属公司
    private String projectDepartmentName;//所属项目部
    private String maintainDepartmentName;//所属维修部
    private String snCode;//sn码
    private Integer isOnline;//是否在线  0、离线 1、在线
    private Double longitude;//经度
    private Double latitude;//纬度
    private String stationId;//所属站点id
    private String stationName;//所属站点
    private String lineId;//所属线路id
    private String lineName;//所属线路
    private Integer type;//修改类型1、消息2、震动
    private Integer flag;//标记类型0、关1、开
    private Integer messageFlag;//消息接收状态0、不接收1、接收
    private Integer shakeFlag;//震动提示状态0、不接收1、接收
    private String pic;//照片

    private String token;
    private String userRoleCode;

    public User() {
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDepartmentMobile() {
        return departmentMobile;
    }

    public void setDepartmentMobile(String departmentMobile) {
        this.departmentMobile = departmentMobile;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProjectDepartmentName() {
        return projectDepartmentName;
    }

    public void setProjectDepartmentName(String projectDepartmentName) {
        this.projectDepartmentName = projectDepartmentName;
    }

    public String getMaintainDepartmentName() {
        return maintainDepartmentName;
    }

    public void setMaintainDepartmentName(String maintainDepartmentName) {
        this.maintainDepartmentName = maintainDepartmentName;
    }

    public String getSnCode() {
        return snCode;
    }

    public void setSnCode(String snCode) {
        this.snCode = snCode;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getMessageFlag() {
        return messageFlag;
    }

    public void setMessageFlag(Integer messageFlag) {
        this.messageFlag = messageFlag;
    }

    public Integer getShakeFlag() {
        return shakeFlag;
    }

    public void setShakeFlag(Integer shakeFlag) {
        this.shakeFlag = shakeFlag;
    }



    public String getToken() {
        return token;
    }



    public void setToken(String token) {
        this.token = token;
    }



    public String getStationId() {
        return stationId;
    }



    public void setStationId(String stationId) {
        this.stationId = stationId;
    }



    public String getLineId() {
        return lineId;
    }



    public void setLineId(String lineId) {
        this.lineId = lineId;
    }



    public String getPic() {
        return pic;
    }



    public void setPic(String pic) {
        this.pic = pic;
    }



    public String getUserRoleCode() {
        return userRoleCode;
    }



    public void setUserRoleCode(String userRoleCode) {
        this.userRoleCode = userRoleCode;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
