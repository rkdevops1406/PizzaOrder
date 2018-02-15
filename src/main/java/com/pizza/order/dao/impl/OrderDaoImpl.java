package com.pizza.order.dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.pizza.order.constants.OrderConstants;
import com.pizza.order.dao.OrderDao;
import com.pizza.order.domain.OrderBean;
import com.pizza.order.util.DateUtil;


/**
 * @author pdevaraj
 * Order Dao class
 */
@Repository
public class OrderDaoImpl implements OrderDao {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OrderDaoImpl.class);
	/**
	 * Read the data from the source file.
	 */
	@Override
	public List<OrderBean> readData(String inputFile) throws Exception {
		List<OrderBean> orderList = new ArrayList<>();
		File file = null;

		try {
			file = new File(inputFile);
			Scanner scanner = new Scanner(file);
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String orderStr = scanner.nextLine();
				StringTokenizer st = new StringTokenizer(orderStr, "\t");
				while (st.hasMoreTokens()) {
					OrderBean order = new OrderBean();
					order.setOrderName(st.nextToken());
					order.setOrderTime(Long.valueOf(st.nextToken()));
					orderList.add(order);
				}
			}
			scanner.close();
			Collections.sort(orderList);
		} catch (IOException e) {
			LOGGER.error("Error: "+OrderConstants.FILE_NOT_FOUND + e.getMessage(), e);
			throw e;
		}

		return orderList;
	}
	/**
	 * Write the data to destination file.
	 */
	@Override
	public boolean writeData(List<OrderBean> data, String outputFile)
			throws Exception {
		File file = new File(outputFile);
		FileOutputStream fout = null;
		BufferedWriter bw = null;
		boolean flag = false;
		int rowNo = 0;
		String line = "";
		try {
			StringBuilder output = new StringBuilder();
			output.append(getHeader()).append("\n");
			fout = new FileOutputStream(file);
			bw = new BufferedWriter(new OutputStreamWriter(fout));
			bw.write(getHeader());
			bw.newLine();
			for (OrderBean order : data) {
				line = String
						.format("%-6d\t%-10s\t%-15s", ++rowNo, order
								.getOrderName(), DateUtil
								.convertEpochToUTC(order.getOrderTime() * 1000));
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
			flag = true;
		} catch (Exception e) {
			LOGGER.error("Error:" + e.getMessage(), e);
			throw e;
		} finally {
			bw.close();
			fout.close();
		}
		return flag;
	}

	private String getHeader() {
		return String.format("%6s\t%10s\t%15s", OrderConstants.ORDER_NO,
				OrderConstants.ORDER_NAME, OrderConstants.ORDER_TIME);
	}
}
