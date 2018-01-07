package uncc.edu.inclass08;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExpenseAppFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ExpenseAppFragment extends Fragment {

    ListView listView;
    ListAdapter adapter;
    FloatingActionButton addButton;
    private OnFragmentInteractionListener mListener;

    public ExpenseAppFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_expense_app, container, false);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addButton= (FloatingActionButton) getActivity().findViewById(R.id.imageAddExpence);
        if(mListener.getExpenses()!=null && !mListener.getExpenses().isEmpty()) {
            getActivity().findViewById(R.id.emptyListText).setVisibility(View.INVISIBLE);
            adapter = new ListAdapter(getActivity(), R.layout.list_row_item, mListener.getExpenses());
            listView = (ListView) getActivity().findViewById(R.id.expencesList);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mListener.gotoShowExpenseFragment(mListener.getExpenses().get(position));

                }
            });

            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    adapter.remove(mListener.getExpenses().get(position));
                    if (mListener.getExpenses() == null || mListener.getExpenses().isEmpty())
                        ((TextView) getActivity().findViewById(R.id.emptyListText)).setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Expense Deleted", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.goToAddExpenseFragment();
                }
            });
        }
        else{
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.goToAddExpenseFragment();
                }
            });
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
        void onFragmentInteraction(Uri uri);
        public ArrayList<Expense> getExpenses();
        public void goToAddExpenseFragment();
        public void gotoShowExpenseFragment(Expense expense);
    }
}
