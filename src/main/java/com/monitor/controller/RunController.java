package com.monitor.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.monitor.pojo.GdAccount;
import com.monitor.pojo.GdSninfo;
import com.monitor.pojo.GdStationError;
import com.monitor.pojo.SjPlantinfo;
import com.monitor.pojo.SjSninfo;
import com.monitor.pojo.SjSninfoField;
import com.monitor.pojo.TbInfo;
import com.monitor.service.IGdSninfoService;
import com.monitor.service.ITbInfoService;
import com.monitor.service.impl.GdSninfoService;
import com.monitor.service.impl.SjService;
import com.monitor.util.HttpTool;
import com.monitor.util.Intime;

@Controller
@RequestMapping("/")
public class RunController {
	@Resource
	private GdSninfoService gdAccountService;
	@Resource
	private IGdSninfoService gdSninfoService;
	@Resource
	private ITbInfoService tbInfoService;
	@Resource
	private SjService sjService;

	@ResponseBody
	// 查询所有账户信息
	@RequestMapping(value = "Test1", method = { RequestMethod.GET })
	public int Test1() {

		Boolean flag = Intime.isBelong();
		System.out.println(flag);

		// TODO Auto-generated method stub
		final long timeInterval = 1000;
		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {
					// ------- code for task to run
					System.out.println("Hello !!");
					// ------- ends here
					try {
						Thread.sleep(timeInterval);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();

		return 1;

	}

	@ResponseBody
	@RequestMapping(value = "RunGd", method = { RequestMethod.GET })
	public List<String> insertError(HttpServletRequest request) {
		// List<String> stationid=gdSninfoService.selectStationid();

		// run in a second
		final long timeInterval = 1000;
		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {

					Boolean flag = Intime.isBelong();

					if (flag) {

						List<String> stationList = gdSninfoService.selectStationid();
						int num1 = stationList.size();

						for (int j = 0; j < num1; j++) {

							List<GdSninfo> stationidlist = gdSninfoService.selectStationidTop(j, 1);

							Iterator stationid2 = stationidlist.iterator();
							while (stationid2.hasNext()) {
								// String stationid3 = (String) stationid2.next();
								GdSninfo gdstationid = (GdSninfo) stationid2.next();
								// 获取account表里的所有数据
								String stationid3 = gdstationid.getStationid();

								JsonParser parser = new JsonParser();
								Gson gson = new Gson();
								// 通过stationId获取电站信息列表地址
								String url2 = "http://www.goodwe-power.com/mobile/GetMyDeviceListById?stationId="
										+ stationid3;
								String jsoninfo2;
								try {
									jsoninfo2 = new HttpTool().sendPost("", url2);

									JsonElement el2 = parser.parse(jsoninfo2);
									JsonArray jsonArray2 = null;
									if (el2.isJsonArray()) {
										jsonArray2 = el2.getAsJsonArray();
									}
									GdStationError field2 = null;
									Iterator it2 = jsonArray2.iterator();
									while (it2.hasNext()) {
										JsonElement e2 = (JsonElement) it2.next();
										field2 = gson.fromJson(e2, GdStationError.class);
										// 获取当前时间戳
										long time = System.currentTimeMillis();
										String nowTimeStamp = String.valueOf(time / 1000);
										// 错误列表接口
										TbInfo gd = new TbInfo();
										gd.setAddtime(nowTimeStamp);
										gd.setStationid(stationid3);
										gd.setInventersn(field2.getInventersn());
										gd.setIdesc("固德威逆变器");
										gd.setPower(field2.getPower());
										gd.setStatus(field2.getStatus());
										gd.setEday(field2.getEday());
										gd.setEtotal(field2.getEtotal());
										gd.setErrormsg(field2.getErrormsg());
										// 错误信息反馈
										tbInfoService.insertInfo(gd);

									}
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

						}
					}
					try {
						Thread.sleep(timeInterval);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/RunSj", method = { RequestMethod.GET })
	public String selectplantdata() {
		// String access_token=sjAccountService.getToken();//这里的返回结果需要解析
		String access_token = "9be9eb38dca04661bfb731a0de8f6b88";

		List<SjPlantinfo> plantlistt = sjService.selectAll();
		// System.out.println(stationList.toString());
		int num1 = plantlistt.size();

		final long timeInterval = 1000;
		Runnable runnable = new Runnable() {
			public void run() {

				while (true) {
					Boolean flag = Intime.isBelong();

					if (flag) {
						for (int j = 0; j < num1; j++) {
							List<SjPlantinfo> plantlist = sjService.selectTop(j, 1);
							Iterator list = plantlist.iterator();

							// 循环账户列表
							while (list.hasNext()) {
								SjPlantinfo sjPlantinfo = (SjPlantinfo) list.next();
								String plant_id = sjPlantinfo.getPlantId();
								String surl = "http://api.saj-solar.com/device/list?page=1&perpage=100&plant_id="
										+ plant_id + "&access_token=" + access_token;
								JsonParser parser = new JsonParser();
								Gson gson = new Gson();
								String jsoninfo;
								try {
									jsoninfo = new HttpTool().sendPost("", surl);
									JsonElement el2 = parser.parse(jsoninfo);
									JsonObject element = el2.getAsJsonObject();
									JsonObject dataJson = element.getAsJsonObject("data");
									JsonArray devicesJson = dataJson.getAsJsonArray("devices");
									JsonArray jsonArray2 = null;
									if (devicesJson.isJsonArray()) {
										jsonArray2 = devicesJson.getAsJsonArray();
									}

									Iterator it2 = jsonArray2.iterator();
									while (it2.hasNext()) {
										JsonElement e2 = (JsonElement) it2.next();
										SjSninfoField field = gson.fromJson(e2, SjSninfoField.class);
										// 插入sn数据到库
										SjSninfo sj = new SjSninfo();
										sj.setDeviceId(field.getDevice_id());
										sj.setDeviceSn(field.getDevice_sn());
										sj.setDtype(field.getDType());
										sj.setEmonth(field.getEMonth());
										sj.setEtoday(field.getEToday());
										sj.setEtotal(field.getETotal());
										sj.setLastUpdateTime(field.getLast_update_time());
										sj.setManufacturer(field.getManufacturer());
										sj.setModel(field.getModel());
										sj.setSyspower(field.getSysPower());
										sj.setType(field.getType());
										sj.setTzone(field.getTZone());
										sj.setUpdatadate(field.getUpdataDate());

										int res = sjService.insert(sj);
										// */
										if (res > 0) {
											TbInfo gd = new TbInfo();
											// 获取当前时间戳
											long time = System.currentTimeMillis();
											String nowTimeStamp = String.valueOf(time / 1000);

											gd.setAddtime(nowTimeStamp);
											gd.setStationid(field.getDevice_id());
											gd.setInventersn(field.getDevice_sn());
											gd.setIdesc("三晶逆变器");
											gd.setPower("0");
											gd.setStatus("Offline");
											gd.setEday(field.getEToday());
											gd.setEtotal(field.getETotal());

											gd.setErrormsg("N/A");

											// 错误信息反馈
											tbInfoService.insertInfo(gd);
										}

									}

								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		return "1";
	}
}