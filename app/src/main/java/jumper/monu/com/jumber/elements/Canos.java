package jumper.monu.com.jumber.elements;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.ListIterator;

import jumper.monu.com.jumber.graphic.Tela;

/**
 * Created by gneves on 05/04/2017.
 */

public class Canos {

    public static final int DISTANCIA_ENTRE_CANOS = 200;
    public static final int QUANTIDADE_DE_CANOS = 5;
    public static final int POSICAO_INICIAL_CANOS = 400;
    private final ArrayList<Cano> canos = new ArrayList<Cano>();
    private Tela tela;
    private Pontuacao pontuacao;
    private Context context;


    public Canos (Tela tela, Pontuacao pontuacao, Context context)
    {
        this.context = context;
        this.pontuacao = pontuacao;
        this.tela = tela;
        int posicao = POSICAO_INICIAL_CANOS;
        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicao += DISTANCIA_ENTRE_CANOS;
            Cano cano = new Cano(tela, posicao, context);
            canos.add(cano);

        }
    }

    public void desenhaNo(Canvas canvas) {
        for (Cano cano: canos) {
            cano.desenhaNo(canvas);
        }
    }

    public void move() {
        ListIterator<Cano> iterator = canos.listIterator();
        while (iterator.hasNext())
        {
            Cano cano = iterator.next();
            cano.move();

            if(cano.saiDaTela())
            {
                pontuacao.aumenta();
                Cano outro = new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS, context);
                iterator.remove();
                iterator.add(outro);
            }
        }
    }

    public int getMaximo() {
        int maximo = 0;
        for(Cano cano : canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    public boolean temColisaoCom(Passaro passaro) {

        for (Cano cano : canos) {
            if(cano.temColisaoHorizontalCom(passaro)
                    &&  cano.temColisaoVerticalCom(passaro))
            {
                return true;
            }

        }
        return false;
    }
}
