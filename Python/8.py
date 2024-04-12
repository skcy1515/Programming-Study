import turtle as t
import random

swidth, sheight = 500, 500
myTurtle, tX, tY, tColor, tSize, tShape = [None] * 6 # 터틀 리스트 6개 생성
shapeList= []
shapeList = t.getshapes() # 사용 가능한 모든 모양의 이름 목록을 반환

playerTurtles = [] # 이중 리스트

t.setup(width = swidth + 50, height = sheight + 50) # 터틀 캔버스 창
t.screensize(swidth, sheight) # 터틀 캔버스 창 

for i in range(100):
        random.shuffle(shapeList) 
        myTurtle = t.Turtle(shapeList[0]) # shapeList[0] 모양을 하는 myTurtle 객체 생성
        tX = random.randrange(-swidth // 2, swidth // 2)
        tY = random.randrange(-sheight // 2, sheight // 2)
        r = random.random(); g = random.random(); b = random.random() # rgb 랜덤 생성
        tSize = random.randrange(1, 3)
        playerTurtles.append([myTurtle, tX, tY, tSize, r, g, b])
    
for tList in playerTurtles :
        t = tList[0] # myTurtle 객체 가져와 t로 선언
        t.color((tList[4],tList[5],tList[6]))
        t.pencolor((tList[4],tList[5],tList[6]))
        t.turtlesize(tList[3])
        t.goto(tList[1], tList[2])

turtle.done()
