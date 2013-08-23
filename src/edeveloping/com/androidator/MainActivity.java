package edeveloping.com.androidator;

/**
 * ©2013 Edeveloping, Egbert Dijkstra
 * */


import java.awt.font.NumericShaper;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, button00, buttonDot, buttonPlus, buttonMinus, buttonDivide, buttonMultiply, buttonEquals, buttonDelete; 
	
	private TextView screen;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//set the View (the xml file)
		setContentView(R.layout.activity_main);
		
		init();
	}
	
	private void init(){
		
		/**
		 * This is the first function thats get called, so here we define each button, and give that button an onClickListener
		 * 
		 * Also we define the screen (textview)
		 * */
		
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.Button2);
		button3 = (Button) findViewById(R.id.Button3);
		button4 = (Button) findViewById(R.id.Button4);
		button5 = (Button) findViewById(R.id.Button5);
		button6 = (Button) findViewById(R.id.Button6);
		button7 = (Button) findViewById(R.id.Button7);
		button8 = (Button) findViewById(R.id.Button8);
		button9 = (Button) findViewById(R.id.Button9);
		button0 = (Button) findViewById(R.id.button0);
		button00 = (Button) findViewById(R.id.button00);
		buttonDot = (Button) findViewById(R.id.buttonDot);
		
		buttonMinus = (Button) findViewById(R.id.buttonMinus);
		buttonPlus = (Button) findViewById(R.id.buttonPlus);
		buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
		buttonDivide = (Button) findViewById(R.id.buttonDivide);
		
		buttonEquals = (Button) findViewById(R.id.buttonEquals);
		buttonDelete = (Button) findViewById(R.id.buttonDelete);
		
		screen = (TextView) findViewById(R.id.screen);
		screen.setText("");
		/**
		 * So, now all our buttons are setup,
		 * 
		 * Now add the onClickListener to each onClickListener.
		 * 
		 * We do this a bit different now, because we have allot of buttons, so it would be a mess if we do it the 'traditional way';
		 * 
		 * button1.setOnClickListener(new OnClickListner{
		 * 		 public void onClick(View v) {
		                
		                //do someting here
		                
		        }
		 * });
		 * 
		 * and that for all our buttons...
		 * 
		 * So what i have done is, i created i created a method which checks which button is pressed, and excecute the right command.
		 * This function is called 'ourOnclickListener'
		 * */
		
		button1.setOnClickListener(ourOnclickListener(button1));
		button2.setOnClickListener(ourOnclickListener(button2));
		button3.setOnClickListener(ourOnclickListener(button3));
		button4.setOnClickListener(ourOnclickListener(button4));
		button5.setOnClickListener(ourOnclickListener(button5));
		button6.setOnClickListener(ourOnclickListener(button6));
		button7.setOnClickListener(ourOnclickListener(button7));
		button8.setOnClickListener(ourOnclickListener(button8));
		button9.setOnClickListener(ourOnclickListener(button9));
		button0.setOnClickListener(ourOnclickListener(button0));
		button00.setOnClickListener(ourOnclickListener(button00));
		buttonDot.setOnClickListener(ourOnclickListener(buttonDot));
		
		buttonMinus.setOnClickListener(ourOnclickListener(buttonMinus));
		buttonPlus.setOnClickListener(ourOnclickListener(buttonPlus));
		buttonMultiply.setOnClickListener(ourOnclickListener(buttonMultiply));
		buttonDivide.setOnClickListener(ourOnclickListener(buttonDivide));
		
		buttonEquals.setOnClickListener(ourOnclickListener(buttonEquals));
		buttonDelete.setOnClickListener(ourOnclickListener(buttonDelete));
		
		
		//we set here the longpress for the delete button, to delete the whole screen
		
		buttonDelete.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				//we just set it as a empty string
				screen.setText("");
				return true;
			}
		});
	}	
	
	View.OnClickListener ourOnclickListener(final Button buttonClicked){
		 return new View.OnClickListener() {
		        public void onClick(View v) {
		        	switch (buttonClicked.getId()) {		        	
			          
		        		/**
		        		 * So how this works;
		        		 * 
		        		 * If you press an number, for example 1, you want that digit added on the screen, so i made a function for that; addNumber(String number)
		        		 * 
		        		 * If you press an 'action', for example +, you want that also to be on the screen, with spaces on both sides, so we use that same function.
		        		 * 
		        		 * if you shortpress delete, you want to delete the newest digit/action, this can be done with the function; deleteShortPress()
		        		 * But if you long press it, the whole screen needs to be cleared, but we handle that in the init() function.
		        		 * 
		        		 * If you press 'equals' you want to calculate the final awnser. I wanna do that in a different way than usual. 
		        		 * Ussualy you store the number 1 in a variable, number 2 in a variable and the action in a variable, right?
		        		 * What i wanna do now is place spaces between every number and action, so with the function *text on the screen*.split(' ')
		        		 * 
		        		 * So now you have an array of the numbers, and the actions between them
		        		 * */
		        	
		        	
		        	
		        		case R.id.button1:
			                // number 1 is pressed
		        			
		        			addNumber("1");
		        			
			                break;
			            case R.id.Button2:
			                // number 2 is pressed
			            	
			            	addNumber("2");
			                
			            	break;
			            case R.id.Button3:
			                // number 3 is pressed
			                
			            	addNumber("3");
			            	
			            	break;
			            
			            case R.id.Button4:
			                // number 4 is pressed
			                
			            	addNumber("4");
			            	
			            	break;

			            case R.id.Button5:
			                // number 5 is pressed
			                
			            	addNumber("5");
			            	
			            	break;
			                
			            case R.id.Button6:
			                // number 6 is pressed
			                
			            	addNumber("6");
			            	
			            	break;
			                
			            case R.id.Button7:
			                // number 7 is pressed
			                
			            	addNumber("7");
			            	
			            	break;
			                
			            case R.id.Button8:
			                // number 8 is pressed
			                
			            	addNumber("8");
			            	
			            	break;
			                
			            case R.id.Button9:
			                // number 9 is pressed
			                
			            	addNumber("9");
			            	
			            	break;
    			                
			            case R.id.button0:
			                // number 0 is pressed
			                
			            	addNumber("0");
			            	
			            	break;
			        	
			        	case R.id.button00:
			                // number 00 is pressed
			               
			        		addNumber("00");
			        		
			        		break;
			                
			        	case R.id.buttonDot:
			                // the dot is pressed
			                
			        		addNumber(".");
			        		
			        		break;
			                
			                
			                
			        	case R.id.buttonMinus:
			                // minus is pressed
			                
			        		addNumber(" - ");
			        		
			        		break;   
			                
			        	case R.id.buttonPlus:
			                // plus is pressed
			        		
			        		addNumber(" + ");
			        		
			                break;  
			                
			        	case R.id.buttonMultiply:
			                // multiply is pressed
			        		
			        		addNumber(" × ");
			        		
			                break;
			                
			        	case R.id.buttonDivide:
			                // divide is pressed
			        		
			        		addNumber(" ÷ ");
			        		
			                break;
			                
			                
			        	case R.id.buttonEquals:
			                // equals is pressed
			        		
			        		calculate();
			        		
			                break;
			                
			        	case R.id.buttonDelete:
			                // Delete is pressed
			        		
			        		deleteShortPress();
			        		
			                break;
		        	}
		        }
		    };		
	}
	
	private void addNumber(String number){
		String textOnScreen = "";
		
		
		//here we put all the numbers and actions in a string
		textOnScreen = screen.getText().toString();
		
		//Here we insert the number/dot or action(which includes spaces on both side)
		textOnScreen += number;
		
		//we display our new screen
		screen.setText(textOnScreen);		
		
	}

	private void deleteShortPress(){
		//here we delete 1 number/action/dot
		
		String textOnScreen = "";
		
		
		//here we put all the numbers and actions in a string
		textOnScreen = screen.getText().toString();
		
		
		//first check if there is something on the screen, if not return so nothing happens.
		
		if (textOnScreen.length() == 0){
			return;
		}
		
		/**
		 * this is kinda complicated, we use the function substring here.
		 * With this function, we can take a part of an string.
		 * 
		 * It has 2 parameters, the beginning of the part that we wanna take, and the ending of that part.
		 * We want everthing, except the last digit/dot/action
		 * 
		 * But we need to check something first, u remember we putted a space at the biginning and end of the action? good
		 * 
		 * example:
		 * 
		 * 		you putted a minus, but you want a plus, 
		 * 
		 * u need to delete that minus, but that is 3 digits.
		 * 
		 * Example:
		 * 
		 * 		you putted a 2, but you wanted a 6
		 * 
		 * here you can just delete the last digit.
		 * 
		 * we need to check the thing that we wanna delete before we delete something, 
		 * if the last digit is an space, we wanna delete the 3 digits, but if it is an number/dot we wanna delete 1 digit.
		 * */
		
		char lastDigit;
		
		//now we grab the last digit
		lastDigit = textOnScreen.charAt(textOnScreen.length()-1);
		
		//check if the last digit is an space
		if (lastDigit == ' '){
			//it is a space, delete 3 digits
			
			textOnScreen = textOnScreen.substring(0, textOnScreen.length() - 3);
		
		}else{
			//it is not a space, delete 1 digit
			
			textOnScreen = textOnScreen.substring(0, textOnScreen.length() - 1);
		}
		
		//we display our new screen
		screen.setText(textOnScreen);	
	}
	
	private void calculate(){
		//this is our calculate function
		
		String textOnScreen = "";
		textOnScreen = screen.getText().toString();
		
		//now we use the function split(" ") to create an array
		
		String[] arrayOfStrings = textOnScreen.split(" ");
		
		/**
		 * now we gonna check how many items this array has.
		 * options:
		 * 
		 * 0: empty, say that through Toast
		 * 1: too less: say that through Toast
		 * 2: too less: say that through Toast
		 * 3: good, calculate :D
		 * >= 4: too much, not so difficult to implement, but im too lazy at the moment, and its like 30°C inside my room ;p
		 * 		*hint hint, good excersize perhaps?*
		 * */
		
		int sizeOfArray = arrayOfStrings.length;
		
		//now we gonna use the lovely switch statement again <3
		
		switch (sizeOfArray) {
		
			case 0:
					Toast.makeText(getApplicationContext(), "You need to insert some numbers and actions", Toast.LENGTH_SHORT).show();
				break;
				
			case 1:
				
					Toast.makeText(getApplicationContext(), "You have too few numbers and actions", Toast.LENGTH_SHORT).show();
				
				break;				
				
			case 2:
					
					Toast.makeText(getApplicationContext(), "You have too few numbers and actions", Toast.LENGTH_SHORT).show();
				
				break;
				
			case 3:
					
				Boolean number0IsNumber = false, number2IsNumber  = false , number1IsAction = false;
				
					//first check if the array[0] && array[2] are numbers (ints or float(with the dot)), so set the booleans to true
					//we put this in try brackets, because it is not a number, it throws an exception
				
				//this is for the first number
				try {
					//to check if this is an Float, i use the isFloat function, which i got from the interwebs (http://stackoverflow.com/a/16078719)
					//if this is false, i check if it is an int, if that triggers the catch statement, it is also not an int, so it need to be an action.
					
					if (isFloat(arrayOfStrings[0])){
						number0IsNumber = true;
					}else{
						Integer.parseInt(arrayOfStrings[0]);
						number0IsNumber = true;
					};	
				
				}catch(NumberFormatException ex){
					//if this get triggerd, it means that integer.parse gave an error, so the first number isnt a number.
					number0IsNumber = false;
				}
				
				//this is for the second number
				try {					
					if (isFloat(arrayOfStrings[2])){
						number2IsNumber = true;
					}else{
						Integer.parseInt(arrayOfStrings[2]);
						number2IsNumber = true;
					};				
				}catch(NumberFormatException ex){
					//if this get triggerd, it means that integer.parse gave an error, so the first number isnt a number.
					number2IsNumber = false;
				}
				
				/**
				 * Now we are gonna check if the action is an legit action, and use the respective function to do the math, and display the awnser on the screen
				 * 
				 * but first check if we have 2 numbers
				 * */
				 if (number2IsNumber && number0IsNumber){
					 
					 if(arrayOfStrings[1].equals( "-")){
						
						 Minus(Float.valueOf(arrayOfStrings[0]), Float.valueOf(arrayOfStrings[2]));
						 
					 }else if(arrayOfStrings[1].equals("+")){
						 
						 Plus(Float.valueOf(arrayOfStrings[0]), Float.valueOf(arrayOfStrings[2]));
						 
					 }else if(arrayOfStrings[1].equals("×")){
						 
						 Multiply(Float.valueOf(arrayOfStrings[0]), Float.valueOf(arrayOfStrings[2]));
						 
					 }else if(arrayOfStrings[1].equals("÷")){
						 
						 Divide(Float.valueOf(arrayOfStrings[0]), Float.valueOf(arrayOfStrings[2]));
						 
					 }else{
						 screen.setText("Error");
					 }
					 
				 }		
				
				break;
				
			//so everything else ( >3) is grabbed by 'default'	
			
			default:
				Toast.makeText(getApplicationContext(), "You have too much numbers and actions, delete some", Toast.LENGTH_SHORT).show();
				break;
		
		}		
	}
	
	private static final Pattern DOUBLE_PATTERN = Pattern.compile(
		    "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
		    "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
		    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
		    "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");

		public static boolean isFloat(String s)
		{
		    return DOUBLE_PATTERN.matcher(s).matches();
		}
		
		
		private void Minus(Float nmbr1, Float nmbr2){
			
			Float awnser = nmbr1 - nmbr2;
			
			screen.setText(awnser.toString());
		
		}
		
		private void Plus(Float nmbr1, Float nmbr2){
			
			Float awnser = nmbr1 + nmbr2;
			
			screen.setText(awnser.toString());
		}
		
		private void Multiply(Float nmbr1, Float nmbr2){
			
			Float awnser = nmbr1 * nmbr2;
			
			screen.setText(awnser.toString());
			
		}
		
		private void Divide(Float nmbr1, Float nmbr2){
			
			Float awnser = nmbr1 / nmbr2;
			
			screen.setText(awnser.toString());
			
		}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
