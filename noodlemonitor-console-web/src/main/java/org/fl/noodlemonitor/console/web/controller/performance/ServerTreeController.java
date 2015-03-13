package org.fl.noodlemonitor.console.web.controller.performance;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.fl.noodle.common.connect.expand.monitor.constent.ModuleType;
import org.fl.noodle.common.connect.expand.monitor.constent.MonitorType;
import org.fl.noodle.common.mvc.annotation.NoodleResponseBody;
import org.fl.noodlemonitor.console.web.persistence.BuildTree;

@Controller
@RequestMapping(value = "monitor/server/tree")
public class ServerTreeController {
	
	@RequestMapping(value = "/querynull")
	@NoodleResponseBody
	public List<TreeVo> queryNull() throws Exception {
		List<TreeVo> treeVoList = new ArrayList<TreeVo>();
		return treeVoList;
	}
	
	@RequestMapping(value = "/queryservicelist")
	@NoodleResponseBody
	public List<TreeVo> queryServiceList(String queryInfo) throws Exception {
		
		List<TreeVo> treeVoList = new ArrayList<TreeVo>();
		
		String serviceName = null;
		if (queryInfo != null && !queryInfo.equals("")) {
			String[] queryInfos = queryInfo.split("\\.");
			if (queryInfos.length > 0) {
				serviceName = queryInfos[0];
			}
		}
		Set<String> serviceSet = BuildTree.ipMap.keySet();
		for (String serviceNameIt : serviceSet) {
			if (serviceName == null) {
				TreeVo treeVo = new TreeVo();
				treeVo.setId(serviceNameIt);
				treeVo.setLabel(serviceNameIt);
				treeVo.setPid(MonitorType.CONNECT.getCode());
				treeVo.setUrl("monitor/server/tree/queryserverlist");
				treeVoList.add(treeVo);
			} else {
				if (serviceNameIt.toUpperCase().contains(serviceName.toUpperCase())) {
					TreeVo treeVo = new TreeVo();
					treeVo.setId(serviceNameIt);
					treeVo.setLabel(serviceNameIt);
					treeVo.setPid(MonitorType.CONNECT.getCode());
					treeVo.setUrl("monitor/server/tree/queryserverlist");
					treeVoList.add(treeVo);
				}
			}
		}
		
		return treeVoList;
	}
	
	@RequestMapping(value = "/queryserverlist")
	@NoodleResponseBody
	public List<TreeVo> queryMethodList(String pid) throws Exception {
		
		List<TreeVo> treeVoList = new ArrayList<TreeVo>();
		Set<String> ipSet = BuildTree.ipMap.get(pid);
		if (ipSet != null) {
			for (String ip : ipSet) {
				TreeVo treeVo = new TreeVo();
				treeVo.setId(ip);
				treeVo.setLabel(ip);
				treeVo.setPid(pid);
				treeVo.setUrl("monitor/server/tree/querymethodlist");
				treeVoList.add(treeVo);
			}
		}
		
		return treeVoList;
	}
	
	@RequestMapping(value = "/querymethodlist")
	@NoodleResponseBody
	public List<TreeVo> queryMethodList(String queryInfo, String pid, String ppid) throws Exception {
		
		List<TreeVo> treeVoList = new ArrayList<TreeVo>();
		
		String methodName = null;
		if (queryInfo != null && !queryInfo.equals("")) {
			String[] queryInfos = queryInfo.split("\\.");
			if (queryInfos.length > 1) {
				methodName = queryInfos[1];
			}
		}
		
		Set<String> methodSet = BuildTree.methodMap.get(ppid);
		for (String methodNameIt : methodSet) {
			if (methodName == null) {
				TreeVo treeVo = new TreeVo();
				treeVo.setId(methodNameIt);
				treeVo.setLabel(methodNameIt);
				treeVo.setPid(pid);
				treeVo.setOther(ModuleType.SERVER.getCode());
				treeVo.setUrl("monitor/server/tree/querynull");
				treeVo.setEnableHighlight("true");
				treeVo.setLoad("true");
				treeVoList.add(treeVo);
			} else {
				if (methodNameIt.toUpperCase().contains(methodName.toUpperCase())) {
					TreeVo treeVo = new TreeVo();
					treeVo.setId(methodNameIt);
					treeVo.setLabel(methodNameIt);
					treeVo.setPid(pid);
					treeVo.setOther(ModuleType.SERVER.getCode());
					treeVo.setUrl("monitor/server/tree/querynull");
					treeVo.setEnableHighlight("true");
					treeVo.setLoad("true");
					treeVoList.add(treeVo);
				}
			}
		}
		
		return treeVoList;
	}
}
