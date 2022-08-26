<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자용 마이페이지</title>
<!-- 구글차트 활용 -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<!-- 구글차트 활용 -->
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart', 'bar']});
      google.charts.setOnLoadCallback(drawStuff);

      function drawStuff() {

        var button = document.getElementById('change-chart');
        var chartDiv = document.getElementById('chart_div');

        // DB에서 데이터 들고 와야함
        var data = google.visualization.arrayToDataTable([
          ['날짜', '매출', '가입자'],
          ['2022/08/04', 100000, 300],
          ['2022/08/04', 150000, 200],
          ['2022/08/04', 250000, 500],
          ['2022/08/04', 130000, 550],
          ['2022/08/04', 130000, 400]
        ]);

        var materialOptions = {
          chart: {
            subtitle: 'L = 매출 / R = 가입자 수'
          },
          series: {
            0: { axis: '매출' },
            1: { axis: '가입자 수' }
          }
        };

        var classicOptions = {
          series: {
            0: {targetAxisIndex: 0},
            1: {targetAxisIndex: 1}
          },
          title: '매출과 가입자 수',
          vAxes: {
            0: {title: '매출'},
            1: {title: '가입자 수'}
          }
        };

        function drawMaterialChart() {
          var materialChart = new google.charts.Bar(chartDiv);
          materialChart.draw(data, google.charts.Bar.convertOptions(materialOptions));
          button.innerText = 'Change to Classic';
          button.onclick = drawClassicChart;
        }

        function drawClassicChart() {
          var classicChart = new google.visualization.ColumnChart(chartDiv);
          classicChart.draw(data, classicOptions);
          button.innerText = 'Change to Material';
          button.onclick = drawMaterialChart;
        }
        drawMaterialChart();
    };
    </script>
<!-- 일별 가입자수 차트 자리 -->
<link href="css/admin_page.css" rel="stylesheet"/>
</head>
<body>
	<!-- 헤더 넣는 자리 -->
	<jsp:include page="/inc/admin_header.jsp"/>
	<!-- 헤더 넣는 자리 -->
	<div class="wrapper">
		<!-- 주문 / 배송 처리 현황 자리 -->
		<div class="table">
			<a href="OrderList.ad?order_status=all">
			    <div class="row header">
		      		<div class="cell">
		        		주문관리 &gt;
		      		</div>
		      	</div>
			</a>
			<a href="OrderList.ad?order_status=yes">
		      	<div class="row">
			      	<div class="cell">
			        	당일 신규주문
			      	</div>
			      	<div class="cell2">
			        	<!-- 신규주문 건수 -->${ordNoArr[0] }건
			        </div>
			   	</div>
			</a>
			<a href="OrderList.ad?order_status=no">
		      	<div class="row">
			      	<div class="cell">
			        	당일 주문취소
			      	</div>
			      	<div class="cell2">
			        	<!-- 신규주문 건수 -->${ordNoArr[1] }건
			        </div>
			   	</div>
			</a>
		</div>
		<!-- 주문 / 배송 처리 현황 자리 -->
		
		<!-- 상품관리 게시판자리 -->
	 		<div class="table">
	 		<a href="ProductList.ad?pd_quan=all">
		    	<div class="row header">
		      		<div class="cell">상품관리 &gt;
		      		</div>
		      	</div>
	      	</a>
		    <a href="ProductList.ad?pd_quan=false" >
			    <div class="row">
			      	<div class="cell">
			        	상품품절
			      	</div>
			      	<div class="cell2">
			        	${pdNoArr[0] }건
			        </div>
			    </div>
		    </a>
		</div>
		<!-- 교환/취소 게시판자리 -->
		
		<!-- 고객문의 게시판자리 -->
	 		<div class="table">
		 		<a href="QnaList.ad">
			    	<div class="row header">
			      		<div class="cell">
			        		고객문의 &gt;
			      		</div>
			      	</div>
		      	</a>
		      	<a href="QnaList.ad?qna_type=일반" >
				    <div class="row">
				      	<div class="cell">
				        	일반문의 미답변
				      	</div>
				      	<div class="cell2">
				        	<!-- 일반문의 미답변 건수 -->${qnaNoArr[1] }건
				        </div>
				    </div>
				</a>
				<a href="QnaList.ad?qna_type=상품" >
				    <div class="row">
				      	<div class="cell">
				        	상품문의 미답변
				      	</div>
				      	<div class="cell2">
				        	<!-- 상품문의 미답변 건수 -->${qnaNoArr[0] }건
				        </div>
				   	</div>
				</a>
		</div>
		<!-- 고객문의 게시판자리 -->
	</div>
	
	<div class=veiw_chart>
		<div id="chart_subject">
			<a href ="">&lt; 일별 매출 / 일별 가입자 수 차트 &gt;</a>
		</div>
		<!-- 일별 매출그래프 자리 -->
		<div class="chart1" id="chart_div"  style="width: 1285px; height: 400px;"></div>
		<!-- 일별 매출그래프 자리  -->
	</div>
</body>
</html>