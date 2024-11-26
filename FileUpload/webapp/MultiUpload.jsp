<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	function validateFormform){
		if(form.title.value  == ""){
			form.title.focus();
			retuen false;
		}
		if(form.attachedFile.value == ""){
			alert("첨부 파일은 필 수 입력사항 입니다.");
			return false;
		}
	}
</script>
<title>MultiFileUpload</title>
</head>
<body>
	<h3>멀티파일 업로드(multiple 속성 추가)</h3>
	<span style= "color:red;">${errorMessage}</span>
	<form name = "fileForm" method="post" enctype="multipart/form-data" action="MultipleProcess.do" onsubmit="return validateForm(this);">
		제목 : <input type= "text" name= "title" /><br/>
		카테고리(선택 사항) :
			<input type="checkbox" name="cate" value="사진" checked/> 사진
			<input type="checkbox" name="cate" value="과제" /> 과제
			<input type="checkbox" name="cate" value="워드" /> 워드
			<input type="checkbox" name="cate" value="음원" /> 음원 <br/>
		첨부파일 (다중선택가능): <input type ="file"  name="ofile" multiple/> <br/> 
			<input type="submit" value="전송하기"/>

	</form>
</body>
</html>