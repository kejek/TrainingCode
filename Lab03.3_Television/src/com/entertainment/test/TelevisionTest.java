//Lab 7.1 Packages
package com.entertainment.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

import com.entertainment.Catalog;
import com.entertainment.ColorTelevision;
import com.entertainment.PortableTelevision;
import com.entertainment.Television;

public class TelevisionTest {
	public static void main(String[] args) throws Exception {
		
		//Variables
		Random volume = new Random();
		int colTV = 0;
		int portableTV = 0;
		int baseTV = 0;
		int maxVolume = 0;
		
		//Modified Lab 6.1 Arrays
		ArrayList<Television> tvArray = new ArrayList<Television>();
		
		//Lab 11.1 Optional - Loudest TV
		Television loudest = null;
		
		//Lab 8.2 Inheritance Hardcoded TVs
		Television colorTV = new ColorTelevision("Sony",
				volume.nextInt(100));
		PortableTelevision portTV = new PortableTelevision("Hitachi",
				volume.nextInt(100));
		//Lab 11.1 Collections
				Collection<Television> results;				
				Collection<Television> fullInv = Catalog.getInventory();
				
				
				
		//Lab 11.2 Using Sets
		ArrayList<Television> tvList = new ArrayList<Television>();
		HashSet<Television> tvCopy = new HashSet<Television>();
		HashSet<Television> tvHash = new HashSet<Television>();
		
		
		//Lab 11.2 Using Sets
		tvList.add(colorTV);
		tvList.add(colorTV);
		tvList.add(portTV);
		tvList.add(portTV);

		System.out.println("ArrayList size: " + tvList.size());

		tvHash.add(colorTV);
		tvHash.add(colorTV);
		tvHash.add(portTV);
		tvHash.add(portTV);

		System.out.println("HashSet size: " + tvHash.size());

		tvCopy.addAll(tvList);

		System.out.println("HashSet copy Size: " + tvCopy.size());

		//Lab 6.1 - Arrays
		for (String s : args) {

			tvArray.add(new Television(s, volume.nextInt(100)));

			results = Catalog.searchByBrand(s);
			
			//Count the total number of loops in results.
			int i = 0;
			
			// Reset counts for next iteration
			colTV = 0;
			portableTV = 0;
			baseTV = 0;
			for (Television tv : results) {

				if (tv instanceof ColorTelevision) {
					colTV++;
				} else if (tv instanceof PortableTelevision) {
					portableTV++;
				} else if (tv instanceof Television) {
					baseTV++;
				}
				// outputTV(tv);
				i++;
				if (i >= results.size()) {
					System.out.println("For " + tv.getBrand());
				}
			}

			System.out.println("There are " + baseTV + " Televisions.");
			System.out.println("There are " + colTV + " Color Televisions.");
			System.out.println("There are " + portableTV
					+ " Portable Televisions.");

		}

		tvArray.add(portTV);
		tvArray.add(colorTV);

		for (int x = 0; x < tvArray.size(); x++) {
			outputTV(tvArray.get(x));

		}

		// Reset i for new loop.

		//Lab 11.1 Optional - Loudest Television
		for (Television tv : fullInv) {
			if (tv.getVolume() > maxVolume) {
				maxVolume = tv.getVolume();
				loudest = tv;
			}
		}

		System.out.println("Loudest television is " + loudest.toString());

	}

	private static void outputTV(Television tv) {
		System.out.println(tv);

		System.out.println("Muting " + tv.getTvType() + " " + tv.getBrand()
				+ "...");
		
		//Option Lab - Muting
		tv.mute();
		System.out.println(tv);

		System.out.println("Unmuting " + tv.getTvType() + " " + tv.getBrand()
				+ "...");

		tv.mute();
		System.out.println(tv);
		//End Optional Lab - Muting

		System.out.println("Changing channel on " + tv.getTvType() + " "
				+ tv.getBrand() + "...");

		tv.gotoChannel("ESPN 8: The Ocho");
		System.out.println(tv);
	}
}