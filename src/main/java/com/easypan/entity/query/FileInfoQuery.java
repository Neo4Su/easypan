package com.easypan.entity.query;

import java.util.Date;


/**
 * 文件信息表参数
 */
public class FileInfoQuery extends BaseParam {

	public Boolean getQueryExpire() {
		return queryExpire;
	}

	public void setQueryExpire(Boolean queryExpire) {
		this.queryExpire = queryExpire;
	}

	private Boolean queryExpire;


	private String[] fileIdArray;



	private String[] excludeFileIdArray;

	public Boolean getQueryNickName() {
		return queryNickName;
	}

	public void setQueryNickName(Boolean queryNickName) {
		this.queryNickName = queryNickName;
	}

	private Boolean queryNickName;


	/**
	 * 文件id
	 */
	private String fileId;

	private String fileIdFuzzy;

	/**
	 * 父级id
	 */
	private String filePid;

	private String filePidFuzzy;

	/**
	 * 标记删除  0:删除 1:回收站 2:正常
	 */
	private Integer delFlag;

	/**
	 * 文件大小: 字节
	 */
	private Long fileSize;

	/**
	 * 文件名
	 */
	private String fileName;

	private String fileNameFuzzy;

	/**
	 * 封面
	 */
	private String fileCover;

	private String fileCoverFuzzy;

	/**
	 * 文件路径
	 */
	private Integer filePath;

	/**
	 * 创建时间
	 */
	private String createTime;

	private String createTimeStart;

	private String createTimeEnd;

	/**
	 * 最后更新时间
	 */
	private String lastUpdateTime;

	private String lastUpdateTimeStart;

	private String lastUpdateTimeEnd;

	/**
	 * 0:文件 1:目录
	 */
	private Integer folderType;

	/**
	 * 1:视频 2:音频  3:图片 4:pdf 5:doc 6:excel 7:txt 8:code 9:zip 10:其它
	 */
	private Integer fileType;

	/**
	 * 0:转码中 1:转码失败 2:转码成功
	 */
	private Integer status;

	/**
	 * 进入回收站时间
	 */
	private String recoveryTime;

	private String recoveryTimeStart;

	private String recoveryTimeEnd;

	/**
	 * 文件分类 1:视频  2:音频 3:图片 4:文档  5:其它
	 */
	private Integer fileCategory;

	/**
	 * 用户id
	 */
	private String userId;

	private String userIdFuzzy;

	/**
	 * 文件md5值
	 */
	private String fileMd5;

	private String fileMd5Fuzzy;

	public String[] getExcludeFileIdArray() {
		return excludeFileIdArray;
	}

	public void setExcludeFileIdArray(String[] excludeFileIdArray) {
		this.excludeFileIdArray = excludeFileIdArray;
	}

	public void setFileId(String fileId){
		this.fileId = fileId;
	}

	public String getFileId(){
		return this.fileId;
	}

	public void setFileIdFuzzy(String fileIdFuzzy){
		this.fileIdFuzzy = fileIdFuzzy;
	}

	public String getFileIdFuzzy(){
		return this.fileIdFuzzy;
	}

	public void setFilePid(String filePid){
		this.filePid = filePid;
	}

	public String getFilePid(){
		return this.filePid;
	}

	public void setFilePidFuzzy(String filePidFuzzy){
		this.filePidFuzzy = filePidFuzzy;
	}

	public String getFilePidFuzzy(){
		return this.filePidFuzzy;
	}

	public void setDelFlag(Integer delFlag){
		this.delFlag = delFlag;
	}

	public Integer getDelFlag(){
		return this.delFlag;
	}

	public void setFileSize(Long fileSize){
		this.fileSize = fileSize;
	}

	public Long getFileSize(){
		return this.fileSize;
	}

	public void setFileName(String fileName){
		this.fileName = fileName;
	}

	public String getFileName(){
		return this.fileName;
	}

	public void setFileNameFuzzy(String fileNameFuzzy){
		this.fileNameFuzzy = fileNameFuzzy;
	}

	public String getFileNameFuzzy(){
		return this.fileNameFuzzy;
	}

	public String[] getFileIdArray() {
		return fileIdArray;
	}

	public void setFileIdArray(String[] fileIdArray) {
		this.fileIdArray = fileIdArray;
	}

	public void setFileCover(String fileCover){
		this.fileCover = fileCover;
	}

	public String getFileCover(){
		return this.fileCover;
	}

	public void setFileCoverFuzzy(String fileCoverFuzzy){
		this.fileCoverFuzzy = fileCoverFuzzy;
	}

	public String getFileCoverFuzzy(){
		return this.fileCoverFuzzy;
	}

	public void setFilePath(Integer filePath){
		this.filePath = filePath;
	}

	public Integer getFilePath(){
		return this.filePath;
	}

	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	public String getCreateTime(){
		return this.createTime;
	}

	public void setCreateTimeStart(String createTimeStart){
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart(){
		return this.createTimeStart;
	}
	public void setCreateTimeEnd(String createTimeEnd){
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd(){
		return this.createTimeEnd;
	}

	public void setLastUpdateTime(String lastUpdateTime){
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdateTime(){
		return this.lastUpdateTime;
	}

	public void setLastUpdateTimeStart(String lastUpdateTimeStart){
		this.lastUpdateTimeStart = lastUpdateTimeStart;
	}

	public String getLastUpdateTimeStart(){
		return this.lastUpdateTimeStart;
	}
	public void setLastUpdateTimeEnd(String lastUpdateTimeEnd){
		this.lastUpdateTimeEnd = lastUpdateTimeEnd;
	}

	public String getLastUpdateTimeEnd(){
		return this.lastUpdateTimeEnd;
	}

	public void setFolderType(Integer folderType){
		this.folderType = folderType;
	}

	public Integer getFolderType(){
		return this.folderType;
	}

	public void setFileType(Integer fileType){
		this.fileType = fileType;
	}

	public Integer getFileType(){
		return this.fileType;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setRecoveryTime(String recoveryTime){
		this.recoveryTime = recoveryTime;
	}

	public String getRecoveryTime(){
		return this.recoveryTime;
	}

	public void setRecoveryTimeStart(String recoveryTimeStart){
		this.recoveryTimeStart = recoveryTimeStart;
	}

	public String getRecoveryTimeStart(){
		return this.recoveryTimeStart;
	}
	public void setRecoveryTimeEnd(String recoveryTimeEnd){
		this.recoveryTimeEnd = recoveryTimeEnd;
	}

	public String getRecoveryTimeEnd(){
		return this.recoveryTimeEnd;
	}

	public void setFileCategory(Integer fileCategory){
		this.fileCategory = fileCategory;
	}

	public Integer getFileCategory(){
		return this.fileCategory;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return this.userId;
	}

	public void setUserIdFuzzy(String userIdFuzzy){
		this.userIdFuzzy = userIdFuzzy;
	}

	public String getUserIdFuzzy(){
		return this.userIdFuzzy;
	}

	public void setFileMd5(String fileMd5){
		this.fileMd5 = fileMd5;
	}

	public String getFileMd5(){
		return this.fileMd5;
	}

	public void setFileMd5Fuzzy(String fileMd5Fuzzy){
		this.fileMd5Fuzzy = fileMd5Fuzzy;
	}

	public String getFileMd5Fuzzy(){
		return this.fileMd5Fuzzy;
	}

}
