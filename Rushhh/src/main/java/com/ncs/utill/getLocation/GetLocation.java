package com.ncs.utill.getLocation;

import java.io.File;
import java.io.IOException;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;

public class GetLocation {

	public static void main(String[] args) {
		GetLocation obj = new GetLocation();
		ServerLocation location = obj.getLocation("111.118.250.74");
		System.out.println(location);
	}

	public ServerLocation getLocation(String ipAddress) {
		String fileName = "GeoLiteCity.dat";
		ClassLoader classLoader = new GetLocation().getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return getLocation(ipAddress, file);
	}

	public ServerLocation getLocation(String ipAddress, File file) {

		ServerLocation serverLocation = null;

		try {

			serverLocation = new ServerLocation();

			LookupService lookup = new LookupService(file, LookupService.GEOIP_MEMORY_CACHE);
			Location locationServices = lookup.getLocation(ipAddress);

			serverLocation.setCountryCode(locationServices.countryCode);
			serverLocation.setCountryName(locationServices.countryName);
			serverLocation.setRegion(locationServices.region);
			serverLocation
					.setRegionName(regionName.regionNameByCode(locationServices.countryCode, locationServices.region));
			serverLocation.setCity(locationServices.city);
			serverLocation.setPostalCode(locationServices.postalCode);
			serverLocation.setLatitude(String.valueOf(locationServices.latitude));
			serverLocation.setLongitude(String.valueOf(locationServices.longitude));

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		return serverLocation;

	}
}
