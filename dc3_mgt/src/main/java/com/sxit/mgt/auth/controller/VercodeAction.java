package com.sxit.mgt.auth.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxit.common.action.BaseAction;

/**
 * @公司:深讯信科
 * @功能:登录 Action
 * @作者:张如兵
 * @日期:2015-03-02 15:50:48
 * @版本:1.0
 * @修改:
 */

@Controller
@RequestMapping("/auth")
public class VercodeAction extends BaseAction {

	private static final HttpHeaders HTTP_HEADERS;
	private static final Random random;
	static {
		HTTP_HEADERS = new HttpHeaders();
		HTTP_HEADERS.set("Pragma", "No-cache");
		HTTP_HEADERS.set("Cache-Control", "No-cache");
		HTTP_HEADERS.setDate("Expires", 0);
		HTTP_HEADERS.setContentType(MediaType.IMAGE_JPEG);
		random = new Random();
	}

	/**
	 * 验证码
	 * 
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/random.jpeg")
	public ResponseEntity<byte[]> random(HttpSession session)
			throws IOException {

		BufferedImage image = new BufferedImage(80, 30,
				BufferedImage.TYPE_3BYTE_BGR);
		Font font = new Font("Arial", Font.PLAIN, 24);
		int distance = 18;
		Graphics d = image.getGraphics();
		d.setColor(Color.WHITE);
		d.fillRect(0, 0, image.getWidth(), image.getHeight());
		d.setColor(new Color(random.nextInt(100) + 100,
				random.nextInt(100) + 100, random.nextInt(100) + 100));
		for (int i = 0; i < 10; i++) {
			d.drawLine(random.nextInt(image.getWidth()),
					random.nextInt(image.getHeight()),
					random.nextInt(image.getWidth()),
					random.nextInt(image.getHeight()));
		}
		d.setColor(Color.BLACK);
		d.setFont(font);
		String checkCode = "";
		char tmp;
		int x = -distance;
		int show = 4;
		String str = "23456789abxrcdefhkmnp";
		for (int i = 0; i < show; i++) {
			tmp = str.charAt(random.nextInt(str.length() - 1));
			checkCode = checkCode + tmp;
			x = x + distance;
			d.setColor(new Color(random.nextInt(100) + 50,
					random.nextInt(100) + 50, random.nextInt(100) + 50));
			d.drawString(tmp + "", x,
					random.nextInt(image.getHeight() - (font.getSize()))
							+ (font.getSize()));
		}
		d.dispose();

		this.set("random", checkCode);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ImageIO.write(image, "JPEG", out);
		try {
			return new ResponseEntity<byte[]>(out.toByteArray(), HTTP_HEADERS,HttpStatus.OK);
		} finally {
			IOUtils.closeQuietly(out);
		}
	}
}
