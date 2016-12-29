package com.quizApplication.Final;

import java.util.Scanner;

public class QuizApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quiz quiz = new Quiz();
		quiz.begin();

	}

}

class Quiz {

	void begin() {
		// creating 5 objects of quiz
		Question q1 = new Question("what is the valid keyword in Java?", "interface", "interface1", "interface2",
				"interface3", new Answer(1));

		Question q2 = new Question("Where does the java object get created in memoery ?", "stack", "heap", "queue",
				"none of these", new Answer(2));

		Question q3 = new Question("which keyword is used to prevent a method from getting overriden ?", "final",
				"extends", "static", "implements", new Answer(1));

		Question q4 = new Question("for what purpose is the this() constructor is used?",
				"to invoke the parent class constructor", "to invoke the child class constructor", "to invoke nothing",
				"none of above", new Answer(1));

		Question q5 = new Question("when does the object becomes unreachable ?",
				"when it's reference is pointing to null", "when it's reference is pointing to another object",
				"none of above", "first two", new Answer(1));

		// Question array to store questions
		Question questionArray[] = { q1, q2, q3, q4, q5 };

		int countTotal = 0;
		int countCorrect = 0;
		int countWrong = 0;

		for (Question q : questionArray) {
			System.out.println(q.getQuestion());
			System.out.println("A. " + q.getOption1());
			System.out.println("B. " + q.getOption2());
			System.out.println("C. " + q.getOption3());
			System.out.println("D. " + q.getOption4());
			System.out.println("\nEnter an option:");

			Scanner scans = new Scanner(System.in);
			char option = scans.next().toUpperCase().charAt(0);

			int answer=0;

			// switch case
			switch (option) {
			case 'A':
				answer =1;// q1.getOption1();
				break;
			case 'B':
				answer =2;// q2.getOption2();
				break;
			case 'C':
				answer =3;// q3.getOption3();
				break;
			case 'D':
				answer =4;// q4.getOption4();
				break;
			default:
				break;

			}
			// checking

		//	if (answer.equals(q.answer.getAnswer())) {
				if (answer==q.answer.getAnswer()) {
				System.out.println("---------------------------------------------------------------------");
				System.out.println("Correct Answer");

				System.out.println("---------------------------------------------------------------------");

				countCorrect++;

			} else {
				System.out.println("---------------------------------------------------------------------");
				System.out.println("Wrong Answer");

				System.out.println("---------------------------------------------------------------------");

				countWrong++;
			}
			System.out.println("\n============================================================================");
			countTotal++;

		}
		Result result = new Result(countTotal, countCorrect, countWrong);
		result.showResult();

	}

}

interface IResult {
	void showResult();

	double showPercentage(int correctAnswers, int totalQuestions);

	String showPerformance(double percentage);
}

class Result implements IResult {
	int totalQuestions;
	int correctAnswers;
	int wrongAnswers;

	public Result(int totalQuestions, int correctAnswers, int wrongAnswers) {
		super();
		this.totalQuestions = totalQuestions;
		this.correctAnswers = correctAnswers;
		this.wrongAnswers = wrongAnswers;
	}

	@Override
	public void showResult() {
		System.out.println("Your Result :");
		System.out.println("Total Questions  :     " + totalQuestions);
		System.out.println("Correct Answer  :      " + correctAnswers);
		System.out.println("Wrong Anser  :         " + wrongAnswers);
		System.out.println("Percentage  :          " + showPercentage(correctAnswers, totalQuestions));
		System.out
				.println("Performance  :           " + showPerformance(showPercentage(correctAnswers, totalQuestions)));

	}

	@Override
	public double showPercentage(int correctAnswer, int totalQuestions) {

		return ((double) correctAnswer / totalQuestions) * 100;
	}

	@Override
	public String showPerformance(double percentage) {
		String performance = "";
		if (percentage >= 80) {
			performance = "Good";
		} else if (percentage <= 40) {
			performance = "Bad";
		}

		else {
			performance = "Average";
		}

		return performance;
	}

}

class Question {
	// instance variables or
	// member variables

	String question;
	String option1;
	String option2;
	String option3;
	String option4;
	Answer answer;

	public Question(String question, String option1, String option2, String option3, String option4, Answer answer) {
		super();
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public String getOption1() {
		return option1;
	}

	public String getOption2() {
		return option2;
	}

	public String getOption3() {
		return option3;
	}

	public String getOption4() {
		return option4;
	}

	public Answer getAnswer() {
		return answer;
	}

}

class Answer {
	int answer;

	public Answer(int answer) {
		super();
		this.answer = answer;
	}

	public int getAnswer() {
		return answer;
	}

}