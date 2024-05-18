# Stream API
Stream API는 데이터를 처리하고 변환하는 데 사용할 수 있는 기능을 제공한다. 이 API를 사용하면 배열, 리스트, 맵 등의 컬렉션에서 데이터를 추출하고 필터링, 매핑, 집계 등 다양한 작업을 수행할 수 있다. 

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
