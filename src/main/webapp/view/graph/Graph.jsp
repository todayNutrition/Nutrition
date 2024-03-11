<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

 <!-- 차트 링크 -->
  <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
  
 <!-- 부트스트랩 -->  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
<!--헤더-->
<jsp:include page="/view/fix/header.jsp"></jsp:include> 

  <!-- 차트 -->
<!--   <script>
  /* 사용자 섭취량 */
  const mydata = [${param.na}, ${param.carbo}, ${param.sugar}, ${param.fat},${param.tFat},${param.sFat},${param.chole},${param.protein}];
  /* 평균 섭취량 */
  const mydataHalf = [
	  	${dto.na }, ${dto.carbo }, ${dto.sugar }, ${dto.fat }, ${dto.tFat }, ${dto.sFat }, ${dto.chole }, ${dto.protein }
	  ];
  </script> -->
  

<h1>통계</h1>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

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
          label: '하루 섭취량',
          data: /* ${MainUser.na}, ${MainUser.carbo}, ${MainUser.sugar}, ${MainUser.fat},${MainUser.tFat},${MainUser.sFat},${MainUser.chole},${MainUser.protein}, */
        	   [12, 19, 3, 5, 2, 3, 10, 8], 
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)',
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)'
            
          ],
          borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)',
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)'
          ],
          borderWidth: 1
        },
        {
            label: '하루 평균 권장 섭취량',
            data: /* mydataHalf ${redUser.na}, ${redUser.carbo}, ${redUser.sugar}, ${redUser.fat},${redUser.tFat},${redUser.sFat},${redUser.chole},${redUser.protein},*/
             	[12, 19, 3, 5, 2, 3, 10, 8], 
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

  </script>