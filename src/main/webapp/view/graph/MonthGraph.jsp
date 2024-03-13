<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
	.container{
		margin-top: 100px;
		background-color: #fff;
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

  <div class="container">
    <canvas id="myChart"></canvas>
  </div>
  
    <div>
  	<a href="MonthGraph">month</a>
  	<a href="#">week</a>
  	<a href="Graph">day</a>
  </div>
  
 <script>
    var ctx = document.getElementById('myChart');
    var myChart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ['나트륨', '탄수화물', '당류', '지방', '트렌스지방', '포화지방', '콜레스테롤', '단백질'],
        datasets: [{
          label: '한 달 섭취량',
          data: 
        	  <c:forEach items="${readMonth}" var="mdto">
          [${mdto.na}, ${mdto.carbo}, ${mdto.sugar}, ${mdto.fat}, ${mdto.tFat}, ${mdto.sFat}, ${mdto.chole}, ${mdto.protein}],
      </c:forEach>
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
            label: '하루 평균 권장 섭취량',
             data: 
             	<c:forEach items="${readUser}" var="dto">
        			[${dto.na}, ${dto.carbo}, ${dto.sugar}, ${dto.fat},${dto.tFat},${dto.sFat},${dto.chole},${dto.protein}],
            	</c:forEach>
            backgroundColor: 'transparent',
            borderColor: 'skyblue',
            type: 'line'
          }]
      },
      options: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }
    });

  </script> --%>
  
  
  
  
  
  <!DOCTYPE html>
<html lang="en">
<!-- <html lang="en" style="height: 100%"> -->

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>부트스트랩 차트그리기</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <!-- 차트 링크 -->
  <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
</head>

<body>
  <div class="container">
      <div class="row my-2">
          <div class="col-md-6">
              <div class="card">
                  <div class="card-body">
                      <canvas class="myChart"></canvas>
                  </div>
              </div>
          </div>
      </div>
  </div>
  <!-- 부트스트랩 -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
  <!-- 차트 -->
  <script>
  const mydata = [10, 20, 30, 40,10, 20, 30, 40];
  const mydataHalf = [5, 10, 20, 7,10, 20, 30, 40];
  // var ctx = document.getElementById("myChart");
  var ctx = document.getElementsByClassName("myChart");

  var mixedChart = {
    type: 'bar',
    labels: ['나트륨', '탄수화물', '당류', '지방', '트렌스지방', '포화지방', '콜레스테롤', '단백질'],
    datasets : [
      {
        label: 'Bar Dataset',
        data : mydata,
        backgroundColor: 'rgba(256, 0, 0, 0.1)'
      },
      {
        label: 'Line Dataset',
        data: mydataHalf,
        backgroundColor: 'transparent',
        borderColor: 'skyblue',
        type: 'line'
      }
    ]
    };
    var myChart = new Chart(ctx, {
      type: 'bar',
      data: mixedChart,
      options: {
        legend: {
          display: true
        }
      }
    });  
  </script>
</body>
</html>
<c:forEach items="${readUser}" var="dto">
        			[${dto.na}, ${dto.carbo}, ${dto.sugar}, ${dto.fat},${dto.tFat},${dto.sFat},${dto.chole},${dto.protein}],
            	</c:forEach>
            	
            	
<c:forEach items="${readMonth}" var="mdto">
        			[${mdto.na}, ${mdto.carbo}, ${mdto.sugar}, ${mdto.fat},${mdto.tFat},${mdto.sFat},${mdto.chole},${mdto.protein}],
            	</c:forEach>            	