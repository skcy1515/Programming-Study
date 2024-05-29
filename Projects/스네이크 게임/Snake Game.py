from tkinter import *
import random

def game_main():
    global snake, snake_direction, food, score, running, obstacles, time_left
    snake = [(60, 60), (50, 60)]  # 뱀 초기 위치 설정
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

def create_food():
    global food
    # 기존 음식 삭제 (게임 재시작시)
    if food:
        canvas.delete(food)
    
    # 새로운 음식 위치 설정
    while True:
        x = random.randint(0, 19) * 30
        y = random.randint(0, 19) * 30
        food = canvas.create_rectangle(x, y, x + 30, y + 30, fill="red")
        
        if (x, y) not in snake and (x, y) not in obstacles:  # 좌표가 스네이크 몸통이나 장애물 좌표와 겹치지 않을 때 반복문 종료
            break

def create_obstacles(count):
    global obstacles
    # 기존 장애물 삭제 (게임 재시작시)
    for obstacle in obstacles:
        canvas.delete(obstacle)
    obstacles = []

    # 장애물 생성
    for _ in range(count):
        while True:
            x = random.randint(0, 17) * 30
            y = random.randint(0, 17) * 30
            
            # 장애물이 뱀이나 음식과 겹치지 않도록
            if (x, y) not in snake and (x, y) != canvas.coords(food)[:2]:
                obstacle = canvas.create_rectangle(x, y, x + 30, y + 30, fill="gray")
                obstacles.append((x, y))  # 장애물 좌표 저장
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
    timer_text = canvas.create_text(500, 20, fill="black", text="남은 시간: " + str(time_left), font=("Helvetica", 16))

def countdown():
    global time_left, running, timer_id
    if running and time_left > 0:
        time_left -= 1
        update_timer()
        window.after(1000, countdown)
    elif time_left == 0:
        end_game()

def end_game():
    global running
    running = False
    canvas.create_text(300, 200, fill="blue", text="게임 종료!", font=("Helvetica", 32))
    canvas.create_text(300, 260, fill="blue", text="점수: " + str(score), font=("Helvetica", 24))
    canvas.create_text(300, 320, fill="blue", text="재시작하려면 R키를 누르세요", font=("Helvetica", 24))

def change_direction(event):
    global snake_direction
    # 키보드 입력을 받아 뱀의 방향을 변경
    new_direction = event.keysym
    all_directions = {"Up", "Down", "Left", "Right"}
    opposites = {"Up": "Down", "Down": "Up", "Left": "Right", "Right": "Left"}

    # 현재 방향과 반대 방향이 아닌지 확인
    if new_direction in all_directions and new_direction != opposites[snake_direction]:
        # 새 방향과 현재 방향이 평행하지 않은지 확인
        if (snake_direction == "Up" or snake_direction == "Down") and (new_direction == "Left" or new_direction == "Right"):
            snake_direction = new_direction
        elif (snake_direction == "Left" or snake_direction == "Right") and (new_direction == "Up" or new_direction == "Down"):
            snake_direction = new_direction

def restart_game(event):
    # 게임 재시작 시 모든 요소 초기화
    global current_obstacle_count
    canvas.delete("all")
    game_main()
    countdown()
    create_obstacles(current_obstacle_count)

def move_snake():
    global running, score, food
    # 뱀의 머리 위치 업데이트
    head_x, head_y = snake[0]
    if snake_direction == "Up":
        new_head = (head_x, head_y - 30)
    elif snake_direction == "Down":
        new_head = (head_x, head_y + 30)
    elif snake_direction == "Left":
        new_head = (head_x - 30, head_y)
    elif snake_direction == "Right":
        new_head = (head_x + 30, head_y)

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
        canvas.create_rectangle(element[0], element[1], element[0] + 30, element[1] + 30, fill="green", tag="snake")

def check_collision():
    head_x, head_y = snake[0]
    # 벽이나 자기 자신과의 충돌 여부 확인
    return (
        head_x < 0 or head_x >= 600 or head_y < 0 or head_y >= 600 or
        (head_x, head_y) in snake[1:] or
        (head_x, head_y) in obstacles  # 장애물과의 충돌 확인
    )

def game_loop(speed):
    if running:
        move_snake()
    window.after(speed, game_loop, speed)

def start_game(speed, obstacle_count):
    global current_obstacle_count
    current_obstacle_count = obstacle_count
    game_loop(speed)
    create_obstacles(obstacle_count)  # 장애물 생성
    countdown()  # 타이머 시작
    canvas.delete(button1_window)
    canvas.delete(button2_window)
    canvas.delete(button3_window)

# 게임 실행
window = Tk()
window.title("스네이크 게임")
canvas = Canvas(window, bg="white", width=600, height=600)  # 캔버스 생성
canvas.pack()  # 생성한 캔버스 윈도우에 배치

# 이미지 로드
img = PhotoImage(file="C:/Users/skcy1/OneDrive/Desktop/코딩/Programming-Study/Projects/스네이크 게임/KGU.gif")

# 캔버스에 이미지 삽입
canvas.create_image(475, 40, anchor=NW, image=img)

current_obstacle_count = 0  # 현재 장애물 개수를 저장할 변수

game_main()  # 게임 초기화
window.bind("<KeyPress>", change_direction)  # 키보드 입력 처리
window.bind("<KeyPress-r>", restart_game)  # 게임 재시작 처리

# 버튼 1 생성
button1 = Button(window, text="쉬움", command=lambda: start_game(150, 3), width=8, height=3)
button1_window = canvas.create_window(130, 250, anchor="nw", window=button1)

# 버튼 2 생성
button2 = Button(window, text="보통", command=lambda: start_game(100, 6), width=8, height=3)
button2_window = canvas.create_window(270, 250, anchor="nw", window=button2)

# 버튼 3 생성
button3 = Button(window, text="어려움", command=lambda: start_game(100, 9), width=8, height=3)
button3_window = canvas.create_window(410, 250, anchor="nw", window=button3)

# 게임 루프 시작
window.mainloop()


