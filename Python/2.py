import turtle

t = turtle.Turtle()

for i in range(4):
    t.forward(100)
    t.right(90)

t.penup()
t.goto(100, 100)
t.pendown()
t.pencolor("blue")
t.pensize(5)
for i in range(3):
    t.forward(100) 
    t.left(120)   

t.penup()
t.goto(-200, -200)
t.pendown()
t.pencolor("red")
t.pensize(5)

for i in range(4):
    t.forward(100)
    t.right(90)
