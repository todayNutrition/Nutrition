<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

/*프로필, 섭취량 감싸는 틀*/
.big {
	margin:auto;
	margin-top: 100px;
	height: 300px;
}
/*프로필, 섭취량*/
.profile{
	width: 350px;
	height: 430px;
	margin:auto;
}
.cate{
	float: left;
	width: 100px;
	margin-left: 25px;
	font-size: 17px;
}
.litle_d{
	margin-bottom: 15px;
}
input[type="text"]{
	width: 150px;
	border: none;
	border-bottom: 1px solid #000;
}

@media (max-width: 767px)  {
	.title {
	     text-align: center;
	     font-size: 200%;
	     margin: 20px;
	}
	
	/*프로필, 섭취량 감싸는 틀*/
	.big {
	   margin:auto;
	   margin-top: 100px;
	   width:100%;
	   height: 300px;
	}
	/*프로필, 섭취량*/
	.profile{
	   width: 95%;
	   height: 430px;
	   margin:auto;
	   
	}
	.cate{
	   float: left;
	   width: 30%;
	   margin-left: 25px;
	   font-size: 17px;
	}
	.litle_d{
	   margin-bottom: 15px;
	   display: flex;
	   align-items:center;
	   justify-content: space-around;

	}
	.litle_d > div:last-child{
		width: 70%;
		margin-right: 25px;
	}
	input[type="text"]{
	   width: 100%;
	   border: none;
	   border-bottom: 1px solid #000;
	}
}

</style>
 
<div class="big">
<form action="/Nutrition/realStart/RealStartReg" method="get">
	<div class="profile">
		<h1 class="title">회원</h1>
		<div class="litle_d">
			<div class="cate">닉네임</div>
			<div><input type="text" name="name" required/></div>
		</div>
		<div>
			<div align="center" class="litle_d"><input type="submit" value="Start" class="btn-mini"/></div>
		</div>
	</div>
</form>
</div>