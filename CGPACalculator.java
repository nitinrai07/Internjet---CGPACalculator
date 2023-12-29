package Npackage;
import java.util.Scanner;
public class CGPACalculator {
  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter the number of courses: ");
	        int numCourses = sc.nextInt();
	        String[] courseNames = new String[numCourses];
	        int[] credits = new int[numCourses];
	        double[] grades = new double[numCourses];

	        for (int i = 0; i < numCourses; i++) {
	            System.out.println("\nEnter details for Course " + (i + 1) + ":");
	            System.out.print("Enter course name: ");
	            courseNames[i] = sc.next();
	            System.out.print("Enter credit hours for " + courseNames[i] + ": ");
	            credits[i] = sc.nextInt();
	            System.out.print("Enter grade for " + courseNames[i] + ": ");
	            grades[i] = sc.nextDouble();
	        }

	        System.out.print("\nChoose grading system (1 for 4-point scale, 2 for 10-point scale): ");
	        int gradingSystem = sc.nextInt();

	        double cgpa = calculateCGPA(credits, grades, gradingSystem);

	        
	        System.out.println("\nYour CGPA is: " + cgpa);
            sc.close();
	    }

	    private static double calculateCGPA(int[] credits, double[] grades, int gradingSystem) {
	        double totalCredits = 0;
	        double weightedSum = 0;

	        for (int i = 0; i < credits.length; i++) {
	            totalCredits += credits[i];
	            
	            double gpa = convertToGPA(grades[i], gradingSystem);
	            weightedSum += gpa * credits[i];
	        }

	     
	        return weightedSum / totalCredits;
	    }

	    private static double convertToGPA(double grade, int gradingSystem) {
	     
	        if (gradingSystem == 1) {
	            if (grade >= 90) return 4.0;
	            else if (grade >= 80) return 3.0;
	            else if (grade >= 70) return 2.0;
	            else if (grade >= 60) return 1.0;
	            else return 0.0;
	        } else if (gradingSystem == 2) {
	            return grade / 10.0;
	        } else {
	                return 0.0;
	        }
	    }
	}



