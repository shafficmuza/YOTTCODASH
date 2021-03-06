package com.shafficmuza.yottcodash;

public class ServiceProvider {

    private String title;
    private String desc;
    private String phone;
    private int photo;

    public ServiceProvider() {}

    public ServiceProvider(String title, String desc, String phone, int photo) {
        this.title = title;
        this.desc = desc;
        this.phone = phone;
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
