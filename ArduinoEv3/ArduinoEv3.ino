//#include <SoftwareSerial.h>
//SoftwareSerial mySerial(2, 4); // RX, TX

#include <Servo.h>

enum keyWords {
  GET,
  SET,
  MOTOR_PORT,
  MOTOR_SPEED,
  MOTOR_UPDATE,
  MOTOR_TACHO_0,
  MOTOR_TACHO_1,
  MOTOR_TACHO_2,
  MOTOR_TACHO_3,
  SERVO_PORT,
  SERVO_POSITION,
  SERVO_UPDATE,
  SIZE
};

enum machineState {
  WAITING_HEADER,
  WAITING_KEY,
  WAITING_VALUE,
  DO_GET,
  DO_SET
};

byte dataArray[SIZE];
byte dataSize[SIZE] = {1, 1, 1, 1, 1, 4, 0, 0, 0, 1, 1, 1};

byte motorPin[] = {6, 5};
byte motorSpeed[sizeof(motorPin)];
Servo motor[sizeof(motorPin)];

byte servoPin[] = {9, 10, 11};
byte servoPosition[sizeof(servoPin)];
Servo servo[sizeof(servoPin)];

byte encoderChannelAPin[] = {2, 3};
//byte encoderChannelAPrevPrevPrevState[sizeof(encoderChannelAPin)];
//byte encoderChannelAPrevPrevState[sizeof(encoderChannelAPin)];
//byte encoderChannelAPrevState[sizeof(encoderChannelAPin)];
//byte encoderChannelACurrentState[sizeof(encoderChannelAPin)];
byte encoderChannelBPin[] = {7, 4};
long encoderValue[sizeof(encoderChannelAPin)];

byte state = WAITING_HEADER;

bool dataAvailable = false;
byte incomingByte = 0;
byte header = 0;
byte key = 0;
byte value = 0;

byte prevMotorPort = 0;
byte prevMotorSpeed = 0;

byte prevServoPort = 0;
byte prevServoPosition = 0;

byte i = 0;

byte debugLedState = LOW;

void setup() {
  for (i = 0; i < sizeof(motorPin); i++)
  {
    motor[i].attach(motorPin[i]);
  }
  for (i = 0; i < sizeof(servoPin); i++)
  {
    servo[i].attach(servoPin[i]);
  }
  for (i = 0; i < sizeof(encoderChannelAPin); i++)
  {
    pinMode(encoderChannelAPin[i], INPUT);
    pinMode(encoderChannelBPin[i], INPUT);
  }
  pinMode(LED_BUILTIN, OUTPUT);
  attachInterrupt(digitalPinToInterrupt(encoderChannelAPin[0]), motor0EncoderHandler, RISING);
  attachInterrupt(digitalPinToInterrupt(encoderChannelAPin[1]), motor1EncoderHandler, RISING);
  Serial.begin(115200);
  //mySerial.begin(38400);
}

void blinkDebugLed()
{
  debugLedState = !debugLedState;
  digitalWrite(LED_BUILTIN, debugLedState);
}

void updateMotors()
{
  if (dataArray[MOTOR_PORT] >= sizeof(motorPin))
  {
    // L'idiot du village essaye de nous faire crasher. Ce port n'existe pas.
    dataArray[MOTOR_PORT] = prevMotorPort;
  }
  if (prevMotorPort != dataArray[MOTOR_PORT])
  {
    prevMotorSpeed = dataArray[MOTOR_SPEED] = motorSpeed[dataArray[MOTOR_PORT]];
    prevMotorPort = dataArray[MOTOR_PORT];
  }
  memcpy(dataArray + MOTOR_TACHO_0, &(encoderValue[dataArray[MOTOR_PORT]]), dataSize[MOTOR_TACHO_0]);
  if (dataArray[MOTOR_UPDATE])
  {
    blinkDebugLed();
    motorSpeed[dataArray[MOTOR_PORT]] = dataArray[MOTOR_SPEED];
    motor[dataArray[MOTOR_PORT]].writeMicroseconds((int8_t)(motorSpeed[dataArray[MOTOR_PORT]]) * 5 + 1500); //scale up to 1000-2000
    dataArray[MOTOR_UPDATE] = 0;
  }
}

void updateServos()
{
  if (dataArray[SERVO_PORT] >= sizeof(servoPin))
  {
    // L'idiot du village essaye de nous faire crasher. Ce port n'existe pas.
    dataArray[SERVO_PORT] = prevServoPort;
  }
  if (prevServoPort != dataArray[SERVO_PORT])
  {
    prevServoPosition = dataArray[SERVO_POSITION] = servoPosition[dataArray[SERVO_PORT]];
    prevServoPort = dataArray[SERVO_PORT];
  }
  if (dataArray[SERVO_UPDATE])
  {
    servoPosition[dataArray[SERVO_PORT]] = dataArray[SERVO_POSITION];
    servo[dataArray[SERVO_PORT]].writeMicroseconds((int8_t)(servoPosition[dataArray[SERVO_PORT]]) * 10 + 1000); //scale up to 1000-2000
    dataArray[SERVO_UPDATE] = 0;
  }
}

void readChannelB(byte index)
{
  if (digitalRead(encoderChannelBPin[index]))
  {
    encoderValue[index]++;
  }
  else
  {
    encoderValue[index]--;
  }
}

/*void checkEncoders2And3()
{
  for (i = 2; i < sizeof(encoderChannelAPin); i++)
  {
    encoderChannelACurrentState[i] = digitalRead(encoderChannelAPin[i]);
    if (encoderChannelAPrevPrevPrevState[i] == LOW && encoderChannelAPrevPrevState[i] == LOW && encoderChannelAPrevState[i] == HIGH && encoderChannelACurrentState[i] == HIGH)
    {
      readChannelB[i];
    }
    encoderChannelAPrevPrevPrevState[i] = encoderChannelAPrevPrevState[i];
    encoderChannelAPrevPrevState[i] = encoderChannelAPrevState[i];
    encoderChannelAPrevState[i] = encoderChannelACurrentState[i];
  }
}*/

void motor0EncoderHandler()
{
  readChannelB(0);
}

void motor1EncoderHandler()
{
  readChannelB(1);
}

void checkIncomingData()
{
  if (!dataAvailable && Serial.available())
  {
    incomingByte = Serial.read();
    dataAvailable = true;
  }
}

void doReceiveDataStateMachine()
{
  switch (state)
  {
    case WAITING_HEADER:
      if (dataAvailable)
      {
        header = incomingByte;
        //mySerial.write(header);
        dataAvailable = false;
        if (header == GET || header == SET)
        {
          state = WAITING_KEY;
        }
      }
      break;
    case WAITING_KEY:
      if (dataAvailable)
      {
        key = incomingByte;
        //mySerial.write(key);
        dataAvailable = false;
        if (header == GET)
        {
          state = DO_GET;
        }
        else // header == SET
        {
          state = WAITING_VALUE;
        }
      }
      break;
    case WAITING_VALUE:
      if (dataAvailable)
      {
        value = incomingByte;
        //mySerial.write(value);
        dataAvailable = false;
        state = DO_SET;
      }
      break;
    case DO_GET:
      Serial.write(dataArray + key, dataSize[key]);
      //mySerial.write(dataArray[key]);
      state = WAITING_HEADER;
      break;
    case DO_SET:
      dataArray[key] = value;
      state = WAITING_HEADER;
      break;
    default:
      break;
  }
}

void loop()
{
  
  checkIncomingData();
  doReceiveDataStateMachine();
  //checkEncoders2And3(); // 0 et 1 sont sur interruptions
  updateMotors();
  updateServos();
  
}
