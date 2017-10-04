package jumper.monu.com.jumber.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import jumper.monu.com.jumber.R;

/**
 * Created by gneves on 06/04/2017.
 */

public class Som {

    private final SoundPool soundPool;
    private final Context context;
    public final int PULO;
    public final int PONTUACAO;
    public final int COLISAO;

    public Som(Context context) {
        this.context = context;
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC,0);
        PULO = soundPool.load(context, R.raw.pulo,1);
        PONTUACAO = soundPool.load(context, R.raw.pontos,1);
        COLISAO = soundPool.load(context, R.raw.colisao, 0);
    }
    public void toca(int som)
    {
        soundPool.play(som, 1,1,1,0,1);
    }
}
