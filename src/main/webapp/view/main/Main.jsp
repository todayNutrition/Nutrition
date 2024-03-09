<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a href="#" class="navbar-brand"> Navbar </a>

        <button class="navbar-toggler" data-toggle="collapse" data-target="#expand">
            <span class="navbar-toggler-icon"></span>
        </button>
        <!-- 부트스트랩의 일부, 요소를 숨기거나 나타내게 할 수 있음 -->
        <div class="collapse navbar-collapse" id="expand">
            <div class="navbar-nav">
                <a href="#" class="nav-item nav-link">메인페이지</a>
                <a href="#" class="nav-item nav-link">성분표 업로드</a>
                <a href="#" class="nav-item nav-link">그래프</a>
                <a href="#" class="nav-item nav-link">목표 설정</a>
                <a href="#" class="nav-item nav-link">달력</a>
            </div>
        </div>
    </nav>
<!--
navbar-light
텍스트 요소가 밝은 배경에서 잘보이게 설정 (폰트색이 검정으로 변함)

bg-light
배경색을 하얀색에 가깝게 설정

navbar-dark 
텍스트 요소가 밝은 배경에서 잘보이게 설정 (폰트색이 검정으로 변함)

bg-dark
배경색을 검정색에 가깝게 설정

navbar-nav
가벼운 네비게이션 항목을 만들 때 사용 (드롭다운 지원)

nav-item
네비게이션 그룹에 포함된 요소들

nav-link
네비게이션 링크에 대한 스타일을 지정 

collpase 
요소를 숨기거나 드러냄 (사용 시, 링크 요소가 숨겨짐)

navbar-collpase
navbar 요소에 적용 

navbar-expand-md
뷰포트 너비가 미디움이상의 사이즈가 되면, collapse로 숨겨진 항목이 보이고
그 이하는 보이지 않는다.

navbar-toggler
아이콘을 누를 수 있는 토글버튼이 생성됨

navbar-toggler-icon
토글 버튼이 아이콘으로 스타일링 됩니다.

data-toggle="collapse"
collapse 속성으로 숨겨진 요소를 연결합니다.

data-target="#expand"
아이콘을 클릭햇을 때, 보여줘야할 요소들의 그룹(div)의 ID명을 적어 연결합니다.

ml-auto 
전체폼에서 좌측에 마진이 자동으로 설정된다
-->



<form action="" method="set">
	<table border="">
		<h1>나의 프로필</h1>
		<tr>
			<td>닉네임</td>
			<td><input type="text" name="name" value="${param.name}"/>수정가능</td>
		</tr>
		<tr>
			<td>키</td>
			<td><input type="text" name="height" value="${param.height}"/>수정가능</td>
		</tr>
		<tr>
			<td>몸무게</td>
			<td><input type="text" name="weight" value="${param.weight}"/>수정가능</td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" value="${param.age}"/>수정가능</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${param.gender}</td>
		</tr>
		<tr>
			<td>목표 칼로리</td>
			<td>고정값 - 혜성언니</td>
		</tr>
		<tr>
			<td><input type="submit" value="수정"/></td>
		</tr>
	</table>
</form>


	<table>
			<h1>일일 섭취량</h1>
		<tr>
			<td>칼로리</td>
			<td>${param.kcal}mg</td>
		</tr>
		<tr>
			<td>나트륨</td>
			<td>${param.na}mg</td>
		</tr>
		<tr>
			<td>탄수화물</td>
			<td>${param.carbo}mg</td>
		</tr>
		<tr>
			<td>당류</td>
			<td>${param.sugar}mg</td>
		</tr>
		<tr>
			<td>지방</td>
			<td>${param.fat}mg</td>
		</tr>
		<tr>
			<td>트렌스지방</td>
			<td>${param.tFat}mg</td>
		</tr>
		<tr>
			<td>포화지방</td>
			<td>${param.sFat}mg</td>
		</tr>
		<tr>
			<td>콜레스테롤</td>
			<td>${param.chole}mg</td>
		</tr>
		<tr>
			<td>단백질</td>
			<td>${param.protein}mg</td>
		</tr>
	</table>