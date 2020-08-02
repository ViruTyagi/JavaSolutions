class Car:
    def __init__(self,speed,unit):
        self.speed = speed
        self.unit = unit
    def __new__(cls,speed,unit):
        return "Car with maximum speed of "+str(speed) +" "+ unit

s = Car(45,"km")
print(s)