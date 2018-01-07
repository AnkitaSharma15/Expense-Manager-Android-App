package uncc.edu.inclass08;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddExpenseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AddExpenseFragment extends Fragment {

    private OnFragmentInteractionListener mListener;



    public AddExpenseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_expense, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().findViewById(R.id.buttonAddExpense).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextExpenseName = (EditText)getView().findViewById(R.id.editTextExpenseName);
                EditText editTextAmount = (EditText)getView().findViewById(R.id.editTextAmount);
                Spinner spinnerCategory = (Spinner)getView().findViewById(R.id.spinnerCategory);
                if (editTextExpenseName.getText().toString().equals("") ){
                    Toast.makeText(getActivity(), "Missing field Expense Name", Toast.LENGTH_LONG).show();
                }
                else if ( editTextAmount.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Missing field Amount", Toast.LENGTH_LONG).show();
                }
                else{
                    Expense expense = new Expense();
                    expense.setExName(editTextExpenseName.getText().toString());
                    expense.setExAmt(editTextAmount.getText().toString());
                    expense.setExCategory(spinnerCategory.getSelectedItem().toString());
                    expense.setExDate();
                    mListener.gotoExpenseAppFragment(expense);
                    //Toast.makeText(getActivity(),"Added Expense",Toast.LENGTH_SHORT).show();
                    if (getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0) {
                        getActivity().getSupportFragmentManager().popBackStack();
                    }
                }
            }
        });

        getView().findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        //  void onFragmentInteraction(Uri uri);
        void gotoExpenseAppFragment(Expense expense);
    }
}
