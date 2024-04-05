import turtle as t # turtle 모듈 불러오고 turtle 대신 t 사용

colors = ["yellow", "green", "blue", "purple", "red", "orange"] # 색깔 리스트

t.speed(0) # 터틀의 속도를 최대한 빠르게

t.penup()
t.goto(0, -300) # 좌표 이동
t.pendown()


for i in range(250):
    t.color(colors[i % len(colors)]) # i를 배열의 길이로 나눈 나머지를 색깔로 지
    t.circle(i+5) # 반지름이 i+5만큼 증가
