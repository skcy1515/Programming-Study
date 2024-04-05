import turtle as t

colors = ["yellow", "green", "blue", "purple", "red", "orange"] # 색깔 리스트

screen = t.Screen() # 스크린 객체 생성

screen.bgcolor("black") # 배경색 검정으로 지정

t.speed(0) # 최대한 빠르게

t.pensize(3)

for i in range(97):
    t.color(colors[i % len(colors)])
    t.right(89)
    t.forward(15 + i*5) 
