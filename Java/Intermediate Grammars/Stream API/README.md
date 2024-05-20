# Stream API
Stream API는 데이터를 처리하고 변환하는 데 사용할 수 있는 기능을 제공한다. 이 API를 사용하면 배열, 리스트, 맵 등의 컬렉션에서 데이터를 추출하고 필터링, 매핑, 집계 등 다양한 작업을 수행할 수 있다. 

자바 스트림은 일회용이기 때문에, 한 번 사용된 스트림은 재사용할 수 없다. 만약 스트림을 이미 사용한 후 다시 사용하려고 시도하는 경우에 오류가 발생한다.

# Stream 생성
```
        // 콜렉션으로부터 생성
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Stream<String> stream = list.stream();

        // 배열으로부터 생성
        String[] arr = {"d", "e", "f"};
        Stream<String> stream2 = Arrays.stream(arr);

        // Stream.of 사용
        Stream<String> stream3 = Stream.of("g", "h", "i");

```

# Stream 중간 연산
### filter()
조건에 맞는 요소만 선택하여 Stream으로 반환한다.
```
        Stream<String> stream = Stream.of("apple", "banana", "cherry", "durian");
        Stream<String> filteredStream = stream.filter(str -> str.length() > 5);

        filteredStream.forEach(System.out::println); // banana cherry durian
```

### map()
각 요소에 매핑 함수를 적용하여 새로운 Stream으로 반환한다.

- map 함수: 스트림의 각 요소를 다른 형태로 변환한다. (예: 문자열을 대문자로 변환, 숫자를 제곱 등.)
- filter 함수: 스트림의 각 요소를 조건에 따라 필터링합니다. (예: 짝수만 남기기, 특정 조건을 만족하는 객체만 남기기 등)

```
        Stream<String> stream2 = Stream.of("apple", "banana", "cherry");
        Stream<Integer> mappedStream = stream2.map(str -> str.length());

        mappedStream.forEach(System.out::println); // 5 6 6
```

### sorted()
요소를 정렬한다.

```
        Stream<String> stream3 = Stream.of("banana", "apple", "durian", "cherry");
        Stream<String> sortedStream = stream3.sorted();

        sortedStream.forEach(System.out::println); // apple banana cherry durian
```

### distinct()
요소의 중복을 제거한다.

```
        Stream<String> stream4 = Stream.of("apple", "banana", "apple", "cherry");
        Stream<String> distinctStream = stream4.distinct();

        distinctStream.forEach(System.out::println); // apple banana cherry
```

# Stream 최종 연산
Stream에 대해 최종 연산을 수행할 수 있다. 최종 연산은 Stream을 반환하지 않고, 최종 결과를 반환한다.

### forEach()
각 요소에 대해 작업을 수행한다.
```
filteredStream.forEach(System.out::println); // banana cherry durian
```

### toArray()
Stream의 요소를 배열로 반환한다.
```
        Stream<String> stream5 = Stream.of("apple", "banana", "cherry", "durian");
        String[] arr = stream5.toArray(String[]::new);
        System.out.println(Arrays.toString(arr)); // [apple, banana, cherry, durian]
```

### collect()
Stream의 요소를 새로운 collection, list, set으로 반환한다.
```
        Stream<String> stream6 = Stream.of("apple", "banana", "cherry", "durian");
        List<String> list = stream6.collect(Collectors.toList());
        list.forEach(System.out::println); // apple banana cherry durian
```

### reduce()
Stream의 요소를 하나로 줄여 하나의 결과를 반환한다.
```
        Stream<Integer> stream7 = Stream.of(1, 2, 3, 4, 5);
        int sum = stream7.reduce(0, (acc, val) -> acc + val);
        System.out.println(sum); // 15
```

### count()
Stream의 요소의 개수를 반환한다.
```
        Stream<String> stream8 = Stream.of("apple", "banana", "cherry", "durian");
        long count = stream8.count();
        System.out.println(count); // 4
```

### anyMatch(), allMatch()
하나 이상의 요소가 있는지, 모든 요소가 있는지 검사하여 결과를 반환한다. 
```
        Stream<String> stream9 = Stream.of("apple", "banana", "cherry", "durian");
        boolean result = stream9.anyMatch(str -> str.startsWith("a"));
        System.out.println(result); // true

        Stream<String> stream10 = Stream.of("apple", "banana", "cherry", "durian");
        boolean result2 = stream10.allMatch(str -> str.length() > 3);
        System.out.println(result2); // true
```

# Stream 활용 예제 모음
```
        // 짝수만 필터링
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        evenNumbers.forEach(System.out::println); // 2, 4, 6, 8, 10

        // 대문자로 변환
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> upperCaseWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        upperCaseWords.forEach(System.out::println); // APPLE, BANANA, CHERRY

        // 요소들의 합 출력
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers2.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum); // Sum: 15

        // 최댓값 찾기
        List<Integer> numbers3 = Arrays.asList(3, 5, 2, 8, 1);
        Optional<Integer> max = numbers3.stream()
                .reduce(Integer::max);
        max.ifPresent(value -> System.out.println("Max: " + value)); // Max: 8

        // 리스트를 집합으로 만들기
        List<String> words2 = Arrays.asList("apple", "banana", "cherry", "apple");
        Set<String> wordSet = words2.stream()
                .collect(Collectors.toSet());
        wordSet.forEach(System.out::println); // apple, banana, cherry

        // 정렬하기
        List<Integer> numbers4 = Arrays.asList(5, 3, 8, 1, 2);
        List<Integer> sortedNumbers = numbers4.stream()
                .sorted()
                .collect(Collectors.toList());
        sortedNumbers.forEach(System.out::println); // 1, 2, 3, 5, 8

        // 모든 숫자가 짝수인지 아닌지
        List<Integer> numbers5 = Arrays.asList(2, 4, 6, 8, 10);
        boolean allEven = numbers5.stream()
                .allMatch(n -> n % 2 == 0);
        System.out.println("All even: " + allEven); // All even: true


        // 요소 수 세기
        List<String> words3 = Arrays.asList("apple", "banana", "cherry");
        long count = words3.stream()
                .count();
        System.out.println("Count: " + count); // Count: 3
```
