package com.example.extremetech.gastrotec;

public class Student {

    private String mName;
    private String mCareer;
    private int mId;
    private String mEmail;
    private int mType;// 0 admin user 1 normal user

    /**
     * Constructor
     *
     * @param name
     * @param career
     * @param id
     * @param email
     * @param type
     */
    Student(String name, String career, int id, String email, int type) {
        mName = name;
        mCareer = career;
        mId = id;
        mEmail = email;
        mType = type;
    }


    /**
     * get del nombre
     *
     * @return nombre
     */
    public String getmName() {
        return mName;
    }

    /**
     * set del nombre
     *
     * @param mName
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    /**
     * get de la carrera
     *
     * @return carrera
     */
    public String getmCareer() {
        return mCareer;
    }

    /**
     * set de la carrera
     *
     * @param mCareer
     */
    public void setmCareer(String mCareer) {
        this.mCareer = mCareer;
    }

    /**
     * get del carnet
     *
     * @return carnet
     */
    public int getmId() {
        return mId;
    }

    /**
     * set del carnet
     *
     * @param mId
     */
    public void setmId(int mId) {
        this.mId = mId;
    }

    /**
     * get del email
     *
     * @return email
     */
    public String getmEmail() {
        return mEmail;
    }

    /**
     * set del email
     *
     * @param mEmail
     */
    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    /**
     * get del tipo de estudiante
     *
     * @return tipo
     */
    public int getmType() {
        return mType;
    }

    /**
     * set del tipo
     *
     * @param mType
     */
    public void setmType(int mType) {
        this.mType = mType;
    }
}
