package com.kyy.java.addstudy;

import java.util.*;

public class CollectionMain {

    static class ResponseResult<T> {
        int code;
        String msg;
        T body;
    }

    static class ResponseResult2 {
        int code;
        String msg;
        Object body;
    }

    static class Member {
        String name;
        String phone;

        public Member(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }

    class SeoList extends AbstractList implements List {


        List getList() {
            return this;
        }

        String findByString(CollectionMain collectionMain, String hello) {
            for(String str : collectionMain.list) {
                if (str.equals(hello)) {
                    System.out.println(str);
                }
            }
            return "";
        }

        @Override
        public Object get(int index) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    }

    // 리스트 : 순서가 있는 데이터의 집합
    List<String> list = new ArrayList<>();
    List<String> seoList = new SeoList();
    List<Map<String, Object>> list2 = new ArrayList<>();
    List<Member> list3 = new ArrayList<>();

    // 맵 : 키와 값의 쌍으로 이루어진 데이터의 집합

    // 셋 : 중복을 허용하지 않는 데이터의 집합

    public static void main(String[] args) {
        System.out.println("Collection hello");
//        testMap();

        // Set
        Set<String> set = new HashSet<>();
        // 추가
        set.add("1");
        set.add("54");
        // 삭제
        set.remove("1");
        // 조회
        set.contains("1");

        // 1,2,3,4,5,6

        // 1,1,3,4,5,6

        System.out.println(set);

    }

    private static void testMap() {
        // String
        // 1
        CollectionMain collectionMain = new CollectionMain();
        // 추가
        collectionMain.list.add("hello");
        // 삭제
        collectionMain.list.remove("hello");
        // 수정
        collectionMain.list.set(0, "hello"); // 에디트 edit

        collectionMain.list.remove("hello"); // 지우고 추가
        collectionMain.list.add("hello");
        // 전체 조회
        getList(collectionMain);
        // 단건 조회
        findByString(collectionMain, "hello2");

        SeoList seoList = collectionMain.new SeoList();
        seoList.findByString(collectionMain, "hello2");
        seoList.getList();

        // Map
        collectionMain.list2.add(Map.of("hello", "world"));
        collectionMain.list2.set(0, Map.of("hello", "world"));
        collectionMain.list2.remove(Map.of("hello", "world"));
        collectionMain.list2.add(Map.of("hello", "world2"));

        // add
        collectionMain.list3.add(new Member("영희", "123123"));
        // remove
        collectionMain.list3.remove(new Member("영희", "12312312"));
        // edit
        collectionMain.list3.remove(new Member("영희", "123123123"));
        collectionMain.list3.add(new Member("영희", "9999"));

        collectionMain.list3.set(0, new Member("영희", "9999"));

        // 초기화
        Map<String, String> map = Map.of("hello", "world"); // 선언 + 초기화 + 값대입
        Map<String, Object> map2 = new HashMap<>(); // 선언 + 초기화
        // 삭제
        map.put("hello", "world"); // 값대입
        map.remove("hello"); // 값삭제
        // 수정
        map.remove("hello");
        map.put("hello", "world2");
        // 조회
        map.get("hello");

        Map<Integer, String> map3 = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map3.put(i, "hello" + i);
        }

        Map<String, Member> map4 = new HashMap<>();
        map4.put("820410-123123", new Member("영희", "123123"));
        map4.put("820410-123123", new Member("영희", "123123"));
        map4.put("820410-123123", new Member("영희", "123123"));
        map4.put("820410-123123", new Member("영희", "123123"));

        /**
         * {
         *   code : 200,
         *   msg : "success",
         *   body : {
         *    name : "영희",
         *    phone : "123123"
         *    }
         * }
         */
        // 비추
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", "200");
        resultMap.put("code", "200");
        resultMap.put("msg", "success");
        resultMap.put("body", new Member("영희", "123123"));

        // 강추
        ResponseResult<Member> responseResult = new ResponseResult<>();
        responseResult.code = 200;
        responseResult.msg = "success";
        responseResult.body = new Member("영희", "123123");
    }

    private static void getList(CollectionMain collectionMain) {
        collectionMain.list.toString();
    }

    private static void findByString(CollectionMain collectionMain, String hello) {
        for(String str : collectionMain.list) {
            if (str.equals(hello)) {
                System.out.println(str);
            }
        }
    }
}
