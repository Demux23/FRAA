package presentazione;

import entity.PrenotazioneBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Classe che mostra un frame con i dettagli della prenotazione chiamata dall'impiegato. */
public class MostraPrenotazioneAccettataView {
  private final ImageIcon infermiera = new ImageIcon("src/image/frameIcon.png");
  private JFrame frame = new JFrame();
  private JLabel idPrenotazione = new JLabel();
  private JLabel codicefiscale = new JLabel();
  private JPanel panneloCentrale = new JPanel();

  /**
   * Costruttore frame MostraPrenotazioneAccettata.
   *
   * @param p bean della prenotazione
   */
  public MostraPrenotazioneAccettataView(PrenotazioneBean p) {
    // Settaggi frame
    frame.setTitle("MedQueue");
    frame.setSize(500, 500);
    frame.setResizable(false);
    frame.setLayout(new BorderLayout());
    frame.getContentPane().setBackground(Color.white);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Posiziona il pannello al centro dello schermo
    frame.setIconImage(infermiera.getImage());

    idPrenotazione.setText(Integer.toString(p.getId()));
    codicefiscale.setText(p.getCodiceFiscale());
    idPrenotazione.setAlignmentX(Component.CENTER_ALIGNMENT);
    codicefiscale.setAlignmentX(Component.CENTER_ALIGNMENT);
    idPrenotazione.setFont(
        new Font(idPrenotazione.getFont().getName(), idPrenotazione.getFont().getStyle(), 30));
    codicefiscale.setFont(
        new Font(codicefiscale.getFont().getName(), codicefiscale.getFont().getStyle(), 30));

    panneloCentrale.setLayout(new BoxLayout(panneloCentrale, BoxLayout.Y_AXIS));
    panneloCentrale.add(Box.createRigidArea(new Dimension(0, 150)));
    panneloCentrale.add(idPrenotazione);
    panneloCentrale.add(Box.createRigidArea(new Dimension(0, 50)));
    panneloCentrale.add(codicefiscale);

    frame.add(panneloCentrale, BorderLayout.CENTER);

    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.addWindowListener(
        new WindowAdapter() {

          // chiudere il frame
          @Override
          public void windowClosing(WindowEvent e) {
            frame.dispose();
          }
        });
    frame.setVisible(true);
  }

  /**
   * Restituisce il frame.
   *
   * @return frame
   */
  public JFrame getFrame() {
    return frame;
  }
}
