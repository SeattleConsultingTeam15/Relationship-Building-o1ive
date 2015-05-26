<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dolteng Auto Generated</title>
<link rel="stylesheet" href='${f:url("/css/style.css")}'>
</head>
<body>
<div id="header"><tiles:insert template="/WEB-INF/view/common/header.jsp" flush="true"/>

			<h1>こんにちは${loginDto.userName}さん</h1>
			<td>あなたが話した人は全体の${topDto.talk}%です。(${talkingParameter.employeesDtos.size()}/${employeesViewDto.employeesDtos.size()})</td><br>
			<tr>あなたが話していない人は全体の${topDto.nontalk}%です。(${isNotTalkingParameter.employeesDtos.size()}/${employeesViewDto.employeesDtos.size()})</tr><br>
			<tr>登録人数${employeesViewDto.employeesDtos.size()}人</tr><br>
			<tr>話した人数${talkingParameter.employeesDtos.size()}人</tr><br>
			<tr>話してない人数${isNotTalkingParameter.employeesDtos.size()}人</tr><br>
		</div>
</div>
</body>