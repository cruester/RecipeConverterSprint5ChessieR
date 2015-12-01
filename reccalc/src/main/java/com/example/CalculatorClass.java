/************************************
 ***** Goals Completed last week*****
 ***********************************/
//Fractions work

//User can now calculate nutrition info based on how many servings they're having.

package com.example;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;


public class CalculatorClass {

    public static void main(String args[]) {

        Recipe myRecipe = new Recipe();
        /*  This counter is for adding elements 1- infinity to the ingredients
            array.  Element 0 will always exist, and will be taken care of inside
            the while loop */
        int counter = 1;


        /* This variable will hold the user's ingredient name input. Then, the
           appropriate element in the ingredients array will be assigned the value
           held in this variable.  */
        String ingredient = "";

        // Accepts user input
        Scanner input = new Scanner(System.in);

        // This variable will be used in the while loop that populates the ingredients,
        // amounts, and units arrays.
        boolean keepAdding = true;


        //This variable will hold the user's ingredient amount input. Then, the
        // appropriate element in the amounts array will be assigned the value
        double amount = 0;

        //This array will hold the unit for each ingredient
        //ArrayList<String> units = new ArrayList<String>();

        //This variable will hold the user's unit value before it is stored in
        // the units array.
        int unit = 0;

        int conversionFactor = 0;

        double inputFactor = 1; //Holds custom conversion value

        boolean inputUsableVal = false;
        int convertAction = 0; //Will be used in the switch statement controlling what actions the program
        // will perform.

        char calcNutrition = 'N';

        double calsPerServing = 0.00;
        double fatPerServing = 0.00;
        double proteinPerServing = 0.00;
        double sodiumPerServing = 0.00;
        double carbsPerServing = 0.00;

        double servingNum = 0.00;

        System.out.println("Enter ingredient 1:"); //There MUST be an ingredient 1
        ingredient = input.next();
        myRecipe.setFirstIngredient(ingredient); //Call setFirstIngredient method

        System.out.println("How much of ingredient 1 is in the recipe? (Don't add units)");
        amount = input.nextDouble();
        myRecipe.setFirstAmount(amount); //Call setFirstAmount method

        System.out.println("Please enter the unit for " + ingredient);
        System.out.println("-----------------------------------------");
        System.out.println("1. Cups");
        System.out.println("2. teaspoons");
        System.out.println("3. Tablespoons");
        System.out.println("4. Grams");
        System.out.println("5. lbs");
        System.out.println("6. Liters");
        System.out.println("7. Milliliters");
        System.out.println("8. Ounces");
        System.out.println("9: Cups (liquid)");
        System.out.println("10: Fluid Ounces");
        System.out.println("11: Kilograms");
        System.out.println("12. No unit");
        unit = input.nextInt();
        myRecipe.setFirstUnit(unit); //Call setFirstUnit method

        // The number of other ingredients vary, so the user can add as many
        // as are needed, including none.
        while (keepAdding) {
            System.out.println("Enter ingredient " + (counter + 1) + " or type 'done' to move on");
            ingredient = input.next();

            /* If the user chooses to quit, nothing is added to the arrays.
             Our flag is just switched to false. Also, we want to make
             Sure that the program recognizes the word 'done' in a few
             different cases, in case the user enters it differently
             than the way we prompt them to. */
            if ((ingredient.equals("done")) || (ingredient.equals("Done"))) {
                keepAdding = false;
            } else {
                myRecipe.setIngredients(ingredient, counter); //Set ingredient

                System.out.println("How much of ingredient " + (counter + 1) + " does the recipe call for?");
                amount = input.nextDouble();
                myRecipe.setAmounts(amount, counter); //Set amount

                System.out.println("Please select the unit for " + ingredient);
                System.out.println("-----------------------------------------");
                System.out.println("1. Cups");
                System.out.println("2. teaspoons");
                System.out.println("3. Tablespoons");
                System.out.println("4. Grams");
                System.out.println("5. lbs");
                System.out.println("6. Liters");
                System.out.println("7. Milliliters");
                System.out.println("8. Ounces (dry ingredients)");
                System.out.println("9: Cups (liquid)");
                System.out.println("10: Fluid Ounces");
                System.out.println("11: Kilograms");
                System.out.println("12. No unit");
                unit = input.nextInt();
                myRecipe.setUnits(unit, counter); //Set unit

                counter++; //Increment counter so we don't over wright what we just set
            }
        }


        myRecipe.setCounter(counter);
        System.out.println(""); //For aesthetics

        /*** This section Includes the metric conversion option ***/
        System.out.println("Please enter the number next to the action(s) you wish to select");
        System.out.println("----------------------------------------------------------------");
        System.out.println("1. Make a different amount of this recipe");
        System.out.println("2. Convert this recipe from English to metric");
        System.out.println("3. Convert this recipe from metric to English");
        System.out.println("4. Make a different amount of this recipe AND convert to English");
        System.out.println("5. Make a different amount of this recipe AND convert to metric");
        convertAction = input.nextInt();

        switch (convertAction)
        {
            case 1: //Just change amounts
            {
                //This section displays a menu of available hardcoded conversion factors. The do while loop
                // ensures an appropriate value is entered.
                do {
                    System.out.println("Enter the number next to the amount of the");
                    System.out.println("recipe you would like to make, or choose");
                    System.out.println("to enter your own amount.");
                    System.out.println("------------------------------------------");
                    System.out.println("1. 1/4");
                    System.out.println("2. 1/2");
                    System.out.println("3. 1/3");
                    System.out.println("4. 1.5");
                    System.out.println("5. Double");
                    System.out.println("6. Triple");
                    System.out.println("7. I would like to enter my own");
                    conversionFactor = input.nextInt();

                    if ((conversionFactor < 7) && (conversionFactor > 0)) {
                        // If the user does not choose to input their own conversion factor, call the
                        // convertAmounts method. It has the hardcoded values switch statement
                        myRecipe.convertAmounts(conversionFactor, counter);
                        inputUsableVal = true;
                    }
                    // Otherwise, accept custom conversion factor and use calculateCustomAmounts method
                    else if (conversionFactor == 7) {
                        System.out.println("Please enter the amount of the recipe you'd like to make in decimal form");
                        inputFactor = input.nextDouble();
                        myRecipe.calculateCustomAmounts(counter, inputFactor);
                        inputUsableVal = true;
                    } else {
                        System.out.println("Not an option");
                    }

                } while (inputUsableVal == false);
                //myRecipe.displayNewList(counter);
                myRecipe.formatAsFraction();
                myRecipe.displayAmountsInFractionFormat();

            }
            break;
            case 2: //Convert from english to metric
            {
                myRecipe.englishToMetric(counter);
                //myRecipe.displayEnglishToMetricList(counter);
                myRecipe.formatMetricAsFraction();
                myRecipe.displayMetricAmountsInFractionFormat();
            }
            break;
            case 3: //Convert from metric to English
            {
                myRecipe.metricToEnglish(counter);
                // myRecipe.displayMetricToEnglishList(counter);
                myRecipe.formatEnglishAsFraction();
                myRecipe.displayEnglishAmountsInFractionFormat();
            }
            break;
            case 4: //Change amounts AND convert to English
            {
                //Change amounts
                do {
                    System.out.println("Enter the number next to the amount of the recipe you would like to make," +
                            "or choose to enter your own amount.");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("1. 1/4");
                    System.out.println("2. 1/2");
                    System.out.println("3. 1/3");
                    System.out.println("4. 1.5");
                    System.out.println("5. Double");
                    System.out.println("6. Triple");
                    System.out.println("7. I would like to enter my own");
                    conversionFactor = input.nextInt();

                    if ((conversionFactor < 7) && (conversionFactor > 0)) {
                        // If the user does not choose to input their own conversion factor, call the
                        // convertAmounts method. It has the hardcoded values switch statement
                        myRecipe.convertAmounts(conversionFactor, counter);
                        inputUsableVal = true;
                    }
                    // Otherwise, accept custom conversion factor and use calculateCustomAmounts method
                    else if (conversionFactor == 7) {
                        System.out.println("Please enter the amount of the recipe you'd like to make in decimal form");
                        inputFactor = input.nextDouble();
                        myRecipe.calculateCustomAmounts(counter, inputFactor);
                        inputUsableVal = true;
                    } else {
                        System.out.println("Not an option");
                    }

                } while (inputUsableVal == false);

                //Convert to English
                myRecipe.modifiedMetricToEnglish(counter);
                //myRecipe.modifiedMetricToEnglish(counter);
                myRecipe.formatEnglishAsFraction();
                myRecipe.displayEnglishAmountsInFractionFormat();

            }
            break;
            case 5: //Change amounts AND convert to Metric
            {
                //Change amounts
                do {
                    System.out.println("Enter the number next to the amount of the recipe you would like to make," +
                            "or choose to enter your own amount.");
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println("1. 1/4");
                    System.out.println("2. 1/2");
                    System.out.println("3. 1/3");
                    System.out.println("4. 1.5");
                    System.out.println("5. Double");
                    System.out.println("6. Triple");
                    System.out.println("7. I would like to enter my own");
                    conversionFactor = input.nextInt();

                    if ((conversionFactor < 7) && (conversionFactor > 0)) {
                        // If the user does not choose to input their own conversion factor, call the
                        // convertAmounts method. It has the hardcoded values switch statement
                        myRecipe.convertAmounts(conversionFactor, counter);
                        inputUsableVal = true;
                    }
                    // Otherwise, accept custom conversion factor and use calculateCustomAmounts method
                    else if (conversionFactor == 7) {
                        System.out.println("Please enter the amount of the recipe you'd like to make in decimal form");
                        inputFactor = input.nextDouble();
                        myRecipe.calculateCustomAmounts(counter, inputFactor);
                        inputUsableVal = true;
                    } else {
                        System.out.println("Not an option");
                    }

                } while (inputUsableVal == false);

                //Convert to metric
                myRecipe.modifiedEnglishToMetric(counter);
                //myRecipe.displayEnglishToMetricList(counter);
                myRecipe.formatMetricAsFraction();
                myRecipe.displayMetricAmountsInFractionFormat();

            }
            break;
        }

        System.out.println("Would you like to calculate nutritional info? Type Y for yes" +
                "or N for no.");
        calcNutrition = input.next().charAt(0);
        if (calcNutrition == 'Y' || calcNutrition == 'y')
        {
            System.out.println("Enter the number of calories per serving or type 0 if N/A");
            calsPerServing = input.nextDouble();

            if (calsPerServing > 0)
            {myRecipe.setCalories(calsPerServing);}

            System.out.println("Enter grams of fat per serving or type 0 if N/A");
            fatPerServing = input.nextDouble();

            if (fatPerServing > 0)
            {myRecipe.setGramsOfFat(fatPerServing);}

            System.out.println("Enter grams of protein per serving or type 0 if N/A");
            proteinPerServing = input.nextDouble();

            if (proteinPerServing > 0)
            {myRecipe.setProtein(proteinPerServing);}

            System.out.println("Enter milligrams of sodium per serving or type 0 if N/A");
            {sodiumPerServing = input.nextDouble();}

            if (sodiumPerServing > 0)
            {myRecipe.setSodium(sodiumPerServing);}

            System.out.println("Enter grams for total carbohydrates per serving or type 0 if N/A");
            carbsPerServing = input.nextDouble();

            if (carbsPerServing > 0)
            {myRecipe.setCarbs(carbsPerServing);}

            System.out.println("How many servings would you like nutrition info for?");
            servingNum = input.nextDouble();
            myRecipe.modifyNutritionInfo(servingNum);
            myRecipe.displayNutritionInfo();
        }

    }

}
/*****************************************
 *******Goals for next week include: ******
 ****************************************/

//Clean up code. Get rid of things that no longer need to be there

//Clean up formatting

//Research how rounding amounts may affect recipes and maybe give rounded recommendations
//alongside exact amounts.  With a disclaimer.

//Small things like "a pinch of salt" and "pepper to taste"





