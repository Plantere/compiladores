package sintatico;

import lexic.Class;
import lexic.Lexic;
import lexic.Token;

public class Sintatico {

    private String nomeArquivo;
    private Lexic lexico;
    private Token token;

    public Sintatico(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        lexico = new Lexic(nomeArquivo);
    }

    public void analisar() {
        System.out.println("Analisando "  + nomeArquivo);
        token = lexico.nextToken();
        programa();
    }

    private void programa() {
        if(token.getClasse() == Class.reservedWord && token.getValue().getstringValue().equals("program")) {
            token = lexico.nextToken();

            if(token.getClasse() == Class.identifier) {
                token = lexico.nextToken();
                // { A01 }

                if(token.getClasse() == Class.semicolon){
                    token = lexico.nextToken();
                    corpo();
                    if(token.getClasse() == Class.dot) {
                        token = lexico.nextToken();
                        // { A45 }
                    } else {
                        System.err.println(token.getLine() + ", " + token.getColumn() + " (.) Ponto final é esperado no programa.");
                    }
                } else {
                    System.err.println(token.getLine() + ", " + token.getColumn() + " (;) Ponto e virgula é esperado no programa.");
                }
            } else {
                System.err.println(token.getLine() + ", " + token.getColumn() + " (<identifier>) Identificador é esperado no programa.");
            }
        } else {
            System.err.println(token.getLine() + ", " + token.getColumn() + " (program) Palavra reservada é esperado no programa.");
        }
    }


    private void corpo(){
        // declara();
        // rotina(); - Não sera implementado.
        // { A44 }

        if(token.getClasse() == Class.reservedWord && token.getValue().getstringValue().equals("begin")) {
            token = lexico.nextToken();
            // sentencas();
            if(token.getClasse() == Class.reservedWord && token.getValue().getstringValue().equals("end")) {
                token = lexico.nextToken();
                // { A46 }
            } else {
                System.err.println(token.getLine() + ", " + token.getColumn() + " (end) Palavra reservada é esperado no programa.");
            }
        } else {
            System.err.println(token.getLine() + ", " + token.getColumn() + " (begin) Palavra reservada é esperado no programa.");
        }
    }
}
