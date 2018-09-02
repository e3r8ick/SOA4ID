package com.example.extremetech.gastrotec;

public class Student {

    private String mName;
    private String mCareer;
    private int mId;
    private String mEmail;
    private int mType;// 0 admin user 1 normal user

    Student(String name, String career, int id, String email, int type){
        mName = name;
        mCareer = career;
        mId = id;
        mEmail = email;
        mType = type;
    }


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCareer() {
        return mCareer;
    }

    public void setmCareer(String mCareer) {
        this.mCareer = mCareer;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }
}
