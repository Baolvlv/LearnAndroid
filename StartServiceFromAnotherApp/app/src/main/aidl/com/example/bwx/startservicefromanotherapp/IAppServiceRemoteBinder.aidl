// IAppServiceRemoteBinder.aidl
package com.example.bwx.startservicefromanotherapp;

// Declare any non-default types here with import statements

interface IAppServiceRemoteBinder {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    void setData(String data);
}
