package fun.fiver;

import fun.fiver.tests.SortByNameTest;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {

        //TestExecutor executor = new TestExecutor(CreditAuthorsTest.class);
        //TestExecutor executor = new TestExecutor(CreateFolderTest.class);
        TestExecutor executor = new TestExecutor(SortByNameTest.class);

        Result result = executor.execute(true);

        System.out.println("Done: [" + result.getResults().toString(2) + "]");

    }

}
