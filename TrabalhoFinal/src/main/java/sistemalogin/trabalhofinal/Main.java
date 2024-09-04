/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sistemalogin.trabalhofinal;

import sistemalogin.trabalhofinal.Presenter.Sistema;
import sistemalogin.trabalhofinal.View.TelaPrincipal;

/**
 *
 * @author kaios
 */
public class Main {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        TelaPrincipal telaprincipal = new TelaPrincipal();
        telaprincipal.jDesktopPane1Init(sistema);

    }
}
