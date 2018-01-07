package uncc.edu.inclass08;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExpenseAppFragment.OnFragmentInteractionListener, AddExpenseFragment.OnFragmentInteractionListener,ShowExpensesFragment.OnFragmentInteractionListener{
    ArrayList<Expense> expenses=new ArrayList<>();
    Expense clickedExp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,new ExpenseAppFragment(),"expenseFragment")
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public ArrayList<Expense> getExpenses() {
        return expenses;
    }


    @Override
    public void goToAddExpenseFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new AddExpenseFragment(),"addExFragment")
                .addToBackStack(null)
                .commit();
        getSupportFragmentManager().executePendingTransactions();
    }

    @Override
    public void gotoShowExpenseFragment(Expense expense) {
        clickedExp=expense;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new ShowExpensesFragment(),"showExpenseFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void gotoExpenseAppFragment(Expense expense) {
        Log.d("demo","I am going to jump");
        expenses.add(expense);

    }


    @Override
    public Expense getClickedExpense() {
        return clickedExp;

    }
}
