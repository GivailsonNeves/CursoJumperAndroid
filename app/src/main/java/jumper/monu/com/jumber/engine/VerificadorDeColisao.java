package jumper.monu.com.jumber.engine;

import jumper.monu.com.jumber.elements.Canos;
import jumper.monu.com.jumber.elements.Passaro;

/**
 * Created by gneves on 05/04/2017.
 */

class VerificadorDeColisao {

    private Passaro passaro;
    private Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos) {

        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }
}
