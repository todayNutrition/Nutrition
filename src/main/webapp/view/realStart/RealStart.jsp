<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
#st {
  flex: 1 1 auto;
  padding: 0px 100px;
  text-align: center;
  font-size: 50px;
  text-transform: uppercase;
  transition: 0.5s;
  background-size: 100% auto;
  color: white;
 /* text-shadow: 0px 0px 10px rgba(0,0,0,0.2);*/
  box-shadow: 0 0 20px #eee;
  border-radius: 10px;
  margin: auto;
 }
#st:hover {
  background-position: right center; /* change the direction of the change here */
}
#st {
  background-image: linear-gradient(to right, #84fab0 0%, #8fd3f4 51%, #84fab0 100%);
}
.title {
	  text-align: center;
	  font-size: 45px;
	  margin-bottom: 40px;
}
#gogo {
	  text-align: center;
	  font-size: 25px;
	  margin-bottom: 40px;
}
.big {
	margin: auto;
	margin-top: 100px;
	margin-bottom: 40px;
	display: flex;
	flex-direction: column;
   	align-items:center;
   	justify-content: space-around;
}
.info{
	text-align: center;
}
p{
	margin: 20px;
}
@media (max-width: 767px)  {
	#st{
		padding: 0px;
		text-align: center;
		width: 90%;
	}
	p{
		font-size: 12px;
	}
}

</style>    



<div class="big">   
	<div class="title">Today Nutrition</div> 
	<div class="info">
	<p>
	이 사이트의 목적은 사용자들이 건강한 식습관을 형성하고 
	유지할 수 있도록 도와주는 것입니다.<br/>
	영양성분표를 기반으로 한 사용자 맞춤형 건강 정보를 제공하여, 
	사용자들이 자신의 식단을 분석하고 영양상태를 파악할 수 있도록 합니다. <br/>
	또한 건강한 식습관과 영양소 섭취에 대한 인식을 높이고, 
	사용자가 자신의 몸과 건강에 대한 책임을 느끼게 하는 것을 목표로 합니다.<br/>
	</p>
	</div>
	<div id="gogo">영양해! 지금 시작하시겠습니까?</div>
	<a id="st" href="/Nutrition/main/UserStart">Start</a>
</div>
