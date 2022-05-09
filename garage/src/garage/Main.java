package garage;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	//this is the main method, it acts as the controller class and runs the entire code.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] models = {"toyota", "tesla", "ford", "mitsubishi", "subaru"};
		String[] colors = {"red", "green", "gray", "black", "orange", "white"};
		String[] modelPackages = {"standard", "premium", "deluxe"};
		
		ArrayList<Car> garage = new ArrayList<Car>();
		
		for (String a: models)
		{
			for (String b: colors)
			{
				for(String c: modelPackages)
				{
					garage.add(new Car(a, b, c));
				}
			}
		}
		boolean run = true;
		String[] options = {"display all cars", "display all available models", "display all specific cars based on model", "remove all models based on color", "remove all models based on package", "remove one car with specific model and package", "add a car"};
		while (run)
		{
			String menuSelection = (String)JOptionPane.showInputDialog(null, "please select an option", "garage program", 0, null, options, null);
			if(menuSelection == "display all cars")
			{
				String print = "";
				for(int i = 0; i < garage.size(); i++)
				{
					int a = i+1;
					print += a + ") " + garage.get(i).color + " " + garage.get(i).model + " with " + garage.get(i).modelPackage + " package ";
					if (i%3 == 0)
					{
						print += "\n";
					}
				}
				JOptionPane.showMessageDialog(null, print);
			}
			else if (menuSelection == "display all available models")
			{
				int toyota = 0;
				int tesla = 0;
				int ford = 0;
				int mitsubishi = 0;
				int subaru = 0;
				for (int i = 0; i < garage.size(); i++)
				{
					if (garage.get(i).model == "toyota")
						toyota++;
					else if (garage.get(i).model == "tesla")
						tesla++;
					else if (garage.get(i).model == "ford")
						ford++;
					else if (garage.get(i).model == "mitsubishi")
						mitsubishi++;
					else if (garage.get(i).model == "subaru")
						subaru++;		
				}
				JOptionPane.showMessageDialog(null, "There are " + toyota + " toyotas, " + tesla + " teslas, " + ford + " fords, " + mitsubishi + " mitsubishis, and " + subaru + " subarus.");
			}
			else if (menuSelection == "display all specific cars based on model")
			{
				String print = "";
				String model = (String) JOptionPane.showInputDialog(null, "please select a model", "garage program", 0, null, models, null);
				for (int i = 0; i < garage.size(); i++)
				{
					if(garage.get(i).model.equalsIgnoreCase(model))
					{
						print += garage.get(i).color + " " + garage.get(i).model + " with " + garage.get(i).modelPackage + " package\n";
					}
				}
				JOptionPane.showMessageDialog(null, print);
			}
			else if (menuSelection == "remove all models based on color")
			{
				int counter = 0;
				String color = (String) JOptionPane.showInputDialog(null, "please select a color", "garage program", 0, null, colors, null);
				for (int i = 0; i < garage.size(); i++)
				{
					if(garage.get(i).color.equalsIgnoreCase(color))
					{
						garage.remove(i);
						i = 0;
						counter++;
					}
				}
				JOptionPane.showMessageDialog(null, "removed " + counter + " cars");
			}
			else if (menuSelection == "remove all models based on package")
			{
				int counter = 0;
				String carPackage = (String) JOptionPane.showInputDialog(null, "please select a package", "garage program", 0, null, modelPackages, null);
				for (int i = 0; i < garage.size(); i++)
				{
					if(garage.get(i).modelPackage.equalsIgnoreCase(carPackage))
					{
						garage.remove(i);
						i = 0;
						counter++;
					}
				}
				JOptionPane.showMessageDialog(null, "removed " + counter + " cars");
			}
			else if (menuSelection == "remove one car with specific model and package")
			{
				String print = "";
				String model = (String) JOptionPane.showInputDialog(null, "please select a model", "garage program", 0, null, models, null);
				String carPackage = (String) JOptionPane.showInputDialog(null, "please select a package", "garage program", 0, null, modelPackages, null);
				for (int i = 0; i < garage.size(); i++)
				{
					if(garage.get(i).model.equalsIgnoreCase(model) && garage.get(i).modelPackage.equalsIgnoreCase(carPackage))
					{
						print += "Removed a " + garage.get(i).color + " " + garage.get(i).model + " with a " + garage.get(i).modelPackage + " package.";
						garage.remove(i);
						i = garage.size();
					}
				}
				JOptionPane.showMessageDialog(null, print);
			}
			else if (menuSelection == "add a car")
			{
				String model = (String) JOptionPane.showInputDialog(null, "please select a model", "garage program", 0, null, models, null);
				String color = (String) JOptionPane.showInputDialog(null, "please select a color", "garage program", 0, null, colors, null);
				String carPackage = (String) JOptionPane.showInputDialog(null, "please select a package", "garage program", 0, null, modelPackages, null);
				garage.add(new Car(model, color, carPackage));
			}
			else
			{
				run = false;
			}
		}
	}
}
