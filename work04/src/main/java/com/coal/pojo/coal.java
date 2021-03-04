package com.coal.pojo;

public class coal {
    private String _id;
    private String create_time;
    private String data_time;
    private String mine_code;
    private String point_code;
    private String point_location;
    private String point_status;
    private String point_status_name;
    private double point_value;
    private String province_org_code;
    private String sensor_type;
    private String sensor_type_name;
    private String supervisor_org_code;
    private String upload_time;
    private String value_unit;

    public coal(String _id, String create_time, String data_time, String mine_code, String point_code, String point_location, String point_status, String point_status_name, double point_value, String province_org_code, String sensor_type, String sensor_type_name, String supervisor_org_code, String upload_time, String value_unit) {
        this._id = _id;
        this.create_time = create_time;
        this.data_time = data_time;
        this.mine_code = mine_code;
        this.point_code = point_code;
        this.point_location = point_location;
        this.point_status = point_status;
        this.point_status_name = point_status_name;
        this.point_value = point_value;
        this.province_org_code = province_org_code;
        this.sensor_type = sensor_type;
        this.sensor_type_name = sensor_type_name;
        this.supervisor_org_code = supervisor_org_code;
        this.upload_time = upload_time;
        this.value_unit = value_unit;
    }

    public coal() {
//        System.out.println("Blank");
    }

    @Override
    public String toString() {
        return "coal{" +
                "_id='" + _id + '\'' +
                ", create_time='" + create_time + '\'' +
                ", data_time='" + data_time + '\'' +
                ", mine_code='" + mine_code + '\'' +
                ", point_code='" + point_code + '\'' +
                ", point_location='" + point_location + '\'' +
                ", point_status='" + point_status + '\'' +
                ", point_status_name='" + point_status_name + '\'' +
                ", point_value='" + point_value + '\'' +
                ", province_org_code='" + province_org_code + '\'' +
                ", sensor_type='" + sensor_type + '\'' +
                ", sensor_type_name='" + sensor_type_name + '\'' +
                ", supervisor_org_code='" + supervisor_org_code + '\'' +
                ", upload_time='" + upload_time + '\'' +
                ", value_unit='" + value_unit + '\'' +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getData_time() {
        return data_time;
    }

    public void setData_time(String data_time) {
        this.data_time = data_time;
    }

    public String getMine_code() {
        return mine_code;
    }

    public void setMine_code(String mine_code) {
        this.mine_code = mine_code;
    }

    public String getPoint_code() {
        return point_code;
    }

    public void setPoint_code(String point_code) {
        this.point_code = point_code;
    }

    public String getPoint_location() {
        return point_location;
    }

    public void setPoint_location(String point_location) {
        this.point_location = point_location;
    }

    public String getPoint_status() {
        return point_status;
    }

    public void setPoint_status(String point_status) {
        this.point_status = point_status;
    }

    public String getPoint_status_name() {
        return point_status_name;
    }

    public void setPoint_status_name(String point_status_name) {
        this.point_status_name = point_status_name;
    }

    public double getPoint_value() {
        return point_value;
    }

    public void setPoint_value(double point_value) {
        this.point_value = point_value;
    }

    public String getProvince_org_code() {
        return province_org_code;
    }

    public void setProvince_org_code(String province_org_code) {
        this.province_org_code = province_org_code;
    }

    public String getSensor_type() {
        return sensor_type;
    }

    public void setSensor_type(String sensor_type) {
        this.sensor_type = sensor_type;
    }

    public String getSensor_type_name() {
        return sensor_type_name;
    }

    public void setSensor_type_name(String sensor_type_name) {
        this.sensor_type_name = sensor_type_name;
    }

    public String getSupervisor_org_code() {
        return supervisor_org_code;
    }

    public void setSupervisor_org_code(String supervisor_org_code) {
        this.supervisor_org_code = supervisor_org_code;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public String getValue_unit() {
        return value_unit;
    }

    public void setValue_unit(String value_unit) {
        this.value_unit = value_unit;
    }
}
