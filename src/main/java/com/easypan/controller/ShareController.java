package com.easypan.controller;

import java.util.List;

import com.easypan.annotation.GlobalInterceptor;
import com.easypan.annotation.VerifyParam;
import com.easypan.entity.dto.SessionWebUserDto;
import com.easypan.entity.query.FileShareQuery;
import com.easypan.entity.po.FileShare;
import com.easypan.entity.vo.PaginationResultVO;
import com.easypan.entity.vo.ResponseVO;
import com.easypan.service.FileShareService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 分享信息 Controller
 */
@RestController("shareController")
@RequestMapping("/share")
public class ShareController extends ABaseController{

	@Resource
	private FileShareService fileShareService;

	@RequestMapping("/loadShareList")
	@GlobalInterceptor
	public ResponseVO loadShareList(HttpSession session, FileShareQuery query){
		query.setOrderBy("share_time desc");
		SessionWebUserDto webUserDto = getUserInfoFromSession(session);
		query.setUserId(webUserDto.getUserId());
		query.setQueryFileName(true);
		PaginationResultVO result = fileShareService.findListByPage(query);

		return getSuccessResponseVO(result);
	}

	@RequestMapping("/shareFile")
	@GlobalInterceptor
	public ResponseVO shareFile(HttpSession session,
								@VerifyParam(required = true) String fileId,
								@VerifyParam(required = true) Integer validType,
								String code){
		SessionWebUserDto webUserDto = getUserInfoFromSession(session);
		FileShare share = new FileShare();
		share.setFileId(fileId);
		share.setUserId(webUserDto.getUserId());
		share.setValidType(validType);
		share.setCode(code);
		fileShareService.saveShare(share);

		return getSuccessResponseVO(share);
	}

	@RequestMapping("/cancelShare")
	@GlobalInterceptor(checkParams = true)
	public ResponseVO cancelShare(HttpSession session, @VerifyParam(required = true) String shareIds) {
		SessionWebUserDto userDto = getUserInfoFromSession(session);
		fileShareService.deleteFileShareBatch(shareIds.split(","), userDto.getUserId());
		return getSuccessResponseVO(null);
	}


}