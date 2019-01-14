package com.chaoxing.gsd.web;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chaoxing.gsd.modules.entity.LiteratureCompDetail;
import com.chaoxing.gsd.modules.service.LiteratureCompService;
import com.chaoxing.gsd.web.res.BaseResponse;
/**
 * 文献对比入口
 * @author winsl
 *
 */
@Controller
@RequestMapping("/gsd")
public class LiteratureCompController {

	@Autowired
	private LiteratureCompService literatureCompService;
	
	/**
	 * 创建对比标签
	 * @param userid
	 * @param labelname
	 * @return
	 */
	@POST
    @RequestMapping("/createLabel")
    @ResponseBody
    public BaseResponse createLabel(@RequestParam(value = "userid", required = true) String userid,
                                       @RequestParam(value = "labelname", required = true) String labelname){
		BaseResponse rsp = literatureCompService.createLabel(labelname, userid);
        return rsp;
    }
	
	@DELETE
    @RequestMapping("/deleteLabel")
    @ResponseBody
    public BaseResponse deleteLabel(@RequestParam(value = "labelid", required = true) Integer labelid){
		BaseResponse rsp = literatureCompService.deleteLabel(labelid);
        return rsp;
    }
	
	@PUT
    @RequestMapping("/updateLabel")
    @ResponseBody
    public BaseResponse updateLabel(@RequestParam(value = "labelid", required = true) Integer labelid,
                                       @RequestParam(value = "labelname", required = true) String labelname){
		BaseResponse rsp = literatureCompService.updateLabel(labelid, labelname);
        return rsp;
    }
	
	@GET
    @RequestMapping("/queryLabels")
    @ResponseBody
    public BaseResponse queryLabels(@RequestParam(value = "userid", required = true) String userid){
		BaseResponse rsp = literatureCompService.queryLabels(userid);
        return rsp;
    }
	
	@POST
    @RequestMapping("/insertDetails")
    @ResponseBody
    public BaseResponse insertDetails(@RequestBody List<LiteratureCompDetail> data){
		BaseResponse rsp = new BaseResponse();
		if(null != data)
		{
			rsp = literatureCompService.insertDetails(data);
		}
		else
		{
			rsp.setStatu(false);
			rsp.setMsg("your input parameter is wrong, please check!!!");
		}
        return rsp;
    }
	
	@POST
    @RequestMapping("/updateLabelShowSetting")
    @ResponseBody
    public BaseResponse updateLabelShowSetting(@RequestParam(value = "labelid", required = true) Integer labelid,
                                       @RequestParam(value = "filedsnamecn", required = false) String filedsnamecn, 
                                       @RequestParam(value = "filedids", required = false) String filedids){
		BaseResponse rsp = literatureCompService.updateLabelShowSetting(labelid, filedsnamecn, filedids);
        return rsp;
    }
	
	@DELETE
    @RequestMapping("/deleteDetails")
    @ResponseBody
    public BaseResponse deleteDetails(@RequestBody List<LiteratureCompDetail> data){
		BaseResponse rsp = new BaseResponse();
		if(null != data)
		{
			rsp = literatureCompService.deleteDetails(data);
		}
		else
		{
			rsp.setStatu(false);
			rsp.setMsg("your input parameter is wrong, please check!!!");
		}
        return rsp;
    }
	
	@GET
    @RequestMapping("/queryDetails")
    @ResponseBody
    public BaseResponse queryDetails(@RequestParam(value = "labelid", required = true) Integer labelid){
		BaseResponse rsp = literatureCompService.queryDetails(labelid);
        return rsp;
    }
}
