package uncc.edu.inclass08;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowExpensesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ShowExpensesFragment extends Fragment {

    TextView textExName,textExAmt,textExCat,textExDate;

    private OnFragmentInteractionListener mListener;

    public ShowExpensesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textExName= (TextView) getActivity().findViewById(R.id.show_name_value);
        textExCat= (TextView) getActivity().findViewById(R.id.show_cat_value);
        textExAmt= (TextView) getActivity().findViewById(R.id.show_amt_value);
        textExDate= (TextView) getActivity().findViewById(R.id.show_date_value);
        Expense expense=mListener.getClickedExpense();
        textExName.setText(expense.getExName());
        textExCat.setText(expense.getExCategory());
        textExAmt.setText("$"+expense.getExAmt());
        textExDate.setText(expense.getExDate());

        getActivity().findViewById(R.id.buttonClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity().getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_expenses, container, false);
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
        public Expense getClickedExpense();
    }
}
