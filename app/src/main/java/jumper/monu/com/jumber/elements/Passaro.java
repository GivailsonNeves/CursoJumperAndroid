package jumper.monu.com.jumber.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import jumper.monu.com.jumber.R;
import jumper.monu.com.jumber.engine.Som;
import jumper.monu.com.jumber.graphic.Cores;
import jumper.monu.com.jumber.graphic.Tela;

/**
 * Created by gneves on 03/04/2017.
 */

public class Passaro {
    public  static final float X = 100;
    public static final float RAIO = 50;
    private static final Paint VERMELHO = Cores.getCorDoPassaro();
    private final Tela tela;
    private final Bitmap passaro;
    private float altura;
    private final Som som;

    public Passaro(Tela tela, Context context, Som som)
    {
        this.som = som;
        this.tela = tela;
        this.altura = 100;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = bp.createScaledBitmap(bp, (int)RAIO * 2, (int)RAIO * 2, false);
    }

    public void desenhaNo(Canvas canvas)
    {
        canvas.drawBitmap(passaro,X - RAIO,altura, null);
        //canvas.drawCircle(X, altura, RAIO, VERMELHO);
    }
    public void cai()
    {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();
        if(!chegouNoChao) {
            this.altura += 5;
        }
    }

    public void pula()
    {
        this.altura =  Math.max( this.altura - 150, 0 );
        som.toca(som.PULO);
    }


    public float getAltura() {
        return altura;
    }
}
