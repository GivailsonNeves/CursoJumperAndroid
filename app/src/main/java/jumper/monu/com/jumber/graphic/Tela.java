package jumper.monu.com.jumber.graphic;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by gneves on 03/04/2017.
 */

public class Tela {

    private DisplayMetrics metrics;
    public Tela(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        metrics = new DisplayMetrics();
        display.getMetrics(metrics);
    }
    public int getAltura()
    {
        return metrics.heightPixels;
    }

    public int getLargura() {
        return metrics.widthPixels;
    }
}
