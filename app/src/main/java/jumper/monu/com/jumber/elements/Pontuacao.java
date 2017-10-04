package jumper.monu.com.jumber.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import jumper.monu.com.jumber.engine.Som;
import jumper.monu.com.jumber.graphic.Cores;

/**
 * Created by gneves on 05/04/2017.
 */

public class Pontuacao {

    public static final Paint BRANCO = Cores.getCorDaPontuacao();
    private int pontos;
    private Som som;

    public Pontuacao(Som som)
    {
        this.som = som;
    }

    public void desenhaNo(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100,100, BRANCO);
    }

    public void aumenta() {
        pontos++;
        som.toca(som.PONTUACAO);
    }
}
