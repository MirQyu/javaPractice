package invokeanydemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialize the parameters of the user
				String username="test";
				String password="test";
				
				// Create two user validation objects
				UserValidator ldapValidator=new UserValidator("LDAP");
				UserValidator dbValidator=new UserValidator("DataBase");
				UserValidator abcValidator=new UserValidator("ABC");
				// Create two tasks for the user validation objects
				TaskValidator ldapTask=new TaskValidator(ldapValidator, username, password);
				TaskValidator dbTask=new TaskValidator(dbValidator, username, password);
				TaskValidator abcTask=new TaskValidator(abcValidator, username, password);
				// Add the two tasks to a list of tasks
				List<TaskValidator> taskList=new ArrayList<>();
				taskList.add(ldapTask);
				taskList.add(dbTask);
				taskList.add(abcTask);
				// Create a new Executor
				ExecutorService executor=(ExecutorService)Executors.newCachedThreadPool();
				String result;
				try {
					// Send the list of tasks to the executor and waits for the result of the first task 
					// that finish without throw and Exception. If all the tasks throw and Exception, the
					// method throws and ExecutionException.
					result = executor.invokeAny(taskList);
					System.out.printf("Main: Result: %s\n",result);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
				
				// Shutdown the Executor
				executor.shutdown();
				System.out.printf("Main: End of the Execution\n");
	}

}
