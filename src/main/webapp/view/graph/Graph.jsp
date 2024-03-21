<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
    var myChart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ['나트륨', '탄수화물', '당류', '지방', '트렌스지방', '포화지방', '콜레스테롤', '단백질'],
        datasets: [{
          label: '일일 섭취량',
          data: [${readDay.na}, ${readDay.carbo}, ${readDay.sugar}, ${readDay.fat},${readDay.tFat},${readDay.sFat},${readDay.chole},${readDay.protein}],
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(17, 44, 98, 0.2)',  
            'rgba(255, 0, 0, 0.2)',
            'rgba(150, 75, 0, 0.2)',
            'rgba(153, 102, 255, 0.2)'
            
          ],
          borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(17, 44, 98, 1)',
            'rgba(255, 0, 0, 1)',
            'rgba(150, 75, 0, 1)',
            'rgba(153, 102, 255, 1)'
          ],
          borderWidth: 1
        },
        {
            label: '일일 평균 권장 섭취량(백분율)',
             data: [100, 100, 100, 100, 100, 100, 100, 100],
            backgroundColor: 'transparent',
            borderColor: 'red',
            type: 'line'
          }]
      },
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
