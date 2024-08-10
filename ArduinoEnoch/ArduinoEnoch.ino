
int analogPin = A0;

double partialVal = 0;

double totalVal = 0;
void setup() {
  Serial.begin(9600) ;
  // put your setup code here, to run once:
}

void loop() {
  partialVal = ((analogRead(analogPin))*5.0) / 1024;
  totalVal = (partialVal * (55.0 / 22));
   Serial.println(analogRead(analogPin)*5.0);
   Serial.println(partialVal);
   Serial.println(totalVal);
   Serial.println();
    delay(1000); 
  // put your main code here, to run repeatedly:

}
