package com.cdy.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 验证码Servlet
 * 
 * @author wentao_chang
 * @date 2014-2-19
 */
public class ImageServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1943513256366407786L;
	// 去掉了0和o l和1
	private static char[] disaply = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v',
			'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7', '8', '9' };

	public ImageServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width = 100;
		int height = 30;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			//int x1 = random.nextInt(width);
			//int x2 = random.nextInt(width);
			//int y1 = random.nextInt(height);
			//int y2 = random.nextInt(height);
			//graphics.setColor(Color.RED);
			//graphics.drawLine(x1, y1, x2, y2);
		}
		int inta = random.nextInt(disaply.length);
		int intb = random.nextInt(disaply.length);
		int intc = random.nextInt(disaply.length);
		int intd = random.nextInt(disaply.length);
		String disaplystr = disaply[inta] + " " + disaply[intb] + " "
				+ disaply[intc] + " " + disaply[intd] + "";
		HttpSession session = request.getSession();
		session.setAttribute("cver_code", disaplystr);
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.setFont(new Font("Arial", Font.PLAIN, 25));
		graphics.drawString(disaplystr, 10, 20);
		OutputStream output = response.getOutputStream();
		ImageIO.write(image, "png", output);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
