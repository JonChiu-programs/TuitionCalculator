/**
 File name: TuitionCalculator.java
 Short description: Class for calculating college tuition using up-to-date statistics and rates to provide the most accurate amount possible.
 @author Jonathon Chiu
 @version 1.4.1
 date of last revision: 08/10/2025
 details of the revision: Included the ability to terminate session at instructions screen by typing "exit".
 \*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TuitionCalculator {
    public static void main(String[] args) throws FileNotFoundException {
        try (FileInputStream key = new FileInputStream("TuitionCalculatorInstructions.txt"); Scanner input = new Scanner(key)){
            ArrayList <String> instructions = new ArrayList<>();
            while (input.hasNextLine()){
                instructions.add(input.nextLine());
            }
            if (instructions.get(17).equals("                             *  *  *") && instructions.get(18).equals("                          *     *     *") && instructions.get(19).equals("                       *     *     *     *") && instructions.get(20).equals("                    *        *  *  *        *") && instructions.get(21).equals("                 *           *     *           *") && instructions.get(22).equals("              *              *  *  *              *") && instructions.get(23).equals("           *              *     *     *              *") && instructions.get(24).equals("        *              *        *  *      *             *") && instructions.get(25).equals("     *              *        *  *            *             *") && instructions.get(26).equals("  *              *              *  *           *              *") && instructions.get(27).equals("  *           *              *  *                 *           *") && instructions.get(28).equals("  *        *                    *                    *        *") && instructions.get(29).equals("     *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *") && instructions.get(30).equals("        *                       *                       *") && instructions.get(31).equals("           *                    *                    *") && instructions.get(32).equals("              *                 *                 *") && instructions.get(33).equals("                 *              *              *") && instructions.get(34).equals("                    *           *           *") && instructions.get(35).equals("                       *        *        *") && instructions.get(36).equals("                          *     *     *") && instructions.get(37).equals("                             *  *  *")){
                for (String line : instructions) {
                    if (!line.equals("                             *  *  *") && !line.equals("                          *     *     *") && !line.equals("                       *     *     *     *") && !line.equals("                    *        *  *  *        *") && !line.equals("                 *           *     *           *") && !line.equals("              *              *  *  *              *") && !line.equals("           *              *     *     *              *") && !line.equals("        *              *        *  *      *             *") && !line.equals("     *              *        *  *            *             *") && !line.equals("  *              *              *  *           *              *") && !line.equals("  *           *              *  *                 *           *") && !line.equals("  *        *                    *                    *        *") && !line.equals("     *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *") && !line.equals("        *                       *                       *") && !line.equals("           *                    *                    *") && !line.equals("              *                 *                 *") && !line.equals("                 *              *              *") && !line.equals("                    *           *           *") && !line.equals("                       *        *        *")){
                        System.out.println(line);
                    }
                }
                Scanner input1 = new Scanner (System.in);
                String enter = input1.nextLine();
                if (enter.isEmpty()){
                    System.out.println("What type of student will you be next year? (full-time or part-time)");
                    System.out.println("Part-time = < 12 credits per semester; full-time = > 12 credits per semester");
                    String studentType = input1.next();
                    System.out.println();
                    if (studentType.equalsIgnoreCase("part-time") || studentType.equalsIgnoreCase("full-time")){
                        double classTotal = classCalculator(studentType);
                        double roomBoardTotal = roomBoardCalculator();
                        tuitionCalculator(classTotal,roomBoardTotal);
                    }
                    else{
                        while (!studentType.equalsIgnoreCase("part-time") || !studentType.equalsIgnoreCase("full-time")){
                            System.out.println("Enter student type as either 'part-time' or 'full-time'.");
                            studentType = input1.next();
                            if (studentType.equalsIgnoreCase("part-time") || studentType.equalsIgnoreCase("full-time")){
                                double classTotal = classCalculator(studentType);
                                double roomBoardTotal = roomBoardCalculator();
                                tuitionCalculator(classTotal,roomBoardTotal);
                            }
                        }
                    }
                }
                if (enter.equalsIgnoreCase("exit")){
                    cancel();
                }
                else{
                    while (!enter.isEmpty()){
                        System.out.println("PLEASE PRESS ENTER TO CONTINUE");
                        enter = input1.nextLine();
                        if (enter.isEmpty()) {
                            System.out.println("What type of student will you be next year? (full-time or part-time)");
                            System.out.println("Part-time = < 12 credits per semester; full-time = > 12 credits per semester");
                            String studentType = input1.next();
                            if (studentType.equalsIgnoreCase("part-time") || studentType.equalsIgnoreCase("full-time")) {
                                double classTotal = classCalculator(studentType);
                                double roomBoardTotal = roomBoardCalculator();
                                tuitionCalculator(classTotal, roomBoardTotal);
                            } else {
                                while (!studentType.equalsIgnoreCase("part-time") || !studentType.equalsIgnoreCase("full-time")) {
                                    System.out.println("Enter student type as either 'part-time' or 'full-time'.");
                                    studentType = input1.next();
                                    if (studentType.equalsIgnoreCase("part-time") || studentType.equalsIgnoreCase("full-time")) {
                                        double classTotal = classCalculator(studentType);
                                        double roomBoardTotal = roomBoardCalculator();
                                        tuitionCalculator(classTotal, roomBoardTotal);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else{
                System.out.println("THIS FILE IS INVALID. PLEASE DOWNLOAD PROPER INSTRUCTIONS FILE BEFORE USE!");
            }
        }
        catch (IOException error) {
            System.out.println("PLEASE DOWNLOAD INSTRUCTIONS FILE BEFORE USE!");
        }
    }

    public static double classCalculator(String studentType) {
        double sum = 0;
        Scanner input2 = new Scanner(System.in);
        if (studentType.equalsIgnoreCase("part-time")){
            System.out.println("How many classes do you plan to take next semester");
            int classes = input2.nextInt();
            System.out.println();
            double [] classCosts = new double [classes];
            System.out.println("How much does a single credit cost for a part-time student at your university/college?");
            double creditCost = input2.nextDouble();
            System.out.println();
            System.out.println("What is the maximum amount of credits you can obtain from a class?");
            int creditMax = input2.nextInt();
            System.out.println();
            int credits;
            for (int i = 0; i < classCosts.length; i++) {
                System.out.println("How many credits are you taking for class " + (i + 1) + "?");
                if (input2.hasNextInt()){
                    credits = input2.nextInt();
                    if (credits >= 1 && credits <= creditMax){
                        classCosts[i] = credits * creditCost;
                        sum = sum + classCosts[i];
                        System.out.println();
                    }
                    else {
                        System.out.println("Please enter an amount of credits that is within the range you inputted.");
                        System.out.println("How many credits are you taking for class " + (i + 1) + "?");
                        if (input2.hasNextInt()) {
                            credits = input2.nextInt();
                            if (credits >= 1 && credits <= creditMax) {
                                classCosts[i] = credits * creditCost;
                                sum = sum + classCosts[i];
                                System.out.println();
                            }
                        }
                    }
                }
            }
        }
        if (studentType.equalsIgnoreCase("full-time")){
            System.out.println("What year student will you be next year (1 - 4)");
            System.out.println("Enter 5 if super-senior, 6 for graduate, or 7 for PhD.");
            System.out.println("Note: Please consider if the inclusion of dual-enrollment/AP test credits have affected your year placement.");
            int studentYear = input2.nextInt();
            System.out.println();
            if (studentYear >= 1 && studentYear <= 7){
                if (studentYear == 1 || studentYear == 2 || studentYear == 3 || studentYear == 4 || studentYear == 5){
                    System.out.println("Enter the amount of tuition for each semester as an undergraduate student");
                    sum = input2.nextDouble();
                    System.out.println();
                }
                if (studentYear == 6){
                    System.out.println("Enter the amount of tuition for each semester as a graduate student");
                    sum = input2.nextDouble();
                    System.out.println();
                }
                if (studentYear == 7){
                    System.out.println("Are your courses for audit or for credit");
                    String choice = input2.next();
                    System.out.println();
                    if (choice.equalsIgnoreCase("audit")){
                        System.out.println("Enter the amount of tuition for each semester as a PHD student");
                        sum = input2.nextDouble();
                        System.out.println();
                    }
                    else if (choice.equalsIgnoreCase("credit")){
                        System.out.println("Enter the amount of tuition for each semester as a PHD student");
                        sum = input2.nextDouble();
                        System.out.println();
                    }
                }
            }
        }
        return sum;
    }

    public static double roomBoardCalculator() {
        Scanner inputRB = new Scanner(System.in);
        System.out.println("Enter the costs for room and meals/board as separate values");
        System.out.print("Room: ");
        double room = inputRB.nextDouble();
        System.out.print("Meals/Board: ");
        double meals = inputRB.nextDouble();
        System.out.println();
        return room + meals;
    }

    public static void tuitionCalculator(double classTotal, double roomBoardTotal) {
        Scanner inputStudentFee = new Scanner(System.in);
        System.out.println("Enter the cost of your university's student fee");
        double studentFee = inputStudentFee.nextDouble();
	System.out.println();
        double semesterTuition = studentFee + classTotal + roomBoardTotal;
        System.out.println("Do you have any financial aid (scholarships, grants, loans, etc.)?");
        Scanner input3 = new Scanner(System.in);
        String FinAidInput = input3.next();
        System.out.println();
        if (FinAidInput.equalsIgnoreCase("yes")){
            System.out.println("Input amount of financial aid");
            double FinAid;
            if (input3.hasNextDouble()){
                FinAid = input3.nextDouble();
                System.out.println();
                semesterTuition = semesterTuition - FinAid;
                double yearlyTuition = semesterTuition * 2;
                System.out.printf("Semester tuition costs: $%.2f %n", semesterTuition);
                System.out.printf("Yearly tuition costs: $%.2f %n", yearlyTuition);
            }
        }
        else if (FinAidInput.equalsIgnoreCase("No")){
            System.out.println();
            double yearlyTuition = semesterTuition * 2;
            System.out.printf("Semester tuition costs: $%.2f %n", semesterTuition);
            System.out.printf("Yearly tuition costs: $%.2f %n", yearlyTuition);
        }
        else{
            while(!FinAidInput.equalsIgnoreCase("Yes") && !FinAidInput.equalsIgnoreCase("No")){
                System.out.println("Please enter a response of 'yes' or 'no'.");
                FinAidInput = input3.next();
                if (FinAidInput.equalsIgnoreCase("yes")){
                    System.out.println("Input amount of financial aid");
                    double FinAid;
                    if (input3.hasNextDouble()){
                        FinAid = input3.nextDouble();
                        System.out.println();
                        semesterTuition = semesterTuition - FinAid;
                        double yearlyTuition = semesterTuition * 2;
                        System.out.printf("Semester tuition costs: $%.2f %n", semesterTuition);
                        System.out.printf("Yearly tuition costs: $%.2f %n", yearlyTuition);
                    }
                }
                else if (FinAidInput.equalsIgnoreCase("No")){
                    double yearlyTuition = semesterTuition * 2;
                    System.out.println();
                    System.out.printf("Semester tuition costs: $%.2f %n", semesterTuition);
                    System.out.printf("Yearly tuition costs: $%.2f %n", yearlyTuition);
                }
            }
        }
    }
    public static void cancel(){
        System.out.println();
        System.out.println("Session terminated");
    }
}