package com.easypan.controller;

import com.easypan.annotation.GlobalInterceptor;
import com.easypan.annotation.VerifyParam;
import com.easypan.entity.dto.SessionWebUserDto;
import com.easypan.entity.dto.UploadResultDto;
import com.easypan.entity.enums.FileCategoryEnums;
import com.easypan.entity.enums.FileDelFlagEnums;
import com.easypan.entity.enums.FileFolderTypeEnums;
import com.easypan.entity.po.FileInfo;
import com.easypan.entity.query.FileInfoQuery;
import com.easypan.entity.vo.FileInfoVO;
import com.easypan.entity.vo.PaginationResultVO;
import com.easypan.entity.vo.ResponseVO;
import com.easypan.service.FileInfoService;
import com.easypan.utils.CopyTools;
import com.easypan.utils.StringTools;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

/**
 * 文件信息表 Controller
 */
@RestController("fileInfoController")
@RequestMapping("/file")
public class FileInfoController extends CommonFileController{

	@Resource
	private FileInfoService fileInfoService;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	@GlobalInterceptor(checkParams = true)
	public ResponseVO loadDataList(HttpSession session, FileInfoQuery query, String category) {
		FileCategoryEnums categoryEnum = FileCategoryEnums.getByCode(category);
		if (null != categoryEnum) {
			query.setFileCategory(categoryEnum.getCategory());
		}
		query.setUserId(getUserInfoFromSession(session).getUserId());
		query.setOrderBy("last_update_time desc");
		query.setDelFlag(FileDelFlagEnums.USING.getFlag());
		PaginationResultVO result = fileInfoService.findListByPage(query);
		return getSuccessResponseVO(convert2PaginationVO(result, FileInfoVO.class));
	}

	@RequestMapping("/uploadFile")
	@GlobalInterceptor(checkParams = true)
	public ResponseVO uploadFile(HttpSession session,
								 String fileId,
								 MultipartFile file,
								 @VerifyParam(required = true) String fileName,
								 @VerifyParam(required = true) String filePid,
								 @VerifyParam(required = true) String fileMd5,
								 @VerifyParam(required = true) Integer chunkIndex,
								 @VerifyParam(required = true) Integer chunks,
								 FileInfoQuery query, String category){

		SessionWebUserDto webUserDto = getUserInfoFromSession(session);

		UploadResultDto resultDto = fileInfoService.uploadFile(webUserDto, fileId, file, fileName,
				filePid, fileMd5, chunkIndex, chunks);
		return getSuccessResponseVO(resultDto);
	}



	@RequestMapping("/getImage/{imageFolder}/{imageName}")
	public void getImage(HttpServletResponse response, @PathVariable("imageFolder") String imageFolder,
						 @PathVariable("imageName") String imageName){
		super.getImage(response, imageFolder, imageName);
	}

	@RequestMapping("/ts/getVideoInfo/{fileId}")
	@GlobalInterceptor
	public void getVideoInfo(HttpSession session,HttpServletResponse response, @PathVariable("fileId") String fileId){
		SessionWebUserDto webUserDto = getUserInfoFromSession(session);
		super.getFile(response, fileId, webUserDto.getUserId());
	}


	@RequestMapping("/getFile/{fileId}")
	@GlobalInterceptor
	public void getFile(HttpSession session,HttpServletResponse response, @PathVariable("fileId") String fileId){
		SessionWebUserDto webUserDto = getUserInfoFromSession(session);
		super.getFile(response, fileId, webUserDto.getUserId());

	}

	@RequestMapping("/newFoloder")
	@GlobalInterceptor(checkParams = true)
	public ResponseVO newFoloder(HttpSession session,
								 @VerifyParam(required = true) String filePid,
								 @VerifyParam(required = true) String fileName) {
		SessionWebUserDto webUserDto = getUserInfoFromSession(session);
		FileInfo fileInfo = fileInfoService.newFolder(filePid, webUserDto.getUserId(), fileName);
		return getSuccessResponseVO(CopyTools.copy(fileInfo,FileInfoVO.class));
	}

	@RequestMapping("/getFolderInfo")
	@GlobalInterceptor(checkParams = true)
	public ResponseVO getFolderInfo(HttpSession session, @VerifyParam(required = true) String path) {
		return super.getFolderInfo(path, getUserInfoFromSession(session).getUserId());
	}

	@RequestMapping("/rename")
	@GlobalInterceptor(checkParams = true)
	public ResponseVO rename(HttpSession session,
							 @VerifyParam(required = true) String fileId,
							 @VerifyParam(required = true) String fileName){
		SessionWebUserDto webUserDto = getUserInfoFromSession(session);
		FileInfo fileInfo = fileInfoService.rename(fileId, webUserDto.getUserId(), fileName);
		return getSuccessResponseVO(CopyTools.copy(fileInfo,FileInfoVO.class));
	}


	@RequestMapping("/loadAllFolder")
	@GlobalInterceptor(checkParams = true)
	public ResponseVO loadAllFolder(HttpSession session,
							 @VerifyParam(required = true) String filePid, String currentFileIds){
		SessionWebUserDto webUserDto = getUserInfoFromSession(session);
		FileInfoQuery infoQuery = new FileInfoQuery();
		infoQuery.setUserId(webUserDto.getUserId());
		infoQuery.setFilePid(filePid);
		infoQuery.setFolderType(FileFolderTypeEnums.FOLDER.getType());
		if (!StringTools.isEmpty(currentFileIds)){
			infoQuery.setExcludeFileIdArray(currentFileIds.split(","));
		}
		infoQuery.setDelFlag(FileDelFlagEnums.USING.getFlag());
		infoQuery.setOrderBy("create_time desc");
		List<FileInfo> fileInfoList = fileInfoService.findListByParam(infoQuery);

		return getSuccessResponseVO(CopyTools.copyList(fileInfoList,FileInfoVO.class));
	}

	@RequestMapping("/changeFileFolder")
	@GlobalInterceptor(checkParams = true)
	public ResponseVO changeFileFolder(HttpSession session,
									   @VerifyParam(required = true) String fileIds,
									   @VerifyParam(required = true) String filePid){
		SessionWebUserDto webUserDto = getUserInfoFromSession(session);
		fileInfoService.changeFileFolder(fileIds,filePid,webUserDto.getUserId());
		return getSuccessResponseVO(null);
	}

	@RequestMapping("/createDownloadUrl/{fileId}")
	@GlobalInterceptor(checkParams = true)
	public ResponseVO createDownloadUrl(HttpSession session,
									   @VerifyParam(required = true) @PathVariable("fileId") String fileId){
		SessionWebUserDto webUserDto = getUserInfoFromSession(session);
		return super.createDownloadUrl(fileId, webUserDto.getUserId());
	}

	@RequestMapping("/download/{code}")
	@GlobalInterceptor(checkParams = true,checkLogin = false)
	public void download(HttpServletRequest req,HttpServletResponse res,
							   @VerifyParam(required = true) @PathVariable("code") String code) throws Exception {

		super.download(req, res, code);
	}

	@RequestMapping("/delFile")
	@GlobalInterceptor(checkParams = true,checkLogin = false)
	public ResponseVO download(HttpSession session, @VerifyParam(required = true) String fileIds) throws Exception {

		SessionWebUserDto webUserDto = getUserInfoFromSession(session);
		fileInfoService.removeFile2RecycleBatch(webUserDto.getUserId(),fileIds);
		return getSuccessResponseVO(null);
	}


}