<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<title>KH ���������ý���</title>
	<link rel="stylesheet" href="css/Mainpage_Frame.css"></link>
	<link rel="stylesheet" href="css/left_menu.css"></link>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="js/leftMenu_jquery.js"></script>
</head>

<body>
	<div id="box">
		<div id="header">
			<div id="header_1">
				<ul class="menu">
					<li><a href="ChartBoard.action?category=chart"><img src="main/bbu_main_img/chart.png" name="chart" border="0" class="rollover"/></a></li>
					<li><a href="NewChartBoard.action?category=new"><img src="main/bbu_main_img/new.png"  name="new" border="0" class="rollover"/></a></li>
	
					<li><a href="GenreChartBoard.action?category=genre"><img src="main/bbu_main_img/genre.png" name="genre" border="0" class="rollover"/></a>
						<ul class="sub">
							<li><a href="GenreChartBoard.action?category=genre&type=dance"><img src="main/bbu_main_img/dance.png" name="dance" border="0" class="rollover"/></a></li>
							<li><a href="GenreChartBoard.action?category=genre&type=balad"><img src="main/bbu_main_img/balad.png" name="balad" border="0" class="rollover"/></a></li>
						</ul>
					</li>
					<li>
						<a href="#"><img src="main/bbu_main_img/payment.png" name="payment_buy" class="rollover" border="0"/></a>
						<ul class="sub">
							<li><a href="payBuyList.action?buy_id="><img src="main/bbu_main_img/bbu_payment.png" name="payment" border="0" class="rollover"/></a></li>
							<li><a href="cashCharge.action?my_id=" onclick="return idCheck();"><img src="main/bbu_main_img/cash.png" name="cash" border="0" class="rollover"/></a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div id="header_2">
				<center>
					<form name="bbu" method="post">
						<input type="hidden" name="id" value=""/>
						<a href="#"><img src="main/bbu_main_img/BBuMainLogo.png" name="bbuMain" border="0" onclick="bbusic_main()"/></a>
					</form>
				</center>
			</div>
		</div>
	</div>

	<div id="box">
		<div id="box2">
	    	<div id="content">
	    		<div id="tab_menu">					
					<ul>
						<li class="btn"><a class="menu1">��������</a></li>
						<li class="ly" style="display:list-item;">
							<dl>
								<dt>��������</dt>
								<dd><a href="#">��������</a></dd>
							</dl>
						</li>
						<li class="btn"><a class="menu2">����</a></li>
						<li class="ly">
							<dl>
								<dt>����</dt>
								<dd><a href="#">�����⺻������ȸ �� ����</a></dd>
							</dl>
						</li>
						<li class="btn"><a class="menu3">����/����</a></li>
						<li class="ly">
							<dl>
								<dt>����/����</dt>
								<dd><a href="#">���н�û</a></dd>
								<dd><a href="#">���н�û</a></dd>
							</dl>
						</li>
						<li class="btn"><a class="menu4">����/����</a></li>
						<li class="ly">
							<dl>
								<dt>����/����</dt>
								<dd><a href="#">��������</a></dd>
								<dd><a href="#">������û</a></dd>
								<dd><a href="#">�������� ��ȸ</a></dd>
								<dd><a href="#">������û ������ȸ</a></dd>
								<dd><a href="#">���� �ð�ǥ ��ȸ</a></dd>
							</dl>
						</li>
						<li class="btn"><a class="menu5">����/����</a></li>
						<li class="ly">
							<dl>
								<dt>����/����</dt>
								<dd><a href="#">������</a></dd>
								<dd><a href="#">���б� ������ȸ</a></dd>
								<dd><a href="#">��ü ������ȸ</a></dd>
								<dd><a href="#">�⼮��ȸ</a></dd>
							</dl>
						</li>
						<li class="btn"><a class="menu6">���/����</a></li>
						<li class="ly">
							<dl>
								<dt>���/����</dt>
								<dd><a href="#">���б� ���г���</a></dd>
								<dd><a href="#">�ٷ����� ��û</a></dd>
								<dd><a href="#">�ٷ����� ���</a></dd>
								<dd><a href="#">������ ���� ����</a></dd>
								<dd><a href="#">��ϱ� ������</a></dd>
								<dd><a href="#">�г���ϱ� ������</a></dd>
							</dl>
						</li>
						<li class="btn"><a class="menu7">������</a></li>
						<li class="ly">
							<dl>
								<dt>������</dt>
								<dd><a href="#">å �뿩 ��û</a></dd>
								<dd><a href="#">å �뿩 ����Ʈ</a></dd>
								<dd><a href="#">å ���� ���</a></dd>
							</dl>
						</li>
						<li class="btn"><a class="menu8">����</a></li>
						<li class="ly">
							<dl>
								<dt>����</dt>
								<dd><a href="#">���� ��û</a></dd>
								<dd><a href="#">�Ʒ����� ��ȸ</a></dd>
								<dd><a href="#">�Ʒð�� ��ȸ</a></dd>
							</dl>
						</li>
					</ul>
				</div>
	    	</div>
		</div>
		<div id="box3"> </div>
		<div id="box4"> <center><br/><br/></center> </div>
	</div>
</body>
</html>


