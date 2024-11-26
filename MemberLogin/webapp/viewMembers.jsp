<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 목록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff; /* 배경색을 화이트로 설정 */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            width: 60%; /* 가로 크기 설정 */
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #555555; /* 딥 그레이 색상 */
            font-size: 24px;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table th, table td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ddd;
        }

        table th {
            background-color: #555555; /* 딥 그레이 배경색 */
            color: white;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2; /* 테이블 행 간에 회색 배경 */
        }

        table tr:hover {
            background-color: #ddd; /* 마우스 오버 시 배경색 변경 */
        }

        .button-container {
            text-align: center;
            margin-top: 20px;
        }

        .back-button {
            padding: 10px 20px;
            background-color: #555555;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }

        .back-button:hover {
            background-color: #444444;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>회원 목록</h2>
        <table>
            <thead>
                <tr>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>이메일</th>
                </tr>
            </thead>
            <tbody>
                <!-- 회원 목록 데이터 동적으로 표시 -->
                <c:forEach var="member" items="${membersList}">
                    <tr>
                        <td>${member.id}</td>
                        <td>${member.name}</td>
                        <td>${member.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="button-container">
            <a href="member" class="back-button">회원 등록 페이지로 돌아가기</a>
        </div>
    </div>

</body>
</html>
