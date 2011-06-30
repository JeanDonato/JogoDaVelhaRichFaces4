/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jogodavelha.controller;

import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.richfaces.event.DropEvent;

/**
 *
 * @author jeandonato
 */
@Named
@ConversationScoped
public class JogoDaVelhaController implements Serializable {

    private String A1;
    private String A2;
    private String A3;
    private String B1;
    private String B2;
    private String B3;
    private String C1;
    private String C2;
    private String C3;
    private Peca pecaJogador1 = new Peca(1, "X");
    private Peca pecaJogador2 = new Peca(2, "O");
    private Boolean status;
    private Boolean vezJg1 = true;
    private Boolean vezJg2 = true;
    private String win;
    Peca peca = new Peca();
    @Inject
    Conversation conversation;

    public void start() {
        if (conversation.isTransient()) {
            conversation.begin();
            System.out.println("starting conversation");
        }
    }

    public void fisnish() {
        conversation.end();
    }

    public Peca getPecaJogador1() {
        return pecaJogador1;
    }

    public void setPecaJogador1(Peca pecaJogador1) {
        this.pecaJogador1 = pecaJogador1;
    }

    public Peca getPecaJogador2() {
        return pecaJogador2;
    }

    public void setPecaJogador2(Peca pecaJogador2) {
        this.pecaJogador2 = pecaJogador2;
    }

    public String getA1() {
        if (peca != null) {
            if (A1 == null) {
                A1 = peca.getValor();
                verificarVitoria();
            }
        }
        return A1;
    }

    public void setA1(String A1) {
        this.A1 = A1;
    }

    public String getA2() {
        if (peca != null) {
            if (A2 == null) {
                A2 = peca.getValor();
                verificarVitoria();
            }
        }
        return A2;
    }

    public void setA2(String A2) {
        this.A2 = A2;
    }

    public String getA3() {
        if (peca != null) {
            if (A3 == null) {
                A3 = peca.getValor();
                verificarVitoria();
            }
        }
        return A3;
    }

    public void setA3(String A3) {
        this.A3 = A3;
    }

    public String getB1() {
        if (peca != null) {
            if (B1 == null) {
                B1 = peca.getValor();
                verificarVitoria();
            }
        }
        return B1;
    }

    public void setB1(String B1) {
        this.B1 = B1;
    }

    public String getB2() {
        if (peca != null) {
            if (B2 == null) {
                B2 = peca.getValor();
                verificarVitoria();
            }
        }
        return B2;
    }

    public void setB2(String B2) {
        this.B2 = B2;
    }

    public String getB3() {
        if (peca != null) {
            if (B3 == null) {
                B3 = peca.getValor();
                verificarVitoria();
            }
        }
        return B3;
    }

    public void setB3(String B3) {
        this.B3 = B3;
    }

    public String getC1() {
        if (peca != null) {
            if (C1 == null) {
                C1 = peca.getValor();
                verificarVitoria();
            }
        }
        return C1;
    }

    public void setC1(String C1) {
        this.C1 = C1;
    }

    public String getC2() {
        if (peca != null) {
            if (C2 == null) {
                C2 = peca.getValor();
                verificarVitoria();
            }
        }
        return C2;
    }

    public void setC2(String C2) {
        this.C2 = C2;
    }

    public String getC3() {
        if (peca != null) {
            if (C3 == null) {
                C3 = peca.getValor();
                verificarVitoria();
            }
        }
        return C3;
    }

    public void setC3(String C3) {
        this.C3 = C3;
    }

    public void processDrop(DropEvent dropEvent) {
        Object pecaArrastada = dropEvent.getDragValue();
        peca = (Peca) pecaArrastada;

        if (peca.getValor().equals("X")) {
            setVezJg1(false);
            setVezJg2(true);
        } else {
            setVezJg1(true);
            setVezJg2(false);
        }
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public Boolean getVezJg1() {
        return vezJg1;
    }

    public void setVezJg1(Boolean vezJg1) {
        this.vezJg1 = vezJg1;
    }

    public Boolean getVezJg2() {
        return vezJg2;
    }

    public void setVezJg2(Boolean vezJg2) {
        this.vezJg2 = vezJg2;
    }

    public void verificarVitoria() {
        if (A1 != null && A2 != null && A3 != null) {
            if (A1.equals("X") && A2.equals("X") && A3.equals("X")) {
                System.out.println("Play 1 Win");
                setStatus(true);
                setWin("Jogador 1 Vencedor. Parabéns!");
            } else {
                if (A1.equals("O") && A2.equals("O") && A3.equals("O")) {
                    System.out.println("Play 2 Win");
                    setStatus(true);
                    setWin("Jogador 2 Vencedor. Parabéns!");
                }
            }
        }
        if (B1 != null && B2 != null && B3 != null) {
            if (B1.equals("X") && B2.equals("X") && B3.equals("X")) {
                System.out.println("Play 1 Win");
                setStatus(true);
                setWin("Jogador 1 Vencedor. Parabéns!");
            } else {
                if (B1.equals("O") && B2.equals("O") && B3.equals("O")) {
                    System.out.println("Play 2 Win");
                    setStatus(true);
                    setWin("Jogador 2 Vencedor. Parabéns!");
                }
            }
        }
        if (C1 != null && C2 != null && C3 != null) {
            if (C1.equals("X") && C2.equals("X") && C3.equals("X")) {
                System.out.println("Play 1 Win");
                setStatus(true);
                setWin("Jogador 1 Vencedor. Parabéns!");
            } else {
                if (C1.equals("O") && C2.equals("O") && C3.equals("O")) {
                    System.out.println("Play 2 Win");
                    setStatus(true);
                    setWin("Jogador 2 Vencedor. Parabéns!");
                }
            }
        }
        if (A1 != null && B1 != null && C1 != null) {
            if (A1.equals("X") && B2.equals("X") && C1.equals("X")) {
                System.out.println("Play 1 Win");
                setStatus(true);
                setWin("Jogador 1 Vencedor. Parabéns!");
            } else {
                if (A1.equals("O") && B1.equals("O") && C1.equals("O")) {
                    System.out.println("Play 2 Win");
                    setStatus(true);
                    setWin("Jogador 2 Vencedor. Parabéns!");
                }
            }
        }
        if (A2 != null && B2 != null && C2 != null) {
            if (A2.equals("X") && B2.equals("X") && C2.equals("X")) {
                System.out.println("Play 1 Win");
                setStatus(true);
                setWin("Jogador 1 Vencedor. Parabéns!");
            } else {
                if (A2.equals("O") && B2.equals("O") && C2.equals("O")) {
                    System.out.println("Play 2 Win");
                    setStatus(true);
                    setWin("Jogador 2 Vencedor. Parabéns!");
                }
            }
        }
        if (A3 != null && B3 != null && C3 != null) {
            if (A3.equals("X") && B3.equals("X") && C3.equals("X")) {
                System.out.println("Play 1 Win");
                setStatus(true);
                setWin("Jogador 1 Vencedor. Parabéns!");
            } else {
                if (A3.equals("O") && B3.equals("O") && C3.equals("O")) {
                    System.out.println("Play 2 Win");
                    setStatus(true);
                    setWin("Jogador 2 Vencedor. Parabéns!");
                }
            }
        }
        if (A1 != null && B2 != null && C3 != null) {
            if (A1.equals("X") && B2.equals("X") && C3.equals("X")) {
                System.out.println("Play 1 Win");
                setStatus(true);
                setWin("Jogador 1 Vencedor. Parabéns!");
            } else {
                if (A1.equals("O") && B2.equals("O") && C3.equals("O")) {
                    System.out.println("Play 2 Win");
                    setStatus(true);
                    setWin("Jogador 2 Vencedor. Parabéns!");
                }
            }
        }
        if (A3 != null && B2 != null && C1 != null) {
            if (A3.equals("X") && B2.equals("X") && C1.equals("X")) {
                System.out.println("Play 1 Win");
                setStatus(true);
                setWin("Jogador 1 Vencedor. Parabéns!");
            } else {
                if (A3.equals("O") && B2.equals("O") && C1.equals("O")) {
                    System.out.println("Play 2 Win");
                    setStatus(true);
                    setWin("Jogador 2 Vencedor. Parabéns!");
                }
            }
        }
    }
}
