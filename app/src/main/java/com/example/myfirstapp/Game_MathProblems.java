package com.example.myfirstapp;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Generates math problems questions and Answers
 */
public class Game_MathProblems {

    /**
     * Boolean flag for boss stage
     */
    private boolean myBoss;

    /**
     * int answer of a specific question.
     */
    private String myAns;

    /**
     * Random class object.
     */
    private static Random myRandom;

    /**
     * List of arithmetic operands as characters.
     */
    private static final char[] listOfOperator = {'+', '-', 'X', '/'};

    /**
     * BasicsOps class object for easy questions part.
     */
    private BasicOps myBasicOpsObject;

    /**
     * Set of Integers to store 4 choices of answers.
     */
    private Set<String> mySet;

    /**
     * number of types of questions for hard questions:
     * currently includes squares, square roots, inequalities, and algebra problems
     */
    public final int NUM_OF_HARD_QUESTION_TYPES = 4;

    /**
     * number of wrong choices a question can have
     */
    public final int NUM_OF_WRONG_ANSWERS = 3;

    /**
     * Base math problem class constructor - contains different classes
     * @param theBoss flag to notify if it is boss stage.
     */
    public Game_MathProblems(boolean theBoss)
    {
        myBoss = theBoss;
        myRandom = new Random();
        mySet = new HashSet<>();
    }

    /**
     * void method to set make boss stage on.
     * @param theState boolean value, true if boss stage
     */
    public void setBoss(boolean theState)
    {
        myBoss = theState;
    }

    /**
     * gets a random 1 digit number
     * @return a number from 1 to 9 inclusive
     */
    public int getRandOneDigitNum()
    {
        return myRandom.nextInt(9) + 1;
    }

    /**
     * gets a random 2 digit number
     * @return a number from 10 to 99 inclusive
     */
    public int getRandTwoDigitNum()
    {
        return myRandom.nextInt(89) + 10;
    }

    /**
     * method to get the answer of a specific question
     * @return int the answer
     */
    public String getAnswer(){  return myAns; }

    /**
     * To get easy question - 1 digit arithmetic
     * @return String representation of the question
     */
    public String getEasyQuestions() {

        char operator = listOfOperator[myRandom.nextInt(listOfOperator.length)];

        //Basic ops
        myBasicOpsObject = new BasicOps(operator, 1, false);

        return myBasicOpsObject.toString();
    }

    /**
     * To get 4 choices of the answers.
     * @return Set<Integer> containing 4 different choice to be displayed.
     */
    public Set<String> getEasyAnswers(){
        mySet = new HashSet<>(myBasicOpsObject.getWrongs());
        myAns = myBasicOpsObject.mySolution+"";
        mySet.add(myAns+"");
        return (mySet);
    }

    /**
     * To get medium question - 2 digit arithmetic
     * @return String representation of the question.
     */
    public String getMediumQuestions() {
        //nextInt(2) gets addition or subtraction
        char operator = listOfOperator[myRandom.nextInt(2)];

        //Basic ops
        myBasicOpsObject = new BasicOps(operator, 2, false);

        return myBasicOpsObject.toString();
    }

    /**
     * To get 4 choices of the answers.
     * @return Set<Integer> containing 4 different choice to be displayed.
     */
    public Set<String> getMediumAnswers(){
        mySet = new HashSet<>(myBasicOpsObject.getWrongs());
        myAns = myBasicOpsObject.mySolution + "";
        mySet.add(myAns+"");
        return (mySet);
    }

    /**
     * Method for the intermediate mode
     * Needed fraction part to be implemented for this method
     * @return
     */
    public String getIntermediateQuestion(){
        String theS = "";

        int randomChoice = myRandom.nextInt(2);

        switch (randomChoice){

            //for square problem
            case 0:
                SqProb sqr = new SqProb(false);
                theS = sqr.toString();
                mySet = new HashSet<>();
                mySet = sqr.getWrongs();
                myAns = sqr.mySolution + "";
                mySet.add(myAns+"");
                break;

            //For square root problem
            case 1:
                SqrtProb sqrRt = new SqrtProb(false);
                theS = sqrRt.toString();
                mySet = new HashSet<>();
                mySet = sqrRt.getWrongs();
                myAns = sqrRt.mySolution + "";
                mySet.add(myAns+"");
//                mySet.add(sqrRt.mySolution);
                break;

            //For medium question part
            case 2:
                theS = getMediumQuestions();
                mySet = new HashSet<>();
                mySet = getMediumAnswers();
                break;

            default:
                try
                {
                    throw new Exception();
                }
                catch(Exception e)
                {
                    System.out.println(e + "\nInvalid hard question");
                }
                break;
        }

        return theS;
    }

    public Set<String> getIntermediateQuestionAnswer(){
        return mySet;
    }

    /**
     * To get hard question - Problems related to square, square root, inequality, algebra
     * @return String representation of the question.
     */
    public String getHardQuestions(){

        String theS = "";

        int randomChoice = myRandom.nextInt(NUM_OF_HARD_QUESTION_TYPES);

        switch (randomChoice){

            //for square problem
            case 0:
                SqProb sqr = new SqProb(false);
                theS = sqr.toString();
                mySet = new HashSet<>();
                mySet = sqr.getWrongs();
                myAns = sqr.mySolution + "";
                mySet.add(myAns+"");
                break;

            //For square root problem
            case 1:
                SqrtProb sqrRt = new SqrtProb(false);
                theS = sqrRt.toString();
                mySet = new HashSet<>();
                mySet = sqrRt.getWrongs();
                myAns = sqrRt.mySolution + "";
                mySet.add(myAns+"");
//                mySet.add(sqrRt.mySolution);
                break;

            //For Inequality part
            case 2:
                IneqProb inqO = new IneqProb(false);
                theS = inqO.toString();
                mySet = new HashSet<>();
                mySet = inqO.getWrongs();
                myAns = inqO.mySolution + "";
                mySet.add(myAns+"");
//                mySet.add(inqO.mySolution);
                break;

            //For algebra part
            case 3:
                AlgProb algO = new AlgProb(false);
                theS = algO.toString();
                mySet = new HashSet<>();
                mySet = algO.getWrongs();
                myAns = algO.mySolution + "";
                mySet.add(myAns+"");
//                mySet.add(algO.mySolution);
                break;

            default:
                try
                {
                    throw new Exception();
                }
                catch(Exception e)
                {
                    System.out.println(e + "\nInvalid hard question");
                }
                break;
        }

        return theS;
    }

    /**
     * To get 4 choices of the answers.
     * @return Set<Integer> containing 4 different choice to be displayed.
     */
    public Set<String> getHardAnswers(){
        return (mySet);
    }

    /**
     * To get hard question - Problems related to square, square root, inequality, algebra
     * @return String representation of the question.
     */
    public String getExtrHardQuestions(){

        String theS = "";

        int randomChoice = myRandom.nextInt(2);

        //for testing purpose
//        randomChoice = 1;

        switch (randomChoice){

            //for square problem
            case 0:
                CubeProb cube = new CubeProb(false);
                theS = cube.toString();
                mySet = new HashSet<>();
                mySet = cube.getWrongs();
                myAns = cube.mySolution + "";
                mySet.add(myAns+"");
                break;

            //For square root problem
            case 1:
                CubeRtProb cubRt = new CubeRtProb(false);
                theS = cubRt.toString();
                mySet = new HashSet<>();
                mySet = cubRt.getWrongs();
                myAns = cubRt.mySolution + "";
                mySet.add(myAns+"");
//                mySet.add(sqrRt.mySolution);
                break;

            case 2:
                Factorial fact = new Factorial();
                theS = fact.toString();
                mySet = new HashSet<>();
                mySet = fact.getMyWrongs();
                myAns = fact.mySolution + "";
                mySet.add(myAns+"");
//                mySet.add(algO.mySolution);
                break;

            default:
                try
                {
                    throw new Exception();
                }
                catch(Exception e)
                {
                    System.out.println(e + "\nInvalid hard question");
                }
                break;
        }

        return theS;
    }

    /**
     * To get 4 choices of the answers.
     * @return Set<Integer> containing 4 different choice to be displayed.
     */
    public Set<String> getExtrHardAnswers(){
        return (mySet);
    }



    /**
     * Class for basic arithmetic operation - 1 digit and 2 digits
     * Extends MathProblem class
     */
    public static class BasicOps extends Game_MathProblems
    {
        /**
         * character variable for operator
         */
        private char myOp;

        /**
         * private int field for first operand
         */
        private int myOperand1;

        /**
         * private int field for second operand
         */
        private int myOperand2;

        /**
         * private int to store correct solution
         */
        private int mySolution;

        /**
         * Set of Integer to store wrong choices for the question.
         */
        private Set<String> myWrongs;

        /**
         * Contructor for basic operation class
         * @param theOp character arithmetic operator (+,-, *, /)
         * @param theDigits the number of digits (1 or 2) for operands
         * @param theBoss boolean flag to notify it its boss stage
         */
        public BasicOps(char theOp, int theDigits, boolean theBoss)
        {
            super(theBoss);
            char op = theOp;
            if(theOp == 'x' || theOp == '*')
            {
                op = 'X';
            }

            myOp = op;
            initializeOperands(theDigits, theBoss);
            initializeSolutions(myOp, theDigits);
        }

        /**
         * method to initialize the basic operation (easy/medium) question
         * @param theDigits the number of digits (1 or 2) for operands
         * @param theBoss boolean flag to notify it its boss stage
         */
        private void initializeOperands(int theDigits, boolean theBoss)
        {

            switch(theDigits)
            {

                case 1:
                    myOperand1 = getRandOneDigitNum();
                    myOperand2 = getRandOneDigitNum();
                    break;

                case 2:
                    myOperand1 = getRandTwoDigitNum();
                    myOperand2 = getRandTwoDigitNum();
                    break;

                default:

                    try
                    {
                        throw new Exception();
                    }

                    catch(Exception e)
                    {
                        System.out.println(e + "\nInvalid amount of digits in "
                                + "math problem");
                    }
                    break;
            }

        }

        /**
         * Method to initialize the solution and the other wrong choices for the question
         * @param theOp the character variable for the operator (+,-,*,/)
         */
        private void initializeSolutions(char theOp, int theDigits)
        {
            myWrongs = new HashSet<>();

            switch(theOp)
            {
                case '+':
                    mySolution = myOperand1 + myOperand2;
                    while(myWrongs.size() < NUM_OF_WRONG_ANSWERS)
                    {
                        //nextInt(17) + 2 yields the range of possible sums of 2 one digit numbers
                        int nextWrong;
                        if(theDigits == 1)
                        {
                            nextWrong = myRandom.nextInt(17) + 2;
                        }
                        //2 digit case yields all possible 2 digit sums
                        else
                        {
                            nextWrong = myRandom.nextInt(178) + 20;
                        }

                        if(nextWrong != mySolution)
                        {
                            myWrongs.add(nextWrong+"");
                        }
                    }
                    break;

                case '-':
                    mySolution = myOperand1 - myOperand2;
                    boolean negative = myOperand1 < myOperand2;
                    while(myWrongs.size() < NUM_OF_WRONG_ANSWERS)
                    {
                        //we do the same random numbers with subtraction
                        //(subtraction is just addition with negatives)
                        //but it could be negative too
                        //so the negative conditional takes care of that
                        //nextInt(17) + 2 yields the range of possible sums of 2 one digit numbers
                        int nextWrong;
                        if(theDigits == 1)
                        {
                            nextWrong = myRandom.nextInt(17) + 2;
                        }
                        //2 digit case yields all possible 2 digit sums
                        else
                        {
                            nextWrong = myRandom.nextInt(178) + 20;
                        }
                        if(negative)
                        {
                            nextWrong *= -1;
                        }
                        if(nextWrong != mySolution)
                        {
                            myWrongs.add(nextWrong+"");
                        }
                    }
                    break;

                case 'X':
                    mySolution = myOperand1 * myOperand2;
                    while(myWrongs.size() < NUM_OF_WRONG_ANSWERS)
                    {
                        //nextInt(82) yields 0 to 81
                        //which is the range of 1 digit times 1 digit products
                        int nextWrong = myRandom.nextInt(82);
                        if(nextWrong != mySolution)
                        {
                            myWrongs.add(nextWrong+"");
                        }
                    }
                    break;

                case '/':
                    //will yield whole numbers
                    myOperand1 = myOperand2 * myOperand1;
                    mySolution = myOperand1 / myOperand2;

                    while(myWrongs.size() < NUM_OF_WRONG_ANSWERS)
                    {
                        int nextWrong = myRandom.nextInt(20) + 1;
                        if(nextWrong != mySolution)
                        {
                            myWrongs.add(nextWrong+"");
                        }
                    }
                    break;

                default:
                    try
                    {
                        throw new Exception();
                    }

                    catch(Exception e)
                    {
                        System.out.println(e.getStackTrace() + "\nInvalid operation in "
                                + "math problem");
                    }

            }

        }

        /**
         * Method to get correct solution for the question
         * @return int right solution
         */
        public int getSolution()
        {
            return mySolution;
        }

        /**
         * Method to get set of wrong answer choices for the questions.
         * @return set<Integer> containing incorrect answers
         */
        public Set<String> getWrongs()
        {
            return myWrongs;
        }

        /**
         * To get string representation of the question.
         * @return String representing the question
         */
        public String toString()
        {
            return myOperand1 + " " + myOp + " " + myOperand2 + " = ?";
        }

    }


    /**
     * Class for the questions related to square of a number
     * Extends MathProblem class
     */
    public static class SqProb extends Game_MathProblems
    {
        /**
         * int variable for the operands of the square problem.
         */
        private int myOperand;

        /**
         * private int to store correct solution
         */
        private int mySolution;

        /**
         * Set of Integer to store wrong choices for the question.
         */
        private Set<String> myWrongs;

        /**
         * Constructor for SquareProblem class
         * @param theBoss boolean flag to notify it its boss stage
         */
        public SqProb(boolean theBoss)
        {
            super(theBoss);
            myOperand = getRandOneDigitNum();
            initializeSolutions();
        }

        /**
         * Method to initialize the solution and the other wrong choices for the question.
         */
        private void initializeSolutions()
        {
            mySolution = (int)Math.pow(myOperand, 2);
            myWrongs = new HashSet<>();
            while(myWrongs.size() < NUM_OF_WRONG_ANSWERS)
            {
                //we restrict highest answer to be 81 because we only include 1 digit squares
                int nextWrong = myRandom.nextInt(82);
                if(nextWrong != mySolution)
                {
                    myWrongs.add(nextWrong+"");
                }
            }
        }

        /**
         * Method to get correct solution for the question
         * @return int right solution
         */
        public int getSolution()
        {
            return mySolution;
        }

        /**
         * Method to get set of wrong answer choices for the questions.
         * @return set<Integer> containing incorrect answers
         */
        public Set<String> getWrongs()
        {
            return myWrongs;
        }

        /**
         * To get string representation of the question.
         * @return String representing the question
         */
        public String toString()
        {
            return myOperand + "² = ?";
        }
    }

    /**
     * Class for the questions related to square root of a number
     * Extends MathProblem class
     */
    public static class SqrtProb extends Game_MathProblems
    {
        //whole numbers
        //unicode for square root function \u221A

        /**
         * int variable for the operands of the square problem.
         */
        private final int myOperand;
        /**
         * private int to store correct solution
         */
        private int mySolution;
        /**
         * Set of Integer to store wrong choices for the question.
         */
        private Set<String> myWrongs;

        /**
         * Constructor for SquareRootProblem class
         * @param theBoss boolean flag to notify it its boss stage
         */
        public SqrtProb(boolean theBoss)
        {
            super(theBoss);
            myOperand = (int) Math.pow(myRandom.nextInt(21), 2) ;
            initializeSolutions();
        }

        /**
         * Method to initialize the solution and the other wrong choices for the question.
         */
        private void initializeSolutions()
        {
            mySolution = (int)Math.sqrt(myOperand);
            myWrongs = new HashSet<>();

            while(myWrongs.size() < NUM_OF_WRONG_ANSWERS)
            {
                //we set upper bound to 21 to have square roots between 0 and 20
                int nextWrong = myRandom.nextInt(21);
                if(nextWrong != mySolution)
                {
                    myWrongs.add(nextWrong+"");
                }
            }

        }

        /**
         * Method to get set of wrong answer choices for the questions.
         * @return set<Integer> containing incorrect answers
         */
        public Set<String> getWrongs()
        {
            return myWrongs;
        }

        /**
         * Method to get correct solution for the question
         * @return int right solution
         */
        public int getSolution()
        {
            return mySolution;
        }

        /**
         * To get string representation of the question.
         * @return String representing the question
         */
        public String toString()
        {
            return "\u221A" + myOperand + " = ?";
        }
    }

    /**
     * Class for the questions related to Inequality of x
     * Extends MathProblem class
     * General format is : Ax + B > C or Ax + B < C
     */
    public static class IneqProb extends Game_MathProblems
    {
        /**
         * private int to store correct solution
         */
        private int mySolution;
        /**
         * Set of Integer to store wrong choices for the question.
         */
        private Set<String> myWrongs;
        /**
         * Int variable for the x coefficient (A)
         */
        private final int myXCoefficient;
        /**
         * int variable for left hand side constant (B)
         */
        private int myLeftConstant;
        /**
         * int variable for right hand side constant (C)
         */
        private int myRightConstant;
        /**
         * Char variable to store the conditional operator (<, >)
         */
        private char myConditionalOperator;

        /**
         * Constructor for Inequality problem class
         * @param theBoss boolean flag to notify it its boss stage
         */
        public IneqProb(boolean theBoss){
            super(theBoss);
            myXCoefficient = getRandOneDigitNum();
            //random number from 1 to 5 inclusive
            myLeftConstant = myRandom.nextInt(5) + 1;
            myRightConstant = (myRandom.nextInt(myXCoefficient)+ 1 ) * myXCoefficient + myLeftConstant;

            //Conditional operator decision
            if(myRightConstant % 2 == 0)
                myConditionalOperator = '<';
            else
                myConditionalOperator = '>';

            initializeSolutions();
        }

        /**
         * Method to initialize the solution and the other wrong choices for the question.
         */
        private void initializeSolutions()
        {
            mySolution = (myRightConstant - myLeftConstant)/ myXCoefficient;
            myWrongs = new HashSet<>();

            while(myWrongs.size() < NUM_OF_WRONG_ANSWERS)
            {
                int nextWrong = myRandom.nextInt(mySolution + 3) + 1;

                if(myConditionalOperator == '<' && nextWrong < mySolution){
                    nextWrong = nextWrong + mySolution;
                }

                if(myConditionalOperator == '>' && nextWrong > mySolution){
                    nextWrong = nextWrong - mySolution - 3;
                }

//                System.out.println(nextWrong);

                if(nextWrong != mySolution)
                {
                    myWrongs.add(nextWrong+"");
                }

            }
        }

        /**
         * Method to get set of wrong answer choices for the questions.
         * @return set<Integer> containing incorrect answers
         */
        public Set<String> getWrongs()
        {
            return myWrongs;
        }

        /**
         * Method to get correct solution for the question
         * @return int right solution
         */
        public int getSolution()
        {
            return mySolution;
        }

        /**
         * To get string representation of the question.
         * @return String representing the question
         */
        public String toString(){

            if(myXCoefficient==1)
                return "x + "+ myLeftConstant +" "+myConditionalOperator+ " "+ myRightConstant + "; then x "+ myConditionalOperator +" ?";

            return myXCoefficient +"x + "+ myLeftConstant + " " + myConditionalOperator + " "+ myRightConstant + "; then x "+ myConditionalOperator+ " ?";
        }
    }

    public static class AlgProb extends Game_MathProblems
    {
        /**
         * private int to store correct solution
         */
        private int mySolution;
        /**
         * Set of Integer to store wrong choices for the question.
         */
        private Set<String> myWrongs;
        /**
         * Int variable for the x coefficient (A)
         */
        private int myXCoefficient;
        /**
         * Int variable for the left hand side constant (B)
         */
        private int myLeftCoefficient;
        /**
         * Int variable for the Right hand side constant (C)
         */
        private int myRightCoefficient;

        /**
         * Constructor for Algebra problem class
         * @param theBoss boolean flag to notify it its boss stage
         */
        public AlgProb(boolean theBoss){
            super(theBoss);
            myXCoefficient = getRandOneDigitNum();
            //random number from 1 to 5 inclusive
            myLeftCoefficient = myRandom.nextInt(5) + 1;
            myRightCoefficient = (myRandom.nextInt(myXCoefficient) + 1) * myXCoefficient + myLeftCoefficient;
            initializeSolutions();
        }

        /**
         * Method to initialize the solution and the other wrong choices for the question.
         */
        private void initializeSolutions()
        {
            mySolution = (myRightCoefficient - myLeftCoefficient) / myXCoefficient;
            myWrongs = new HashSet<>();

            while(myWrongs.size() < NUM_OF_WRONG_ANSWERS)
            {
                int nextWrong = myRandom.nextInt(mySolution+ 3) + 1;
                if(nextWrong != mySolution)
                {
                    myWrongs.add(nextWrong+"");
                }
            }
        }

        /**
         * Method to get set of wrong answer choices for the questions.
         * @return set<Integer> containing incorrect answers
         */
        public Set<String> getWrongs()
        {
            return myWrongs;
        }

        /**
         * Method to get correct solution for the question
         * @return int right solution
         */
        public int getSolution()
        {
            return mySolution;
        }

        /**
         * To get string representation of the question.
         * @return String representing the question
         */
        public String toString()
        {
            if(myXCoefficient==1)
                return "x + "+ myLeftCoefficient +" = "+ myRightCoefficient + ", then x = ?";

            return myXCoefficient +"x + "+ myLeftCoefficient +" = "+ myRightCoefficient + ", then x = ?";
        }
    }


    public static class Factorial{

        int mySolution;
        private Set<String> myWrongs;
        private String myQuestion;
        private int myNumber;

        public Factorial(){

            myNumber = myRandom.nextInt(8);
            mySolution = getFactorial(myNumber);
        }

        /**
         * To avoid the running time of the loop to calculate the factorial number and also the limitation of the displaying
         * large numbers on scree, the numbers are restricted from 0 to 8;
         */
        private int getFactorial(int theN){
            int ans = 1;
            int temp = myNumber;

            while(temp > 0){
                ans = ans * temp;
                temp--;
            }
            return ans;
        }

        public String toString(){
            return myNumber + "! = ?";
        }

        public Set<String> getMyWrongs(){
            myWrongs = new HashSet<>();
            if(myNumber == 0 || myNumber == 1){
                myWrongs.add(0+"");
                myWrongs.add(2+"");
                myWrongs.add(10+"");
                return myWrongs;
            }
            while(myWrongs.size() < 3){
                int wrong = 0;
                wrong = myRandom.nextInt(myNumber) + mySolution;

                if(wrong != mySolution){
                    myWrongs.add(wrong+"");
                }
            }

            return myWrongs;
        }
    }

    /**
     * Class for the questions related to cube of a number
     * Extends MathProblem class
     */
    public static class CubeProb extends Game_MathProblems
    {
        /**
         * int variable for the operands of the square problem.
         */
        private int myOperand;

        /**
         * private int to store correct solution
         */
        private int mySolution;

        /**
         * Set of Integer to store wrong choices for the question.
         */
        private Set<String> myWrongs;

        /**
         * Constructor for CubeProblem class
         * @param theBoss boolean flag to notify it its boss stage
         */
        public CubeProb(boolean theBoss)
        {
            super(theBoss);
            myOperand = getRandOneDigitNum();
            initializeSolutions();
        }

        /**
         * Method to initialize the solution and the other wrong choices for the question.
         */
        private void initializeSolutions()
        {
            mySolution = (int)Math.pow(myOperand, 3);
            myWrongs = new HashSet<>();
            while(myWrongs.size() < NUM_OF_WRONG_ANSWERS)
            {
                //we restrict highest answer to be 81 because we only include 1 digit squares
                int nextWrong = myRandom.nextInt(82);
                if(nextWrong != mySolution)
                {
                    myWrongs.add(nextWrong+"");
                }
            }
        }

        /**
         * Method to get correct solution for the question
         * @return int right solution
         */
        public int getSolution()
        {
            return mySolution;
        }

        /**
         * Method to get set of wrong answer choices for the questions.
         * @return set<Integer> containing incorrect answers
         */
        public Set<String> getWrongs()
        {
            return myWrongs;
        }

        /**
         * To get string representation of the question.
         * @return String representing the question
         */
        public String toString()
        {
            return myOperand + "³ = ?";
        }
    }

    /**
     * Class for the questions related to cube root of a number
     * Extends MathProblem class
     */
    public static class CubeRtProb extends Game_MathProblems
    {
        //whole numbers
        //unicode for square root function \u221A

        /**
         * int variable for the operands of the square problem.
         */
        private final int myOperand;
        /**
         * private int to store correct solution
         */
        private int mySolution;
        /**
         * Set of Integer to store wrong choices for the question.
         */
        private Set<String> myWrongs;

        /**
         * Constructor for SquareRootProblem class
         * @param theBoss boolean flag to notify it its boss stage
         */
        public CubeRtProb(boolean theBoss)
        {
            super(theBoss);
            mySolution = myRandom.nextInt(10);
            myOperand = (int) Math.pow(mySolution, 3) ;
            initializeSolutions();
        }

        /**
         * Method to initialize the solution and the other wrong choices for the question.
         */
        private void initializeSolutions()
        {
//            mySolution = (int)Math.cbrt(myOperand);
            myWrongs = new HashSet<>();

            while(myWrongs.size() < NUM_OF_WRONG_ANSWERS)
            {
                //we set upper bound to 21 to have square roots between 0 and 20
                int nextWrong = myRandom.nextInt(21);
                if(nextWrong != mySolution)
                {
                    myWrongs.add(nextWrong+"");
                }
            }

        }

        /**
         * Method to get set of wrong answer choices for the questions.
         * @return set<Integer> containing incorrect answers
         */
        public Set<String> getWrongs()
        {
            return myWrongs;
        }

        /**
         * Method to get correct solution for the question
         * @return int right solution
         */
        public int getSolution()
        {
            return mySolution;
        }

        /**
         * To get string representation of the question.
         * @return String representing the question
         */
        public String toString()
        {
            return "\u221B" + myOperand + " = ?";
        }
    }


    public static class AddingFraction extends Game_MathProblems
    {
        private Fraction mySolution;

        private Set<Fraction> myWrongs;

        // U00F7
        private Fraction firstFraction;
        private Fraction secondFraction;

        public AddingFraction(boolean theBoss) {
            super(theBoss);
            firstFraction = new Fraction(myRandom.nextInt(9) + 1, myRandom.nextInt(9) + 1);
            secondFraction = new Fraction(myRandom.nextInt(9) + 1, myRandom.nextInt(9) + 1);
            initializeSolutions();
        }

        private void initializeSolutions()
        {
            mySolution = firstFraction.add(secondFraction);
            myWrongs = new HashSet<>();

            while(myWrongs.size() < NUM_OF_WRONG_ANSWERS)
            {
                Fraction nextWrong = new Fraction(myRandom.nextInt(9) + 1, myRandom.nextInt(9) + 1);
                if(nextWrong.toString().equals(mySolution.toString()))
                {
                    myWrongs.add(nextWrong);
                }
            }
        }

        public Set<Fraction> getWrongs()
        {
            return myWrongs;
        }

        public Fraction getSolution()
        {
            return mySolution;
        }
    }

    public static class Fraction{
        private int numerator;
        private int denominator;
        public Fraction(int numr, int denr) {
            numerator = numr;
            denominator = denr;
            reduce();
        }

        public int getNumerator() {
            return numerator;
        }

        public void setNumerator(int numerator) {
            this.numerator = numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        public void setDenominator(int denominator) {
            this.denominator = denominator;
        }

        public int calculateGCD(int numerator, int denominator) {
            if (numerator % denominator == 0) {
                return denominator;
            }
            return calculateGCD(denominator, numerator % denominator);
        }

        void reduce() {
            int gcd = calculateGCD(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        public Fraction add(Fraction fractionTwo) {
            int numer = (numerator * fractionTwo.getDenominator()) +
                    (fractionTwo.getNumerator() * denominator);
            int denr = denominator * fractionTwo.getDenominator();
            return new Fraction(numer, denr);
        }

        public Fraction subtract(Fraction fractionTwo) {
            int newNumerator = (numerator * fractionTwo.denominator) -
                    (fractionTwo.numerator * denominator);
            int newDenominator = denominator * fractionTwo.denominator;
            Fraction result = new Fraction(newNumerator, newDenominator);
            return result;
        }

        public Fraction multiply(Fraction fractionTwo) {
            int newNumerator = numerator * fractionTwo.numerator;
            int newDenominator = denominator * fractionTwo.denominator;
            Fraction result = new Fraction(newNumerator, newDenominator);
            return result;
        }

        public Fraction divide(Fraction fractionTwo) {
            int newNumerator = numerator * fractionTwo.getDenominator();
            int newDenominator = denominator * fractionTwo.numerator;
            Fraction result = new Fraction(newNumerator, newDenominator);
            return result;
        }

        @Override
        public String toString() {
            return this.numerator + "/" + this.denominator;
        }
    }




//    static class trigProb {
//
////        private static DecimalFormat df2 = new DecimalFormat("#.##");
//
//        public enum problemType{
//            sin, cos, tan;
//            public problemType randomType() {
//                Random random = new Random();
//                return values()[random.nextInt(values().length)];
//            }
//        };
//
//        int degree;
//        problemType type;
//        double answer;
//        double[] wrongAnswers;
////    static private float[] allAnswers =
//
//
//        trigProb(){
//            Random rand = new Random();
//            type = problemType.randomType();
//
//            if(rand.nextInt() % 2 == 0)
//                degree = 45 * rand.nextInt(13);
//            else
//                degree = 30 * rand.nextInt(13);
//
//            answer = getAnswer(type, degree);
//
//
//            wrongAnswers = new double[3];
////        for(double x : wrongAnswers){
////
////        }
//
//
//
//
//        }
//
//
//
//        public double getAnswer(problemType type, int degree){
//            double radians = Math.toRadians(degree);
//            double answer = 0;
//
//            switch (type){
//                case sin -> answer = Math.sin(radians);
//                case cos -> answer = Math.cos(radians);
//                case tan -> answer = Math.tan(radians);
//            }
//
//            if(Math.abs(answer) > 2)
//                answer = Double.POSITIVE_INFINITY;
//
//            if(Math.abs(answer) < 0.01)
//                answer = 0;
//
//            return answer;
//        }
//
//        public String toString(){
////        return type.toString() ;
//
//            return type.toString() + '(' + degree + ')' + " = ?";
//
//        }
//
//
//
//
//
//
//    }





}
