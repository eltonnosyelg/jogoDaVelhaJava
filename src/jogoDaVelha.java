import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.*;


public class jogoDaVelha extends JFrame{
    ImageIcon iconCirculo = new ImageIcon(getClass() .getResource("logocirculo.jpeg"));
    ImageIcon iconX = new ImageIcon(getClass() .getResource("xlogo.jpeg"));

    JPanel pTela = new JPanel(new GridLayout(3,3,10,10));
    Bloco[] blocos = new Bloco[9];

    int rodadas = 0;
    final int JOGADOR_1 = 1;
    final int JOGADOR_2 = 2;

    int jogadorVez = JOGADOR_1;

    JLabel lInformacao = new JLabel("Jogador "+JOGADOR_1);
    public jogoDaVelha() {
        configurarJanela();
        configurarTela();
    }
    public void configurarTela() {
        add(BorderLayout.CENTER, pTela);
        add(BorderLayout.NORTH, lInformacao);
        pTela.setBackground(Color.BLACK);
        lInformacao.setFont((new Font("Arial",Font.BOLD,25)));
        lInformacao.setForeground(new Color(50,200,50));
        lInformacao.setHorizontalAlignment(SwingConstants.CENTER);

        for(int i = 0; i < 9;i++) {
            Bloco bloco = new Bloco();
            blocos[i] = bloco;
            pTela.add(bloco);
        }
    }
    public void mudarVez() {
        if(jogadorVez==1) {
            jogadorVez=2;
            lInformacao.setText("Jogador 2");
            lInformacao.setForeground(Color.RED);
        }else{
            jogadorVez=1;
            lInformacao.setText("Jogador 1");
            lInformacao.setForeground(new Color(50,200,50));
        }
    }
    public boolean testarVitoria(int jog) {
        if(blocos[0].quem==jog && blocos[1].quem==jog && blocos[2].quem==jog) {
            return true;
        }
        if(blocos[3].quem==jog && blocos[4].quem==jog && blocos[5].quem==jog) {
            return true;
        }
        if(blocos[6].quem==jog && blocos[7].quem==jog && blocos[8].quem==jog) {
            return true;
        }if(blocos[0].quem==jog && blocos[3].quem==jog && blocos[6].quem==jog) {
            return true;
        }
        if(blocos[1].quem==jog && blocos[4].quem==jog && blocos[7].quem==jog) {
            return true;
        }
        if(blocos[2].quem==jog && blocos[5].quem==jog && blocos[8].quem==jog) {
            return true;
        }
        if(blocos[0].quem==jog && blocos[4].quem==jog && blocos[8].quem==jog) {
            return true;
        }
        if(blocos[6].quem==jog && blocos[4].quem==jog && blocos[2].quem==jog) {
            return true;
        }
        return false;
    }
    public void configurarJanela() {
        setTitle("JOGO DA VELHA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args){
        new jogoDaVelha();
    }
    public class Bloco extends JButton{
        int quem = 0;
        public Bloco(){
            setBackground(Color.WHITE);
            addActionListener(e->{
                if (quem == 0) {
                    if(jogadorVez==JOGADOR_1){
                        setIcon(iconCirculo);
                        quem = JOGADOR_1;
                    }else{
                        setIcon(iconX);
                        quem = JOGADOR_2;
                    }
                    if(testarVitoria(quem)) {
                        JOptionPane.showMessageDialog(null, "Jogador "+quem+" Venceu!");
                        System.exit(0);
                    }
                    rodadas++;
                    if(rodadas==9) {
                        JOptionPane.showMessageDialog(null, "Ninguem Venceu!");
                        System.exit(0);
                    }
                    mudarVez();
                }
            });
        }
    }
}
