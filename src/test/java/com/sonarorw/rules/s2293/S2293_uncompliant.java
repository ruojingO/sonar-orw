package com.sonarorw.rules.s2293;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Sonar rule S2293 官方不合规示例：
List<String> strings = new ArrayList<String>();
Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
*/
class S2293_uncompliant {
    List<String> strings = new ArrayList<String>();
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
}