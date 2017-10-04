package jumper.monu.com.jumber.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import jumper.monu.com.jumber.R;
import jumper.monu.com.jumber.elements.Cano;
import jumper.monu.com.jumber.elements.Canos;
import jumper.monu.com.jumber.elements.GameOver;
import jumper.monu.com.jumber.elements.Passaro;
import jumper.monu.com.jumber.elements.Pontuacao;
import jumper.monu.com.jumber.graphic.Tela;

/**
 * Created by gneves on 03/04/2017.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private final Som som;
    private  boolean isRunning = true;
    private final SurfaceHolder holder = getHolder();
    private Passaro passaro;
    private Bitmap background;
    private Tela tela;
    private Context context;
    private Canos canos;
    private Pontuacao pontuacao;

    public Game(Context context) {
        super(context);
        tela = new Tela(context);
        this.context = context;
        som = new Som(context);

        inicializaElementos();
        setOnTouchListener(this);
    }
    private  void inicializaElementos()
    {
        this.passaro = new Passaro(tela, context, som);
        pontuacao = new Pontuacao(som);
        canos = new Canos(tela, pontuacao, context);
        Bitmap back = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        background  = Bitmap.createScaledBitmap(back,back.getWidth(),tela.getAltura(), false);
    }
    @Override
    public void run() {
        while (isRunning){
            if(holder.getSurface().isValid()) {
                Canvas canvas = holder.lockCanvas();
                canvas.drawBitmap(background, 0, 0, null);
                passaro.desenhaNo(canvas);
                passaro.cai();
                canos.desenhaNo(canvas);
                canos.move();
                pontuacao.desenhaNo(canvas);

                if( new VerificadorDeColisao(passaro, canos).temColisao())
                {
                    som.toca(som.COLISAO);
                    new GameOver(tela).desenhaNo(canvas);
                    isRunning = false;
                }

                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
    public void inicia()
    {
        this.isRunning = true;
    }
    public void pausa()
    {
        this.isRunning = false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        passaro.pula();
        return false;
    }
}
