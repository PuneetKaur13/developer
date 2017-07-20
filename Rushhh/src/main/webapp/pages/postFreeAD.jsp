
<div class="container"
	style="border-bottom: 3px solid #02B875; border-top: 3px solid #02B875; border-right: 3px solid #02B875; border-left: 3px solid #02B875;">
	<br>
	<h2 class="head_h2" style="text-align: center; color: #02B875;">POST
		YOUR PROPERTY</h2>
	<br>
	<div ng-show="ctl.message!=null">
		<br>
		<div
			ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}"
			style="text-align: center">
			<strong>{{ctl.message}}</strong>
		</div>
	</div>
	<form class="form-inline" style="margin-top: 20px"
		ng-submit="ctl.submit()">
		<div class="secHeading">
			<h4>Personal Info</h4>
		</div>
		<div class="col-lg-12" style="margin-top: 10px;">
			<div class="form-group col-sm-12 col-sm-3 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						I am an : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.personType"
					ng-options="d for d in ['Owner','Builder','Agent']" required>
					<option value="">--Select--</option>
				</select>
			</div>
		</div>
		<div class="col-lg-12" style="margin-top: 10px;">
			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						First Name : <span style="color: red;">*</span>
					</h5></label> <input type="text" ng-model="ctl.form.personFirstName"
					class="col-sm-7" style="height: 26px"
					placeholder="Enter First Name" required>
			</div>
			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Last Name : <span style="color: red;">*</span>
					</h5></label> <input type="text" ng-model="ctl.form.personLastName"
					class="col-sm-7" style="height: 26px" placeholder="Enter Last Name"
					required>
			</div>
		</div>
		<div class="col-lg-12" style="margin-top: 10px;">
			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Email : <span style="color: red;">*</span>
					</h5></label> <input type="email" ng-model="ctl.form.personEmail"
					class="col-sm-7" style="height: 26px" placeholder="Enter Email"
					required>
			</div>
			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Mobile No. : <span style="color: red;">*</span>
					</h5></label> <input type="text" ng-model="ctl.form.personMobileNo"
					class="col-sm-7" style="height: 26px" pattern="\d{10}"
					placeholder="Enter 10 digit Mobile No." required>
			</div>
		</div>
		<div class="col-lg-12" style="margin-top: 10px;">
			<hr>
		</div>
		<div class="secHeading">
			<h4>Property Info</h4>
		</div>
		<div class="col-lg-12" style="margin-top: 10px;">
			<div class="form-group col-sm-12 col-sm-3 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Property Type : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.propertyType"
					ng-options="d for d in ['Residential','Commercial','Agriculture Land']"
					required>
					<option value="">--Select--</option>
				</select>
			</div>
			<div class="form-group col-sm-12 col-sm-3 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Property For : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.propertyFor"
					ng-options="d for d in ['Rent','Sell','Buy']" required>
					<option value="">--Select--</option>
				</select>
			</div>
		</div>

		<div class="col-lg-12" style="margin-top: 10px;">

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Brief Description : <span style="color: red;">*</span>
					</h5></label>
				<textarea ng-model="ctl.form.propertyBriefDesciption"
					class="col-sm-7" style="height: 85px"
					placeholder="Brief Description in max 100 Words" maxlength="100"
					required></textarea>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Property Status : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.propertyStatus"
					ng-options="d for d in ['New Property','Ready to Move','Freehold']"
					required>
					<option value="">--Select--</option>
				</select>
			</div>
		</div>

		<div class="col-lg-12" style="margin-top: 10px;"
			ng-show="ctl.form.propertyType=='Residential'">
			<div class="form-group col-sm-12 col-sm-3 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Description Type : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.propertyDescriptionType"
					ng-options="d for d in ['Apartments / Flats','High Rise Apartment',
					'Builder Floor','Villas','Row House','Independent House','Studio Apartment','Duplex Apartment',
					'Condos','Penthouse Apartment','Farm House','Beach House','Residential Plot','Agricultural Plot']"
					ng-required="ctl.form.propertyType=='Residential'">
					<option value="">--Select--</option>
				</select>
			</div>
		</div>
		<div class="col-lg-12" style="margin-top: 10px;"
			ng-show="ctl.form.propertyType=='Commercial'">
			<div class="form-group col-sm-12 col-sm-3 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Description Type : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.propertyDescriptionType"
					ng-options="d for d in ['Office Space','Shop','Showroom']"
					ng-required="ctl.form.propertyType=='Commercial'">
					<option value="">--Select--</option>
				</select>
			</div>
		</div>
		<div class="col-lg-12" style="margin-top: 10px;">
			<hr>
		</div>
		<div class="secHeading">
			<h4 class="local">Property Location</h4>
		</div>
		<div class="col-lg-12" style="margin-top: 10px;">

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Address : <span style="color: red;">*</span>
					</h5></label>
				<textarea ng-model="ctl.form.address" class="col-sm-7"
					style="height: 150px" placeholder="Enter Property Address" required></textarea>
			</div>
			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Locality : <span style="color: red;">*</span>
					</h5></label> <input type="text" ng-model="ctl.form.locality" class="col-sm-7"
					style="height: 26px" placeholder="Enter Locality" required>
			</div>
			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Sub Locality : <span style="color: red;">*</span>
					</h5></label> <input type="text" ng-model="ctl.form.sublocality"
					class="col-sm-7" style="height: 26px"
					placeholder="Enter Sub Locality" required>
			</div>
			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Name Of Society : <span style="color: red;">*</span>
					</h5></label> <input type="text" ng-model="ctl.form.nameOfSociety"
					class="col-sm-7" style="height: 26px"
					placeholder="Enter Name Of Society" required>
			</div>
			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Landmark :</h5></label> <input type="text" ng-model="ctl.form.landmark"
					class="col-sm-7" style="height: 26px" placeholder="Enter Landmark">
			</div>
			<div class="form-group col-sm-12 col-sm-3 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						State : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.stateId"
					ng-options="d.id as d.stateName for d in ctl.dataList.preload.stateList"
					ng-change="ctl.findCity(ctl.form.stateId)" required>
					<option value="">--Select--</option>
				</select>
			</div>

			<div class="form-group col-sm-12 col-sm-3 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						City : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.cityId"
					ng-options="d.id as d.cityName for d in ctl.cityList" required>
					<option value="">--Select--</option>
				</select>
			</div>
		</div>

		<div class="col-lg-12" style="margin-top: 10px;">
			<hr>
		</div>
		<div class="secHeading">
			<h4 class="local">Property Details</h4>
		</div>

		<div class="col-lg-12" style="margin-top: 10px;"
			ng-hide="ctl.form.propertyType=='Agriculture Land'">

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Area : <span style="color: red;">*</span>
					</h5></label> <input type="number" ng-model="ctl.form.area" class="col-sm-7"
					style="height: 26px" pattern="[0-9]+([\,|\.][0-9]+)?" step="0.01"
					placeholder="Enter Property Area" min="0"
					ng-required="ctl.form.propertyType=='Residential' || ctl.form.propertyType=='Commercial'">
			</div>
			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Area Type : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.areaType"
					ng-options="d for d in ['Sq feet','Sq yards','Sq meter','Cents','Grounds','Acres']"
					ng-required="ctl.form.propertyType=='Residential' || ctl.form.propertyType=='Commercial'">
				</select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Carpet Area : <span style="color: red;">*</span>
					</h5></label> <input type="number" ng-model="ctl.form.carpetArea"
					placeholder="Enter Property Carpet Area" class="col-sm-7"
					style="height: 26px" pattern="[0-9]+([\,|\.][0-9]+)?" step="0.01"
					min="0"
					ng-required="ctl.form.propertyType=='Residential' || ctl.form.propertyType=='Commercial'">
			</div>
			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Carpet Area Type : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.carpetAreaType"
					ng-options="d for d in ['Sq feet','Sq yards','Sq meter','Cents','Grounds','Acres']"
					ng-required="ctl.form.propertyType=='Residential' || ctl.form.propertyType=='Commercial'">
				</select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						<span ng-show="ctl.form.propertyType=='Commercial'">Washrooms
							: </span> <span
							ng-show="ctl.form.propertyType=='Residential' || ctl.form.propertyType==undefined">Bathrooms
							: </span> <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.bathrooms"
					ng-options="d for d in ['1','2','3','4+']"
					ng-required="ctl.form.propertyType=='Residential' || ctl.form.propertyType=='Commercial'"><option
						value="">--Select--</option></select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6"
				ng-show="ctl.form.propertyType=='Residential'">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Balconies :</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.balconies"
					ng-options="d for d in ['0','1','2','3','4+']"><option
						value="">--Select--</option>
				</select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6"
				ng-show="ctl.form.propertyType=='Residential'">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Bedrooms : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.bedrooms"
					ng-options="d for d in ['1 BHK','2 BHK','3 BHK','4 BHK','4 BHK+']"
					ng-required="ctl.form.propertyType=='Residential' || ctl.form.propertyType=='Commercial'"><option
						value="">--Select--</option>
				</select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6"
				ng-show="ctl.form.propertyType=='Commercial'">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Pentries :</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.pentries"
					ng-options="d for d in ['1','2','3','4+']"><option
						value="">0</option>
				</select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6"
				ng-show="ctl.form.propertyType=='Commercial'">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Cafeteria : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.cafeteria"
					ng-options="d for d in ['1','2','3','4+']"><option
						value="">0</option>
				</select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Furnishing Type : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.furnishingType"
					ng-options="d for d in ['Fully furnished','Semi furnished','Unfurnished']"
					ng-required="ctl.form.propertyType=='Residential' || ctl.form.propertyType=='Commercial'">
				</select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Total Floors : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.totalFloors"
					ng-required="ctl.form.propertyType=='Residential' || ctl.form.propertyType=='Commercial'">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
					<option value="32">32</option>
					<option value="33">33</option>
					<option value="34">34</option>
					<option value="35">35</option>
					<option value="36">36</option>
					<option value="37">37</option>
					<option value="38">38</option>
					<option value="39">39</option>
					<option value="40">40</option>
					<option value="41">41</option>
					<option value="42">42</option>
					<option value="43">43</option>
					<option value="44">44</option>
					<option value="45">45</option>
					<option value="46">46</option>
					<option value="47">47</option>
					<option value="48">48</option>
					<option value="49">49</option>
					<option value="50">50</option>
					<option value="51">51</option>
					<option value="52">52</option>
					<option value="53">53</option>
					<option value="54">54</option>
					<option value="55">55</option>
					<option value="56">56</option>
					<option value="57">57</option>
					<option value="58">58</option>
					<option value="59">59</option>
					<option value="60">60</option>
				</select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Direction Facing : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.directionFacing"
					ng-options="d for d in ['East','West','North','South','South west','South east','North east','North west']"
					ng-required="ctl.form.propertyType=='Residential' || ctl.form.propertyType=='Commercial'">
					<option value="">--Select--</option>
				</select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Price : <span style="color: red;">*</span>
					</h5></label> <input type="number" ng-model="ctl.form.propertyPrice"
					class="col-sm-7" min="0" style="height: 26px"
					placeholder="Enter Property Price" required>
			</div>
		</div>

		<div class="col-lg-12" style="margin-top: 10px;"
			ng-show="ctl.form.propertyType=='Agriculture Land'">

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						No. Of Open Sides : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.noOfOpenSides"
					ng-options="d for d in ['1','2','3','4']"
					ng-required="ctl.form.propertyType=='Agriculture Land'"><option
						value="">--Select--</option>
				</select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Width of real facing of the plot : <span style="color: red;">*</span>
					</h5></label> <input type="number" ng-model="ctl.form.widthOfRealFacing"
					class="col-sm-7" style="height: 26px" min="0"
					placeholder="Enter Width of real facing"
					ng-required="ctl.form.propertyType=='Agriculture Land'"><label
					class="col-sm-5" style="font-weight: normal;"><h5>Meters</h5></label>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Plot Area : <span style="color: red;">*</span>
					</h5></label> <input type="number" ng-model="ctl.form.plotArea" class="col-sm-7"
					style="height: 26px" min="0" placeholder="Enter Plot Area"
					ng-required="ctl.form.propertyType=='Agriculture Land'">
			</div>
			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Plot Area Type : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.plotAreaType"
					ng-required="ctl.form.propertyType=='Agriculture Land'">
					<option value="Sq-ft">Sq-ft</option>
					<option value="Sq-yrd">Sq-yrd</option>
					<option value="Sq-m">Sq-m</option>
					<option value="Acre">Acre</option>
					<option value="Bigha">Bigha</option>
					<option value="Hectare">Hectare</option>
					<option value="Marla">Marla</option>
					<option value="Kanal">Kanal</option>
					<option value="Biswa1">Biswa1</option>
					<option value="Biswa2">Biswa2</option>
					<option value="Ground">Ground</option>
					<option value="Aankadam">Aankadam</option>
					<option value="Rood">Rood</option>
					<option value="Chatak">Chatak</option>
					<option value="Kottah">Kottah</option>
					<option value="Marla">Marla</option>
					<option value="Cent">Cent</option>
					<option value="Perch">Perch</option>
					<option value="Guntha">Guntha</option>
					<option value="Are">Are</option>
				</select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Plot Length (Yrd) : <span style="color: red;">*</span>
					</h5></label> <input type="number" ng-model="ctl.form.plotLength"
					class="col-sm-7" style="height: 26px"
					pattern="[0-9]+([\,|\.][0-9]+)?" step="0.01" min="0"
					placeholder="Enter Plot Length"
					ng-required="ctl.form.propertyType=='Agriculture Land'">
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Plot Breadth (Yrd) : <span style="color: red;">*</span>
					</h5></label> <input type="number" ng-model="ctl.form.plotBreadth"
					class="col-sm-7" style="height: 26px"
					placeholder="Enter Plot Breadth" pattern="[0-9]+([\,|\.][0-9]+)?"
					step="0.01" min="0"
					ng-required="ctl.form.propertyType=='Agriculture Land'">
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Boundary Wall : <span style="color: red;">*</span>
					</h5></label> <select class="col-sm-7" style="height: 26px"
					ng-model="ctl.form.boundaryWall"
					ng-options="d for d in ['Yes','No']"
					ng-required="ctl.form.propertyType=='Agriculture Land'"><option
						value="">--Select--</option>
				</select>
			</div>

			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<label class="col-sm-5" style="font-weight: normal;"><h5>
						Price : <span style="color: red;">*</span>
					</h5></label> <input type="number" ng-model="ctl.form.propertyPrice"
					class="col-sm-7" style="height: 26px"
					placeholder="Enter Plot Price"
					ng-required="ctl.form.propertyType=='Agriculture Land'">
			</div>
		</div>

		<div class="col-lg-12" style="margin-top: 10px;">
			<hr>
		</div>
		<div class="secHeading">
			<h4 class="local">
				Description <span style="color: red;">*</span>
			</h4>
		</div>
		<div class="col-lg-12" style="margin-top: 10px;">
			<div class="form-group col-xs-12 col-sm-6 col-lg-12">
				<textarea ng-model="ctl.form.description" class="col-sm-12"
					style="height: 110px;" placeholder="Enter Description" required></textarea>
			</div>
		</div>

		<div class="col-lg-12" style="margin-top: 10px;">
			<hr>
		</div>
		<div class="secHeading">
			<h4 class="local">Property Images</h4>
		</div>
		<br>
		<div class="form-group">
			<label for="shortName" class="control-label">Image 1 :
				{{ctl.uploadForm1.uploadMessage}}</label> <img
				ng-src="/Rushhh/upload/{{ctl.form.imagePath1}}" id="mediaHere"
				class="img-rounded" style="max-width: 150px;"
				ng-show="ctl.form.imagePath1!=''"> <input accept="image/*"
				type="file" file-model="ctl.uploadForm1.file" id="fileUser"
				ng-model="ctl.uploadForm1.file" preview-class="img-thumbnail"
				preview-container="mediaHere" media-preview
				ng-change="ctl.upload1();" ng-disabled="!ctl.button.add">
		</div>

		<div class="form-group">
			<label for="shortName" class="control-label">Image 2 :
				{{ctl.uploadForm2.uploadMessage}}</label> <img
				ng-src="/Rushhh/upload/{{ctl.form.imagePath2}}" id="mediaHere"
				class="img-rounded" style="max-width: 150px;"
				ng-show="ctl.form.imagePath2!=''"> <input accept="image/*"
				type="file" file-model="ctl.uploadForm2.file" id="fileUser"
				ng-model="ctl.uploadForm2.file" preview-class="img-thumbnail"
				preview-container="mediaHere" media-preview
				ng-change="ctl.upload2();" ng-disabled="!ctl.button.add">
		</div>


		<div class="form-group">
			<label for="shortName" class="control-label">Image 3 :
				{{ctl.uploadForm3.uploadMessage}}</label> <img
				ng-src="/Rushhh/upload/{{ctl.form.imagePath3}}" id="mediaHere"
				class="img-rounded" style="max-width: 150px;"
				ng-show="ctl.form.imagePath3!=''"> <input accept="image/*"
				type="file" file-model="ctl.uploadForm3.file" id="fileUser"
				ng-model="ctl.uploadForm3.file" preview-class="img-thumbnail"
				preview-container="mediaHere" media-preview
				ng-change="ctl.upload3();" ng-disabled="!ctl.button.add">
		</div>

		<div class="form-group">
			<label for="shortName" class="control-label">Image 4 :
				{{ctl.uploadForm4.uploadMessage}}</label> <img
				ng-src="/Rushhh/upload/{{ctl.form.imagePath4}}" id="mediaHere"
				class="img-rounded" style="max-width: 150px;"
				ng-show="ctl.form.imagePath4!=''"> <input accept="image/*"
				type="file" file-model="ctl.uploadForm4.file" id="fileUser"
				ng-model="ctl.uploadForm4.file" preview-class="img-thumbnail"
				preview-container="mediaHere" media-preview
				ng-change="ctl.upload4();" ng-disabled="!ctl.button.add">
		</div>
		<div class="form-group">
			<label for="shortName" class="control-label">Image 5 :
				{{ctl.uploadForm5.uploadMessage}}</label> <img
				ng-src="/Rushhh/upload/{{ctl.form.imagePath5}}" id="mediaHere"
				class="img-rounded" style="max-width: 150px;"
				ng-show="ctl.form.imagePath5!=''"> <input accept="image/*"
				type="file" file-model="ctl.uploadForm5.file" id="fileUser"
				ng-model="ctl.uploadForm5.file" preview-class="img-thumbnail"
				preview-container="mediaHere" media-preview
				ng-change="ctl.upload5();" ng-disabled="!ctl.button.add">
		</div>
		<div ng-show="ctl.message!=null">
			<br>
			<div
				ng-class="{'alert alert-success':ctl.success,'alert alert-danger':!ctl.success}"
				style="text-align: center">
				<strong>{{ctl.message}}</strong>
			</div>
		</div>
		<div class="col-lg-12" style="margin-top: 10px;">
			<div class="form-group col-xs-12 col-sm-6 col-lg-6">
				<div class="login-grids">
					<div class="login">
						<div class="login-right">
							<input type="submit" value="Submit" ng-disabled="!ctl.button.add"
								style="width: 23%; height: 34px; margin-bottom: 12px; padding-bottom: 30px; margin-left: 477px;">
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>
<br>