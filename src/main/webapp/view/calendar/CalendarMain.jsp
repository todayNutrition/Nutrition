<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang='en'>

<head>
    <meta charset='utf-8' />
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js'></script>
	<link href='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.css' rel='stylesheet'>
    <style>
        #calendar {
            width: 100%;
            margin: auto;
            padding-top: 70px;
        }

        #yrModal {
            position: fixed;
            width: 100%;
            height: 100%;
            background-color: ;
            display: none;
            z-index: 1000;
        }

        #cont {
            margin: 50px auto;
            width: 95%;
            border-radius: 10px;
            height: 85%;
            background-color: rgba(0, 80, 0, 0.95);
            color: white;
            overflow: auto;
        }       
        .fc-day-sun a {

    		color: red;
		}
		.fc-day-sat a {
   			 color: blue;
		}
		.fc-h-event{
			font-weight: 500;
			border: none;
		}
		 .fc .fc-daygrid-day-frame {
    		padding-bottom: 17px;
  		}
		
		
  		.fc .fc-button-primary:disabled {
		    background-color: #C8D1FF;
		    border: none;
		
		}
		.fc .fc-button-primary:not(:disabled),.fc .fc-button-primary:not(:disabled).fc-button-active {
		  	border: none;
			background-color: #C8E5FA;
			font-weight: bold;
		    span {
		      font-weight: 600;
		    }
		}
		.fc .fc-toolbar-title{
			font-size: 1em;
		}		

		.fc .fc-button-primary:hover,  .fc .fc-button-primary:not(:disabled).fc-button-active:hover {
			background-color: #CAD6FA;

		}
		.fc .fc-button-primary:not(:disabled):active{
			background-color: #CAD6FA;
			border-color: 1px solid black;
		}
		.zz{
			float : left;
			width: 80%;
			margin-bottom:3px;
		}
		.yy{
			float : left;
			width: 40%;
			
			margin-right:5%;
		}
		.xx{
			margin-left:5%;
			float : left;
			width: 100%;
		}
		
		#schImg{
  			width:300px; 
  			height:300px; 
  			margin:10px;
  		}
  		.xbutton{
			text-align: right;
			padding-right: 3px;	
		}
		.table{
			width: 90%;
			height: 80%;
			margin: 5%;
		}
  
  
  @media (max-width: 767px)  {
  	#schImg{
	  	width:90%;
	  	height:45%; 
		margin:10px;
  	}
 	.xx{
		float : left;
		width: 100%;
	}
 	
 	.yy{
		width: 80%;
	    display: flex;
	    flex-direction: row;
		margin-right: 20%;
	}
	.table{
		width: 90%;
		height: 80%;
		margin: 5%;
		text-align: center;
			
	}
	
  }
  
    </style>
</head>

<body>
    <!-- 모달은 메인 영역 밖으로 빼어 놓는게 좋음-->
    <div id="yrModal">
        <div id="cont" style="text-align: center;">
            <div class="xbutton"><button onclick="fMClose()">X</button></div>
            <div><h4>일일 섭취량</h4></div>
            <div class="xx">
            	<div class="yy">
            		<div style="width: 60%;">날짜</div>
            		<input class="form-control zz" type="text" id="schStart" value="" readonly="readonly">
            	</div>
            </div>
            <div class="xx">
            	<div class="yy">
	            	<div style="width: 60%;">오늘의 점수</div>
	            	<input class="form-control zz" type="text" id="schJum" value="" readonly="readonly">
	            </div>
            </div>
            <table class="table">
			  <thead>
			    <tr>
			      <th scope="col" style="width: 50%;">영양소</th>
			      <th scope="col">섭취량</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <td>칼로리</td>
			      <td><input class="form-control zz" id="kcal" readonly="readonly" /></td>
			    </tr>
			    <tr>
			      <td>탄수화물</td>
			      <td><input class="form-control zz" id="carbo" readonly="readonly" /></td>
			    </tr>
			    <tr>
			      <td>단백질</td>
			      <td><input class="form-control zz" id="protein" readonly="readonly" /></td>
			    </tr>
			    <tr>
			      <td>지방</td>
			      <td><input class="form-control zz" id="fat" readonly="readonly" /></td>
			    </tr>
			    <tr>
			      <td>나트륨</td>
			      <td><input class="form-control zz" id="na" readonly="readonly" /></td>
			    </tr>
			    <tr>
			      <td>당류</td>
			      <td><input class="form-control zz" id="sugar" readonly="readonly" /></td>
			    </tr>
			    <tr>
			      <td>콜레스테롤</td>
			      <td><input class="form-control zz" id="chole" readonly="readonly" /></td>
			    </tr>
			    <tr>
			      <td>트렌스지방</td>
			      <td><input class="form-control zz" id="tfat" readonly="readonly" /></td>
			    </tr>
			    <tr>
			      <td>포화지방</td>
			      <td><input class="form-control zz" id="sfat" readonly="readonly" /></td>
			    </tr>
			    
			  </tbody>
			</table>
            
        </div>
    </div>
    <!-- 실제 화면을 담을 영역 -->
    <div id="Wrapper">
        <div id='calendar'></div>
    </div>
    <script>
      
        const YrModal = document.querySelector("#yrModal");
        const calendarEl = document.querySelector('#calendar');
        const mySchStart = document.querySelector("#schStart");
        const mySchKcal = document.querySelector("#kcal");
        const mySchCarbo = document.querySelector("#carbo");
        const mySchProtein = document.querySelector("#protein");
        const mySchFat = document.querySelector("#fat");
        const mySchNa = document.querySelector("#na");
        const mySchSugar = document.querySelector("#sugar");
        const mySchChole = document.querySelector("#chole");
        const mySchSfat = document.querySelector("#sfat");
        const mySchTfat = document.querySelector("#tfat");
        
        
        const mySchJum = document.querySelector("#schJum");
        const mySchComment = document.querySelector("#schComment");
        const mySchImg = document.querySelector("#schImg");


        //캘린더 헤더 옵션
        const headerToolbar = {
            left: 'prev,next',
            center: 'title',
            right: 'today'
        }
        
        var ev = ${events};

        // 캘린더 생성 옵션(참공)
        const calendarOption = {
            height: '800px', // calendar 높이 설정
            expandRows: true, // 화면에 맞게 높이 재설정
            slotMinTime: '00:00', // Day 캘린더 시작 시간
            slotMaxTime: '24:00', // Day 캘린더 종료 시간
            // 맨 위 헤더 지정
            headerToolbar: headerToolbar,
            initialView: 'dayGridMonth',  // default: dayGridMonth 'dayGridWeek', 'timeGridDay', 'listWeek'
            locale: 'kr',        // 언어 설정
            selectable: true,    // 영역 선택
            selectMirror: true,  // 오직 TimeGrid view에만 적용됨, default false
            navLinks: true,      // 날짜,WeekNumber 클릭 여부, default false
            weekNumbers: false,   // WeekNumber 출력여부, default false
            editable: false,      // event(일정) 
            /* 시작일 및 기간 수정가능여부
            eventStartEditable: false,
            eventDurationEditable: true,
            */
            dayMaxEventRows: true,  // Row 높이보다 많으면 +숫자 more 링크 보임!
            
            views: {
                dayGridMonth: {
                    dayMaxEventRows: 5
                }
            },
            nowIndicator: true,
            //events:[],
            events: ev,
           eventOrder: 'sortIdx'
        }

        // 캘린더 생성
        const calendar = new FullCalendar.Calendar(calendarEl, calendarOption);
        // 캘린더 그리깅
        calendar.render();

        // 캘린더 이벤트 등록
        calendar.on("eventAdd", info => console.log("Add:", info));
        calendar.on("eventChange", info => console.log("Change:", info));
        calendar.on("eventRemove", info => console.log("Remove:", info));
        calendar.on("eventClick", info => {
            mySchStart.value = info.event.startStr;
            mySchKcal.value = info.event.extendedProps.kcal;
            mySchCarbo.value = info.event.extendedProps.carbo;
            mySchProtein.value = info.event.extendedProps.protein;
            mySchFat.value = info.event.extendedProps.fat;
            mySchNa.value = info.event.extendedProps.na;
            mySchSugar.value = info.event.extendedProps.sugar;
            mySchChole.value = info.event.extendedProps.chole;
            mySchSfat.value = info.event.extendedProps.sfat;
            mySchTfat.value = info.event.extendedProps.tfat;
            mySchJum.value = info.event.title;
      

            YrModal.style.display = "block";
        });
        calendar.on("dateClick", info => console.log("dateClick:", info));
        
      
        // 모달 닫기
        function fMClose() {
            YrModal.style.display = "none";
        }
    </script>
</body>