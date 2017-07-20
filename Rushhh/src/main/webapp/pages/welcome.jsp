<script>
	$(function() {
		$("#slider").responsiveSlides({
			auto : true,
			nav : true,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>

<script>
	$(document).ready(function() {
		$("#owl-demo").owlCarousel({
			items : 1,
			lazyLoad : true,
			autoPlay : true,
			navigation : false,
			navigationText : false,
			pagination : true,
		});
	});
</script>

<div class="content">
	<div class="serach-agile">
		<div class="container">

			<div class="place-grids">
				<div class="col-md-1 place-grid"></div>
				<div class="col-md-4 place-grid">
					<h5>Location</h5>
					<input type="text" placeholder=" Location" class="sel" ng-model="ctl.searchProperty.cityName">
				</div>
				<div class="col-md-2 place-grid">
					<h5>Property For</h5>
					<select class="sel" ng-model="ctl.searchProperty.propertyFor">
						<option value="">All Types</option>
						<option value="Rent">Rent</option>
						<option value="Sale">Sale</option>
						<option value="Buy">Buy</option>
					</select>
				</div>
				<div class="col-md-2 place-grid">
					<h5>Property Type</h5>
					<select class="sel" ng-model="ctl.searchProperty.propertyType">
						<option value="">All Types</option>
						<option value="Residential">Residential</option>
						<option value="Commercial">Commercial</option>
						<option value="Agriculture Land">Agriculture Land</option>
					</select>
				</div>
				<div class="col-md-2 place-grid">
					<h5>&nbsp;</h5>
					<input type="submit" value="Search" class="sel"
						ng-click="linkToDescription()">
				</div>
			</div>
		</div>
	</div>
	<!--banner-->
	<div class="banner-section">
		<div class="slider">
			<div class="callbacks_container">
				<ul class="rslides" id="slider">
					<li><img src="images/ba1.jpg" alt="">
						<div class="caption">
							<h3>Rushhh.in</h3>
							<p>Rushhh Introducing India’s first bidding Portal©2013 in
								fastest growing Real Estate sector. over 1000+ real estate
								Professional operating& providing Rushhh home’s Services in
								various cities.</p>
						</div></li>
					<li><img src="images/ba2.jpg" alt="">
						<div class="caption">
							<h3>Rushhh.in</h3>
							<p>Rushhh Introducing India’s first bidding Portal©2013 in
								fastest growing Real Estate sector. over 1000+ real estate
								Professional operating& providing Rushhh home’s Services in
								various cities.</p>
						</div></li>
					<li><img src="images/ba3.jpg" alt="">
						<div class="caption">
							<h3>Rushhh.in</h3>
							<p>Rushhh Introducing India’s first bidding Portal©2013 in
								fastest growing Real Estate sector. over 1000+ real estate
								Professional operating& providing Rushhh home’s Services in
								various cities.</p>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
	<!--banner-->

	<div class="popular">
		<div class="container">
			<h2 class="tittle">Most Popular</h2>
			<div class="popular-grids">
				<div class="col-md-4 popular-grid">
					<h4>Indore</h4>
					<img src="images/a.jpg" class="img-responsive" alt="" />
					<div class="popular-text">

						<a href="#" class="button">$18000</a>
						<div class="detail-bottom">
							<h3>Vijay Nagar</h3>
							<ul>
								<li class="text-info">Property Type :</li>
								<li class="text-info1">Apartment</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">Sq Ft</li>
								<li class="text-info1">05</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">Baths</li>
								<li class="text-info1">03</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">Beds</li>
								<li class="text-info1">04</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">Parking</li>
								<li class="text-info1">03</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">City / Town</li>
								<li class="text-info1">Vijay Ngar</li>
								<div class="clearfix"></div>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-4 popular-grid">
					<h4>Mumbai</h4>
					<img src="images/a1.jpg" class="img-responsive" alt="" />
					<div class="popular-text">
						<a href="#" class="button">$10000</a>
						<div class="detail-bottom">
							<h3>Vikhroli</h3>
							<ul>
								<li class="text-info">Property Type :</li>
								<li class="text-info1">Office</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">Sq Ft</li>
								<li class="text-info1">04</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">Baths</li>
								<li class="text-info1">03</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">Beds</li>
								<li class="text-info1">04</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">Parking</li>
								<li class="text-info1">03</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">City / Town</li>
								<li class="text-info1">Vikhroli</li>
								<div class="clearfix"></div>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-4 popular-grid">
					<h4>Dehli</h4>
					<img src="images/a2.jpg" class="img-responsive" alt="" />
					<div class="popular-text">

						<a href="#" class="button">$15000</a>
						<div class="detail-bottom">
							<h3>Pitam Pura</h3>
							<ul>
								<li class="text-info">Property Type :</li>
								<li class="text-info1">Villa</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">Sq Ft</li>
								<li class="text-info1">04</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">Baths</li>
								<li class="text-info1">03</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">Beds</li>
								<li class="text-info1">04</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">Parking</li>
								<li class="text-info1">03</li>
								<div class="clearfix"></div>
							</ul>
							<ul>
								<li class="text-info">City / Town</li>
								<li class="text-info1">Pitam Pura</li>
								<div class="clearfix"></div>
							</ul>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--popular-->
	<!--high properties-->
	<div class="properties-ls">
		<div class="container">
			<div class="properties-grids">
				<div class="col-md-6 properties-grid">
					<div id="owl-demo" class="owl-carousel">
						<div class="item">
							<img src="images/p1.jpg" class="img-responsive" alt="" />
						</div>
						<div class="item">
							<img src="images/p2.jpg" class="img-responsive" alt="" />
						</div>
						<div class="item">
							<img src="images/p3.jpg" class="img-responsive" alt="" />
						</div>
					</div>
				</div>
				<div class="col-md-6 properties-grid1">
					<h3 class="tittle">Highly Properties</h3>
					<div class="care">
						<div class="left-grid">
							<p>01</p>
						</div>
						<div class="right-grid">
							<br>
							<h4>Hasle account free creation</h4>

						</div>
						<div class="clearfix"></div>
					</div>
					<div class="care">
						<div class="left-grid">
							<p>02</p>
						</div>
						<div class="right-grid">
							<br>
							<h4>List properties with images</h4>

						</div>
						<div class="clearfix"></div>
					</div>

				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--high properties-->
	<!--featured-->
	<div class="featured-l">
		<div class="container">
			<h3 class="tittle1">Our Services</h3>
			<div class="feature-grids">
				<div class="col-md-4 fer-grid">
					<div class="icons">
						<i class="glyphicon glyphicon-home" aria-hidden="true"></i>
					</div>
					<h4>Easy to use Dashboard</h4>
					<p>Duis aute irure dolor in reprehenderit in voluptate velit
						esse cillum dolore oluptate velit es pariatur.Quis autem vel eum
						iure reprehenderit qui.</p>
				</div>
				<div class="col-md-4 fer-grid">
					<div class="icons">
						<i class="glyphicon glyphicon-signal" aria-hidden="true"></i>
					</div>
					<h4>Customer with delight</h4>
					<p>Duis aute irure dolor in reprehenderit in voluptate velit
						esse cillum dolore oluptate velit es pariatur.Quis autem vel eum
						iure reprehenderit qui.</p>
				</div>
				<div class="col-md-4 fer-grid">
					<div class="icons">
						<i class="glyphicon glyphicon-cog" aria-hidden="true"></i>
					</div>
					<h4>List property with images</h4>
					<p>Duis aute irure dolor in reprehenderit in voluptate velit
						esse cillum dolore oluptate velit es pariatur.Quis autem vel eum
						iure reprehenderit qui.</p>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="feature-grids">
				<div class="col-md-4 fer-grid">
					<div class="icons">
						<i class="glyphicon glyphicon-globe" aria-hidden="true"></i>
					</div>
					<h4>Get prime visibilty</h4>
					<p>Duis aute irure dolor in reprehenderit in voluptate velit
						esse cillum dolore oluptate velit es pariatur.Quis autem vel eum
						iure reprehenderit qui.</p>
				</div>
				<div class="col-md-4 fer-grid">
					<div class="icons">
						<i class="glyphicon glyphicon-signal" aria-hidden="true"></i>
					</div>
					<h4>Customer Delight program</h4>
					<p>Duis aute irure dolor in reprehenderit in voluptate velit
						esse cillum dolore oluptate velit es pariatur.Quis autem vel eum
						iure reprehenderit qui.</p>
				</div>
				<div class="col-md-4 fer-grid">
					<div class="icons">
						<i class="glyphicon glyphicon-cog" aria-hidden="true"></i>
					</div>
					<h4>Best return on investment</h4>
					<p>Duis aute irure dolor in reprehenderit in voluptate velit
						esse cillum dolore oluptate velit es pariatur.Quis autem vel eum
						iure reprehenderit qui.</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--featured-->
	<div class="why">
		<div class="container">
			<div class="why-grids">
				<div class="col-md-6 why-grid">
					<h3 class="tittle2">Mission & Vision</h3>
					<p>Customer Service: We direct all of our efforts toward our
						customers – both internally and externally- to understand,
						anticipate, and satisfy their needs and expectations in a timely,
						cost-effective and value-added manner both as a company and as
						individuals.</p>

					<p>Initiative and Leadership: We encourage and reward
						entrepreneurial behavior, leading by example, prudent risk-taking;
						and we seek to foster an atmosphere of respect and empowerment for
						all employees.</p>

					<p>Communication: We will seek and share all information
						necessary and relevant to complete our jobs to the best of our
						ability.</p>

					<p>Training and Development: We encourage and support all
						employees to realize their full professional potential. We will
						provide training and educational programs to develop technical,
						project management, interpersonal, communication, and leadership
						skills.</p>

				</div>
				<div class="col-md-6 why-grid">
					<h3 class="tittle2">What We Offer</h3>
					<div class="tab1">
						<ul class="place">
							<li><img src="images/cir.png" alt=""></li>
							<li>Offering A Job</li>
						</ul>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Aliquam euismod sollicitudin nunc, eget pretium massa. Ut sed
							adipiscing enim, pellentesque ultrices erat. Integer placerat
							felis neque, et semper augue ullamcorper in. Pellentesque iaculis
							leo iaculis aliquet ultrices. Suspendisse potenti. Aenean ac
							magna faucibus, consectetur ligula vel, feugiat est.</p>
					</div>
					<div class="tab2">
						<ul class="place">
							<li><img src="images/cir.png" alt=""></li>
							<li>Career Oppurtunities</li>
						</ul>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Aliquam euismod sollicitudin nunc, eget pretium massa. Ut sed
							adipiscing enim, pellentesque ultrices erat. Integer placerat
							felis neque, et semper augue ullamcorper in. Pellentesque iaculis
							leo iaculis aliquet ultrices. Suspendisse potenti. Aenean ac
							magna faucibus, consectetur ligula vel, feugiat est.</p>
					</div>
					<div class="tab3">
						<ul class="place">
							<li><img src="images/cir.png" alt=""></li>
							<li>Eaque ipsa quae ab illo</li>
						</ul>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Aliquam euismod sollicitudin nunc, eget pretium massa. Ut sed
							adipiscing enim, pellentesque ultrices erat. Integer placerat
							felis neque, et semper augue ullamcorper in. Pellentesque iaculis
							leo iaculis aliquet ultrices. Suspendisse potenti. Aenean ac
							magna faucibus, consectetur ligula vel, feugiat est.</p>
					</div>

					<div class="tab4">
						<ul class="place">
							<li><img src="images/cir.png" alt=""></li>
							<li>User Guide</li>
						</ul>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Aliquam euismod sollicitudin nunc, eget pretium massa. Ut sed
							adipiscing enim, pellentesque ultrices erat. Integer placerat
							felis neque, et semper augue ullamcorper in. Pellentesque iaculis
							leo iaculis aliquet ultrices. Suspendisse potenti. Aenean ac
							magna faucibus, consectetur ligula vel, feugiat est.</p>
					</div>
					<!--script-->
					<script>
						$(document).ready(function() {
							$(".tab1 p").hide();
							$(".tab2 p").hide();
							$(".tab3 p").hide();
							$(".tab4 p").hide();
							$(".tab1 ul").click(function() {
								$(".tab1 p").slideToggle(300);
								$(".tab2 p").hide();
								$(".tab3 p").hide();
								$(".tab4 p").hide();
							})
							$(".tab2 ul").click(function() {
								$(".tab2 p").slideToggle(300);
								$(".tab1 p").hide();
								$(".tab3 p").hide();
								$(".tab4 p").hide();
							})
							$(".tab3 ul").click(function() {
								$(".tab3 p").slideToggle(300);
								$(".tab4 p").hide();
								$(".tab2 p").hide();
								$(".tab1 p").hide();
							})
							$(".tab4 ul").click(function() {
								$(".tab4 p").slideToggle(300);
								$(".tab3 p").hide();
								$(".tab2 p").hide();
								$(".tab1 p").hide();
							})
						});
					</script>
					<!-- script -->
				</div>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--Testimonial-->
	<div class="testimonials-l">
		<div class="container">
			<h3 class="tittle1" style="margin-bottom: 5px;">Testimonials</h3>
			<div class="testimonial-grids">
				<div class="col-md-6 test-grid">
					<div class="col-md-4 test-left">
						<img src="images/t1.jpg" class="img-responsive" alt="" />
					</div>
					<div class="col-md-8 test-right">
						<p>Over the past 10 years I have had 1-2 properties being
							looked after by Rahul and his staff. I have been extremely happy
							with their professionalism and positive response to what must be
							a very difficult, thankless job. The property managers have been
							active in their response to repairs and always patient with our
							frustrations. Rahul and his staff have always found us wonderful
							tenants and I thank them all for their work in protecting my
							properties.</p>
						<h5>Varun Sharma</h5>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-6 test-grid">
					<div class="col-md-4 test-left">
						<img src="images/t2.jpg" class="img-responsive" alt="" />
					</div>
					<div class="col-md-8 test-right">
						<p>Over the past 10 years I have had 1-2 properties being
							looked after by Rahul and his staff. I have been extremely happy
							with their professionalism and positive response to what must be
							a very difficult, thankless job. The property managers have been
							active in their response to repairs and always patient with our
							frustrations. Rahul and his staff have always found us wonderful
							tenants and I thank them all for their work in protecting my
							properties.</p>
						<h5>Pallavi Rawat</h5>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--Testimonial-->
</div>
