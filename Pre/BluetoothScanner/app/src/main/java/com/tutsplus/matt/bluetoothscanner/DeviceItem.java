package com.tutsplus.matt.bluetoothscanner;

/**
 * Created by Matt on 5/12/2015.
 */
public class DeviceItem {

    private String deviceName;
    private boolean enabled;
    private int batteryLife;

    public String getDeviceName() {
        return deviceName;
    }

    public boolean getEnabled() { return enabled;}

    public int getBatteryLife() {return batteryLife;}

    public void setDeviceName(String deviceName, String enabled, int batteryLife) {
        this.deviceName = deviceName;
    }

    public DeviceItem(String name, String enabled, int batteryLife){
        this.deviceName = name;
        if (enabled == "true") {
            this.enabled = true;
        }
        else {
            this.enabled = false;
        }
        this.batteryLife = batteryLife;
    }
}
