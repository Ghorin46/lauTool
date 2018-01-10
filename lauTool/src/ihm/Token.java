package ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.File;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

import app.Env;
import outils.images.ImageJdr;

public class Token extends JInternalFrame {
	private static final long serialVersionUID = 338578916173833956L;

	protected	JPanel		panel;
	protected	ImageJdr	imageToken;
	

	public Token(String nom, String nomFichierImage) {
		super();
		
		this.imageToken		= new ImageJdr(nom, Env.rep_tokens + File.separator + nomFichierImage);
		
		setIconifiable(false);
		setClosable(false);
		setMaximizable(false);
		setResizable(false);
		setOpaque(false);

		javax.swing.plaf.InternalFrameUI ui	= this.getUI();
		((javax.swing.plaf.basic.BasicInternalFrameUI)ui).setNorthPane(null);
		
		gereComportement();
	}
	
	
	public ImageJdr getImageToken() {
		return imageToken;
	}
	public void setImageToken(ImageJdr imageToken) {
		this.imageToken = imageToken;
	}


	protected void afficheInfosDebut() {
		panel = new JPanel();
		panel.setLayout(null);
	}
	protected void afficheInfosFin() {
		setContentPane(panel);
		
		ToolTipManager.sharedInstance().setInitialDelay(0);
		ToolTipManager.sharedInstance().setDismissDelay(8000);
	}

 	private void gereComportement() {
		MouseAdapter adapterMouse = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("mousePressed");
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("mouseReleased");
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("mouseDragged");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("mouseEntered");
				repaint();
			}
			public void mouseExited(MouseEvent e) {
				System.out.println("mouseExited");
				repaint();
			}
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
//				super.mouseWheelMoved(e);
				System.out.println("mouseWheelMoved");
			}
		};
		this.addMouseListener(adapterMouse);
		this.addMouseMotionListener(adapterMouse);
	}
}
