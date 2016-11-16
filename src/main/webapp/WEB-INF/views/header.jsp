<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

 <nav  class="navbar navbar-light" style="background-color: #e3f2fd;">
	<div class="container-fluid">
	    <ul class="nav navbar-nav">
	    	<li class="active"><a href='<c:url value="/view/all"/>'><span class="glyphicon glyphicon-home"> </span> Home</a></li>
	      	<li><a href='<c:url value="/advertisement/add"/>'><span class="glyphicon glyphicon-plus"> </span> Add</a></li>
	      	<li><a href='<c:url value="/view/search"/>'><span class="glyphicon glyphicon-search"></span> Search</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right" style="padding-top: 8px;">
	    	<sec:authorize  access="isAnonymous()">
	   		 	<a href="<c:url value="/user/login" />" class="btn btn-sm btn-primary">Login <span class="glyphicon glyphicon-log-in"></span></a>
	   		</sec:authorize>
		    <sec:authorize access="isAuthenticated()">
				Hello
				<sec:authentication property="principal.username" />
				<a href="<c:url value="/user/logout" />" class="btn btn-sm btn-primary">Logout <span class="glyphicon glyphicon-share"></span></a>
			</sec:authorize>
	    </ul>
 	</div>
</nav>