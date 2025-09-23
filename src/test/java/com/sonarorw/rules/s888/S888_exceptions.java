package com.sonarorw.rules.s888;

class S888_exceptions {
    String iterateUntilNull(String[] arr) {
        for (int i = 0; arr[i] != null; i++) {
            if (arr[i].isEmpty()) {
                return "empty";
            }
        }
        return "done";
    }

    String captureItems(String[] arr) {
        String item;
        for (int i = 0; (item = arr[i]) != null; i++) {
            if (item.startsWith("ok")) {
                return item;
            }
        }
        return "missing";
    }
}

