import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class QueueStackUnitTest {
    private static final int SIZE = 150;
    private static final int BOUND = 1000;

    @Test
    public void testQueue() {

        MyQueue<Integer> queueTest = new MyQueue<>();
        var testValues = generateArray();

        for (int i : testValues)
            queueTest.push(i);

        for (Integer i : testValues)
            Assert.assertEquals(i, queueTest.pop());

    }

    @Test
    public void testStack() {

        var queueTest = new MyStack<Integer>();
        var testValues = generateArray();

        for (int i : testValues)
            queueTest.push(i);

        for (int i = 0; i < SIZE; i++)
            Assert.assertEquals(testValues.get(SIZE - 1 - i), queueTest.pop());

    }


    private ArrayList<Integer> generateArray() {
        Random random = new Random();
        var randomisedArr = new ArrayList<Integer>();

        for (int i = 0; i < QueueStackUnitTest.SIZE; i++)
            randomisedArr.add(random.nextInt(BOUND));

        return randomisedArr;
    }
}
