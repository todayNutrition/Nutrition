<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<style>
/*혜성언니 수정버튼  */
.btn-mini {
  color: white; 
  padding: 2.5px 12px;  
  display: inline-block;
  border: 1px solid rgba(0,0,0,0.21);
  border-bottom-color: rgba(0,0,0,0.34);
  text-shadow:0 1px 0 rgba(0,0,0,0.15);
  box-shadow: 0 1px 0 rgba(255,255,255,0.34) inset, 
              0 2px 0 -1px rgba(0,0,0,0.13), 
              0 3px 0 -1px rgba(0,0,0,0.08), 
              0 3px 13px -1px rgba(0,0,0,0.21);
  background-color: #7fccde;
  font-size: 15px;
  margin-left: 5px;
  margin-top: 40px;
}
.btn-mini:active {
  top: 1px;
  border-color: rgba(0,0,0,0.34) rgba(0,0,0,0.21) rgba(0,0,0,0.21);
  box-shadow: 0 1px 0 rgba(255,255,255,0.89),0 1px rgba(0,0,0,0.05) inset;
  position: relative;
}

/*글자*/
.title {
	  text-align: center;
	  font-size: 35px;
	  margin: 20px;
}
.gogo {
	  text-align: center;
	  font-size: 25px;
}

/*프로필, 섭취량 감싸는 틀*/
.big {
	margin:auto;
	margin-top: 100px;
	width: 1000px;
	height: 300px;
}
/*프로필, 섭취량*/
.profile{
	width: 350px;
	height: 430px;
	float: left;
	margin-left: 120px;
	border: 7px solid #00ADB2;
	border-radius: 65px;
	background-color: #fff;
}
.cate{
	float: left;
	width: 100px;
	margin-left: 25px;
}
.cate1{
	float: left;
	width: 100px;
	margin-left: 80px;
}

.litle_d{
	margin-bottom: 7px;
}
input{
	width: 150px;
}
 .dash{
	width: 320px;
	height: 400px;
	margin-top: 7px;
	margin-left: 7px;
	border: 2px dashed #00ADB2;
	border-radius: 50px;
}
</style>    
<div class="big">
	<div class="profile">
		<div class="dash">
		<form action="ModifyReg" method="get">
			<div>
	 			<h1 class="title">나의 프로필</h1>
				<div class="litle_d">
					<div class="cate">닉네임</div>
					<div><input type="text" name="name" value="${MainUser.name}"/>◁</div>
				</div>
				<div class="litle_d">
					<div class="cate">키</div>
					<div><input type="text" name="height" value="${MainUser.height}"/>◁</div>
				</div>
				<div class="litle_d">
					<div class="cate">몸무게</div>
					<div><input type="text" name="weight" value="${MainUser.weight}"/>◁</div>
				</div>
				<div class="litle_d">
					<div class="cate">나이</div>
					<div><input type="text" name="age" value="${MainUser.age}"/>◁</div>
				</div>
				<div class="litle_d">
					<div class="cate">성별</div>
					<div><input type="text" name="gender" value="${MainUser.gender}" readonly="readonly"/></div>
				</div>
				<div>
					<div align="center" class="litle_d"><input type="submit" value="수정" class="btn-mini"/></div>
				</div>
			</div>
		</form>
		</div>
	</div>

	 <div class="profile">
		 <div class="dash">
			<div>
	 			<h1 class="title">오늘 섭취량</h1>
				<div class="litle_d">
					<div class="cate1">칼로리</div>
					<div>${readDay.kcal}kcal</div>
				</div>
				<div class="litle_d">
					<div class="cate1">나트륨</div>
					<div>${readDay.na}mg</div>
				</div>
				<div class="litle_d">
					<div class="cate1">탄수화물</div>
					<div>${readDay.carbo}g</div>
				</div>
				<div class="litle_d">
					<div class="cate1">당류</div>
					<div>${readDay.sugar}g</div>
				</div>
				<div class="litle_d">
					<div class="cate1">지방</div>
					<div>${readDay.fat}g</div>
				</div>
				<div class="litle_d">
					<div class="cate1">트렌스지방</div>
					<div>${readDay.tFat}g</div>
				</div>
				<div class="litle_d">
					<div class="cate1">포화지방</div>
					<div>${readDay.sFat}g</div>
				</div>
				<div class="litle_d">
					<div class="cate1">콜레스테롤</div>
					<div>${readDay.chole}mg</div>
				</div>
				<div class="litle_d">
					<div class="cate1">단백질</div>
					<div>${readDay.protein}g</div>
				</div>
			</div>
		</div>	 
	</div> 
</div>