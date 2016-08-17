/**
 * Project Name:poi-demo
 * File Created at Aug 17, 2016
 *
*/

package cn.liuzhiping.poi.demo;

import java.io.Closeable;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {add comment} <br/>
 * Date: Aug 17, 2016 <br/>
 * 
 * @author jepson.liu
 * @version 1.0
 * @since 1.0
 */
public class Util {
	private static final Logger logger = LoggerFactory.getLogger(Util.class);

	/**
	 * 
	 * 获取当前日期
	 * 
	 * @return Date[YYYYMMDDHHmmSS]
	 */
	public static final String getCurrentDateStr() {
		SimpleDateFormat sf = new SimpleDateFormat("YYYYMMddHHmmss");
		return sf.format(new Date());
	}
	public static final void close(Closeable... ios) {
		for (Closeable io : ios) {
			if (null != io) {
				try {
					io.close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(getCurrentDateStr());
	}
}
