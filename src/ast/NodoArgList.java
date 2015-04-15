/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author Cristopher_Notebook
 */
public class NodoArgList extends NodoBase {
    private NodoIdentificador id;
    private String identificador;
    private tipoDato tipo;
    private NodoBase argumento;

    public NodoArgList(String identificador,tipoDato tipo) {
        super();
        this.identificador = identificador;
        this.tipo = tipo;
    }

    public NodoArgList(String identificador, tipoDato tipo, NodoBase argumento) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.argumento = argumento;
    }
    
    public NodoArgList(NodoBase argumento) {
        this.argumento = argumento;
    } 

    public void setArgumento(NodoBase argumento) {
        this.argumento = argumento;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setTipo(tipoDato tipo) {
        this.tipo = tipo;
    }

    public NodoBase getArgumento() {
        return argumento;
    }

    public String getIdentificador() {
        return identificador;
    }

    public tipoDato getTipo() {
        return tipo;
    }
    public NodoBase getId() {
        return id;
    }
}
