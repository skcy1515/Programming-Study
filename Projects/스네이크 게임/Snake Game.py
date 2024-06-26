from tkinter import *
import random

width, height = 700, 700 # 캔버스 크기
rSize = 35 # 객체 크기

def game_main():
    global snake, snake_direction, food, score, running, obstacles, time_left, img
    snake = [(70, 70), (60, 70)]  # 뱀 초기 위치 설정
    snake_direction = "Right"  # 초기 방향 설정
    food = None
    obstacles = []  # 장애물 리스트
    time_left = 30  # 타이머 초기화
    
    create_food()  # 음식 생성

    # 점수 초기화
    score = 0
    update_score()
    update_timer()  # 타이머 업데이트

    # 게임 상태 플래그
    running = True

    # 이미지 로드 (전역 변수로 설정)
    if 'img' not in globals():
        img = PhotoImage(file="C:/Users/skcy1/OneDrive/Desktop/코딩/Programming-Study/Projects/스네이크 게임/KGU.gif")

    # 캔버스에 이미지 삽입
    canvas.create_image(590, 40, anchor=NW, image=img)

def create_food():
    global food
    # 기존 음식 삭제
    if food is not None:
        canvas.delete(food)
        food = None
    
    # 새로운 음식 위치 설정
    while True:
        x = random.randint(0, 19) * rSize
        y = random.randint(0, 19) * rSize
                
        if (x, y) not in snake and (x, y) not in obstacles:  # 좌표가 스네이크 몸통이나 장애물 좌표와 겹치지 않을 때 반복문 종료
            food = canvas.create_rectangle(x, y, x + rSize, y + rSize, fill="red") # x, y 랜덤 좌표에 rSize 크기인 사각형 먹이 객체 생성
            break

def create_obstacles(count):
    global obstacles
    # 기존 장애물 삭제 (게임 재시작시)
    for obstacle in obstacles:
        canvas.delete(obstacle)
    obstacles = [] # 장애물 리스트 생성

    # 장애물 생성
    for _ in range(count):
        while True:
            x = random.randint(0, 17) * rSize
            y = random.randint(0, 17) * rSize
            
            # 장애물이 뱀이나 음식과 겹치지 않도록
            if (x, y) not in snake and (x, y) != canvas.coords(food)[:2]:
                obstacle = canvas.create_rectangle(x, y, x + rSize, y + rSize, fill="gray")
                obstacles.append((x, y))  # 장애물 리스트에 좌표 저장
                break

def update_score():
    global score_text
    # 점수 업데이트 시 객체 삭제하고 다시 생성
    if 'score_text' in globals():
        canvas.delete(score_text)
    
    # 점수 텍스트 업데이트
    score_text = canvas.create_text(50, 20, fill="black", text="점수: " + str(score), font=("Helvetica", 16))

def update_timer():
    global timer_text, time_left
    # 타이머 업데이트 시 객체 삭제하고 다시 생성
    if 'timer_text' in globals():
        canvas.delete(timer_text)
    
    # 타이머 텍스트 업데이트
    timer_text = canvas.create_text(600, 20, fill="black", text="남은 시간: " + str(time_left), font=("Helvetica", 16))

def countdown():
    global time_left, running, timer_id
    if running and time_left > 0: # 실행중일 때와 남은 시간이 1초 이상일 때 시간 감소
        time_left -= 1
        update_timer()
        timer_id = window.after(1000, countdown)
    elif time_left == 0: # 남은 시간이 0초일 때 게임 종료
        end_game()

def end_game():
    global running
    running = False
    canvas.create_text(350, 300, fill="blue", text="게임 종료!", font=("Helvetica", 32))
    canvas.create_text(350, 360, fill="blue", text="점수: " + str(score), font=("Helvetica", 24))
    canvas.create_text(350, 420, fill="blue", text="재시작하려면 R키를 누르세요", font=("Helvetica", 24))

def change_direction(event):
    global snake_direction
    # 키보드 입력을 받아 뱀의 방향을 변경
    new_direction = event.keysym # 키 입력 받음
    all_directions = {"Up", "Down", "Left", "Right"} # 가능한 방향 정의
    opposites = {"Up": "Down", "Down": "Up", "Left": "Right", "Right": "Left"} # 현재 이동 방향의 반대 방향을 쉽게 확인하기 위한 딕셔너리 정의

    # 현재 방향과 반대 방향이 아닌지 확인
    if new_direction in all_directions and new_direction != opposites[snake_direction]:
        snake_direction = new_direction

def restart_game(event):
    # 게임 재시작 시 모든 요소 초기화
    global current_obstacle_count, timmer_id
    window.after_cancel(timer_id) # 카운트다운 정지
    canvas.delete("all") 
    game_main()
    countdown()
    create_obstacles(current_obstacle_count)

def move_snake():
    global running, score, food
    # 뱀의 머리 위치 업데이트
    head_x, head_y = snake[0]
    if snake_direction == "Up":
        new_head = (head_x, head_y - rSize)
    elif snake_direction == "Down":
        new_head = (head_x, head_y + rSize)
    elif snake_direction == "Left":
        new_head = (head_x - rSize, head_y)
    elif snake_direction == "Right":
        new_head = (head_x + rSize, head_y)

    # 뱀의 위치 업데이트
    snake.insert(0, new_head)
    snake.pop()

    # 충돌 확인
    if check_collision():
        end_game()
        return

    # 뱀이 음식을 먹었는지 확인
    if canvas.coords(food)[:2] == [new_head[0], new_head[1]]:  # coords로 food의 x, y좌표를 가져와 뱀의 머리 좌표와 비교
        snake.append(snake[-1])  # 뱀의 길이 증가
        canvas.delete(food)  # 기존 음식 삭제
        food = None
        create_food()  # 새로운 음식 생성
        score += 1  # 점수 증가
        update_score()  # 점수 업데이트

    # 뱀을 화면에 그리기
    canvas.delete("snake")
    for element in snake:
        canvas.create_rectangle(element[0], element[1], element[0] + rSize, element[1] + rSize, fill="green", tag="snake")

def check_collision():
    head_x, head_y = snake[0]
    # 벽이나 자기 자신과의 충돌 여부 확인
    return (
        head_x < 0 or head_x >= width or head_y < 0 or head_y >= height or
        (head_x, head_y) in snake[1:] or
        (head_x, head_y) in obstacles  # 장애물과의 충돌 확인
    )

def game_loop(speed):
    if running:
        move_snake()
    window.after(speed, game_loop, speed) # speed 밀리초후에 재귀적으로 game_loop 다시 실행

def start_game(speed, obstacle_count):
    global current_obstacle_count
    current_obstacle_count = obstacle_count # 현재 장애물 개수를 저장할 변수
    game_loop(speed)
    create_obstacles(obstacle_count)  # 장애물 생성
    countdown()  # 타이머 시작
    canvas.delete(button1_window)
    canvas.delete(button2_window)
    canvas.delete(button3_window)

# 게임 실행
window = Tk()
window.title("스네이크 게임")
canvas = Canvas(window, bg="white", width=700, height=700)  # 캔버스 생성
canvas.pack()  # 생성한 캔버스 윈도우에 배치

# 이미지 로드
img = PhotoImage(file="C:/Users/skcy1/OneDrive/Desktop/코딩/Programming-Study/Projects/스네이크 게임/KGU.gif")

# 캔버스에 이미지 삽입
canvas.create_image(590, 40, anchor=NW, image=img)

game_main()  # 게임 초기화
window.bind("<KeyPress>", change_direction)  # 키보드 입력 처리
window.bind("<KeyPress-r>", restart_game)  # 게임 재시작 처리

# 버튼 1 생성
button1 = Button(window, text="쉬움", command=lambda: start_game(125, 3), width=8, height=3)
button1_window = canvas.create_window(180, 300, anchor="nw", window=button1)

# 버튼 2 생성
button2 = Button(window, text="보통", command=lambda: start_game(100, 6), width=8, height=3)
button2_window = canvas.create_window(320, 300, anchor="nw", window=button2)

# 버튼 3 생성
button3 = Button(window, text="어려움", command=lambda: start_game(75, 9), width=8, height=3)
button3_window = canvas.create_window(460, 300, anchor="nw", window=button3)

# 게임 루프 시작
window.mainloop()


