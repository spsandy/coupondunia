package com.example.sandeep.couponduniatest.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sandeep on 23/11/15.
 */
/*
 "status": {
        "rcode": 200,
        "message": "OK"
    },
    "data": [
        {
            "SubFranchiseID": "0",
            "OutletID": "607",
            "OutletName": "Spill ",
            "BrandID": "403",
            "Address": "J-349, JP Road, Opp. Apna Bazar, JP Rd, D.N.Nagar, Andheri West, Mumbai, Maharashtra, India",
            "NeighbourhoodID": "1",
            "CityID": "1",
            "Email": null,
            "Timings": "Everyday: 6 pm to 1:30 am.",
            "CityRank": null,
            "Latitude": "19.127473",
            "Longitude": "72.832545",
            "Pincode": null,
            "Landmark": null,
            "Streetname": null,
            "BrandName": "Spill ",
            "OutletURL": "https://plus.google.com/111539701326240643109/about?hl=en-US",
            "NumCoupons": 1,
            "NeighbourhoodName": "Andheri West",
            "PhoneNumber": "+91 22 2642 5895",
            "CityName": "Mumbai",
            "Distance": 8205.2235,
            "Categories": [
                {
                    "OfflineCategoryID": "32",
                    "Name": "Continental",
                    "ParentCategoryID": "1",
                    "CategoryType": "Cuisine"
                },
                {
                    "OfflineCategoryID": "13",
                    "Name": "Bar and Restaurant",
                    "ParentCategoryID": "1",
                    "CategoryType": "TypeOfRestaurant"
                },
                {
                    "OfflineCategoryID": "17",
                    "Name": "Italian",
                    "ParentCategoryID": "1",
                    "CategoryType": "Cuisine"
                },
                {
                    "OfflineCategoryID": "1",
                    "Name": "Restaurant",
                    "ParentCategoryID": null,
                    "CategoryType": ""
                },
                {
                    "OfflineCategoryID": "21",
                    "Name": "North Indian",
                    "ParentCategoryID": "1",
                    "CategoryType": "Cuisine"
                }
            ],
            "LogoURL": "http://www.coupondunia.in/sitespecific/media/generated/offlineimages/logo_403.jpg",
            "CoverURL": "http://www.coupondunia.in/sitespecific/media/generated/offlineimages/cover_607.jpg"
        }
 */
public class RestaurantOutlets {


    private String OutletID,SubFranchiseID,OutletName,BrandID,Address
                  ,NeighbourhoodID,CityID,Email,Timings
                  ,CityRank,Latitude,Longitude,Pincode
                  ,Landmark,Streetname,BrandName,OutletURL
                  ,NumCoupons,NeighbourhoodName,PhoneNumber
                  ,CityName,Distance,LogoURL,CoverURL;

    @SerializedName("Categories")
    List<Categories> categories;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String brandID) {
        BrandID = brandID;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public String getCityID() {
        return CityID;
    }

    public void setCityID(String cityID) {
        CityID = cityID;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getCityRank() {
        return CityRank;
    }

    public void setCityRank(String cityRank) {
        CityRank = cityRank;
    }

    public String getCoverURL() {
        return CoverURL;
    }

    public void setCoverURL(String coverURL) {
        CoverURL = coverURL;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getLandmark() {
        return Landmark;
    }

    public void setLandmark(String landmark) {
        Landmark = landmark;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLogoURL() {
        return LogoURL;
    }

    public void setLogoURL(String logoURL) {
        LogoURL = logoURL;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getNeighbourhoodID() {
        return NeighbourhoodID;
    }

    public void setNeighbourhoodID(String neighbourhoodID) {
        NeighbourhoodID = neighbourhoodID;
    }

    public String getNeighbourhoodName() {
        return NeighbourhoodName;
    }

    public void setNeighbourhoodName(String neighbourhoodName) {
        NeighbourhoodName = neighbourhoodName;
    }

    public String getNumCoupons() {
        return NumCoupons;
    }

    public void setNumCoupons(String numCoupons) {
        NumCoupons = numCoupons;
    }

    public String getOutletID() {
        return OutletID;
    }

    public void setOutletID(String outletID) {
        OutletID = outletID;
    }

    public String getOutletName() {
        return OutletName;
    }

    public void setOutletName(String outletName) {
        OutletName = outletName;
    }

    public String getOutletURL() {
        return OutletURL;
    }

    public void setOutletURL(String outletURL) {
        OutletURL = outletURL;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }

    public String getStreetname() {
        return Streetname;
    }

    public void setStreetname(String streetname) {
        Streetname = streetname;
    }

    public String getSubFranchiseID() {
        return SubFranchiseID;
    }

    public void setSubFranchiseID(String subFranchiseID) {
        SubFranchiseID = subFranchiseID;
    }

    public String getTimings() {
        return Timings;
    }

    public void setTimings(String timings) {
        Timings = timings;
    }
}
