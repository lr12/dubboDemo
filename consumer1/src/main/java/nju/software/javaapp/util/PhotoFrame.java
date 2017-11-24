package nju.software.javaapp.util;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class PhotoFrame extends JFrame {

	private static final long serialVersionUID = -2216276219179107707L;
	private Container con;

	private ZPanel zPanel = new ZPanel();
	private JScrollPane imgSp;

	public PhotoFrame(String photoPath) {
		zPanel.setImagePath(photoPath);
		finalSetting();
	}

	public PhotoFrame(Image image) {
		zPanel.setImage(image);
		finalSetting();
	}

	private void finalSetting() {
		zPanel.setPreferredSize(new Dimension(zPanel.getImgWidth(), zPanel
				.getImgHeight()));

		imgSp = new JScrollPane();
		imgSp.setViewportView(zPanel);
		// imgSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		// imgSp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		con = getContentPane();
		con.add(imgSp, BorderLayout.CENTER);

		setTitle("ZakiSoft ZFileRenamerV0.2");

		// Image image = Toolkit.getDefaultToolkit().getImage(
		// this.getClass().getResource("/title.gif"));
		// setIconImage(image);

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		int frameH = getHeight();
		int frameW = getWidth();
		setLocation((screenWidth - frameW) / 2 - 250,
				(screenHeight - frameH) / 2 - 250);
		System.out.println(zPanel.getImgWidth() + "," + zPanel.getImgHeight());
		setSize(zPanel.getImgWidth() + 5, zPanel.getImgHeight() + 5);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
