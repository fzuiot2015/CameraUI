package edu.fzu.cameraui.pojo;

import java.util.Date;

public class FishInfo {
    private Date date;
    private int poolId;
    private int feedQuantity1;
    private int feedQuantity2;
    private int feedQuantity3;
    private int feedQuantity4;
    private int waterQuantity;
    private float phAM;
    private float phPM;
    private int nh4n;
    private int nano2;
    private String MedicationRecord;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPoolId() {
        return poolId;
    }

    public void setPoolId(int poolId) {
        this.poolId = poolId;
    }

    public int getFeedQuantity1() {
        return feedQuantity1;
    }

    public void setFeedQuantity1(int feedQuantity1) {
        this.feedQuantity1 = feedQuantity1;
    }

    public int getFeedQuantity2() {
        return feedQuantity2;
    }

    public void setFeedQuantity2(int feedQuantity2) {
        this.feedQuantity2 = feedQuantity2;
    }

    public int getFeedQuantity3() {
        return feedQuantity3;
    }

    public void setFeedQuantity3(int feedQuantity3) {
        this.feedQuantity3 = feedQuantity3;
    }

    public int getFeedQuantity4() {
        return feedQuantity4;
    }

    public void setFeedQuantity4(int feedQuantity4) {
        this.feedQuantity4 = feedQuantity4;
    }

    public int getWaterQuantity() {
        return waterQuantity;
    }

    public void setWaterQuantity(int waterQuantity) {
        this.waterQuantity = waterQuantity;
    }

    public float getPhAM() {
        return phAM;
    }

    public void setPhAM(float phAM) {
        this.phAM = phAM;
    }

    public float getPhPM() {
        return phPM;
    }

    public void setPhPM(float phPM) {
        this.phPM = phPM;
    }

    public int getNh4n() {
        return nh4n;
    }

    public void setNh4n(int nh4n) {
        this.nh4n = nh4n;
    }

    public int getNano2() {
        return nano2;
    }

    public void setNano2(int nano2) {
        this.nano2 = nano2;
    }

    public String getMedicationRecord() {
        return MedicationRecord;
    }

    public void setMedicationRecord(String medicationRecord) {
        MedicationRecord = medicationRecord;
    }
}
