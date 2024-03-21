<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	.container{
		margin-top: 100px;
		background-color: #fff;
		height: 600px;
	}
	.btn-group{
		margin-left: 45%;
	}
	@media(max-width: 767px){
		.container{
		margin-top: 100px;
		background-color: #fff;
		height: 400px;
		}
		.btn-group{
			margin-top:10%;
			margin-left: 30%;
		}
	}

</style>
 <!-- 차트 링크 -->
  <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
  
 <!-- 부트스트랩 -->  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<div class="btn-group" role="group" aria-label="Basic example">
	  <button type="button" class="btn btn-primary" onclick="location.href='/Nutrition/graph/Graph'">Today</button>
	  <button type="button" class="btn btn-primary" onclick="location.href='/Nutrition/graph/SevenGraph'">Week</button>
	</div>
  <div class="container">
    <canvas id="myChart"></canvas>
  </div>

  <script>

  
  var ctx = document.getElementById('myChart');
	
  var chartData = {
    labels: ['${readWeek[0].regDateStr }','${readWeek[1].regDateStr }','${readWeek[2].regDateStr }','${readWeek[3].regDateStr }','${readWeek[4].regDateStr }','${readWeek[5].regDateStr }','${readWeek[6].regDateStr}'],
    datasets: [{
      label: '나트륨',
      data: [${readWeek[0].na },${readWeek[1].na },${readWeek[2].na },${readWeek[3].na },${readWeek[4].na },${readWeek[5].na },${readWeek[6].na }],
      backgroundColor: 'transparent',
      borderColor: 'rgba(255, 99, 132, 1)',
      borderWidth: 3
    },
    {
      label: '탄수화물',
      data: [${readWeek[0].carbo },${readWeek[1].carbo },${readWeek[2].carbo },${readWeek[3].carbo },${readWeek[4].carbo },${readWeek[5].carbo },${readWeek[6].carbo }],
      backgroundColor: 'transparent',
      borderColor:  'rgba(54, 162, 235, 1)',
      borderWidth: 3
    },
   	{
      label: '당류',
      data: [${readWeek[0].sugar},${readWeek[1].sugar},${readWeek[2].sugar},${readWeek[3].sugar},${readWeek[4].sugar},${readWeek[5].sugar},${readWeek[6].sugar}],
      backgroundColor: 'transparent',
      borderColor: 'rgba(255, 206, 86, 1)',
      borderWidth: 3
     },
     {
       label: '지방',
       data: [${readWeek[0].fat },${readWeek[1].fat },${readWeek[2].fat },${readWeek[3].fat },${readWeek[4].fat },${readWeek[5].fat },${readWeek[6].fat }],
       backgroundColor: 'transparent',
       borderColor: 'rgba(75, 192, 192, 1)',
       borderWidth: 3
     },
     {
       label: '트렌스지방',
       data: [${readWeek[0].tFat },${readWeek[1].tFat },${readWeek[2].tFat },${readWeek[3].tFat },${readWeek[4].tFat },${readWeek[5].tFat },${readWeek[6].tFat }],
       backgroundColor: 'transparent',
       borderColor: 'rgba(17, 44, 98, 1)',
       borderWidth: 3,
     },
     {
       label: '포화지방',
       data: [${readWeek[0].sFat },${readWeek[1].sFat },${readWeek[2].sFat },${readWeek[3].sFat },${readWeek[4].sFat },${readWeek[5].sFat },${readWeek[6].sFat }],
       backgroundColor: 'transparent',
       borderColor:   'rgba(255, 0, 0, 1)',
       borderWidth: 3 
     },
     {
       label: '콜레스테롤',
       data: [${readWeek[0].chole },${readWeek[1].chole },${readWeek[2].chole },${readWeek[3].chole },${readWeek[4].chole },${readWeek[5].chole },${readWeek[6].chole }],
       backgroundColor: 'transparent',
       borderColor: 'rgba(150, 75, 0, 1)',
       borderWidth: 3
     },
     {
       label: '단백질',
       data: [${readWeek[0].protein },${readWeek[1].protein },${readWeek[2].protein },${readWeek[3].protein },${readWeek[4].protein },${readWeek[5].protein },${readWeek[6].protein }],
       backgroundColor: 'transparent',
       borderColor: 'rgba(153, 102, 255, 1)',
       borderWidth: 3
     },
     {
       label: '백분율',
       data: ${size},
       backgroundColor: 'rgba(180, 255, 191, 0.33)',
       borderColor: 'rgba(132, 255, 188, 1)',
       borderWidth: 0
     }]
  };

  
  var myChart = new Chart(ctx, {
      // 챠트 종류를 선택
      type: 'line',

      // 챠트를 그릴 데이타
      data: chartData,

      // 옵션
      options: {
    	maintainAspectRatio:false,
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }
  });

  </script>