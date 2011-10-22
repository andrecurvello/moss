package org.moss.objects;

import org.moss.Common;
import org.moss.Env;
import org.moss.util.Bar;

public class MemBar implements MossObject {

    /**
     * Display memory used in a bar graph.
     */
    public MemBar() { }

    public DataProvider getDataProvider() {
        return memInfo;
    }

    public void preDraw(Env env) { }

    public void draw(Env env) {
        float perc = 0.0f;
        if (memInfo.getMemTotal() > 0) {
            perc = (memInfo.getMemTotal() - memInfo.getMemFree())
                 / (float)  memInfo.getMemTotal();
        }
        Bar b = new Bar();
        b.drawBar(env, perc);
    }

    public void postDraw(Env env) { }

    private ProcMemInfo memInfo = ProcMemInfo.INSTANCE;
}