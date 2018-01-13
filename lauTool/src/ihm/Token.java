package ihm;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.File;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

import app.Env;
import outils.images.ImageJdr;

public abstract class Token extends JInternalFrame {
	private static final long serialVersionUID = 338578916173833956L;

	protected	JPanel		panel;
	protected	ImageJdr	imageToken;
	
	protected	Boolean		highlight;
	protected	Color		token_color;
	
	protected 	Point		origine;


	public Token(String nom, String nomFichierImage) {
		super();
		
		this.imageToken		= new ImageJdr(nom, Env.rep_tokens + File.separator + nomFichierImage + Env.token_image_size + "x" + Env.token_image_size + ".png");
		this.highlight		= false;
		
		this.setTokenColor();
		
		setIconifiable(false);
		setClosable(false);
		setMaximizable(false);
		setResizable(false);
		setOpaque(false);

		javax.swing.plaf.InternalFrameUI ui	= this.getUI();
		((javax.swing.plaf.basic.BasicInternalFrameUI)ui).setNorthPane(null);
		
		gereComportement();
	}
	
	public abstract void setTokenColor();

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
		highlight	= false;
		MouseAdapter adapterMouse = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//System.out.println("mousePressed");
				
				// ---------------------------------------------
				// MENU CONTEXTUEL (CLIC DROIT)
				// ---------------------------------------------

				// ---------------------------------------------
				// INFORMATIONS EN BAS (CLIC GAUCHE)
				// ---------------------------------------------

				// ---------------------------------------------
				// DEPLACEMENT
				// ---------------------------------------------
				// On récupère la position du composant dans le parent
				Point p = e.getComponent().getLocation();
				// On récupère la position de la souris à l'écran
				Point s = e.getLocationOnScreen();
				// On calcule un point d'origine par rapport à ces deux infos :
				origine = new Point(p.x - s.x, p.y - s.y);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				//System.out.println("mouseReleased");
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				//System.out.println("mouseDragged");

				// DEPLACEMENT
				if (origine != null) {
					if(!e.isControlDown()) {
						Point p = e.getLocationOnScreen();
						e.getComponent().setLocation(origine.x + p.x, origine.y + p.y);
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				//System.out.println("mouseEntered");
				highlight		= true;
				repaint();
			}
			public void mouseExited(MouseEvent e) {
				//System.out.println("mouseExited");
				highlight		= false;
				repaint();
			}
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				//System.out.println("mouseWheelMoved");
			}
		};
		this.addMouseListener(adapterMouse);
		this.addMouseMotionListener(adapterMouse);
	}
}
