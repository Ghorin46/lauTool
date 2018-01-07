package ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JInternalFrame;

public class Token extends JInternalFrame {
	private static final long serialVersionUID = 338578916173833956L;

	public Token() {
		super();
		
		setIconifiable(false);
		setClosable(false);
		setMaximizable(false);
		setResizable(false);
		setOpaque(false);

		javax.swing.plaf.InternalFrameUI ui	= this.getUI();
		((javax.swing.plaf.basic.BasicInternalFrameUI)ui).setNorthPane(null);
		
		gereComportement();
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
