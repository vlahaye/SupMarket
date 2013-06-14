<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <title>SupMarket</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="/SupMarket/css/bootstrap.min.css">
    <link rel="stylesheet" href="/SupMarket/css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="/SupMarket/css/font-awesome.min.css">
    <link rel="stylesheet" href="/SupMarket/css/main.css">

    <script src="/SupMarket/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>    
</head>
<body data-target=".subnav" data-offset="150">

<div class="navbar navbar-fixed-top">
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <span class="brand">SupMarket</span>

                <div class="nav-collapse collapse">

                    <ul class="nav">
                        <li class="active"><a href="/SupMarket/stats/dashboard"><i class="icon-home icon-black"></i> Dashboard</a></li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                               class="icon-edit icon-black"></i>
                                APIs <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="/SupMarket/SOAPWebService?wsdl">French sales</a></li>
                                <li><a href="/SupMarket/stats/api/export.json">Canadian sales</a></li>
                                <li><a href="/SupMarket/stats/api/export.csv">Japanese sales</a></li>
                            </ul>
                        </li>

                        <!--<li><a href="#"><i class="icon-user icon-black"></i>Sample 1</a></li>
                        <li><a href="#"><i class="icon-pencil icon-black"></i>Sample 2</a></li>
                        <li><a href="#"><i class="icon-file icon-black"></i>Sample 3</a></li>-->

                    </ul>

                    <!--<ul class="nav pull-right settings">
                        <li class="dropdown">
                            <ul class="dropdown-menu">
                                <li><a href="#">Account Settings</a></li>
                                <li class="divider"></li>
                                <li><a href="#">System Settings</a></li>
                            </ul>
                        </li>
                    </ul>-->

                    <ul class="nav pull-right settings">
                        <!--<li><a href="#" class="tip icon logout" data-original-title="Settings"
                               data-placement="bottom"><i class="icon-large icon-cog"></i></a></li>
                        <li class="divider-vertical"></li>-->
                        <li><a href="/SupMarket/logout" class="tip icon logout" data-original-title="Logout" data-placement="bottom"><i
                           class="icon-large icon-off"></i></a></li>
                    </ul>

                    <ul class="nav pull-right settings">
                        <li class="divider-vertical"></li>
                    </ul>

                    <p class="navbar-text pull-right">
                        Welcome <strong>${username}</strong>
                    </p>

                    <ul class="nav pull-right settings">
                        <li class="divider-vertical"></li>
                    </ul>

                    <!--<div class="pull-right">
                        <form class="form-search form-inline" style="margin:5px 0 0 0;" method="post">
                            <div class="input-append">
                                <input type="text" name="keyword" class="span2 search-query" placeholder="Search">
                                <button type="submit" class="btn"><i class="icon-search"></i></button>
                            </div>
                        </form>
                    </div>-->

                </div>
                <!--/.nav-collapse -->
            </div>
        </div>
    </div>
</div>
                    
<div id="leftSidebar" class="subnav">
    <ul class="nav nav-list bs-docs-sidenav affix">
        <li><a href="#salesSummary">Summary</a></li>
        <li><a href="#bestSellingProducts">Best selling products</a></li>
        <li><a href="#lestSellingProducts">Less sold products</a></li>
        <li><a href="#divBreakdownByChannel">Breakdown by Channel</a></li>
        <li><a href="#divBreakdownByCountry">Breakdown by Country</a></li>
        <li><a href="#sectionBreakdownByGenderAndMS">Breakdown by Gender & MS</a></li>
        <li><a href="#sectionBreakdownByIL">Breakdown by Income Level</a></li>
        <li><a href="#sectionTop20customers">Top 20 Customers</a></li>
    </ul>
</div>
                    
<div>
    <form action="" methode="GET">
    <ul class="nav nav-list bs-docs-sidenav affix" style="margin-top:340px;">
        <li>
            <select name="country">
                <option value="">-- Country --</option>
                <option value="52769">Singapore</option>
                <option value="52770">Italy</option>
                <option value="52771">China</option>
                <option value="52772">Canada</option>
                <option value="52773">Argentina</option>
                <option value="52774">Australia</option>
                <option value="52775">Brazil</option>
                <option value="52776">Germany</option>
                <option value="52777">Denmark</option>
                <option value="52778">Spain</option>
                <option value="52779">France</option>
                <option value="52782">Japan</option>
                <option value="52785">New Zealand</option>
                <option value="52786">Poland</option>
                <option value="52787">Saudi Arabia</option>
                <option value="52788">Turkey</option>
                <option value="52789">United Kingdom</option>
                <option value="52790">United States of America</option>
            </select>
        </li>
        <li>
            <select name="gender">
                <option value="">-- Gender --</option>
                <option value="m">Male</option>
                <option value="f">Female</option>
            </select>
        </li>
        <li>
            <select name="maritalStatus">
                <option value="">-- Marital Status --</option>
                <option value="Divorc.">Divorc.</option>
                <option value="divorced">divorced</option>
                <option value="Mabsent">Mabsent</option>
                <option value="Mar-AF">Mar-AF</option>
                <option value="married">married</option>
                <option value="NeverM">NeverM</option>
                <option value="Separ.">Separ.</option>
                <option value="single">single</option>
                <option value="widow">widow</option>
                <option value="Widowed">Widowed</option>
            </select>
        </li>
        <li>
            <select name="incomeLevel">
                <option value="">-- Income Level --</option>
                <option value="A: Below 30,000">A: Below 30,000</option>
                <option value="B: 30,000 - 49,999">B: 30,000 - 49,999</option>
                <option value="C: 50,000 - 69,999">C: 50,000 - 69,999</option>
                <option value="D: 70,000 - 89,999">D: 70,000 - 89,999</option>
                <option value="E: 90,000 - 109,999">E: 90,000 - 109,999</option>
                <option value="F: 110,000 - 129,999">F: 110,000 - 129,999</option>
                <option value="G: 130,000 - 149,999">G: 130,000 - 149,999</option>
                <option value="H: 150,000 - 169,999">H: 150,000 - 169,999</option>
                <option value="I: 170,000 - 189,999">I: 170,000 - 189,999</option>
                <option value="J: 190,000 - 249,999">J: 190,000 - 249,999</option>
                <option value="K: 250,000 - 299,999">K: 250,000 - 299,999</option>
                <option value="L: 300,000 and above">L: 300,000 and above</option>
            </select>
        </li>
        <li><input type="submit" class="btn btn-success" value="Filter" /></li>
    </ul>
    </form>
</div>

<div style="padding-left:240px">
<div class="row-fluid">
    
    <c:choose>
        <c:when test="${noData}">
            <div class="alert alert-error">No data to display. Please modify your query filters.</div>
        </c:when>
        <c:when test="${!noData}">
    
    <section class="well" id="salesSummary">
    <h4 id="totNumberSales">Total number of sales made</h4>
    ${salesCount}
    <h4 id="totAmountEarn">Total amount earn</h4>
    ${amountSold}
    </section>
    
    <section class="well" id="bestSellingProducts">
    <h4>Best selling products</h4>
    <div style="width:48%; float: left;">
    <table class="table table-bordered">
    <thead>
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Sales count</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${topProducts}" var="product">
        <tr>
            <td>${product[0].prodId.prodId}</td>
            <td>${product[0].prodId.prodName}</td>
            <td>${product[1]}</td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>
    <div id="topProductPie" style="width: 50%; margin-left:2%; height: 300px; float: left;"></div>
    <div class="clearfix"></div>
    </section>
    
    <section class="well" id="lestSellingProducts">
    <h4>Less sold products</h4>
    <table class="table table-bordered" style="width:50%;">
    <thead>
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Sales count</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${flopProducts}" var="product">
        <tr>
            <td>${product[0].prodId.prodId}</td>
            <td>${product[0].prodId.prodName}</td>
            <td>${product[1]}</td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
    </section>
    
    <section class="well" id="divBreakdownByChannel">
    <h4>Breakdown by Channel</h4>
    <div id="breakdownByChannel" style="width: 300px; height: 300px"></div>
    </section>
    
    <section class="well" id="divBreakdownByCountry">
    <h4>Breakdown by Country</h4>
    <div style="width:48%; float: left;">
    <table class="table table-bordered">
    <thead>
        <tr>
            <th>#</th>
            <th>Country</th>
            <th>Sales count</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${breakdownByCountry}" var="country">
        <tr>
            <td>${country[0].custId.countryId.countryId}</td>
            <td>${country[0].custId.countryId.countryName}</td>
            <td>${country[1]}</td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>
    <div id="breakdownByCountry" style="width: 50%; margin-left:2%; height: 300px; float: left;"></div>
    <div class="clearfix"></div>
    </section>
    
    <section class="well" id="sectionBreakdownByGenderAndMS" style="height:345px">
    <div style="width: 48%; height: 300px; float: left;">
        <h4>Breakdown by Gender</h4>
        <div id="breakdownByGender" style="width: 100%; height: 300px;"></div>
    </div>
    
    <div style="width: 50%; margin-left:2%; height: 300px; float: left;">
        <h4>Breakdown by Marital Status</h4>
        <div id="breakdownByMS" style="width: 100%; height: 300px;"></div>
    </div>
    <div class="clearfix"></div>
    </section>
    
    <section class="well" id="sectionBreakdownByIL">
    <h4>Breakdown by Income Level</h4>
    <div style="width:48%; float: left;">
    <table class="table table-bordered">
    <thead>
        <tr>
            <th>Income Level</th>
            <th>Sales count</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${breakdownByIncomeLevel}" var="breakdown">
        <tr>
            <td>${breakdown[0].custId.custIncomeLevel}</td>
            <td>${breakdown[1]}</td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>
    <div id="breakdownByIncomeLevel" style="width: 50%; margin-left:2%; height: 300px; float: left;"></div>
    <div class="clearfix"></div>
    </section>
    
    
    <section class="well" id="sectionTop20customers">
    <h4>20 most loyal Customers</h4>
    <table class="table table-bordered">
    <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>eMail</th>
            <th>Sales count</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${topCustomers}" var="cust">
        <tr>
            <td>${cust[0].custId.custId}</td>
            <td>${cust[0].custId.custFirstName} ${cust[0].custId.custLastName}</td>
            <td>${cust[0].custId.custEmail}</td>
            <td>${cust[1]}</td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
    </section>
    </c:when>
    </c:choose>
</div>
<!--/row-fluid-->

<hr>

<footer align="center">
    <p>Copyright &copy; 2013 <strong>Vincent Lahaye</strong></p>
</footer>

</div>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/SupMarket/js/jquery.flot.js"></script>
<script src="/SupMarket/js/jquery.flot.pie.js"></script>
<script>window.jQuery || document.write('<script src="/SupMarket/js/vendor/jquery-1.8.3.min.js"><\/script>')</script>
<script src="/SupMarket/js/vendor/bootstrap.min.js"></script>
<script src="/SupMarket/js/vendor/bootstrap.scrollspy.js"></script>
<script>
    (function(){
        var prmstr = window.location.search.substr(1);
        var prmarr = prmstr.split ("&");
        var params = {};

        for ( var i = 0; i < prmarr.length; i++) {
            var tmparr = prmarr[i].split("=");
            params[tmparr[0]] = tmparr[1];
        }
        
        if(params.country != null) $("select[name=country] > option[value='"+ params.country +"']").attr("selected", "selected");
        if(params.gender != null) $("select[name=gender] > option[value='"+ params.gender +"']").attr("selected", "selected");
        if(params.maritalStatus != null) $("select[name=maritalStatus] > option[value='"+ params.maritalStatus +"']").attr("selected", "selected");
        if(params.incomeLevel != null) $("select[name=incomeLevel] > option[value='"+ decodeURIComponent(params.incomeLevel).replace(/\+/g, " ") +"']").attr("selected", "selected");
    })();
    
    // enable tooltips
    $(".tip").tooltip();
    
    $(document).ready(function(){
        //console.log($('#leftSidebar').scrollspy());
    });
    
    window.onload = function(){
            $('body').scrollspy($('body').data());
    };
    
    var dataTopProduct = [
        <c:forEach items="${topProducts}" var="product">
            { label: '${product[0].prodId.prodName}',  data: ${product[1]}},
        </c:forEach>
    ];
    
    $.plot('#topProductPie', dataTopProduct, {
        series: {
            pie: {
                show: true
            }
        }
    });
    
    
    
    var dataBreakdownByChannel = [
        <c:forEach items="${breakdownByChannel}" var="chan">
            { label: '${chan[0].channelId.channelDesc}',  data: ${chan[1]}},
        </c:forEach>
    ];
    
    $.plot('#breakdownByChannel', dataBreakdownByChannel, {
        series: {
            pie: {
                show: true
            }
        }
    });
    

    var dataBreakdownByCountry = [
        <c:forEach items="${breakdownByCountry}" var="country">
            { label: '${country[0].custId.countryId.countryName}',  data: ${country[1]}},
        </c:forEach>
    ];
    
    $.plot('#breakdownByCountry', dataBreakdownByCountry, {
        series: {
            pie: {
                show: true
            }
        }
    });
    

    var dataBreakdownByGender = [
        <c:forEach items="${breakdownByGender}" var="gender">
            { label: '${gender[0].custId.custGender}',  data: ${gender[1]}},
        </c:forEach>
    ];
    
    $.plot('#breakdownByGender', dataBreakdownByGender, {
        series: {
            pie: {
                show: true
            }
        }
    });
    
    var dataBreakdownByMS = [
        <c:forEach items="${breakdownByMS}" var="ms">
            { label: '${ms[0].custId.custMaritalStatus}',  data: ${ms[1]}},
        </c:forEach>
    ];
    
    $.plot('#breakdownByMS', dataBreakdownByMS, {
        series: {
            pie: {
                show: true
            }
        }
    });
    
    var dataBreakdownByIncomeLevel = [
        <c:forEach items="${breakdownByIncomeLevel}" var="breakdown">
            { label: '${breakdown[0].custId.custIncomeLevel}',  data: ${breakdown[1]}},
        </c:forEach>
    ];
    
    $.plot('#breakdownByIncomeLevel', dataBreakdownByIncomeLevel, {
        series: {
            pie: {
                show: true
            }
        }
    });
    
</script>

</body>
</html>
