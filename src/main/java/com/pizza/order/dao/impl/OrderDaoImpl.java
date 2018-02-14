package com.pizza.order.dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.pizza.order.constants.OrderConstants;
import com.pizza.order.dao.OrderDao;
import com.pizza.order.domain.OrderBean;
import com.pizza.order.util.DateUtil;
@Repository
/**
 * @author pdevaraj
 */
public class OrderDaoImpl implements OrderDao {
	@Resource
	Environment env;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OrderDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderBean> readData() {
		List<OrderBean> orderList = new ArrayList<OrderBean>();
		try {
			File file = new File(OrderConstants.INPUT_FILE);
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
		} catch (Exception e) {
			LOGGER.error("Error:", e);
		}
		Collections.sort(orderList);
		return orderList;
	}

	@Override
	public boolean writeData(List<OrderBean> data) {
		File file = new File(OrderConstants.OUTPUT_FILE);
		FileOutputStream fout = null;
		int rowNo = 0;
		String line = "";
		try {
			StringBuilder output = new StringBuilder();
			output.append(getHeader()).append("\n");
			fout = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fout));
			bw.write(getHeader());
			bw.newLine();
			for (OrderBean order : data) {
				line = String.format("%-6d\t%-10s\t%-15s", ++rowNo, order
								.getOrderName(), DateUtil
								.convertEpochToUTC(order.getOrderTime() * 1000));
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
			bw.close();
			fout.close();
		} catch (Exception e) {
			LOGGER.error("Error:", e);
			return false;
		}
		return true;
	}
	private String getHeader() {
		return String.format("%6s\t%10s\t%15s", "Order#", "Order Name",	"Order Time");
	}
}
