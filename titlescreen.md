package title;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class GUI {
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI().createAndShowGUI());
    }
 
    public void createAndShowGUI() {
        // Main frame setup
        JFrame frame = new JFrame("NEBULA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
 
        TitlePanel panel = new TitlePanel(frame);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
 
    // === TITLE PAGE ===
    class TitlePanel extends JPanel implements ActionListener {
 
        private Timer timer;
        private JButton startButton, howToPlayButton, quitButton;
        private JFrame frame;
 
        public TitlePanel(JFrame frame) {
            this.frame = frame;
            setLayout(null);
            setBackground(Color.BLACK);
 
            // buttons sa title page
            startButton = createButton("START");
            howToPlayButton = createButton("HOW TO PLAY");
            quitButton = createButton("QUIT");
 
            add(startButton);
            add(howToPlayButton);
            add(quitButton);
 
            // Kung mo-resize ang window, automatic re-center sa mga buttons
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    centerComponents();
                }
            });
 
            // Button actions para ika click mo lahus sa next action
            startButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Starting...")); //SEAN IKAW LAN BAHALA SUMPAY ARI SA GAMEE SA START BUTTON :)
            howToPlayButton.addActionListener(e -> goToHowToPlayPage());
            quitButton.addActionListener(e -> System.exit(0));
 
            // Timer para i-refresh ang mga starts para mo sidlak sidlak sila
            timer = new Timer(100, this);
            timer.start();
        }
 
        private JButton createButton(String text) {
            // Method para create ug uniform and neat ang style sa mga buttons para same sila tanan
            JButton button = new JButton(text);
            button.setFocusPainted(false);
            button.setFont(new Font("Monospaced", Font.BOLD, 30));
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            button.setSize(300, 60);
            return button;
        }
 
        private void centerComponents() {
            // Function para i-center ang mga buttons sa tunga
            int panelWidth = getWidth();
            int panelHeight = getHeight();
 
            int buttonWidth = startButton.getWidth();
            int x = (panelWidth - buttonWidth) / 2;
            int yStart = (panelHeight - 200) / 2;
 
            startButton.setLocation(x, yStart);
            howToPlayButton.setLocation(x, yStart + 80);
            quitButton.setLocation(x, yStart + 160);
        }
 
        private void goToHowToPlayPage() {
            // Kung i-click ang “How to Play” mo-move to next page which is naa didtu mga info sa duwa :)
            HowToPlayPanel nextPage = new HowToPlayPanel(frame);
            frame.setContentPane(nextPage);
            frame.revalidate();
            frame.repaint();
            nextPage.requestFocusInWindow();
        }
 
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
 
            // Drawing sa mga bituon sa background pattern
            for (int i = 0; i < 150; i++) {
                int x = (int) (Math.random() * getWidth());
                int y = (int) (Math.random() * getHeight());
                g.fillRect(x, y, 2, 2);
            }
 
            // Drawing sa title text and mga fonts niya
            g.setFont(new Font("Monospaced", Font.BOLD, 100));
            FontMetrics fm = g.getFontMetrics();
            String title = "C.O.U.R.S.E";
            int x = (getWidth() - fm.stringWidth(title)) / 2;
            int y = 150;
            g.drawString(title, x, y);
 
            centerComponents();
        }
 
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint(); // Para mu-refresh ang stars animation
        }
    }
 
   
}
 
