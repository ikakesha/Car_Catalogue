package com.example.assignment3;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	
         private String name;
         private String description;
         private int image;
         
         public Vehicle(  String name,int image, String description ) {
        	 this.setName(name);
        	 this.setDescription(description);
        	 this.setImage(image);
			// TODO Auto-generated constructor stub
		}
         
         public static List<Vehicle> getDataForListView()
         {
             List<Vehicle> vehiclesList = new ArrayList<Vehicle>();

             Vehicle car = new Vehicle("Chevrolet Corvette",R.drawable.first, "Overview: The all-new Corvette Stingray—the seventh generation, or C7, as it is known—sheds any remaining vestiges of its rude-and-crude heritage. It now competes with the world’s most highly regarded sports cars in output, refinement, and features, at a relative bargain price. To recognize this feat, we gave it a 10Best award. In appearance and performance, it fully earns the revival of its fabled Stingray badge. Should you have the means, we highly recommend it");
                
             vehiclesList.add(car);
             
             car = new Vehicle("Porsche 911",R.drawable.second, "Everything has changed, but it all seems familiar. In its seventh generation, Porsche’s iconic 911 is thoroughly updated while retaining the same unmistakable look and design philosophy it’s had for 50 years: a refined, rear-engined sports car that’s capable of extreme high-speed touring. The advances have been many—liquid cooling, twin turbos, seven-speed transmissions—but the mission remains the same.");
             vehiclesList.add(car);
             
             car = new Vehicle("Audi R8",R.drawable.third, "Overview: Crafted from the rib of the Lamborghini Gallardo, Audi’s luscious R8 supercar is beautiful to behold, easy to live with, and simply marvelous to drive. A midcycle update keeps styling fresh, while a lightweight, 550-hp “V-10 Plus” coupe model joins the lineup for 2014. Both coupe and roadster models remain available with carry-over 430-hp V-8 or 525-hp V-10 engines paired to either a gated six-speed manual or a seven-speed dual-clutch automatic. Regardless of how it comes, the R8 is pure lust. ");
             vehiclesList.add(car);
             
             car = new Vehicle("Jaguar F-type",R.drawable.jaguar, "Overview: Jaguar’s new sports car, the F-type, has big shoes to fill, not to mention stiff competition from the new Chevrolet Corvette and the Porsche 911. Luckily, the F-type’s taut suspension, agile steering, and snarling exhaust note make for an exciting drive. The base engine is a 340-hp 3.0-liter supercharged V-6, but the F-type S ups power to 380 hp. The convertible F-type V-8 S gets a supercharged, 495-hp 5.0-liter V-8 and the coupe gets a 550-hp version of that engine in the F-type R.");
             vehiclesList.add(car);
             
             car = new Vehicle("Nisan G-TR",R.drawable.nissan, "Overview: Nissan’s GT-R may be fugly to the lay person, but as an instrument of pure speed, it’s a thing of beauty. A 545-hp, twin-turbo V-6 and astounding, all-wheel-drive grip give the GT-R supercar-grade performance. Its six-figure price, while high for a Nissan, is cheap among anything else so quick. Numerous enhancements over the years have made it ever faster and more refined, with 0-to-60 times dropping below three seconds. That’s Bugatti territory. This car’s not called Godzilla for nothing.");
             vehiclesList.add(car);
            
             return vehiclesList;

         }

		public String getName() {
			return name;
		}

		private void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		private void setDescription(String description) {
			this.description = description;
		}

		public int getImage() {
			return image;
		}

		private void setImage(int image) {
			this.image = image;
		}
 
}
