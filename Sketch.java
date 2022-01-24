import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  public float textX = 300;
  public float textY = 900;
  
  PImage bed;
  PImage flashlight;
  PImage outside;
 
  PImage A;
  PImage E;
  PImage H;
  PImage N;
  PImage O;
  PImage S;
  PImage T;
  PImage U;
  PImage I;
  
  PImage painting;
  PImage backgroundOpenSafe;
  PImage backgroundWithoutPicture;

  PImage zero;
  PImage one;
  PImage two;
  PImage three;
  PImage four;
  PImage five;
  PImage six;
  PImage seven;
  PImage eight;
  PImage nine;

  public char[] toyBox1 = {'S', 'T', 'H', 'A', 'N', 'U'};
  public char[] toyBox2 = {'H', 'E', 'I', 'N', 'T', 'A'};
  public char[] toyBox3 = {'U', 'I', 'E', 'N', 'S', 'O'};
  public char[] toyBox4 = {'E', 'H', 'T', 'S', 'N', 'I'};
  //public ArrayList<PImage> toyBox = new ArrayList<PImage>();

  public float toyBox1Front = 0;
  public float toyBox2Front = 0;
  public float toyBox3Front = 0;
  public float toyBox4Front = 0;

  /*
  scene 1 = original background (background 1)
  scene 2 = toys
  scene 3 = page
  scene 4 = page 2 (in the safe with how to input the numbers)  
  scene 5 = window
  scene 6 = door
  scene 7 = bed
  scene 8 = text
  scene 9 = safe
  */

  public float scene = 1;
  public float background = 1;
  public float previousScene = 1;
  public float paintingX = 1200;
  public float paintingY = 360;
  
  // to make sure the player does not guess the code. 
  public int steps;

  public boolean activityOpen;

  public String text;

  public boolean paintingMoved;
 

  //variables for flashlight effect
  //public float[] DarkX = new float[1500];
  //public float[] DarkY = new float[1000];
  //public float angle = radians(0);

  public boolean starting = true;
  public int startingSeconds;
  public int startingMinutes;
  public int startingHours;

  public void settings() {
    size(1500, 1000);
  }


  public void setup() {

    painting = loadImage("Painting.png");
    backgroundOpenSafe = loadImage("BackgroundOpenSafe.jpg");
    backgroundWithoutPicture = loadImage("BackgroundWithoutPicture.jpg");

    A = loadImage("A.jpg");
    E = loadImage("E.jpg");
    H = loadImage("H.jpg");
    I = loadImage("I.jpg");
    N = loadImage("N.jpg");
    O = loadImage("O.jpg");
    S = loadImage("S.jpg");
    T = loadImage("T.jpg");
    U = loadImage("U.jpg");

    bed = loadImage("Bed.jpg");
    flashlight = loadImage("Flashlight.png");
    outside = loadImage("Outside.jpg");

    zero = loadImage("0.jpg");
    one = loadImage("1.jpg");
    two = loadImage("2.jpg");
    three = loadImage("3.jpg");
    four = loadImage("4.jpg");
    five = loadImage("5.jpg");
    six = loadImage("6.jpg");
    seven = loadImage("7.jpg");
    eight = loadImage("8.jpg");
    nine = loadImage("9.jpg");

  }

  public void draw() {
    int seconds = second();
    int minutes = minute();
    int hours = hour();

    if (starting == true){
      startingHours = hours;
      startingMinutes = minutes;
      startingSeconds = seconds;
      starting = false;
    }
	  
    if (scene == 1) {
      background();
      
      if (mousePressed){

        if (mouseX >= 206 && mouseX <= 366 && mouseY >= 690 && mouseY <= 840){

          scene = 2;

        }
        if (mouseX >= 180 && mouseX <= 354 && mouseY >= 890 && mouseY <= 970){

          scene = 3;

        }
        if (mouseX >= 100 && mouseX <= 328 && mouseY >= 135 && mouseY <= 596){

          scene = 5;

        } 
        if (mouseX >= 577 && mouseX <= 672 && mouseY >= 270 && mouseY <= 560){

          scene = 5;

        } 
        if (mouseX >= 920 && mouseX <= 1067 && mouseY >= 318 && mouseY <= 746){

          if (steps == 8) {
            scene = 6;
          } else {
            scene = 8;
            text = "This door seems to be locked. I wonder if there are any clues to what the code might be.";
          }
        } 
        if (mouseX >= 1231 && mouseY >= 609){

          scene = 7;
        }

        if (background == 2 && mouseX >= 1230 && mouseX <= 1340 && mouseY >= 380 && mouseY <= 485) {
          scene = 9;
        }
      }

    } else if (scene == 2) {
        activityOpen = true;
        background();
         
        darkBackground();
        
        //print box
        printToy1();
        printToy2();
        printToy3();
        printToy4();

        exit();

        //highlight box and calls method to change the side of said box
        if (mouseX >= 300 && mouseX <= 410 && mouseY >= 450 && mouseY <= 560){

          toyBox1();
          stroke(255, 255, 255, 50);
          fill(255, 255, 255, 50);
          rect(300, 450, 110, 110);
          
        } else if (mouseX >= 550 && mouseX <= 660 && mouseY >= 450 && mouseY <= 560){

          toyBox2();
          stroke(255, 255, 255, 50);
          fill(255, 255, 255, 50);
          rect(550, 450, 110, 110);
          
        } else if (mouseX >= 800 && mouseX <= 910 && mouseY >= 450 && mouseY <= 560){

          toyBox3();
          stroke(255, 255, 255, 50);
          fill(255, 255, 255, 50);
          rect(800, 450, 110, 110);
          
        } else if (mouseX >= 1050 && mouseX <= 1200 && mouseY >= 450 && mouseY <=560){

          toyBox4();
          stroke(255, 255, 255, 50);
          fill(255, 255, 255, 50);
          rect(1050, 450, 110, 110);

        }
      } else if (scene == 3) {

        activityOpen = true; 
        background();
         
        darkBackground();
        //image(page1, );

        steps++;

        exit();

      } else if (scene == 4) {

        activityOpen = true;
        darkBackground();

        steps++;

        exit();
        
      } else if(scene == 5) {

        activityOpen = true;
        
        image(outside, 0, 0);

        darkBackground();
        flashlight();

        exit();
        
      } else if(scene == 6) {

        activityOpen = true;

        door();

        darkBackground();

        exit();

      } else if(scene == 7) {

        activityOpen = true;

        image(bed, 0, 0);

        stroke(0);
        fill(0, 0, 0, 150);
        rect(0, 0, 1500, 1000);

        if (mouseX <= 144 || mouseX >= 379 || mouseY >= 583 || mouseY <= 348){
          stroke(0);
          fill(0);
          rect(144, 348, 235, 235);
        }
        steps++;

        flashlight();

        
      
        //tried to make real flashlight effect
        /*for (int i = 0; i < DarkY.length; i++){
          DarkY[i] = i;
        }
        for (int i = 0; i < DarkX.length; i++){
          DarkX[i] = i;
        }

        for (int i = 0; i < DarkY.length; i++){
          for (int j = 0; j <DarkX.length; j++){

            //int inside = 0;
            //int notinside = 0;


            while (inside != -1){

              //flashlight effect in shape of circle
               if (i >= mouseY + sin(angle) * 100 && i <= mouseY + 100 && j >= mouseX + cos(angle) * 100 && j <= mouseX + cos(PI/2 - angle)){
                inside = -1;
              }

              angle = angle + radians(1);

              if (angle >= 2 * PI) {
                inside = -1;
                notinside = -1;
                
              } 

              if (i >= mouseY - 100 && i <= mouseY + 100 && j >= mouseX - 100 && j <= mouseX + 100){
                inside = -1;
                } else {
                  inside = -1;
                  notinside = -1;
                }

            }

            if (i >= mouseY - 100 && i <= mouseY + 100 && j >= mouseX - 100 && j <= mouseX + 100){
              
            } else {
              if (notinside == -1){
              stroke(0, 0, 0, 255);
              stroke(0, 0, 0, 255);
              point(DarkX[j], DarkY[i]);
              }
            }
          }
        }*/



        exit();
      } else if (scene == 8) {

        textBox();

        stroke(0);
        fill(0);
        textSize(20);

        text(text, textX, textY);

        if (mousePressed) {
          if (mouseX >= 1200 && mouseX <= 1300 && mouseY >= 800 && mouseY <= 900){
            scene = previousScene;
          }
        }
      } else if (scene == 9) {

        activityOpen = true;

        darkBackground();

        exit();
      }

    timer();
}
  public void mouseDragged() {
    
    if (scene == 1) {
      if (mouseX >= 1200 && mouseX <= 1400 && mouseY >= 360 && mouseY <= 490){
        paintingX = mouseX;
        paintingY = mouseY;

        paintingMoved = true;
      }
    }

  }

  /*
  * Computes and prints the amount of time played
  */
  public void timer() {
    int seconds = second();
    int minutes = minute();
    int hours = hour();


    stroke(255);
    fill(255);
    textSize(25);

    text((hours - startingHours) + "/" + (minutes - startingMinutes) + "/" + (seconds - startingSeconds), 25, 25);
    
  }

  /*
  * Prints the correct background based on how far into the game
  */
  public void background() {

    if (paintingX <= 1200 || paintingX >= 1400 || paintingY <= 360 || paintingY >= 490 && paintingMoved == true) {
      background = 2;
    }

    if (background == 1) {

      image(backgroundWithoutPicture, 0, 0);
      image(painting, paintingX, paintingY);

    }
    if (background == 2) {

      image(backgroundWithoutPicture, 0, 0);
      image(painting, paintingX, paintingY);
      

    }
    if (background == 3) {

      image(backgroundOpenSafe, 0, 0);
      image(painting, paintingX, paintingY);

    }
  }

  /*
  * Prints a dark background
  */
  public void darkBackground() {

    stroke(0);
    fill(0, 0, 0, 210);
    rect(0, 0, 1500, 1000);
  }

  /*
  * Prints a textbox
  */
  public void textBox() {
    stroke(255);
    fill(88, 85, 90);

    rect(200, 800, 1100, 200);

    stroke(255);
    fill(255, 0, 0);

    ellipse(1250, 850, 50, 50);
    
    line(1240, 840, 1260, 860);
    line(1260, 840, 1240, 860);
  }

  /*
  * Prints an exit circle
  */
  public void exit() {
    stroke(255);
    fill(255, 0, 0);

    ellipse(1400, 100, 50, 50);
    
    line(1390, 90, 1410, 110);
    line(1410, 90, 1390, 110);

    if (mousePressed){
      if (mouseX >= 1350 && mouseX <= 1450 && mouseY >= 50 && mouseY <= 150){
        
        activityOpen = false;
        scene = 1;

      }
    }
  }

  /*
  * checks if keycodes have been pressed for toybox 1 then changes the sides of the box accordingly 
  */
  public void flashlight() {
    float opacity = 40;
    float size = 100;

    for(int i = 0; i < 10; i++){
        
      stroke(255, 244, 29, opacity);
      fill(255, 244, 29, opacity);
      ellipse(mouseX, mouseY, size, size);
      opacity = opacity - 10;
      size = size + 20;
    }

    image(flashlight, mouseX, mouseY);
  }

  /*
  * checks if keycodes have been pressed for toybox 1 then changes the sides of the box accordingly 
  */
  public void toyBox1() {

    char holder;
    
    if (keyPressed) {
      if (keyCode == UP) {
        
        holder = toyBox1[0];

        toyBox1[0] = toyBox1[1];
        toyBox1[1] = toyBox1[2];
        toyBox1[2] = toyBox1[3];
        toyBox1[3] = holder;

      } else if (keyCode == DOWN) {

        holder = toyBox1[0];

        toyBox1[0] = toyBox1[3];
        toyBox1[3] = toyBox1[2];
        toyBox1[2] = toyBox1[1];
        toyBox1[1] = holder;

      } else if (keyCode == LEFT) {

        holder = toyBox1[0];

        toyBox1[0] = toyBox1[4];
        toyBox1[4] = toyBox1[2];
        toyBox1[2] = toyBox1[5];
        toyBox1[5] = holder;

      } else if (keyCode == RIGHT) {

        holder = toyBox1[0];

        toyBox1[0] = toyBox1[5];
        toyBox1[5] = toyBox1[2];
        toyBox1[2] = toyBox1[4];
        toyBox1[4] = holder;
      }
    }
  }

  /*
  * checks if keycodes have been pressed for toybox 2 then changes the sides of the box accordingly 
  */
  public void toyBox2() {

    char holder;
    
    if (keyPressed) {
      if (keyCode == UP) {
        
        holder = toyBox2[0];

        toyBox2[0] = toyBox2[1];
        toyBox2[1] = toyBox2[2];
        toyBox2[2] = toyBox2[3];
        toyBox2[3] = holder;

      } else if (keyCode == DOWN) {

        holder = toyBox2[0];

        toyBox2[0] = toyBox2[3];
        toyBox2[3] = toyBox2[2];
        toyBox2[2] = toyBox2[1];
        toyBox2[1] = holder;

      } else if (keyCode == LEFT) {

        holder = toyBox2[0];

        toyBox2[0] = toyBox2[4];
        toyBox2[4] = toyBox2[2];
        toyBox2[2] = toyBox2[5];
        toyBox2[5] = holder;

      } else if (keyCode == RIGHT) {

        holder = toyBox2[0];

        toyBox2[0] = toyBox2[5];
        toyBox2[5] = toyBox2[2];
        toyBox2[2] = toyBox2[4];
        toyBox2[4] = holder;
      }
    }
  }

  /*
  * checks if keycodes have been pressed for toybox 3 then changes the sides of the box accordingly 
  */
  public void toyBox3() {

    char holder;
    
    if (keyPressed) {
      if (keyCode == UP) {
        
        holder = toyBox3[0];

        toyBox3[0] = toyBox3[1];
        toyBox3[1] = toyBox3[2];
        toyBox3[2] = toyBox3[3];
        toyBox3[3] = holder;

      } else if (keyCode == DOWN) {

        holder = toyBox3[0];

        toyBox3[0] = toyBox3[3];
        toyBox3[3] = toyBox3[2];
        toyBox3[2] = toyBox3[1];
        toyBox3[1] = holder;

      } else if (keyCode == LEFT) {

        holder = toyBox3[0];

        toyBox3[0] = toyBox3[4];
        toyBox3[4] = toyBox3[2];
        toyBox3[2] = toyBox3[5];
        toyBox3[5] = holder;

      } else if (keyCode == RIGHT) {

        holder = toyBox3[0];

        toyBox3[0] = toyBox3[5];
        toyBox3[5] = toyBox3[2];
        toyBox3[2] = toyBox3[4];
        toyBox3[4] = holder;
      }
    }
  }

  /*
  * checks if keycodes have been pressed for toybox 4 then changes the sides of the box accordingly 
  */
  public void toyBox4() {

    char holder;
    
    if (keyPressed) {
      if (keyCode == UP) {
        
        holder = toyBox4[0];

        toyBox4[0] = toyBox4[1];
        toyBox4[1] = toyBox4[2];
        toyBox4[2] = toyBox4[3];
        toyBox4[3] = holder;

      } else if (keyCode == DOWN) {

        holder = toyBox4[0];

        toyBox4[0] = toyBox4[3];
        toyBox4[3] = toyBox4[2];
        toyBox4[2] = toyBox4[1];
        toyBox4[1] = holder;

      } else if (keyCode == LEFT) {

        holder = toyBox4[0];

        toyBox4[0] = toyBox4[4];
        toyBox4[4] = toyBox4[2];
        toyBox4[2] = toyBox4[5];
        toyBox4[5] = holder;

      } else if (keyCode == RIGHT) {

        holder = toyBox4[0];

        toyBox4[0] = toyBox4[5];
        toyBox4[5] = toyBox4[2];
        toyBox4[2] = toyBox4[4];
        toyBox4[4] = holder;
      }
    }
  }

  /*
  * Prints the correct letter for toybox 1
  */
  public void printToy1() {
    float x = 300;
    float y = 450;

    if (toyBox1[0] == 'S'){

      image(S, x, y);

    }
    if (toyBox1[0] == 'T'){

      image(T, x, y);

    }
    if (toyBox1[0] == 'H'){

      image(H, x, y);

    }
    if (toyBox1[0] == 'A'){

      image(A, x, y);

    }
    if (toyBox1[0] == 'N'){

      image(N, x, y);
      steps++;

    }
    if (toyBox1[0] == 'U'){

      image(U, x, y);

    }

  }

  /*
  * Prints the correct letter for toybox 2
  */
  public void printToy2() {
    float x = 550;
    float y = 450;

    if (toyBox2[0] == 'H'){

      image(H, x, y);

    }
    if (toyBox2[0] == 'E'){

      image(E, x, y);

    }
    if (toyBox2[0] == 'I'){

      image(I, x, y);
      steps++;

    }
    if (toyBox2[0] == 'N'){

      image(N, x, y);

    }
    if (toyBox2[0] == 'T'){

      image(T, x, y);

    }
    if (toyBox2[0] == 'A'){

      image(A, x, y);

    }

  }

  /*
  * Prints the correct letter for toybox 3
  */
  public void printToy3() {
    float x = 800;
    float y = 450;

    if (toyBox3[0] == 'U'){

      image(U, x, y);

    }
    if (toyBox3[0] == 'I'){

      image(I, x, y);

    }
    if (toyBox3[0] == 'E'){

      image(E, x, y);

    }
    if (toyBox3[0] == 'N'){

      image(N, x, y);
      steps++;

    }
    if (toyBox3[0] == 'S'){

      image(S, x, y);

    }
    if (toyBox3[0] == 'O'){

      image(O, x, y);

    }

  }

  /*
  * Prints the correct letter for toybox 4
  */
  public void printToy4() {
    float x = 1050;
    float y = 450;

    if (toyBox4[0] == 'E'){

      image(E, x, y);
      steps++;

    }
    if (toyBox4[0] == 'H'){

      image(H, x, y);

    }
    if (toyBox4[0] == 'T'){

      image(T, x, y);

    }
    if (toyBox4[0] == 'S'){

      image(S, x, y);

    }
    if (toyBox4[0] == 'N'){

      image(N, x, y);

    }
    if (toyBox4[0] == 'I'){

      image(I, x, y);

    }

  }
  /*
  * Checks what the player has inputed for the code and prints if correct or incorrect as well as if the code is too short
  */
  public void door() {

    int numberPosition = 0;
    float numberX = 420;
    float numberY = 250;
    float[] numberValue = new float [4];
    float[] code = {9, 4, 5, 7};

    stroke(255);
    fill(255);
    line(420, 250, 570, 250);
    line(590, 250, 740, 250);
    line(760, 250, 910, 250);
    line(930, 250, 1080, 250);

    image(one, 525, 300);
    image(two, 675, 300);
    image(three, 825, 300);
    image(four, 525, 450);
    image(five, 675, 450);
    image(six, 825, 450);
    image(seven, 525, 600);
    image(eight, 675, 600);
    image(nine, 825, 600);
    image(zero, 675, 750);

    if (numberPosition == 0){
      
      numberX = 420;

    } else if (numberPosition == 1){

      numberX = 590;

    } else if (numberPosition == 2){

      numberX = 760;

    } else if (numberPosition == 3) {

      numberX = 930;

    }

    if (keyPressed) {

      if (key == '1'){

        image(one, numberX, numberY);
        numberValue[numberPosition] = 1;
        numberPosition++;

      } else if (key == '2'){

        image(two, numberX, numberY);
        numberValue[numberPosition] = 2;
        numberPosition++;

      } else if (key == '3') {

        image(three, numberX, numberY);
        numberValue[numberPosition] = 3;
        numberPosition++;

      } else if (key == '4') {

        image(four, numberX, numberY);
        numberValue[numberPosition] = 4;
        numberPosition++;

      } else if (key == '5') {

        image(five, numberX, numberY);
        numberValue[numberPosition] = 5;
        numberPosition++;

      } else if (key =='6') {

        image(six, numberX, numberY);
        numberValue[numberPosition] = 6;
        numberPosition++;

      } else if (key == '7') {

        image(seven, numberX, numberY);
        numberValue[numberPosition] = 7;
        numberPosition++;

      } else if (key == '8') {

        image(eight, numberX, numberY);
        numberValue[numberPosition] = 8;
        numberPosition++;

      } else if (key == '9') {

        image(nine, numberX, numberY);
        numberValue[numberPosition] = 9;
        numberPosition++;

      } else if (key == '0') {

        image(zero, numberX, numberY);
        numberValue[numberPosition] = 0;
        numberPosition++;

      }
    }

    if (keyPressed) {
      if (key == ENTER || key == RETURN){

        for (int i = 0; i < code.length; i++) {

          if (code[i] == numberValue[i]) {

          } else {
            previousScene = scene;
            scene = 8;
            text = "Code is incorrect. Please try again";
          }
        }

      }
    }


  }


}