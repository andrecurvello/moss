package org.moss.objects;

import org.moss.Common;

public class TotalUp extends AbsMossObject implements MossObject {

    /**
     * Display the download speed for a network interface.
     *
     * @param device network device such as eth0 or wlan0
     */
    public TotalUp(String device) {
        this.device = device;
        netDevInfo.registerDevice(device);
    }

    public DataProvider getDataProvider() {
        return netDevInfo;
    }

    @Override
    public String toString() {
        return Common.humanReadble(netDevInfo.getTotalUp(device));
    }

    private String device;
    private ProcNetDev netDevInfo = ProcNetDev.INSTANCE;
}

