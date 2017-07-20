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

<!--header-->
<div class="content">
	<div class="serach-agile">
		<div class="container">
			<div class="place-grids">
				<div class="col-md-1 place-grid"></div>
				<div class="col-md-4 place-grid">
					<h5>Location</h5>
					<input type="text" placeholder=" Location" class="sel">
				</div>
				<div class="col-md-2 place-grid">
					<h5>Property For</h5>
					<select class="sel">
						<option value="">All Types</option>
						<option value="Rent">Rent</option>
						<option value="Sale">Sale</option>
						<option value="Buy">Buy</option>
					</select>
				</div>
				<div class="col-md-2 place-grid">
					<h5>Property Type</h5>
					<select class="sel" >
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
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation" class="active"><a href="#"
				style="margin-top: 30px; border-top-color: #02B875; border-top-width: 3px;">Properties</a></li>
			<!-- <li role="presentation"><a href="#" style="margin-top: 30px;">New
					Projects</a></li>
			<li role="presentation"><a href="#" style="margin-top: 30px;">Agents</a></li> -->
		</ul>
	</div>
	<div class="container">
		<div class="list-strip">
			<div class="row">
				<div class="col-md-8">
					<div class="bhk-text">
						<h4>
							<b>Properties for your criteria</b>
						</h4>
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<input type="email" class="form-control" id="exampleInputEmail1"
							ng-model="Search" placeholder="Search.."
							style="float: right; margin-top: -4px;">
					</div>
				</div>
				<div class="col-md-1">
					<button type="button" class="btn btn-primary"
						style="background-color: #02B875; float: right; height: 34px; margin-top: -4px;">
						<img src="images/list.png" class="hvr-grow">
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="table-background table-responsive"
			ng-repeat="data in ctl.dataList.list | filter : Search">
			<div class="row">
				<div class="col-lg-4">
					<!--Card-->
					<div class="card">
						<!--Card image-->
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								<li data-target="#myCarousel" data-slide-to="1"></li>
								<li data-target="#myCarousel" data-slide-to="2"></li>
								<li data-target="#myCarousel" data-slide-to="3"></li>
								<li data-target="#myCarousel" data-slide-to="4"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img src="/Rushhh/upload/{{data.imagePath1}}"
										class="img-rounded" alt="Cinque Terre" width="304"
										height="236">
								</div>
								<div class="item">
									<img src="/Rushhh/upload/{{data.imagePath2}}"
										class="img-rounded" alt="Cinque Terre" width="304"
										height="236">
								</div>
								<div class="item">
									<img src="/Rushhh/upload/{{data.imagePath3}}"
										class="img-rounded" alt="Cinque Terre" width="304"
										height="236">
								</div>
								<div class="item">
									<img src="/Rushhh/upload/{{data.imagePath4}}"
										class="img-rounded" alt="Cinque Terre" width="304"
										height="236">
								</div>
								<div class="item">
									<img src="/Rushhh/upload/{{data.imagePath5}}"
										class="img-rounded" alt="Cinque Terre" width="304"
										height="236">
								</div>
							</div>
						</div>
						<br>
						<div class="card-block">
							<h3>{{data.personType}} : {{data.personFirstName}}
								{{data.personLastName}}</h3>
							<h4 class="card-text">Area : {{data.area}} {{data.areaType}}</h4>
							<h4 class="card-text">Rs. : {{data.propertyPrice}}</h4>
						</div>
					</div>
					<!--/.Card-->
				</div>
				<div class="col-lg-5">
					<div class="sale" style="text-align: center; margin-top: 10px;">
						<a href="#"></a>
						<h4>
							<b>{{data.propertyBriefDesciption}}</b> For {{data.propertyFor}}
							In {{data.locality}} <b>{{data.area}} {{data.areaType}}</b>
						</h4>
					</div>
					<hr>
					<div class="row">
						<div class="col-md-3">
							<div class="status-text">Status :</div>
							<div class="detail-text">Details :</div>
							<div class="description-text">Description:</div>
						</div>
						<div class="col-md-6">
							<div class="status-description">
								<p>{{data.propertyType}} , {{data.propertyDescriptionType}}</p>
							</div>
							<div class="detail-description">
								<p>
									{{data.bedrooms}} | {{data.furnishingType}} |
									{{data.directionFacing}}
									<!--  <a href="#">View
										Details</a>-->
								</p>
							</div>
							<div class="para-description">
								<p>{{data.propertyType}} is available for
									{{data.propertyFor}} in {{data.locality}}, Near
									{{data.landmark}} {{data.address}}</p>
							</div>
						</div>
					</div>
					<img src="images/contact.png"
						style="margin-top: 10px; margin-left: 121px;"> <img
						src="images/call.png" style="margin-top: 10px;"> <img
						src="images/chat.png" style="margin-top: 10px;"> <img
						src="images/likes.png" style="margin-top: 10px;">
				</div>
				<div class="col-lg-3">
					<div class="location-map">
						<iframe
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3679.3351795924928!2d75.89151466496288!3d22.752939135090216!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x396302af403406fb%3A0x5b50834b117f8bab!2sVijay+Nagar%2C+Indore%2C+Madhya+Pradesh+452010!5e0!3m2!1sen!2sin!4v1498998073055"
							width="265" height="350" frameborder="0" style="border: 0"
							allowfullscreen></iframe>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>