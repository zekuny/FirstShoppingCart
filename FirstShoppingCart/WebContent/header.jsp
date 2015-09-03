
<!-- Navigation Bar -->
<div class="container">
    <nav role="navigation" class="navbar navbar-inverse">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="index.jsp" class="navbar-brand">Tian Mao!</a>
        </div>
        <!-- Collection of nav links, forms, and other content for toggling -->
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="ProductServlet">All Products</a></li>   
                <li class="active"><a href="http://weibo.com/2778297137/profile?topnav=1&wvr=6">Your Profile</a></li>  
                <% if(session.getAttribute("username") != null){%>
                <li class="active"><a href="checkout.jsp">Shopping Cart</a></li>
                	<% if(session.getAttribute("username").equals("admin")){ %>
						<li class="active"><a href = "AllOrderServlet">View all orders</a></li>
						<li class="active"><a href = "CreditServlet">ISSUE CREDIT</a></li>
					<%}else{ %>
						<li class="active"><a href = "PastOrderServlet">View past orders</a></li>
					<% }%>
                <%} %>
                <li class="active"><a href="https://www.tmall.com/?v">Contact us</a></li>
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">About Tian Mao <b class="caret"></b></a>
                    <ul role="menu" class="dropdown-menu">
                        <li><a href="#">Contact</a></li>
                        <li><a href="#">Address/Map</a></li>
                        <li><a href="#">History</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Join us!</a></li>
                    </ul>
                </li>
            </ul>
            <form role="search" class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" placeholder="Search " class="form-control">
                </div>
            </form>
            <% if(session.getAttribute("username") == null){%>
            <ul class="nav navbar-nav navbar-right">
            	<li><a href = "createProfile.jsp">Create Account</a></li>
                <li>
					<div class="dropdown">
						<button class="btn pull-left btn-info dropdown-toggle" type="button"
							data-toggle="dropdown">
							Login<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#"></a>
								<div class="container">
									<form action="LoginServlet" method="post"> <!-- The input for email and password goes to the LoginServlet -->
										<div class="form-group">
											<label class="control-label col-sm-5">Username: </label>
											<div class="col-sm-5">
												<input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-sm-5">Password: </label>
											<div class="col-sm-5">
												<input type="text" class="form-control" id="password"
													name="password" placeholder="Enter password">
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-5">
												<center>
													<button type="submit" class="btn btn-primary btn-lg btn-block" value="addstudent">Login</button>
												</center>
											</div>
										</div>				
									</form>			
								</div>
							</li>
						</ul>
					</div>      
                </li>
            </ul>
            <%}else{ %>
            	<li style = "color: white">Welcome <%= session.getAttribute("username") %></li>
            	<li><a href = "UserLogoutServlet"><button>Logout</button></a></li>
			<%} %>
        </div>
    </nav>
</div>
