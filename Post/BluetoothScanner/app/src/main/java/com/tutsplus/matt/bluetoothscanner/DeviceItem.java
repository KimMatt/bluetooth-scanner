package com.tutsplus.matt.bluetoothscanner;

/**
 * Created by Matt on 5/12/2015.
 */
public class DeviceItem {

    private String deviceName;
    private boolean connected;

    public String getDeviceName() {
        return deviceName;
    }

    public boolean getConnected() { return connected;}


    public void setDeviceName(String deviceName, String enabled, int batteryLife) {
        this.deviceName = deviceName;
    }

    public DeviceItem(String name, String connected){
        this.deviceName = name;
        if (connected == "true") {
            this.connected = true;
        }
        else {
            this.connected = false;
        }
    }
}
