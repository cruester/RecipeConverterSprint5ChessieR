package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Chessie on 11/6/2015.
 */
public  class Recipe {


    ArrayList<String> ingredients = new ArrayList<>(); //This array list holds ingredient NAMES
    ArrayList<Double> amounts = new ArrayList<Double>(); //This array list holds the amount of each ingredient needed
    ArrayList<String> units = new ArrayList<String>(); //This array list holds units for each ingredient
    ArrayList<Double> newAmounts = new ArrayList<Double>();
    int counter = 0; //This variable stores the final value in the main program ingredient counter. I
    // will use it to
    double numerator = 0;

    //These two array lists are for storing metric values. I didn't want to overwrite English values
    ArrayList<Double> metricAmount = new ArrayList<Double>();
    ArrayList<String> metricUnits = new ArrayList<String>();

    //These two array lists are for storing English values.
    ArrayList<Double> englishAmount = new ArrayList<Double>();
    ArrayList<String> englishUnits = new ArrayList<String>();

    //This array list holds nice fraction values
    ArrayList<String> amountsInFractionFormat = new ArrayList<String>();

    double calories = -1; //Stores recipe's calories per serving initialized to -1 to easily skip
    //while displaying if the user doesn't add anything

    double fat = -1; //Stores grams of fat per serving

    double protein = -1; //Stores grams of protein per serving

    double sodium = -1; //Stores mg of sodium per serving

    double carbs = -1; //Stores grams of carbohydrates per serving


    public void setFirstIngredient(String i) {
        ingredients.add(0, i);
    }

    public void setFirstAmount(double a) {
        amounts.add(0, a);
    }

    public void setFirstUnit(int u) {
        switch (u) {
            case 1:
                units.add(0, "Cups");
                break;
            case 2:
                units.add(0, "teaspoons");
                break;
            case 3:
                units.add(0, "Tablespoons");
                break;
            case 4:
                units.add(0, "Grams");
                break;
            case 5:
                units.add(0, "lbs");
                break;
            case 6:
                units.add(0, "Liters");
                break;
            case 7:
                units.add(0, "Milliliters");
                break;
            case 8:
                units.add(0, "Ounces");
                break;
            case 9:
                units.add(0, "Cups (liquid)");
                break;
            case 10:
                units.add(0, "fl Ounces");
                break;
            case 11:
                units.add(0, "Kilograms");
                break;
            case 12:
                units.add(0, "");
                break;
        }
    }

    public void setIngredients(String ingreds, int count) {
        ingredients.add(count, ingreds);
    }

    public void setAmounts(double amount, int count) {
        amounts.add(count, amount);
    }

    //Set units converts the easy to enter int typed by the user into the written out word.
    // Done with a simple switch statement.
    public void setUnits(int unit, int count) {
        switch (unit) {
            case 1:
                units.add(count, "Cups");
                break;
            case 2:
                units.add(count, "teaspoons");
                break;
            case 3:
                units.add(count, "Tablespoons");
                break;
            case 4:
                units.add(count, "Grams");
                break;
            case 5:
                units.add(count, "lbs");
                break;
            case 6:
                units.add(count, "Liters");
                break;
            case 7:
                units.add(count, "Milliliters");
                break;
            case 8:
                units.add(count, "Ounces");
                break;
            case 9:
                units.add(count, "Cups (liquid)");
                break;
            case 10:
                units.add(count, "fl Ounces");
                break;
            case 11:
                units.add(count, "Kilograms");
                break;
            case 12:
                units.add(count, "");
                break;
        }
    }

    public void setCounter(int count) {
        counter = count;
    }

    public void convertAmounts(int c, int count) {

        for (int i = 0; i < count; i++) {
            switch (c) {
                case 1: {
                    newAmounts.add(i, amounts.get(i) * .25);
                }
                break;
                case 2: {
                    newAmounts.add(i, amounts.get(i) * .5);
                }
                break;
                case 3: {
                    newAmounts.add(i, amounts.get(i) / 3);
                }
                break;
                case 4: {
                    newAmounts.add(i, amounts.get(i) * 1.5);
                }
                break;
                case 5: {
                    newAmounts.add(i, amounts.get(i) * 2);
                }
                break;
                case 6: {
                    newAmounts.add(i, amounts.get(i) * 3);
                }
                break;
            }
        }

    }

    public void calculateCustomAmounts(int count, double input) {
        for (int x = 0; x < count; x++) {
            newAmounts.add(x, amounts.get(x) * input);
        }
    }

    public void displayNewList(int count) {
        for (int i = 0; i < count; i++) {
            //This will format the each line according to whether there are units or not (ex. 2 eggs vs eggs 2)
            if (units.get(i) == "") {
                System.out.println(newAmounts.get(i) + " " + ingredients.get(i));
            } else {
                System.out.println(ingredients.get(i) + " " + newAmounts.get(i) + " " + units.get(i));
            }
        }
    }

    public void unitCorrector(int count) {
        for (int x = 0; x < count; x++) {
            if (newAmounts.get(x) > 1) {
                if (units.get(x) == "Cup") {
                    units.set(x, "Cups");
                }
            } else {

            }
        }
    }

    public void englishToMetric(int count) {
        for (int i = 0; i < count; i++) {
            //Cups to ml
            if (units.get(i).equals("Cups (liquid)")) {
                metricUnits.add(i, "mL"); //Change the unit
                metricAmount.add(i, (amounts.get(i) * 236.6)); //Change the amount
            }
            //Oz to grams
            else if (units.get(i).equals("Ounces")) {
                metricUnits.add(i, "grams"); //Change unit
                metricAmount.add(i, (amounts.get(i) * 28.35)); //Change amount
            }
            //Lbs to Kg
            else if (units.get(i).equals("lbs")) {
                metricUnits.add(i, "Kg");
                metricAmount.add(i, amounts.get(i) * 2.2);
            }
            //fl oz to mL
            else if (units.get(i).equals("fl Ounces")) {
                metricUnits.add(i, "mL");
                metricAmount.add(i, amounts.get(i) / .033814);
            } else {
                metricUnits.add(i, units.get(i));
                metricAmount.add(i, amounts.get(i));
            }
        }
    }

    public void displayEnglishToMetricList(int count) {
        for (int i = 0; i < count; i++) {
            //This will format the each line according to whether there are units or not (ex. 2 eggs vs eggs 2)
            if (metricUnits.get(i).equals("")) {
                System.out.println(metricAmount.get(i) + " " + ingredients.get(i));
            } else {
                System.out.println(ingredients.get(i) + " " + metricAmount.get(i) + " " + metricUnits.get(i));
            }
        }
    }

    /*This is a modified englishToMetric method for when amounts get changed.
    It might be a dumb way to take care of the issue, but I'm using it until something
    better comes along */
    public void modifiedEnglishToMetric(int count) {
        for (int i = 0; i < count; i++) {
            //Cups to ml
            if (units.get(i).equals("Cups (liquid)")) {
                metricUnits.add(i, "mL"); //Change the unit
                metricAmount.add(i, (newAmounts.get(i) * 236.6)); //Change the amount
            }
            //Oz to grams
            else if (units.get(i).equals("Ounces")) {
                metricUnits.add(i, "grams"); //Change unit
                metricAmount.add(i, (newAmounts.get(i) * 28.35)); //Change amount
            }
            //Lbs to Kg
            else if (units.get(i).equals("lbs")) {
                metricUnits.add(i, "Kg");
                metricAmount.add(i, newAmounts.get(i) * 2.2);
            }
            //fl oz to mL
            else if (units.get(i).equals("fl Ounces")) {
                metricUnits.add(i, "mL");
                metricAmount.add(i, newAmounts.get(i) / .033814);
            } else {
                metricUnits.add(i, units.get(i));
                metricAmount.add(i, newAmounts.get(i));
            }
        }
    }

    public void metricToEnglish(int count) {
        for (int i = 0; i < count; i++) {
            //mL to cups
            if (units.get(i).equals("Milliliters")) {
                englishUnits.add("Cups"); //Change the unit
                englishAmount.add(amounts.get(i) / 236.6); //Change the amount
            }
            //grams to oz
            else if (units.get(i).equals("Grams")) {
                englishUnits.add("oz"); //Change unit
                englishAmount.add(amounts.get(i) / 28.35); //Change amount
            }
            //Kg to lbs
            else if (units.get(i).equals("Kilograms")) {
                englishUnits.add("lbs");
                englishAmount.add(amounts.get(i) / 2.2);
            } else {
                englishUnits.add(units.get(i));
                englishAmount.add(amounts.get(i));
            }
        }
    }

    /* public void displayMetricToEnglishList(int count)
     {
         for (int i = 0; i < count; i++) {
             //This will format the each line according to whether there are units or not (ex. 2 eggs vs eggs 2)
             if ((englishUnits.get(i)).equals(" ")) {
                 System.out.println(englishAmount.get(i) + " " + ingredients.get(i));
             } else {
                 System.out.println(ingredients.get(i) + " " + englishAmount.get(i) + " " + englishUnits.get(i));
             }
         }
     }
 */
    public void modifiedMetricToEnglish(int count) {
        for (int i = 0; i < count; i++) {
            //mL to cups
            if (units.get(i).equals("Milliliters")) {
                englishUnits.add("Cups"); //Change the unit
                englishAmount.add(newAmounts.get(i) / 236.6); //Change the amount
            }
            //grams to oz
            else if (units.get(i).equals("Grams")) {
                englishUnits.add("oz"); //Change unit
                englishAmount.add(newAmounts.get(i) / 28.35); //Change amount
            }
            //Kg to lbs
            else if (units.get(i).equals("Kilograms")) {
                englishUnits.add("lbs");
                englishAmount.add(newAmounts.get(i) / 2.2);
            } else {
                englishUnits.add(units.get(i));
                englishAmount.add(newAmounts.get(i));
            }
        }
    }

    //This method will be used to format all  amounts as fractions instead of decimals
    //Modified amounts ONLY
    public void formatAsFraction() {

        for (int i = 0; i < counter; i++) {
            double x = newAmounts.get(i);
            double tolerance = 1.0E-6;
            double numerator1 = 1;
            double numerator2 = 0;
            double denominator1 = 0;
            double denominator2 = 1;
            double b = x;
            int marker = 0;

            do {
                double a = Math.floor(b);
                double aux = numerator1;
                numerator1 = a * numerator1 + numerator2;
                numerator2 = aux;
                aux = denominator1;
                denominator1 = a * denominator1 + denominator2;
                denominator2 = aux;
                b = 1 / (b - a);
                // System.out.println("Executed " + marker + " times");
                marker++;
            } while (Math.abs(x - numerator1 / denominator1) > x * tolerance);

            //System.out.println(numerator1+"/"+denominator1);


            if (x < .5) {
                double someNum = numerator1 % denominator1;
                // System.out.println(someNum);
                numerator1 = numerator1 / someNum;
                int numerator1Int = (int) (numerator1);
                denominator1 = denominator1 / someNum;
                int denominator1Int = (int) (denominator1);
                //System.out.println(numerator1Int + "/" + denominator1Int);
                amountsInFractionFormat.add(numerator1Int + "/" + denominator1Int);
            } else if (x < 1) {
                int numerator1Int = (int) (numerator1);
                int denominator1Int = (int) (denominator1);
                //System.out.println(numerator1Int + "/" + denominator1Int);
                amountsInFractionFormat.add(numerator1Int + "/" + denominator1Int);
            } else {
                int numerator1Int = (int) (numerator1);
                int denominator1Int = (int) (denominator1);
                int modNum = numerator1Int % denominator1Int;
                int numToSubtract = numerator1Int - modNum;
                int wholeNum = numToSubtract / denominator1Int;
                numerator1Int = numerator1Int - numToSubtract;
                if (numerator1Int == 0) {
                    amountsInFractionFormat.add(wholeNum + "");
                } else {
                    amountsInFractionFormat.add(wholeNum + " & " + numerator1Int + "/" + denominator1Int);
                }

            }
        }
    }

    //Method that displays new recipe amounts in fraction format
    public void displayAmountsInFractionFormat() {
        for (int i = 0; i < counter; i++) {
            if (units.get(i).equals("")) {
                System.out.println(amountsInFractionFormat.get(i) + " " + ingredients.get(i));
            } else {
                System.out.println(ingredients.get(i) + " " + amountsInFractionFormat.get(i) + " " + units.get(i));
            }
        }
    }

    //This method will be used to format all  amounts as fractions instead of decimals
    //Metric amounts ONLY
    public void formatMetricAsFraction() {

        for (int i = 0; i < counter; i++) {
            double x = metricAmount.get(i);
            double tolerance = 1.0E-6;
            double numerator1 = 1;
            double numerator2 = 0;
            double denominator1 = 0;
            double denominator2 = 1;
            double b = x;
            int marker = 0;

            do {
                double a = Math.floor(b);
                double aux = numerator1;
                numerator1 = a * numerator1 + numerator2;
                numerator2 = aux;
                aux = denominator1;
                denominator1 = a * denominator1 + denominator2;
                denominator2 = aux;
                b = 1 / (b - a);
                // System.out.println("Executed " + marker + " times");
                marker++;
            } while (Math.abs(x - numerator1 / denominator1) > x * tolerance);

            // System.out.println(numerator1+"/"+denominator1);


            if (x < .5) {
                double someNum = numerator1 % denominator1;
                System.out.println(someNum);
                numerator1 = numerator1 / someNum;
                int numerator1Int = (int) (numerator1);
                denominator1 = denominator1 / someNum;
                int denominator1Int = (int) (denominator1);
                //System.out.println(numerator1Int + "/" + denominator1Int);
                amountsInFractionFormat.add(numerator1Int + "/" + denominator1Int);
            } else if (x < 1) {
                int numerator1Int = (int) (numerator1);
                int denominator1Int = (int) (denominator1);
                // System.out.println(numerator1Int + "/" + denominator1Int);
                amountsInFractionFormat.add(numerator1Int + "/" + denominator1Int);
            } else {
                int numerator1Int = (int) (numerator1);
                int denominator1Int = (int) (denominator1);
                int modNum = numerator1Int % denominator1Int;
                int numToSubtract = numerator1Int - modNum;
                int wholeNum = numToSubtract / denominator1Int;
                numerator1Int = numerator1Int - numToSubtract;
                if (numerator1Int == 0) {
                    amountsInFractionFormat.add(wholeNum + "");
                } else {
                    amountsInFractionFormat.add(wholeNum + " & " + numerator1Int + "/" + denominator1Int);
                }

            }
        }
    }

    //Method that displays metric amounts in fraction format
    public void displayMetricAmountsInFractionFormat() {
        for (int i = 0; i < counter; i++) {
            if (metricUnits.get(i).equals("")) {
                System.out.println(amountsInFractionFormat.get(i) + " " + ingredients.get(i));
            } else {
                System.out.println(ingredients.get(i) + " " + amountsInFractionFormat.get(i) + " " + metricUnits.get(i));
            }
        }
    }

    //This method will be used to format all  amounts as fractions instead of decimals
    //English amounts ONLY
    public void formatEnglishAsFraction() {

        for (int i = 0; i < counter; i++) {
            double x = englishAmount.get(i);
            double tolerance = 1.0E-6;
            double numerator1 = 1;
            double numerator2 = 0;
            double denominator1 = 0;
            double denominator2 = 1;
            double b = x;
            int marker = 0;

            do {
                double a = Math.floor(b);
                double aux = numerator1;
                numerator1 = a * numerator1 + numerator2;
                numerator2 = aux;
                aux = denominator1;
                denominator1 = a * denominator1 + denominator2;
                denominator2 = aux;
                b = 1 / (b - a);
                // System.out.println("Executed " + marker + " times");
                marker++;
            } while (Math.abs(x - numerator1 / denominator1) > x * tolerance);

            //System.out.println(numerator1+"/"+denominator1);


            if (x < .5) {
                double someNum = numerator1 % denominator1;
                // System.out.println(someNum);
                numerator1 = numerator1 / someNum;
                int numerator1Int = (int) (numerator1);
                denominator1 = denominator1 / someNum;
                int denominator1Int = (int) (denominator1);
                // System.out.println(numerator1Int + "/" + denominator1Int);
                amountsInFractionFormat.add(numerator1Int + "/" + denominator1Int);
            } else if (x < 1) {
                int numerator1Int = (int) (numerator1);
                int denominator1Int = (int) (denominator1);
                //System.out.println(numerator1Int + "/" + denominator1Int);
                amountsInFractionFormat.add(numerator1Int + "/" + denominator1Int);
            } else {
                int numerator1Int = (int) (numerator1);
                int denominator1Int = (int) (denominator1);
                int modNum = numerator1Int % denominator1Int;
                int numToSubtract = numerator1Int - modNum;
                int wholeNum = numToSubtract / denominator1Int;
                numerator1Int = numerator1Int - numToSubtract;
                if (numerator1Int == 0) {
                    amountsInFractionFormat.add(wholeNum + "");
                } else {
                    amountsInFractionFormat.add(wholeNum + " & " + numerator1Int + "/" + denominator1Int);
                }

            }
        }
    }

    //Method that displays english amounts in fraction format
    public void displayEnglishAmountsInFractionFormat() {
        for (int i = 0; i < counter; i++) {
            if (englishUnits.get(i).equals("")) {
                System.out.println(amountsInFractionFormat.get(i) + " " + ingredients.get(i));
            } else {
                System.out.println(ingredients.get(i) + " " + amountsInFractionFormat.get(i) + " " + englishUnits.get(i));
            }
        }
    }

    //Set nutrition facts
    public void setCalories(double c) {
        calories = c;
    }

    public void setGramsOfFat(double f) {
        fat = f;
    }

    public void setProtein(double p) {
        protein = p;
    }

    public void setSodium(double s) {
        sodium = s;
    }

    public void setCarbs(double carb) {
        carbs = carb;
    }

    //Modifies nutrition info
    public void modifyNutritionInfo(double servingSize) {
        if (calories > 0) {
            calories = calories * servingSize;
        }
        if (fat > 0) {
            fat = fat * servingSize;
        }
        if (protein > 0) {
            protein = protein * servingSize;
        }
        if (sodium > 0) {
            sodium = sodium * servingSize;
        }
        if (carbs > 0) {
            carbs = carbs * servingSize;
        }
    }

    //Display nutrition info
    public void displayNutritionInfo() {
        if (calories > -1) {
            System.out.println("Calories: " + calories);
        }
        if (fat > -1) {
            System.out.println("Fat: " + fat + " grams");
        }
        if (protein > -1) {
            System.out.println("Protein: " + protein + " grams");
        }
        if (sodium > -1) {
            System.out.println("Sodium: " + sodium + " milligrams");
        }
        if (carbs > -1) {
            System.out.println("Total Carbohydrates: " + carbs + " grams");
        }
    }
}

