package nju.software.javaapp.util;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PicUtil {

	private Font font = new Font("宋体", Font.BOLD, 20);// 添加字体的属性设置

	private Graphics2D graphics = null;

	private int fontsize = 0;

	private int x = 0;

	private int y = 0;

	/**
	 * 导入本地图片到缓冲区
	 */
	public BufferedImage loadImageLocal(String imgName) {
		try {
			return ImageIO.read(new File(imgName));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * 导入网络图片到缓冲区
	 */
	public BufferedImage loadImageUrl(String imgName) {
		try {
			URL url = new URL(imgName);
			return ImageIO.read(url);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * 生成新图片到本地
	 */
	public void writeImageLocal(String newImage, BufferedImage img) {
		if (newImage != null && img != null) {
			try {
				File outputfile = new File(newImage);
				ImageIO.write(img, "jpg", outputfile);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * 设定文字的字体等
	 */
	public void setFont(String fontStyle, int fontSize) {
		this.fontsize = fontSize;
		this.font = new Font(fontStyle, Font.PLAIN, fontSize);
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 */
	public BufferedImage modifyImage(BufferedImage img, Object content, int x,
			int y) {
		return modifyImage(img, content, x, y, Color.black);
	}

	public BufferedImage modifyImage(BufferedImage img, Object content, int x,
			int y, Color color) {
		try {
			int w = img.getWidth();
			int h = img.getHeight();
			graphics = img.createGraphics();
			graphics.setBackground(Color.white);
			graphics.setColor(color);// 设置字体颜色
			if (this.font != null)
				graphics.setFont(this.font);
			// 验证输出位置的纵坐标和横坐标
			if (x >= h || y >= w) {
				this.x = h - this.fontsize + 2;
				this.y = w;
			} else {
				this.x = x;
				this.y = y;
			}
			if (content != null) {
				graphics.drawString(content.toString(), this.x, this.y);
			}
			graphics.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（输出多个文本段） xory：true表示将内容在一行中输出；false表示将内容多行输出
	 */
	public BufferedImage modifyImage(BufferedImage img, Object[] contentArr,
			int x, int y, boolean xory) {
		try {
			int w = img.getWidth();
			int h = img.getHeight();
			graphics = img.createGraphics();
			graphics.setBackground(Color.WHITE);
			graphics.setColor(Color.RED);
			if (this.font != null)
				graphics.setFont(this.font);
			// 验证输出位置的纵坐标和横坐标
			if (x >= h || y >= w) {
				this.x = h - this.fontsize + 2;
				this.y = w;
			} else {
				this.x = x;
				this.y = y;
			}
			if (contentArr != null) {
				int arrlen = contentArr.length;
				if (xory) {
					for (int i = 0; i < arrlen; i++) {
						graphics.drawString(contentArr[i].toString(), this.x,
								this.y);
						this.x += contentArr[i].toString().length()
								* this.fontsize / 2 + 5;// 重新计算文本输出位置
					}
				} else {
					for (int i = 0; i < arrlen; i++) {
						graphics.drawString(contentArr[i].toString(), this.x,
								this.y);
						this.y += this.fontsize + 2;// 重新计算文本输出位置
					}
				}
			}
			graphics.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 * 
	 * 时间:2007-10-8
	 * 
	 * @param img
	 * @return
	 */
	public BufferedImage modifyImageYe(BufferedImage img) {

		try {
			int w = img.getWidth();
			int h = img.getHeight();
			graphics = img.createGraphics();
			graphics.setBackground(Color.WHITE);
			graphics.setColor(Color.blue);// 设置字体颜色
			if (this.font != null)
				graphics.setFont(this.font);
			graphics.drawString("www.hi.baidu.com?xia_mingjian", w - 85, h - 5);
			graphics.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

	public BufferedImage modifyImagetogeter(BufferedImage content,
			BufferedImage backgroud) {
		try {
			int w = content.getWidth();
			int h = content.getHeight();

			graphics = backgroud.createGraphics();
			graphics.drawImage(content, 50, 50, w, h, null);
			graphics.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return backgroud;
	}

	public static void main(String[] args) {

		PicUtil picUtil = new PicUtil();

		BufferedImage bufferedImage = picUtil.loadImageLocal("D:/template.jpg");
		// BufferedImage b = tt
		// .loadImageLocal("E:\\文件(word,excel,pdf,ppt.txt)\\zte-logo.png");
		// 往图片上写文件

		picUtil.modifyImage(bufferedImage, "陪审员", 30, 130);
		picUtil.modifyImage(bufferedImage, "高爱民", 30, 230, Color.gray);

		BufferedImage bufferedImage2 = picUtil
				.loadImageLocal("D:/IMG_0024.JPG");

		Image big = bufferedImage2.getScaledInstance(256, 256,
				Image.SCALE_DEFAULT);

		picUtil.modifyImagetogeter(bufferedImage2, bufferedImage);

		picUtil.writeImageLocal("D:/cc.jpg", bufferedImage);
		// 将多张图片合在一起
		new PhotoFrame(bufferedImage);

		System.out.println("success");
	}
}
