import { Stack } from "./Stack.mjs";

let stack = new Stack();

stack.push(1);
stack.push(2);
stack.push(3);
stack.push(4);

console.log("데이터 제거");
console.log(stack.pop().data);

console.log("Top에 있는 데이터 참조");
console.log(stack.peek().data);

console.log("스택이 비어있는지 확인 1");
console.log(stack.isEmpty());

stack.pop();
stack.pop();
stack.pop();

console.log("스택이 비어있는지 확인 2");
console.log(stack.isEmpty());
