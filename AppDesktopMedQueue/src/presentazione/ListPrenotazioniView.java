package presentazione;

import business.PrenotazioneBean;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListPrenotazioniView {
    private ArrayList<PrenotazioneBean> prenotazioni=new ArrayList<PrenotazioneBean>();
    private JFrame frame=new JFrame();
    private JLabel frase=new JLabel("Prenotazioni da servire");


    public static void main(String[] args){
        new ListPrenotazioniView().visible(true);
    }


    public ListPrenotazioniView(){

        frame.setTitle("MedQueue");
        frame.setSize(600,400);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground( Color.white );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        ImageIcon immagine = new ImageIcon("src/image/LogoNoBG.png");
        Image image = immagine.getImage();
        Image newimg = image.getScaledInstance(100, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        immagine = new ImageIcon(newimg);
        ImageIcon infermiera = new ImageIcon("src/image/frameIcon.png");


        PrenotazioneBean p1=new PrenotazioneBean(1,"data","tempo",true,"codicefiscale 1",1,1);
        PrenotazioneBean p2=new PrenotazioneBean(2,"data","tempo",true,"codicefiscale 2",1,1);

        frase.setFont(new Font(frase.getFont().getName(), frase.getFont().getStyle(), 20));
        JPanel pannelloNord=new JPanel();
        pannelloNord.setLayout(new BoxLayout(pannelloNord, BoxLayout.X_AXIS));
        pannelloNord.add(Box.createRigidArea(new Dimension(10,0)));
        pannelloNord.add( new JLabel(immagine));
        pannelloNord.add(Box.createRigidArea(new Dimension(100,0)));
        pannelloNord.add(frase);

        JPanel pannelloCentrale=new JPanel();
        pannelloCentrale.setLayout(new BoxLayout(pannelloCentrale, BoxLayout.X_AXIS));
        pannelloCentrale.add(Box.createRigidArea(new Dimension(30,0)));
        pannelloCentrale.add(bloccoPrenotazione(p1));
        pannelloCentrale.add(Box.createRigidArea(new Dimension(30,0)));
        pannelloCentrale.add(bloccoPrenotazione(p2));
        frame.add(pannelloNord,BorderLayout.NORTH);
        frame.add(pannelloCentrale,BorderLayout.CENTER);
        frame.setIconImage(infermiera.getImage());
    }

    public JPanel bloccoPrenotazione(PrenotazioneBean prenotazione){
        JPanel blocco=new JPanel(new GridLayout(2,1));
        blocco.setMaximumSize(new Dimension(100,100));
        JLabel idPrenotazione= new JLabel(Integer.toString(prenotazione.getId()));
        JLabel codiceFiscale=new JLabel(prenotazione.getCodicefiscale());
        idPrenotazione.setHorizontalAlignment(JLabel.CENTER);
        idPrenotazione.setFont(new Font(frase.getFont().getName(), frase.getFont().getStyle(), 30));
        codiceFiscale.setHorizontalAlignment(JLabel.CENTER);
        codiceFiscale.setFont(new Font(frase.getFont().getName(), frase.getFont().getStyle(), 10));
        blocco.add(idPrenotazione);
        blocco.add(codiceFiscale);
        blocco.setOpaque(true);
        blocco.setBackground(Color.ORANGE);
        return blocco;
    }


    public void setPrenotazioni(ArrayList<PrenotazioneBean> p){
        prenotazioni=p;

    }

    public void visible(boolean v){
        frame.setVisible(v);
    }
}
