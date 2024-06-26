package org.example.Hotel;

import org.apache.solr.client.solrj.beans.Field;

import java.util.List;

public class Hotel {
    @Field
    String city;
    @Field
    String state;
    @Field
    String country;
    @Field
    String uid;
    @Field
    List<String> facilities;
    @Field
    List<String> roomfacilities;
    @Field
    int reviewcount;
    @Field
    float reviewscore;
    @Field
    String hotelname;
    @Field
    String hoteltype;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public List<String> getRoomfacilities() {
        return roomfacilities;
    }

    public void setRoomfacilities(List<String> roomfacilities) {
        this.roomfacilities = roomfacilities;
    }

    public int getReviewcount() {
        return reviewcount;
    }

    public void setReviewcount(int reviewcount) {
        this.reviewcount = reviewcount;
    }

    public float getReviewscore() {
        return reviewscore;
    }

    public void setReviewscore(float reviewscore) {
        this.reviewscore = reviewscore;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getHoteltype() {
        return hoteltype;
    }

    public void setHoteltype(String hoteltype) {
        this.hoteltype = hoteltype;
    }
}
