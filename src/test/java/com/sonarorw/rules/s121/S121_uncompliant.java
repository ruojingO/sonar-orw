package com.sonarorw.rules.s121;

class S121_uncompliant {
    void example(int value) {
        if (value > 10)
            System.out.println("large");
        for (int i = 0; i < value; i++)
            doWork(i);
        while (value-- > 0)
            doWork(value);
    }

    private void doWork(int input) {
        System.out.println(input);
    }
}
