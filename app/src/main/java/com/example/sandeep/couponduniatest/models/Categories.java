package com.example.sandeep.couponduniatest.models;

/**
 * Created by sandeep on 23/11/15.
 */
/*
Categories": [
                {
                    "OfflineCategoryID": "32",
                    "Name": "Continental",
                    "ParentCategoryID": "1",
                    "CategoryType": "Cuisine"
                },
 */
public class Categories {
    private String OfflineCategoryID,Name,ParentCategoryID,CategoryType;

    public String getCategoryType() {
        return CategoryType;
    }

    public void setCategoryType(String categoryType) {
        CategoryType = categoryType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOfflineCategoryID() {
        return OfflineCategoryID;
    }

    public void setOfflineCategoryID(String offlineCategoryID) {
        OfflineCategoryID = offlineCategoryID;
    }

    public String getParentCategoryID() {
        return ParentCategoryID;
    }

    public void setParentCategoryID(String parentCategoryID) {
        ParentCategoryID = parentCategoryID;
    }
}
