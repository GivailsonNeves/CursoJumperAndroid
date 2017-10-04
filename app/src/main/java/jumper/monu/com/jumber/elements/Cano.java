package jumper.monu.com.jumber.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import jumper.monu.com.jumber.R;
import jumper.monu.com.jumber.graphic.Cores;
import jumper.monu.com.jumber.graphic.Tela;

import static android.R.attr.left;
import static android.R.attr.right;

/**
 * Created by gneves on 04/04/2017.
 */

public class Cano {

    private final int alturaDoCanoInferior;
    private final Bitmap canoSuperior;
    private int posicao;
    private Tela tela;
    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;
    private static final Paint VERDE = Cores.getCorDoCano();
    private int alturaDoCanoSuperior;
    private Context context;
    private Bitmap canoInferior;

    public Cano(Tela tela, int posicao, Context context)
    {
        this.context = context;
        this.tela = tela;
        this.posicao = posicao;
        alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO  + valorAleatorio();
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, alturaDoCanoInferior, false);
        canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO, alturaDoCanoSuperior, false);
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    public void desenhaNo(Canvas canvas){
        desenhaCanoSuperiorNo(canvas);
        desenhaCanoInferiorNo(canvas);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas) {
//        canvas.drawRect(posicao,0,posicao + LARGURA_DO_CANO,alturaDoCanoSuperior, VERDE);
        canvas.drawBitmap(canoSuperior, posicao,0, null);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        //canvas.drawRect(posicao,alturaDoCanoInferior,posicao + LARGURA_DO_CANO,tela.getAltura(), VERDE);
        canvas.drawBitmap(canoInferior, posicao, alturaDoCanoInferior, null);

    }

    public void move() {
        this.posicao -= 5;
    }

    public boolean saiDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {

        return this.posicao < passaro.X + passaro.RAIO;
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {

        return passaro.getAltura() - passaro.RAIO < this.alturaDoCanoSuperior
                || passaro.getAltura() + passaro.RAIO > this.alturaDoCanoInferior;
    }
}
